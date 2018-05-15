package com.techelevator.npgeek.model;

import java.util.List;

public interface ParkForecastDao {

	public List<ParkForecast> getParkForecast(String parkCode);
}
