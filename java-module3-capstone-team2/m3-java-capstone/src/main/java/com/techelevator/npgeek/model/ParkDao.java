package com.techelevator.npgeek.model;

import java.util.List;

public interface ParkDao {
	
	public List<Park> getAllParks();
	public Park getParkByCode(String parkCode);
//	public Park getParkForecast(String parkCode);

}
