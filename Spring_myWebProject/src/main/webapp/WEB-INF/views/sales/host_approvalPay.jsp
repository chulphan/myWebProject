<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="mySetting.jsp" %>
<%@ include file="myQuery.jsp" %>
<script src="${myProject }script.js?ver=1"></script>
<link type="text/css" rel="stylesheet" href="${myProject }style.css?ver=1.1">
<html>
<body>
	<c:if test="${isAdded == numOfOrder && isUpdate == numOfOrder && isDelete == numOfOrder }">
		<script type="text/javascript">
			alert("결제승인 되었습니다.");
			window.history.back();
		</script>
	</c:if>
	<c:if test="${isAdded != numOfOrder || isUpdate != numOfOrder || isDelete != numOfOrder}">
		<script type="text/javascript">
			alert("결제승인 실패했습니다.");
			window.history.back();
		</script>
	</c:if>
</body>
</html>