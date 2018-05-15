package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcParkDao implements ParkDao, ParkForecastDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while (results.next()) {
			allParks.add(mapRowToPark(results));
		}
		return allParks;
	}

	@Override
	public Park getParkByCode(String parkCode) {
		Park park = null;
		String sqlSelectionParkCode = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectionParkCode, parkCode);
		if (results.next()) {
			park = mapRowToPark(results);
		}
		return park;
	}

	private Park mapRowToPark(SqlRowSet row) {
		Park park = new Park();
		park.setParkCode(row.getString("parkcode"));
		park.setParkName(row.getString("parkname"));
		park.setState(row.getString("state"));
		park.setAcreage(row.getDouble("acreage"));
		park.setElevationInFeet(row.getInt("elevationinfeet"));
		park.setMilesOfTrail(row.getDouble("milesoftrail"));
		park.setNumberOfCampsites(row.getInt("numberofcampsites"));
		park.setClimate(row.getString("climate"));
		park.setYearFounded(row.getInt("yearfounded"));
		park.setAnnualVisitorCount(row.getInt("annualvisitorcount"));
		park.setInspirationalQuote(row.getString("inspirationalquote"));
		park.setInspirationalQuoteSource(row.getString("inspirationalquotesource"));
		park.setDescription(row.getString("parkdescription"));
		park.setEntryFee(row.getBigDecimal("entryfee"));
		park.setNumberOfAnimalSpecies(row.getInt("numberofanimalspecies"));

		return park;
	}

	@Override
	public List<ParkForecast> getParkForecast(String parkCode) {
		List<ParkForecast> parkForecast = new ArrayList<>();
		String sqlSelectionParkCode = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectionParkCode, parkCode);
		while (results.next()) {
			parkForecast.add(mapRowToParkForecast(results));
		}
		return parkForecast;
	}

	private ParkForecast mapRowToParkForecast(SqlRowSet row) {
		ParkForecast parkForecast = new ParkForecast();
		parkForecast.setParkCode(row.getString("parkcode"));
		parkForecast.setFiveDayForecastValue(row.getInt("fivedayforecastvalue"));
		parkForecast.setLowTemp(row.getInt("low"));
		parkForecast.setHighTemp(row.getInt("high"));
		parkForecast.setForecast(row.getString("forecast"));
		parkForecast.setDaysAsInt(row.getInt("fivedayforecastvalue"));

		return parkForecast;

	}

}
