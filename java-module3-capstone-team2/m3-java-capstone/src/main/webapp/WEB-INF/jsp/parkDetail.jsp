<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/WEB-INF/jsp/common/header.jspf" %>


	<h1 class="parkDetailsH1">Park Details</h1>

	<div class="parkDetailContainer">

		<img class="parkDetailImg" alt="Park Detail Image"
			src="../img/parks/${park.parkCode.toLowerCase()}.jpg"> <br>
		<div class="parkDetailOutput">
			<h2 class="detailParkName">
				<c:out value="${park.parkName}" />
			</h2>
			<h3 class="parkState">
				State:
				<c:out value="${park.state}" />
			</h3>
			<h4 class="parkAcerage">
				Acreage:
				<c:out value="${park.acreage}" />
			</h4>
			<h4 class="parkAcerage">
				Elevation(ft.):
				<c:out value="${park.elevationInFeet}" />
			</h4>
			<h4 class="parkAcerage">
				Miles of Trail:
				<c:out value="${park.milesOfTrail}" />
			</h4>
			<h4 class="parkAcerage">
				Number of Campsites:
				<c:out value="${park.numberOfCampsites}" />
			</h4>
			<h4 class="parkAcerage">
				Year Founded:
				<c:out value="${park.yearFounded}" />
			</h4>
			<h4 class="parkAcerage">
				Annual Visitor Count:
				<c:out value="${park.annualVisitorCount}" />
			</h4>
			<p class="parkDescription">
				Inspirational Quote:
				<c:out value="${park.inspirationalQuote}" />
			</p>
			<p class="parkDescription">
				Source:
				<c:out value="${park.inspirationalQuoteSource}" />
			</p>
			<p class="parkDescription">
				Park Description:
				<c:out value="${park.description}" />
			</p>
			<h4 class="parkAcerage">
				Park Entry Fee: $
				<c:out value="${park.entryFee}" />
			</h4>
			<h4 class="parkAcerage">
				Number of Animal Species:
				<c:out value="${park.numberOfAnimalSpecies}" />
			</h4>
			<h4 class="parkAcerage">
				Climate:
				<c:out value="${park.climate}" />
			</h4>

		</div>
		
		<c:url value="/parkDetail/${park.parkCode}" var="formAction" />
		<form method="POST" action="${formAction}">
	
			<label for="tempType">Temp Type</label>
			<select id="tempType" name="tempType">
				<option value="true"> F </option>
				<option value="false"> C </option>
			</select>
			<input type="hidden" name="parkCode" value="${park.parkCode}"/>
			<input type="submit" value="Submit"/>
		</form>
		
		<div>
			<div class="weatherGrid">
				<c:out value="${fiveDayForecastValue}" />
				<c:forEach var="forecast" items="${parkForecast}">
				
					<c:url var="forecastImage" value="../img/weather/${forecast.forecast.toLowerCase()}.png" />
					
					<c:choose>
						<c:when test="${forecast.fiveDayForecastValue == 1}">
						<div class="todaysWeather">
									
							<div class="today">This week's forecast:
								<p>Today</p>
							</div>
							<img class="todaysWeatherImage" alt="${forecast.forecast}" src="${forecastImage}">
							
						<div class="todaysTemp">
						
							<c:if test="${isF == false}">
								<fmt:formatNumber var="formattedCHigh" maxFractionDigits="0" value="${((forecast.highTemp - 32) * (.5556)) }" />
								High <c:out value="${formattedCHigh}" /> C
								<fmt:formatNumber var="formattedCLow" maxFractionDigits="0" value="${((forecast.highTemp - 32) * (.5556)) }" />
								Low <c:out value="${formattedCLow}" /> C
							</c:if>
							<c:if test="${isF == true || isF == null}">
								High <c:out value="${forecast.highTemp}" /> F
								Low <c:out value="${forecast.lowTemp}" /> F
							</c:if>							
						
							<c:if test="${forecast.highTemp > 75}">
								<p>Bring an extra gallon of water</p>
							</c:if>
							
							<c:if test="${(forecast.highTemp - forecast.lowTemp) > 20}">
								<p>Wear breathable layers</p>
							</c:if>
							
							<c:if test="${forecast.lowTemp < 20}">
								<p>Beware the dangers of exposure to frigid temperatures</p>
							</c:if>

							<c:choose>
								<c:when test="${forecast.forecast.equals('rain')}">
									<p>Pack rain gear and wear waterproof shoes</p>
								</c:when>
								<c:when test="${forecast.forecast.equals('snow')}">
									<p>Pack snow shoes</p>
								</c:when>
								<c:when test="${forecast.forecast.equals('cloudy')}">
									<p>Heavy overcast</p>
								</c:when>
								<c:when test="${forecast.forecast.equals('partly cloudy')}">
									<p>Chance of sun</p>
								</c:when>
								<c:when test="${forecast.forecast.equals('sunny')}">
									<p>Don't forget your sun block</p>
								</c:when>
								<c:when test="${forecast.forecast.equals('thunderstorms')}">
									<p>Seek shelter and avoid hiking on exposed ridges</p>
								</c:when>
							</c:choose>	
							</div>
						</div>	
					</c:when>
							
						<c:otherwise>
						<div class="weeksWeather">
					
							<img class="weeksWeatherImage" alt="${forecast.forecast}"
								src="${forecastImage}">
							<div class="weeksTemp">
								<c:if test="${isF == false}">
									<fmt:formatNumber var="formattedCHigh" maxFractionDigits="0" value="${((forecast.highTemp - 32) * (.5556)) }" />
									High <c:out value="${formattedCHigh}" /> C
									 Low <fmt:formatNumber var="formattedCLow" maxFractionDigits="0" value="${((forecast.highTemp - 32) * (.5556)) }" />
								<c:out value="${formattedCLow}" /> C
								</c:if>
								<c:if test="${isF == true || isF == null}">
									High <c:out value="${forecast.highTemp}" /> F
									Low <c:out value="${forecast.lowTemp}" /> F
								</c:if>
							</div>
							
						</div>			
						</c:otherwise>
					</c:choose>
			
				</c:forEach>
			</div>

		</div>

	</div>
	
<%@ include file="/WEB-INF/jsp/common/footer.jspf" %>