<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/mySetting.jsp" %>
<%@ include file="/resources/myQuery.jsp" %>
<script src="${myProject }script.js"></script>
<link type="text/css" rel="stylesheet" href="${myProject }style.css">
<html>
<body onload="joinFocus();">
	<div class="container">
		<div class="part-header">
			<header class="top-menu">
				<div class="menu-bar">
					<ul class="menu-collector">
						<li class="myAccount"><a href="common_myAccount.do">내 계정</a></li>
						<li class="language"><a href="#">언어</a></li>
						<li class="main_logo"><a href="Main.do"><img src="./images/logo.png" style="width:250px; height:59px"></a>
						<li class="order_list"><a href="#">찜 목록</a></li>
						<li class="cart_list"><a href="#">장바구니</a></li>
					</ul>
				</div>
				<div class="navigator">
					<ul class="navi-collector">
						<li class="toMain"><a href="Main.html">HOME</a></li>
						<li class="#"><a href="#">SHOP</a></li>
						<li class="#"><a href="#">FAQ</a></li>
						<li class="#"><a href="#">주문/배송정보</a></li>
						<li class="#"><a href="#">ABOUT US</a></li>
					</ul>
				</div>
			</header>
			<div class="join-Main">
				<div class="join-shell">
					<form name="join" action="joinUsPro.do" id="process-join" method="post" onsubmit="return joinCheck();">
						<input type="hidden" name="hiddenId" value="0">
						<input type="hidden" name="hiddenBirth" value="0">
						<div class="input_place">
							<label for="juser_id">아이디 : <input type="text" name="juser_id" id="juser_id" placeholder="20자 이내로">
														 <input type="button" name="dupChk" value="중복체크" onclick="confirmId();">
							</label>
							<label for="juser_pw">비밀번호:<input type="password" name="juser_pw" id="juser_pw" placeholder="20자 이내로"></label>
							<label for="juser_rpw">비밀번호(확인):<input type="password" name="juser_rpw" id="juser_rpw" placeholder="재입력"></label>
							<label for="juser_name">이름 : <input type="text" name="juser_name" id="juser_name"></label>
							<label for="juser_birth">주민번호 : <input type="text" name="juser_birth" id="juser_birth" placeholder="'-'를 포함해서 입력하세요">
															 <input type="button" name="birthCheck" value="주민번호인증" onclick="birthCheck();">
							</label>
							<label for="juser_email">이메일 : <input type="email" name="juser_email" id="juser_email" placeholder="'@'를 포함해서 입력하세요"></label>
							<label for="juser_address">거주지 : <input type="text" name="juser_address" id="juser_address"></label>
							<label for="juser_phone">휴대전화번호: <input type="text" name="juser_phone" id="juser_phone" placeholder="'-'를 포함해서 입력하세요"></label>
						</div>
						<div class="input_button">
							<input type="submit" id="submitBtn" value="작성완료">
							<input type="reset" id="resetBtn" value="다시작성">
							<input type="button" onclick="window.location='main.jsp'" value="가입취소">
						</div>
					</form>
				</div>
			</div>
			<div class="footer1">
				<h3>footer</h3>
			</div>
		</div>
	</div>
</body>
</html>