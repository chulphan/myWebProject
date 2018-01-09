<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/mySetting.jsp" %>
<%@ include file="/resources/myQuery.jsp" %>
<script src="${myProject }script.js"></script>
<link type="text/css" rel="stylesheet" href="${myProject }style.css">
<html>
<body>
	
		<table class="finalAccount_table" style="border:1px solid black">
			<tr class="finalAccount_row" style="background-color:gray;color:white;text-align:center;">
				<td class="finalAccount_column"> 결산금액 </td>
			</tr>
			<tr class="finalAccount_row" style="text-align:center">
				<td class="finalAccount_column" colspan="2">${param.finalAccount} </td>
			</tr>
		</table>
			
</body>
</html>