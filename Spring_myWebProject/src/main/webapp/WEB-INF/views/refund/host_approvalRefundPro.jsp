<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/mySetting.jsp" %>
<%@ include file="/resources/myQuery.jsp" %>
<script src="${myProject }script.js"></script>
<link type="text/css" rel="stylesheet" href="${myProject }style.css">
<html>
<body>
	<c:if test="${isDelete == len_checkedRefund && isUpdateProduct == len_checkedRefund && isUpdateRefund == len_checkedRefund}">
		<script type="text/javascript">
			alert("환불승인완료");
			window.location="printRefundList.refund";
		</script>
	</c:if>
	
	<c:if test="${isDelete != len_checkedRefund || isUpdateProduct != len_checkedRefund || isUpdateRefund != len_checkedRefund}">
		<script type="text/javascript">
			alert("환불승인실패")
			window.location="printRefundList.refund";
		</script>
	</c:if>
</body>
</html>