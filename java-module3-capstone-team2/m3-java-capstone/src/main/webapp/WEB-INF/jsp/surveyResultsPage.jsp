<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/jsp/common/header.jspf" %>

<h1 class="topParksH1">Top Voted Parks</h1>


 	<form method="GET" >
		<table class="surveyContainer">
			<tr>
				<th>Park</th>
				<th>Votes</th>
			</tr>
			
			<c:forEach items="${surveyResults}" var="surveyResults">
			
			<tr>
				<td><div class="resultsParkName"><c:out value="${surveyResults.parkName}"/></div></td>
				<td><div class="resultsParkName"><c:out value="${surveyResults.voteCount}"/></div></td>		
			</tr>
			
			</c:forEach>
		</table>


</form>

<%@ include file="/WEB-INF/jsp/common/footer.jspf" %>