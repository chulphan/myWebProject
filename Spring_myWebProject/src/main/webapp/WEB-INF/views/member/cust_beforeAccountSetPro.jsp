<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/mySetting.jsp" %>
<%@ include file="/resources/myQuery.jsp" %>
<script src="${myProject }script.js"></script>
<link type="text/css" rel="stylesheet" href="${myProject }style.css">
<html>
<body>
	
	<c:if test="${requestScope.isCheck == 0 }">
		<script type="text/javascript">
			printError(ErrorIdOrPw);
		</script>
	</c:if>
	
	<c:if test="${requestScope.isCheck != 0 }">
		<c:redirect url="cust_accountSetting"/>
	</c:if>
</body>
</html>