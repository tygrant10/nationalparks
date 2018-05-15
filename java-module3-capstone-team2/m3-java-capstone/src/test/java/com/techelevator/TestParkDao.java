package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.model.JdbcParkDao;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDao;

public class TestParkDao extends DAOIntegrationTest {
	private static SingleConnectionDataSource dataSource;
	private JdbcParkDao sut;
	private String parkCode;
	private ParkDao parkDao;

	@Before
	public void setUp() throws Exception {
		sut = new JdbcParkDao(getDataSource());

		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		String newPark = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING parkcode";
		parkCode = jdbcTemplate.queryForObject(newPark, String.class, "T", "TEST", "OH", 100, 200, 10.0, 4, "WOODLAND", 1980,
				21, "HELLO", "ME", "GOOD", 10, 20);
	}

	@Test
	public void test() {
		List<Park> allParks = sut.getAllParks();

		for (Park park : allParks) {
			if (park.getParkName().equals("TEST") && park.getParkCode().equals(parkCode)) {
				assertEquals(parkCode, park.getParkCode());
				assertEquals("TEST", park.getParkName());
				return;
			}
		}
		fail("No parks found");
	}

}
