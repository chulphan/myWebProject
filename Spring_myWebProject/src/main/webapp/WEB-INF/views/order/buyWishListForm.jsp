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
					<nav class="navigation">	
						<ul class="navi-collector">
							<li class="toMain"><a href="mainSuccess.do">HOME</a></li>
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
			<div class="site-canvas" style="padding-top:157px;">
				<div class="on-canvas">
					<div class="breadcrumbs-container">
						<ul class="breadcrumbs" itemscope itemtype="http://schema.org/BreadcrumbList">
							<li class="breadcrumb">
								<a href="mainSuccss.do" itemprop="url" class="breadcrumb-label breadcrumb-link">
									<span itemprop="name">메인</span>
								</a>
							</li>
							<li class="breadcrumb ">
								<a href="cust_myAccount.order" itemprop="url" class="breadcrumb-label breadcrumb-link">
									<span itemprop="name">내 계정</span>
								</a>
							</li>
							<li class="breadcrumb-is-active">
								<span class="breadcrumb-label">
									<span itemprop="name">내 주문</span>
								</span>
							</li>
						</ul>
					</div>
					<div class="main-content">
						<section class="account-wrapper-account-page-orders-all">
							<div class="account-body">
								<div class="account-header">
									<h1 class="account-heading">주문/결제</h1>
									<div class="account-toolbar"></div>
								</div>
									<form class="" action="buyWishListProductPro.order" name="buyWishListProductPro">  
										<c:forEach var="checkedCarttt" items="${checkedCart }" varStatus="status">	
											<input type="hidden" name="checkedCarts" value="${checkedCarttt}">
										</c:forEach>
										<div class="order-list">
											<h3>01. 주문상품목록</h3>
											<table class="order-table" style="border:1px solid black">
												<tr class="order-table_row">
													<td class="order-table_column" colspan=2>cartid</td>
													<td class="order-table_column" colspan=2>상품정보</td>
													<td class="order-table_column" colspan=2>판매가</td>
													<td class="order-table_column" colspan=2>수량</td>
													<td class="order-table_column" colspan=2>합계</td>
													<td class="order-table_column" colspan=2>배송/판매자</td>
												</tr>
												<c:forEach var="memberInfo" items="${memberInfo }" varStatus="status">
													<tr class="order-table_row">
														<td class="order_table_column" colspan=2>${checkedCart[status.index]}</td>
														<td class="order-table_column" colspan=2><img src="/WebProject_jsp/WebContent/a/images/best-sell-images/${productInfo[status.index].img_path }" style="width:100px;height:100px">${pVo.product_name }</td>
														<td class="order-table_column" colspan=2>${productInfo[status.index].product_price }</td>
														<td class="order-table_column" colspan=2>${productInfo[status.index].product_amount }</td>
														<td class="order-table_column" colspan=2>${productInfo[status.index].product_price * productInfo[status.index].product_amount}</td>
														<td class="order-table_column" colspan=2>host</td>
														<c:set var="totalPricee" value="${totalPrice = totalPrice + (productInfo[status.index].product_price * productInfo[status.index].product_amount) }" scope="request"/>
													</tr>
												</c:forEach>
											</table>
											<br><br>
											<table  class="order-table" style="border:1px solid black">
												<tr class="order-table_row">
													<th>상품금액</th>
													<th>배송비</th>
													<th>결제금액</th>
												</tr>
												<tr class="order-table_row">
													<td class="order-table_column">${totalPrice }</td>
													<td class="order-table_column">0</td>
													<td class="order-table_column">${totalPrice }</td>
												</tr>
											</table>
											<br><br>
											<h3>02. 배송지</h3>
											<table class="order-table" style="border:1px solid black">
												<tr class="order-table_row">
													<td class="order-table_column">
														주문정보
													</td>
													<td colspan="3">
														${memberInfo[0].name }&nbsp;&nbsp;|&nbsp;&nbsp;${memberInfo[0].email}&nbsp;&nbsp;|&nbsp;&nbsp;${memberInfo[0].hp}&nbsp;&nbsp; >> 주문/배송에 관한 SMS 및 메일이 발송됩니다.
													</td>
												</tr>
												<tr class="order-table_row">
													<td class="order-table_column">
														배송방법
													</td>	
													<td class="order-table_column">
														<label for="deliver">
															<input type="radio" id="deliver" value="normal" name="deliver">일반&nbsp;&nbsp;
															<input type="radio" id="deliver" value="convenStore" name="deliver">편의점&nbsp;&nbsp;
															<input type="radio" id="deliver" value="oversea" name="deliver">해외배송
														</label>
													</td>											
												</tr>
												<tr class="order-table_row">
													<td class="order-table_column">
														배송지정보
													</td>
													<td class="order-table_column"> 
														${memberInfo[0].name }<br>
														${memberInfo[0].hp }<br>
														${memberInfo[0].address }<br>
													</td>
												</tr>
												<tr class="order-table_row">
													<td class="order-table_column">
														배송일정
													</td>
													<td class="order-table_column">
														...일 출고 예정입니다.													
													</td>
												</tr>
											</table>
											<br><br>
											<h3>03. 결제정보</h3>
											<table class="order-table" style="border:1px solid black">
												<tr class="order-table_row">
													<td class="order-table_column">신용카드</td>
												</tr>
												<tr class="order-table_row">
													<td class="order-table_column">간편결제</td>
												</tr>
												<tr class="order-table_row">
													<td class="order-table_column">현금결제</td>
												</tr>
												<tr class="order-table_row">
													<td class="order-table_column">휴대폰 결제</td>
												</tr>
											</table>
										<div class="operate_btn">
											<input type="submit" value="결제하기">
											<input type="button" value="취소" onclick="window.history.back();">
										</div>
									</div>
								</form>
							</div>
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>