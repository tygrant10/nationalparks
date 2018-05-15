<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/jsp/common/header.jspf" %>

	<c:forEach items="${parks}" var="park">

		<div class="parkContainer">

			<c:url value="/parkDetail/${park.parkCode}" var="parks" />
			<a href="${parks}"> <img class="parkImg" alt="Park Image"
				src="img/parks/${park.parkCode.toLowerCase()}.jpg">
			</a>
			<div class="hpParkNandD">
				<div class="hpParkName"><c:out value="${park.parkName}" /></div>
				<div class="hpParkDescription"><c:out value="${park.description}" /></div>
			</div>
		</div>
	</c:forEach>

<%@ include file="/WEB-INF/jsp/common/footer.jspf" %>