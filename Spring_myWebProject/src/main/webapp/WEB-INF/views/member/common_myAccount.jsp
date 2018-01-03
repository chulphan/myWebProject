<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/mySetting.jsp" %>
<%@ include file="/resources/myQuery.jsp" %>
<script src="${myProject }script.js"></script>
<link type="text/css" rel="stylesheet" href="${myProject }style.css">
<!-- <script type="text/javascript" src="./js/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(function(){
	$(".dropdown-toggle-top-level-nav-link").click(function(){
		var status = $(".dropdown-panel-mega-nav-panel-visible").css("display"); 
		if (status == "none"){
			$(".dropdown-panel-mega-nav-panel-visible").css("display", "block");
		}else{
			$(".dropdown-panel-mega-nav-panel-visible").css("display", "none");
		}
	});
});
</script> -->

<html>
<body onload="loginFocus();">


<div class="container">
		<div class="part-header">
			<header class="top-menu">
				<div class="menu-bar">
					<ul class="menu-collector">
						<li class="myAccount"><a href="common_myAccount">내 계정</a></li>
						<li class="language"><a href="#">언어</a></li>
						<li class="main_logo"><a href="mainSuccess"><img
								src="./images/logo.png" style="width: 250px; height: 59px"></a>
						<li class="order_list"><a href="#">찜 목록</a></li>
						<li class="cart_list"><a href="#">장바구니</a></li>
					</ul>
				</div>
				<div class="navigator">
					<nav class="navigation">	
						<ul class="navi-collector">
							<li class="toMain"><a href="mainSuccess">HOME</a></li>
							<li class="toShop">
								<a class="dropdown-toggle-top-level-nav-link" href="#">SHOP
									<svg class="icon-arrow-down" width="9" height="7" viewBox="0 0 9 7" xmlns="http://www.w3.org/2000/svg"><title>dropdown_arrow</title><path d="M1.832.753l2.668 2.7 2.67-2.7c.418-.42 1.097-.42 1.516 0 .417.424.42 1.11 0 1.533l-3.428 3.46c-.417.42-1.098.42-1.518 0L.314 2.287c-.42-.424-.42-1.11 0-1.533.42-.42 1.1-.42 1.518 0z">
									</path>
									</svg>
								</a>
								<div class="dropdown-panel-mega-nav-panel-visible">
									<div class="container">
										<div class="mega-nav-variant-container">
											<ul class="mega-nav-root-list">
												<li class="mega-nav-root-item" data-category-id="262">
													<a href="newArraivals.html">New Arrivals</a>
												</li>
												<li class="mega-nav-root-item" data-category-id="10" data-mega-nav-root-item>
													<a href="plasticModel.html">Plastic Model</a>
												</li>
											</ul>
										</div>
									</div>
								</div>
							</li>
							<li class="toFaq"><a href="#">FAQ</a></li>
							<li class="toInfo"><a href="#">주문/배송정보</a></li>
							<li class="toAbout"><a href="#">ABOUT US</a></li>
						</ul>
					</nav>	
				</div>
			</header>
		</div>
		<div class="myAccount_main">
			<div class="loginPage">
				<form name="login" action="loginPro" id="login" method="post" onsubmit="return loginCheck();">
					<h3>login</h3>
					<div class="input_box">
						
						<c:choose>
							<c:when test="${requestScope.isCheck > 0 }">
								<c:redirect url="loginSuccess"/>
							</c:when>
							<c:when test="${requestScope.isCheck < 0 }">
								<p> 아이디 또는 비밀번호를 확인해주세요.</p>
							</c:when>
							<c:otherwise>
								<p>....</p>
							</c:otherwise>
						</c:choose>
						
						<label for=login_id>아이디 :&nbsp;&nbsp;&nbsp; <input
							type="text" name="login_id" id="login_id"></label><br>
						<label	for=login_pw>비밀번호 : <input type="password"
							name="login_pw" id="login_pw"></label>
					</div>
					<div class="login_button">
						<br> <input type="submit" id="loginBtn" value="로그인">
						<input type="button" id="resetBtn" value="메인으로" onclick="window.history.back();">
					</div>
				</form>
			</div>
			<div class="signUp">
				<h3>회원가입</h3>
				<div class="signUp_message">
					
				</div>
				<div class="signUp_button">
					<a href="joinUs"><input type="button" id="go_signUp"
						value="회원가입하기"></a>
						<input type="button" id="no_signUp" value="메인으로" onclick="window.history.back();">
				</div>
			</div>
		</div>
		<div class="footer1">
			<h3>footer</h3>
		</div>
	</div>	
</body>
</html>