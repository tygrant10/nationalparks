package com.techelevator.npgeek.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDao;
import com.techelevator.npgeek.model.ParkForecast;
import com.techelevator.npgeek.model.ParkForecastDao;

@Controller
public class HomeController {
	
	@Autowired
	private ParkDao parkDao;
	@Autowired
	private ParkForecastDao parkForecastDao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayNationalParks(ModelMap modelHolder) {
		List<Park> allParks = parkDao.getAllParks();
		modelHolder.put("parks", allParks);
		return "homePage";
	}
	
	@RequestMapping(path="/parkDetail/{parkCode}", method=RequestMethod.GET)
	public String displayParkDetail(ModelMap modelHolder, @PathVariable String parkCode) {
		Park park = parkDao.getParkByCode(parkCode);
		List<ParkForecast> parkForecast = parkForecastDao.getParkForecast(parkCode);
		modelHolder.put("park", park);
		modelHolder.put("parkForecast", parkForecast);
		return "parkDetail";
	}

	@RequestMapping(path="/parkDetail/{parkCode}", method=RequestMethod.POST)
	public String changeTempType(HttpSession session, @PathVariable String parkCode, @RequestParam boolean tempType) {
		Boolean isF = true;
		if(tempType == true) {
			isF = true;
		} else {
			isF = false;
		}
		
		session.setAttribute("isF", isF);
		return "redirect:/parkDetail/" + parkCode;
	}
}
