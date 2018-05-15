package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.model.survey.JdbcSurveyDao;
import com.techelevator.npgeek.model.survey.Survey;
import com.techelevator.npgeek.model.survey.SurveyDao;
import com.techelevator.npgeek.model.survey.SurveyResults;
import com.techelevator.npgeek.model.survey.SurveyResultsDao;

public class TestSurveyDao extends DAOIntegrationTest {
	
	private static SingleConnectionDataSource dataSource;
	private JdbcSurveyDao sut;
	
	private SurveyResultsDao surveyResultsDao;
	private SurveyDao surveyDao;

	@Before
	public void setUp() throws Exception {
		Survey survey = new Survey();
		
		sut = new JdbcSurveyDao(getDataSource());
		survey.setEmailAddress("got");
		survey.setActivityLevel("low");
		survey.setParkCode("T");
		survey.setState("OH");
		
		sut.save(survey);
	}


	@Test
	public void save() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		String sqlSelectSurveys = "SELECT state FROM survey_result WHERE state = 'OH'";
		 SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectSurveys);
		    results.next();
		    assertEquals("OH", results.getString("state"));
		
	}
}

