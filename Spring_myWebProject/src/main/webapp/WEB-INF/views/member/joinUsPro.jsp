<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/mySetting.jsp" %>
<%@ include file="/resources/myQuery.jsp" %>
<script src="${myProject }script.js"></script>
<link type="text/css" rel="stylesheet" href="${myProject }style.css">
<html>
<body>
	<%-- <%
		int isInsert = (Integer) request.getAttribute("isInsert");
	%> --%>
	
	<c:choose>	
		<c:when test="${requestScope.isInsert == 0}">
			<script type="text/javascript">
				printError(insertError);
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				printMsg(insertSuccess);
			</script>
		<c:redirect url="mainSuccess"/>
		</c:otherwise>
	</c:choose>
</body>
</html>