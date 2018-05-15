package com.techelevator.npgeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.ParkDao;
import com.techelevator.npgeek.model.survey.Survey;
import com.techelevator.npgeek.model.survey.SurveyDao;
import com.techelevator.npgeek.model.survey.SurveyResults;
import com.techelevator.npgeek.model.survey.SurveyResultsDao;

@Controller
public class SurveyController {

	@Autowired
	private SurveyDao surveyDao;
	@Autowired
	private SurveyResultsDao surveyResultsDao;

	@RequestMapping(path = "/surveyInputPage", method = RequestMethod.GET)
	public String displaySurveyPage() {
		return "surveyInputPage";
	}
	
	@RequestMapping(path = "/surveyInputPage", method = RequestMethod.POST)
	public String submitSurvey(@RequestParam String parkCode, String emailInput, String stateSelection, String activityLevel) {
		
		Survey s = new Survey();
		s.setParkCode(parkCode);
		s.setEmailAddress(emailInput);
		s.setState(stateSelection);
		s.setActivityLevel(activityLevel);
		surveyDao.save(s);		
		
		return "redirect:/surveyResultsPage";
	}

	@RequestMapping(path = "/surveyResultsPage", method = RequestMethod.GET)
	public String displaySurveyResults(ModelMap modelHolder) {		
		List<SurveyResults> surveyResults = surveyResultsDao.getSurveyByCount();
		
		modelHolder.put("surveyResults", surveyResults);
		
		return "surveyResultsPage";
	}

}
