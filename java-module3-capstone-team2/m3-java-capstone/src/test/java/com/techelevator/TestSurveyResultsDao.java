package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.model.survey.JdbcSurveyDao;
import com.techelevator.npgeek.model.survey.Survey;
import com.techelevator.npgeek.model.survey.SurveyDao;
import com.techelevator.npgeek.model.survey.SurveyResults;
import com.techelevator.npgeek.model.survey.SurveyResultsDao;

public class TestSurveyResultsDao extends DAOIntegrationTest {
	
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
	public void test() {
		List<SurveyResults> allResults = new ArrayList<>();
		for(SurveyResults surveyResults : allResults) {
			assertEquals(1, surveyResults.getVoteCount());
		}
		fail("No surveys found");
	}

}
