<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/mySetting.jsp" %>
<%@ include file="/resources/myQuery.jsp" %>
<script src="${myProject }script.js"></script>
<link type="text/css" rel="stylesheet" href="${myProject }style.css">
<html>
<body>
<body>
	<div class="site-wrapper">
		<div class="part-header">
			<header class="top-menu">
				<div class="menu-bar">
					<ul class="menu-collector">
						<li class="myAccount"><a href="mainSuccess.do">로그아웃</a></li>
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
									<span itemprop="name">게시판</span>
								</span>
							</li>
						</ul>
					</div>
					<div class="main-content">
						<section class="account-wrapper-account-page-orders-all">
							<nav class="account-nav">
								<ul class="account-nav-list">
									<li class="account-nav-item">
										<a class="account-nav-link" href="host_myAccount.order" style="text-align:center;">
											재고관리
										</a>
									</li>
									<li class="account-nav-item">
										<a class="account-nav-link" href="host_manageOrder.order">주문관리</a>
									</li>
									<li class="account-nav-item">
										<a class="account-nav-link" href="host_finalAccount.sales">결산</a>
									</li>
									<li class="account-nav-item-is-active">
										<a class="account-nav-link" href="boardList.board">게시판</a>
									</li>
									<li class="account-nav-item">
										<a class="account-nav-link" href="host_manageGuestInfo.do">회원관리</a>
									</li>
								</ul>
							</nav>
							<div class="account-body">
								<div class="account-header">
									<h1 class="account-heading">공지사항</h1>
									<div class="account-toolbar"></div>
								</div>
								<div class="account-empty">
									<table class="Notice_table" style="border:1px solid black">
										<tr class="Notice_row" style="background-color:gray;color:white;text-align:center;">
											<td class="Notice_column"> 번호 </td>
											<td class="Notice_column" colspan="2"> 작성자 </td>
											<td class="Notice_column" colspan="6"> 제목 </td>
											<td class="Notice_column" colspan="2"> 조회수 </td>
											<td class="Notice_column" colspan="2"> 작성일시 </td>
											<td class="Notice_column" colspan="2"> 아이피 </td>
										
										</tr>
										<c:if test="${requestScope.cnt != 0 }">
											<c:forEach var="bVo" items="${requestScope.bVos }">
												<tr class="Notice_row" style="text-align:center">
													<td class="Notice_column"> 
														${bVo.num } 
														<c:set var="number" value="${number-1 }"/>
													</td>
													<td class="Notice_column" colspan="6">
														<c:if test="${bVo.ref_level > 1 }">	
															<c:set var="wid" value="${(bVo.ref_level - 1) * 10 }"/>
														</c:if>
														<c:if test="${bVo.ref_level > 0 }">
															
														</c:if>
														<a href="board_contentForm?num=${bVo.num}&pageNum=${pageNum}&number=${number+1}">
															${bVo.subject }
														</a> 
														<c:if test="${bVo.readcnt>10 }">
															
														</c:if>
													</td>
													<td class="Notice_column" colspan="2"> ${bVo.writer } </td>
													<td class="Notice_column" colspan="2"> ${bVo.readcnt }</td>
													<td class="Notice_column" colspan="2"> ${bVo.reg_date }</td>
													<td class="Notice_column" colspan="2"> ${bVo.ip }</td>
												</tr>
											</c:forEach>
										</c:if>
										<c:if test="${requestScope.cnt == null }">
											<tr>
												<td>표시할 게시물이 없습니다.</td>
											</tr>
										</c:if>
									</table>
									
									<table style="width:1000px; height:auto;"  align="center">
										<th align="center">
											<c:if test="${requestScope.cnt > 0 }">
												<c:if test="${startPage > pageBlock }">
													<a href="boardList">[◀◀]</a>
													<a href="boardList?pageNum=${startPage-pageBlock }">[◀]</a>
												</c:if>
												
												<c:forEach var="page" begin="${startPage }" end="${endPage }">
													<c:if test="${page==currentPage }">
														<span><b>[${page}]</b></span>
													</c:if>
													<c:if test="${page!=currentPage }">
														<a href="boardList?pageNum=${pageNum}">[${pageNum}]</a>
													</c:if>
												</c:forEach>
												
												<c:if test="${pageCount>endPage }">
													<a href="boardList?pageNum=${startPage+pageBlock }">[▶]</a>
													<a href="boardList?pageNum=${pageCount }">[▶▶]</a>
												</c:if>
											</c:if>	
										</th>
									</table>
									<div class="operate_btn">
										<input type="button" id="writeBtn" onclick="window.location='writeBoard'" value="쓰기">
										<input type="button" id="searchBtn" onclick="searchBoard" value="검색">
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