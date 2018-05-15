package com.techelevator.npgeek.model.survey;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JdbcSurveyDao implements SurveyDao, SurveyResultsDao {
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<SurveyResults> getSurveyByCount() {
		List<SurveyResults> surveyTopParks = new ArrayList<>();
		String sqlSelectCountOfReviews = "SELECT COUNT(*) votecount, parkname FROM survey_result JOIN park ON park.parkcode = survey_result.parkcode GROUP BY parkname ORDER BY votecount DESC, parkname ASC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectCountOfReviews);
		while(results.next()) {
			SurveyResults surveyResults = new SurveyResults();
			surveyResults.setParkName(results.getString("parkname"));
			surveyResults.setVoteCount(results.getInt("votecount"));
			surveyTopParks.add(surveyResults);
		}
		return surveyTopParks;
	}

//	@Override
//	public List<Survey> getSurveyByMostSubmits() {
//		List<Survey> favorites = new ArrayList<>();
//		String sqlSelectCountOfReviews = "SELECT parkname FROM survey_result JOIN park ON park.parkcode = survey_result.parkcode GROUP BY parkname";
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectCountOfReviews);
//		while(results.next()) {
////			favorites.add(results.getLong("surveycount")+":"+results.getString("parkcode"));
////			favorites.add(results.getString("parkname"));
////			Survey survey = new Survey();
////			survey.setSurveyId(results.getLong("surveyid"));
////			survey.setParkCode(results.getString("parkcode"));
////			survey.setEmailAddress(results.getString("emailaddress"));
////			survey.setState(results.getString("state"));
////			survey.setActivityLevel(results.getString("activitylevel"));
////			favorites.add(survey);
//		}
//		return favorites;
//	}

	@Override
	public void save(Survey survey) {
		Long surveyId = getNextId();
		String sqlInsertSurvey = "INSERT INTO survey_result(surveyid, parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertSurvey, surveyId, survey.getParkCode(), survey.getEmailAddress(), survey.getState(), survey.getActivityLevel());
		survey.setSurveyId(surveyId);
	}
	
	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyid')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		Long surveyId = null;
		if(results.next()) {
			surveyId = results.getLong(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next survey id from sequence");
		}
		return surveyId;
	}
	


}
