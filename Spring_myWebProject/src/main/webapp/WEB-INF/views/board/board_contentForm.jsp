<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/mySetting.jsp" %>
<%@ include file="/resources/myQuery.jsp" %>
<script src="${myProject }script.js"></script>
<link type="text/css" rel="stylesheet" href="${myProject }style.css">
<html>
<body>
	<h2><center>상세페이지</center></h2>
	<div class="site-wrapper">
		<div class="part-header">
			<header class="top-menu">
				<div class="menu-bar">
					<ul class="menu-collector">
						<li class="myAccount"><a href="Main.html">로그아웃</a></li>
						<li class="language"><a href="#">언어</a></li>
						<li class="main_logo"><a href="host.html"><img src="./images/logo.png" style="width:250px; height:59px"></a>
						<li class="order_list"><a href="#">찜 목록</a></li>
						<li class="cart_list"><a href="#">장바구니</a></li>
					</ul>
				</div>
				<div class="navigator">
					<ul class="navi-collector">
						<li class="toMain"><a href="host.html">HOME</a></li>
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
								<a href="customer.html" itemprop="url" class="breadcrumb-label breadcrumb-link">
									<span itemprop="name">메인</span>
								</a>
							</li>
							<li class="breadcrumb ">
								<a href="cust_myAccount.html" itemprop="url" class="breadcrumb-label breadcrumb-link">
									<span itemprop="name">관리자 계정</span>
								</a>
							</li>
							<li class="breadcrumb-is-active">
								<span class="breadcrumb-label">
									<span itemprop="name">공지사항</span>
								</span>
							</li>
						</ul>
					</div>
					<div class="main-content">
						<section class="account-wrapper-account-page-orders-all">
							<nav class="account-nav">
								<ul class="account-nav-list">
									<li class="account-nav-item">
										<a class="account-nav-link" href="host_myAccount.html" style="text-align:center;">
											재고관리
										</a>
									</li>
									<li class="account-nav-item">
										<a class="account-nav-link" href="host_manageOrder.html">주문관리</a>
									</li>
									<li class="account-nav-item">
										<a class="account-nav-link" href="host_finalAccount.html">결산</a>
									</li>
									<li class="account-nav-item-is-active">
										<a class="account-nav-link" href="boardList.board">게시판</a>
									</li>
									<li class="account-nav-item">
										<a class="account-nav-link" href="host_manageGuestInfo.html">회원관리</a>
									</li>
								</ul>
							</nav>
							<div class="account-body">
								<div class="account-header">
									<h1 class="account-heading">공지사항</h1>
									<div class="account-toolbar"></div>
								</div>
								<div class="account-empty">
									<table align="center">
										<tr>
											<th style="width:150px">글번호</th>
											<td style="width:150px">${bVo.getNum() }</td>
											
											<th style="width:150px">조회수</th>
											<td style="width:150px">${bVo.getReadcnt()}</td>
										</tr>
										<tr>
											<th style="width:150px">작성자</th>
											<td style="width:150px">${bVo.getWriter() }</td>
											
											<th style="width:150px">작성일</th>
											<td style="width:150px">
												<fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm" value="${bVo.getReg_date()}"/>
											</td>
										</tr>
										<tr>
											<th>글제목</th>
											<td colspan="3">${bVo.getSubject() }</td>
										</tr>
										<tr>
											<th>글내용</th>
											<td colspan="3">${bVo.getContent() }</td>
										</tr>
										<tr>
											<th>ip</th>
											<td colspan="3">${bVo.getIp() }</td>
										</tr>
										
										<tr>
											<th colspan="4">
												<input class="inputButton" type="button" value="글수정" onclick="window.location='board_modifyForm?num=${bVo.num}&pageNum=${requestScope.pageNum }'">
												<input class="inputButton" type="button" value="글삭제" onclick="window.location='board_deleteForm?num=${bVo.num}&pageNum=${requestScope.pageNum }'">
												<input class="inputButton" type="button" value="답글쓰기" onclick="window.location='writeBoard?num=${bVo.num}&ref=${bVo.ref}&ref_level=${bVo.ref_level}&ref_step=${bVo.ref_step}'">
												<input class="inputButton" type="button" value="목록보기" onclick="window.location='boardList?pageNum=${requestScope.pageNum}'">
											</th>
										</tr>
										
									</table>
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