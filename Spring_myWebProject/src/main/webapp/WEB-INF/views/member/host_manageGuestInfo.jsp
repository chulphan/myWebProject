<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/mySetting.jsp" %>
<%@ include file="/resources/myQuery.jsp" %>
<script src="${myProject }script.js"></script>
<link type="text/css" rel="stylesheet" href="${myProject }style.css">
<html>
<body>
	<div class="site-wrapper">
		<div class="part-header">
			<header class="top-menu">
				<div class="menu-bar">
					<ul class="menu-collector">
						<li class="myAccount"><a href="logout.do">로그아웃</a></li>
						<li class="language"><a href="#">언어</a></li>
						<li class="main_logo"><a href="mainSuccess.do"><img src="./images/logo.png" style="width:250px; height:59px"></a>
						<li class="order_list"><a href="#">찜 목록</a></li>
						<li class="cart_list"><a href="#">장바구니</a></li>
					</ul>
				</div>
				<div class="navigator">
					<ul class="navi-collector">
						<li class="toMain"><a href="mainSuccess.do">HOME</a></li>
						<li class="toShop"><a href="#">SHOP</a></li>
						<li class="toFaq"><a href="#">FAQ</a></li>
						<li class="toInfo"><a href="#">주문/배송정보</a></li>
						<li class="toAbout"><a href="#">ABOUT US</a></li>
					</ul>
				</div>
			</header>
			<div class="site-canvas" style="padding-top:157px;">
				<div class="on-canvas">
					<div class="breadcrumbs-container">
						<ul class="breadcrumbs" itemscope itemtype="http://schema.org/BreadcrumbList">
							<li class="breadcrumb">
								<a href="mainSuccess.do" itemprop="url" class="breadcrumb-label breadcrumb-link">
									<span itemprop="name">메인</span>
								</a>
							</li>
							<li class="breadcrumb ">
								<a href="host_myAccount.do" itemprop="url" class="breadcrumb-label breadcrumb-link">
									<span itemprop="name">관리자 계정</span>
								</a>
							</li>
							<li class="breadcrumb-is-active">
								<span class="breadcrumb-label">
									<span itemprop="name">회원관리</span>
								</span>
							</li>
						</ul>
					</div>
					<div class="main-content">
						<section class="account-wrapper-account-page-orders-all">
							<nav class="account-nav">
								<ul class="account-nav-list">
									<li class="account-nav-link">
										<a class="account-nav-link" href="host_myAccount.do" style="text-align:center;">
											재고관리
										</a>
									</li>
									<li class="account-nav-item">
										<a class="account-nav-link" href="host_manageOrder.do">주문관리</a>
									</li>
									<li class="account-nav-item">
										<a class="account-nav-link" href="host_finalAccount.do">결산</a>
									</li>
									<li class="account-nav-item">
										<a class="account-nav-link" href="boardList.board">게시판</a>
									</li>
									<li class="account-nav-item-is-active">
										<a class="account-nav-link" href="host_manageGuestInfo.do">회원관리</a>
									</li>
								</ul>
							</nav>
							<div class="account-body">
								<div class="account-header">
									<h1 class="account-heading">회원관리</h1>
									<div class="account-toolbar"></div>
								</div>
								<div class="account-empty">
									<table class="manageGuest_table" style="border:1px solid black">
										<tr class="manageGuest_row" style="background-color:gray;color:white;text-align:center;">
											<td class="manageGuest_column"> 번호 </td>
											<td class="manageGuest_column" colspan="2"> 고객ID </td>
											<td class="manageGuest_column"> 이름 </td>
											<td class="manageGuest_column"> 성별 </td>
											<td class="manageGuest_column" colspan="2"> 생년월일 </td>
											<td class="manageGuest_column" colspan="2"> 주소 </td>
											<td class="manageGuest_column" colspan="2"> 이메일</td>
											<td class="manageGuest_column" colspan="2"> 휴대전화번호</td>
											<td class="manageGuest_column" colspan="2"> 가입일자</td>
											<td class="manageGuest_column" colspan="2"> 마지막 방문일자</td>
										</tr>
										<tr class="manageGuest_row" style="text-align:center">
											<td class="manageGuest_column"> 1 </td>
											<td class="manageGuest_column" colspan="2"> antil </td>
											<td class="manageGuest_column"> 김철환 </td>
											<td class="manageGuest_column"> 남 </td>
											<td class="manageGuest_column" colspan="2"> 90-06-17 </td>
											<td class="manageGuest_column" colspan="2"> 경기도 고양시 일산서구 주엽동<br>강선마을 롯데아파트 806동 203호</td>
											<td class="manageGuest_column" colspan="2"> chkim100617@outlook.kr</td>
											<td class="manageGuest_column" colspan="2"> 01085795014</td>
											<td class="manageGuest_column" colspan="2"> 2017-11-03</td>
											<td class="manageGuest_column" colspan="2"> 2017-11-03</td>
										</tr>
										<tr class="manageGuest_row" style="text-align:center">
											<td class="manageGuest_column"> 2 </td>
											<td class="manageGuest_column" colspan="2"> merong </td>
											<td class="manageGuest_column"> 홍길동</td>
											<td class="manageGuest_column"> 남</td>
											<td class="manageGuest_column" colspan="2"> 85-01-17</td>
											<td class="manageGuest_column" colspan="2"> 서울시 영등포구 </td>
											<td class="manageGuest_column" colspan="2"> hkd111@naver.com</td>
											<td class="manageGuest_column" colspan="2"> 01195462123</td>
											<td class="manageGuest_column" colspan="2"> 2011-10-23</td>
											<td class="manageGuest_column" colspan="2"> 2017-11-01</td>
										</tr>
										<tr class="manageGuest_row" style="text-align:center">
											<td class="manageGuest_column"> 3 </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column"> </td>
											<td class="manageGuest_column"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
										</tr>
										<tr class="manageGuest_row" style="text-align:center">
											<td class="manageGuest_column"> 4 </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column"> </td>
											<td class="manageGuest_column"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
										</tr>
										<tr class="manageGuest_row" style="text-align:center">
											<td class="manageGuest_column"> 5 </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column"> </td>
											<td class="manageGuest_column"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
										</tr>
										<tr class="manageGuest_row" style="text-align:center">
											<td class="manageGuest_column"> 6 </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column"> </td>
											<td class="manageGuest_column"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
										</tr>
										<tr class="manageGuest_row" style="text-align:center">
											<td class="manageGuest_column"> 7 </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column"> </td>
											<td class="manageGuest_column"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
											<td class="manageGuest_column" colspan="2"> </td>
										</tr>
									</table>
									<div class="operate_btn">
										<button name="updateGuestInfo" onclick="updateGuestInfo.jsp">고객정보 수정</button>
										<button name="deleteGuestInfo" onclick="deleteGuestInfo.jsp">고객정보 삭제</button>
										<button name="searchGuestInfo" onclick="searchGuestInfo.jsp">고객정보 검색</button>
										<button name="requestDropOutList" onclick="requestDropOutList.jsp">탈퇴요청리스트</button>
									</div>
								</div>
							</div>
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>