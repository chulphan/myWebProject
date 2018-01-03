<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="mySetting.jsp" %>
<%@ include file="myQuery.jsp" %>
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
									<span itemprop="name">재고관리</span>
								</span>
							</li>
						</ul>
					</div>
					<div class="main-content">
						<section class="account-wrapper-account-page-orders-all">
							<nav class="account-nav">
								<ul class="account-nav-list">
									<li class="account-nav-item-is-active">
										<a class="account-nav-link" href="host_myAccount.do" style="text-align:center;">
											재고관리
										</a>
									</li>
									<li class="account-nav-item">
										<a class="account-nav-link" href="host_manageOrder.order">주문관리</a>
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
									<h1 class="account-heading">환불목록</h1>
									<div class="account-toolbar"></div>
								</div>
								<div class="account-empty">
									<form action="host_approvalRefundPro.refund" name="host_approvalRefundPro" id="host_approvalRefundPro" method="post">
										<table class="inventory_table" style="border:1px solid black">
											<tr class="inventory_row" style="background-color:gray;color:white;text-align:center;">
												<td class="inventory_column" colspan="2">&nbsp;&nbsp;&nbsp;&nbsp; </td>
												<td class="inventory_column" colspan="2"> 번호 </td>
												<td class="inventory_column" colspan="2"> 환불코드 </td>
												<td class="inventory_column" colspan="2"> 상품코드 </td>
												<td class="inventory_column" colspan="2"> 상품명 </td>
												<td class="inventory_column" colspan="2"> 구매자 </td>
												<td class="inventory_column" colspan="2"> 구매수량 </td>
												<td class="inventory_column" colspan="2"> 구매일자 </td>
												<td class="inventory_column" colspan="2"> 거래가격 </td>
												<td class="inventory_column" colspan="2"> 상태 </td>
											</tr>
											<c:if test="${requestScope.cnt > 0 }">
												<c:forEach var="rVo" items="${requestScope.rVos }" varStatus="status">
													<tr class="inventory_row" style="text-align:center">
														<td class="inventory_column" colspan="2"><input type="checkbox" name="checkRefund" value="${rVo.refund_code }"> </td>
														<td class="inventory_column" colspan="2"> ${rVo.num } </td>
														<td class="inventory_column" colspan="2"> ${rVo.refund_code } </td>
														<td class="inventory_column" colspan="2"> ${productInfo[status.index].product_code } </td>
														<td class="inventory_column" colspan="2"> ${productInfo[status.index].product_name } </td>
														<td class="inventory_column" colspan="2"> ${memberInfo[status.index].id } </td>
														<td class="inventory_column" colspan="2"> ${rVo.refund_amount } </td>
														<td class="inventory_column" colspan="2"> ${rVo.refund_date } </td>
														<td class="inventory_column" colspan="2"> ${rVo.refund_amount * productInfo[status.index].product_price } </td>
														<td class="inventory_column" colspan="2"> ${rVo.refund_status } </td>
													</tr>
												</c:forEach>
											</c:if>
											<c:if test="${requestScope.cnt == 0 }">
												<tr> 
													<td class="inventory_column" colspan="2"> 상품이 존재하지 않습니다</td>
												</tr>
											</c:if>
										</table>
										<table style="width:1000px" align="center">
											<th align="center">
												<c:if test="${requestScope.cnt > 0 }">
													<c:if test="${startPage > pageBlock }">
														<a href="printSalesList.sales">[◀◀]</a>
														<a href="printSalesList.sales?pageNum=${startPage - pageBlock }">[◀]</a>
													</c:if>
													
													<c:forEach var="i" begin="${startPage }" end="${endPage }">
														<c:if test="${i==currentPage }">
															<span><b>[${i }]</b></span>
														</c:if>
														<c:if test="${i!=currentPage }">
															<a href="printSalesList.sales?pageNum=${i }">[${i }]</a>
														</c:if>
													</c:forEach>
													<c:if test="${pageCount>endPage}">
														<a href="printSalesList.sales?pageNum=${startPage+pageBlock }">[▶]</a>
														<a href="printSalesList.sales?pageNum=${pageCount }">[▶▶]</a>
													</c:if>
												</c:if>
											</th>
										</table>
										<div class="operate_btn">
											<input type="button" id="slt_inven" onclick="window.history.back()" value="이전으로">
											<input type="submit" id="slt_inven"  value="환불승인">
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