<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/mySetting.jsp" %>
<%@ include file="/resources/myQuery.jsp" %>
<script src="${myProject }script.js"></script>
<link type="text/css" rel="stylesheet" href="${myProject }style.css">
<html>
<body>
	<c:if test="${isDelete == 0 }">
		<h3>delete failed</h3>
	</c:if>
	
	<c:if test="${isDelete != 0 }">
		<h3>delete successed</h3>
	</c:if>
</body>
</html>