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
									<span itemprop="name">주문관리</span>
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
									<li class="account-nav-item-is-active">
										<a class="account-nav-link" href="host_manageOrder.do">주문관리</a>
									</li>
									<li class="account-nav-item">
										<a class="account-nav-link" href="host_finalAccount.do">결산</a>
									</li>
									<li class="account-nav-item">
										<a class="account-nav-link" href="boardList.board">게시판</a>
									</li>
									<li class="account-nav-item">
										<a class="account-nav-link" href="host_manageGuestInfo.do">회원관리</a>
									</li>
								</ul>
							</nav>
							<div class="account-body">
								<div class="account-header">
									<h1 class="account-heading">주문관리</h1>
									<div class="account-toolbar"></div>
								</div>
								<div class="account-empty">
									<form action="host_approvalPay" name="manageOrderForm" id="manageOrderForm" method="post">
										<table class="orderList_table" style="border:1px solid black">
											<tr class="orderList_row" style="background-color:gray;color:white;text-align:center;">
												<td class="orderList_column">&nbsp;</td>
												<td class="orderList_column"> 번호 </td>
												<td class="orderList_column" colspan="2"> 주문번호 </td>
												<td class="orderList_column" colspan="2"> 상품코드</td>
												<td class="orderList_column" colspan="2"> 합계(가격*수량)</td>
												<td class="orderList_column" colspan="2"> 요구수량</td>
												<td class="orderList_column" colspan="2"> 고객ID</td>
												<td class="orderList_column" colspan="2"> 배송지</td>
												<td class="orderList_column" colspan="2"> 상태</td>
											</tr>
											<c:if test="${requestScope.cnt > 0 }">
												<c:forEach var="oAry" items="${requestScope.oAry }" varStatus="status">
													<tr class="orderList_row" style="text-align:center">
														<td class="orderList_column"><input type="checkbox" class="checkOrder" name="checkOrder" value="${oAry.order_code }"></td>
														<td class="orderList_column"> ${oAry.num } </td>
														<td class="orderList_column" colspan="2"> ${oAry.order_code } </td>
														<td class="orderList_column" colspan="2"> ${oAry.product_code } </td>
														<td class="orderList_column" colspan="2"> ${oAry.purchase_price } (${oAry.product.product_price} * ${oAry.amountOfPurchase }) </td>
														<td class="orderList_column" colspan="2"> ${oAry.amountOfPurchase } </td>
														<td class="orderList_column" colspan="2"> ${oAry.id } </td>
														<td class="orderList_column" colspan="2"> ${oAry.member.address}</td>
														<td class="orderList_column" colspan="2"> ${oAry.order_status } </td>
													</tr>
												</c:forEach>
											</c:if>
											<c:if test="${requestScope.cnt == 0 }">
												<tr class="orderList_row"> 
													<td class="orderList_column" colspan="2"> 상품이 존재하지 않습니다</td>
												</tr>
											</c:if>
										</table>
										<table style="width:1000px" align="center">
											<th align="center">
												<c:if test="${requestScope.cnt > 0 }">
													<c:if test="${startPage > pageBlock }">
														<a href="host_myAccount">[◀◀]</a>
														<a href="host_myAccount?pageNum=${startPage - pageBlock }">[◀]</a>
													</c:if>
													
													<c:forEach var="i" begin="${startPage }" end="${endPage }">
														<c:if test="${i==currentPage }">
															<span><b>[${i }]</b></span>
														</c:if>
														<c:if test="${i!=currentPage }">
															<a href="host_myAccount?pageNum=${i }">[${i }]</a>
														</c:if>
													</c:forEach>
													<c:if test="${pageCount>endPage}">
														<a href="host_myAccount?pageNum=${startPage+pageBlock }">[▶]</a>
														<a href="host_myAccount?pageNum=${pageCount }">[▶▶]</a>
													</c:if>
												</c:if>
											</th>
										</table>
										<div class="operate_btn">
											<input type="submit" name="approvalPay" id="approvalPay"  value="결제승인">    <!-- onclick에 메소드를 만들자. -->
											<input type="button" name="deleteList" id="deleteList" onclick="location.href='deleteOrderList.jsp'" value="목록삭제">
											<input type="button" name="printSalesList" id="deleteList" onclick="window.location='printSalesList.sales'" value="거래완료목록">
										</div>
									</form>
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