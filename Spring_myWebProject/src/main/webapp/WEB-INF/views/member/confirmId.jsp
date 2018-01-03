<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/mySetting.jsp" %>
<%@ include file="/resources/myQuery.jsp" %>
<script src="${myProject }script.js"></script>
<link type="text/css" rel="stylesheet" href="${myProject }style.css">



<html>
<body>
	<%-- <%
		int isDupl = (Integer) request.getAttribute("isDupl");
		String curr_id = (String) request.getAttribute("curr_id");	
	%> --%>
	
	<form action="confirmId" name="confirmForm" method="post" onsubmit="return confirmIdCheck();">
		
	
		<c:if test="${requestScope.isDupl == 1 }">
			<div class="containerc">
				<span>${requestScope.curr_id }</span>를 사용할 수 없습니다.
				<div class="resInput">
					<span class="pp">아이디 : </span>
					<input class="input" type="text" name="reId" maxlength="20" style="width:100px;">
				</div>
				<div class="buttonSet">
					<input class="inputButton" type="submit" value="확인">
					<input class="inputButton" type="reset" value="취소" onclick="self.close();"> 
				</div>
			</div>
		</c:if>			
		<c:if test="${requestScope.isDupl != 1 }">
			<div class="containerc">
				<span class="resInput">${requestScope.curr_id }</span> 를 사용할 수 있습니다.
				<div class="buttonSet">
					<input class="inputButton" type="button" value="확인" onclick="setId('${requestScope.curr_id}')">				</div>
			</div>
		</c:if>
	</form>
</body>
</html>