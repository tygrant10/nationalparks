<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/jsp/common/header.jspf" %>

<div class="surveyInputContainer">
<h1>Survey Page</h1>
	
	
	<form method="POST">
	
		<div class="favParkInput">
			<label for="parkCode">Favorite National Park</label>
			<select id="parkCode" name="parkCode">
				<option value="CVNP">Cuyahoga Valley National Park</option>
				<option value="ENP">Everglades National Park</option>
				<option value="GCNP">Grand Canyon National Park</option>
				<option value="GNP">Glacier National Park</option>
				<option value="GSMNP">Great Smoky Mountains National Park</option>
				<option value="GTNP">Grand Teton National Park</option>
				<option value="MRNP">Mount Rainier National Park</option>
				<option value="RMNP">Rocky Mountain National Park</option>
				<option value="YNP">Yellowstone National Park</option>
				<option value="YNP2">Yosemite National Park</option>
			</select>
		</div>
		
		<div class="yourEmail">
			<label for="emailInput">Your email</label>
			<input type="text" id="emailInput" name="emailInput" />
		</div>
		
		<div class="residence">
			<label for="stateSelection">State of residence</label>
			<select id="stateSelection" name="stateSelection">
				<option value="AL">AL</option>
				<option value="AK">AK</option>
				<option value="AZ">AZ</option>
				<option value="AR">AR</option>
				<option value="CA">CA</option>
				<option value="CO">CO</option>
				<option value="CT">CT</option>
				<option value="DE">DE</option>
				<option value="DC">DC</option>
				<option value="FL">FL</option>
				<option value="GA">GA</option>
				<option value="HI">HI</option>
				<option value="ID">ID</option>
				<option value="IL">IL</option>
				<option value="IN">IN</option>
				<option value="IA">IA</option>
				<option value="KS">KS</option>
				<option value="KY">KY</option>
				<option value="LA">LA</option>
				<option value="ME">ME</option>
				<option value="MD">MD</option>
				<option value="MA">MA</option>
				<option value="MI">MI</option>
				<option value="MN">MN</option>
				<option value="MS">MS</option>
				<option value="MO">MO</option>
				<option value="MT">MT</option>
				<option value="NE">NE</option>
				<option value="NV">NV</option>
				<option value="NH">NH</option>
				<option value="NJ">NJ</option>
				<option value="NM">NM</option>
				<option value="NY">NY</option>
				<option value="NC">NC</option>
				<option value="ND">ND</option>
				<option value="OH">OH</option>
				<option value="OK">OK</option>
				<option value="OR">OR</option>
				<option value="PA">PA</option>
				<option value="RI">RI</option>
				<option value="SC">SC</option>
				<option value="SD">SD</option>
				<option value="TN">TN</option>
				<option value="TX">TX</option>
				<option value="UT">UT</option>
				<option value="VT">VT</option>
				<option value="VA">VA</option>
				<option value="WA">WA</option>
				<option value="WV">WV</option>
				<option value="WI">WI</option>
				<option value="WY">WY</option>
			</select>
		</div>

		<div class="activityInput">
			<label for="activityLevel">Activity level</label>
			
			<input type="radio" name="activityLevel" value="inactive" checked> inactive
			<input type="radio" name="activityLevel" value="sedentary"> sedentary
			<input type="radio" name="activityLevel" value="active"> active	
			<input type="radio" name="activityLevel" value="extremely"> extremely active	
		</div>
			
		<input type="submit" value="Submit" />	
		
	</form>
	
</div>
<%@ include file="/WEB-INF/jsp/common/footer.jspf" %>