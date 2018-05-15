package com.techelevator.npgeek.model;

public class ParkForecast {

		private String parkCode;
		private int fiveDayForecastValue;
		private int daysAsInt;
		private int lowTemp;
		private int highTemp;
		private String forecast;
		
		
		
		public String getParkCode() {
			return parkCode;
		}
		public void setParkCode(String parkCode) {
			this.parkCode = parkCode;
		}
		public int getFiveDayForecastValue() {
			return fiveDayForecastValue;
		}
		public void setFiveDayForecastValue(int fiveDayForecastValue) {
			this.fiveDayForecastValue = fiveDayForecastValue;
		}
		public int getLowTemp() {
			return lowTemp;
		}
		public void setLowTemp(int lowTemp) {
			this.lowTemp = lowTemp;
		}
		public int getHighTemp() {
			return highTemp;
		}
		public void setHighTemp(int highTemp) {
			this.highTemp = highTemp;
		}
		public String getForecast() {
			return forecast;
		}
		public void setForecast(String forecast) {
			this.forecast = forecast;
		}
		public int getDaysAsInt() {
			return daysAsInt;
		}
		public void setDaysAsInt(int daysAsInt) {
			this.daysAsInt = daysAsInt;
		}
}
