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
						<c:choose>
							<c:when test="${sessionScope.curr_id == null }">
								<li class="myAccount"><a href="common_myAccount">내 계정</a></li>
							</c:when>
							<c:when test="${sessionScope.curr_id == 'manager' }">
								<li class="myAccount"><a href="host_myAccount">내 계정</a></li>
							</c:when>
							<c:otherwise>
								<li class="myAccount"><a href="cust_myAccount">내 계정</a></li>
							</c:otherwise>
						</c:choose>
						<li class="language"><a href="#">언어</a></li>
						<li class="main_logo">
						<a href="mainSuccess">
						<img src="${myProject }images/logo.png" id="main-logo" style="width:250px; height:59px">
						</a>
						<li class="order_list"><a href="#">찜 목록</a></li>
						<li class="cart_list"><a href="cust_wishlists">장바구니</a></li>
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
													<a href="plamodel_lists.board">Plastic Model</a>
												</li>
												<li class="mega-nav-root-item" data-category-id="12" data-mega-nav-root-item>
													<a href="plasticModel.html">Action Figure</a>
												</li>
												<li class="mega-nav-root-item" data-category-id="13" data-mega-nav-root-item>
													<a href="plasticModel.html">POKEMON</a>
												</li>
												<li class="mega-nav-root-item" data-category-id="14" data-mega-nav-root-item>
													<a href="plasticModel.html">JIGSAW PUZZLES</a>
												</li>
											</ul>
										</div>
									</div>
								</div>
							</li>
							<li class="toFaq"><a href="faq.html">FAQ</a></li>
							<li class="toInfo"><a href="#">주문/배송정보</a></li>
							<li class="toAbout"><a href="#">ABOUT US</a></li>
						</ul>
					</nav>	
				</div>
			</header>
		</div>
		<div class="part-main">
			<div class="main-slide">
				<h3>뭐 소개할만한거.</h3>
			</div>
			<div class="Category">
				<ul class="cate-navi">
					<li class="AF_cate">
						<a href="#"><img src="${myProject }images/figurebannercomp.jpg"></a>
					</li>
					<li class="PM_cate">
						<a href="#"><img src="${myProject }images/plasticmodelbannercomp.jpg"></a>
					</li>
					<li class="Poke_cate">
						<a href="#"><img src="${myProject }images/pokemonbannercomp.jpg"></a>
					</li>
					<li class="JP_cate">
						<a href="#"><img src="${myProject }images/puzzlesbannercomp.jpg"></a>
					</li>
				</ul>
			</div>
			<div class="best-seller">
				<h3>Best Seller</h3>
				<ul class="best-sell-navi">
					<li class=best1>	
						<div class="product-item-thumbnail">
							<a href="#"><img src="${myProject }images/best-sell-images/afImages/law_main.jpg"></a>
						</div>
						<div class="product-item-details">
							<div class="product-item-brand">BANDAI</div>
							<h5 class="product-item-brand">
							<a href="#">
							BANDAI 197843 FIGUARTS ZERO<br> TRAFALGAR LAW GAMMA KNIFE FIGURE<br>(ONE PIECE)<br><br>12345원
							</a>
							</h5>
						</div>
					</li>
					<li class=best2>
						<div class="product-item-thumbnail">
							<a href="#"><img src="${myProject }images/best-sell-images/plamodelImages/hi-v_main.jpg"></a>
						</div>
						<div class="product-item-details">
							<div class="product-item-brand">BANDAI</div>
							<h5 class="product-item-brand">
							<a href="#">
							BANDAI MG 222422 GUNDAM RX-93-V2<br> HI-V GUNDAM VERSIONKA WITH<br> SPECIAL DECAL 1/100 SCALE KIT<br><br>12345원
							</a>
							</h5>
						</div>
					</li>
					<li class=best3>
						<div class="product-item-thumbnail">
							<a href="#"><img src="${myProject }images/best-sell-images/pokemonImages/metamon_main.jpg"></a>
						</div>
						<div class="product-item-details">
							<div class="product-item-brand">&nbsp;</div>
							<h5 class="product-item-brand">
							<a href="#">
							&nbsp;&nbsp;<br>Pokemon Center Original Plush Doll<br>Hat Ditto (Metamon) 1028-<br><br>12345원
							</a>
							</h5>
						</div>
					<li class=best4>
						<div class="product-item-thumbnail">
							<a href="#"><img src="${myProject }images/best-sell-images/puzzleimages/bolivia_main.jpg"></a>
						</div>
						<div class="product-item-details">
							<div class="product-item-brand">&nbsp;</div>
							<h5 class="product-item-brand">
							<a href="#">
							&nbsp;&nbsp;<br>Yanoman Jigsaw Puzzle 10-1294<br>Salar de Uyuni Bolivia (1000 Pieces)<br><br>12345원
							</a>
							</h5>
						</div>
					</li>
				</ul>
			</div>
			<div class="recommend">
				<h3>추천상품</h3>
				<ul class="recommend-navi">
					<li class=recommend1><img src="${myProject }images/best-sell-images/afImages/BANDAI 177487 FIGUARTS ZERO RORONOA ZORO ONE PIECE 20TH ANNIVERSARY FIGURE.jpg"></li>
					<li class=recommend2><img src="${myProject }images/best-sell-images/afImages/BANDAI 177531 FIGUARTS ZERO MONKEY D LUFFY ONE PIECE 20TH ANNIVERSARY FIGURE.jpg"></li>
					<li class=recommend3><img src="${myProject }images/best-sell-images/afImages/BANDAI FIGUARTS ZERO ONE PIECE MONKEY D LUFFY BROTHER'S BOND FIGURE.jpg"></li>
					<li class=recommend4><a href="detailProduct?product_id=BANDAI 143369 "><img src="${myProject }images/best-sell-images/afImages/BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE.jpg"></a></li>
				</ul>
			</div>
			<div class="new-products">
				<h3>새로운 상품</h3>
				<ul class="new-products-navi-top">
					<li class="new1"><img src="${myProject }images/best-sell-images/plamodelImages/BANDAI GUNDAM W ENDLESS WALTZ HIRESOLUTION MODEL WING GUNDAM ZERO EW 1100 SCALE KIT 167464.jpg"></li>
					<li class="new2"><img src="${myProject }images/best-sell-images/plamodelImages/BANDAI MG 222361 MSZ010 ZZ GUNDAM VERSION KA (VER. KA) WITH SPECIAL DECAL 1100 SCALE KIT.jpg"></li>
					<li class="new3"><img src="${myProject }images/best-sell-images/plamodelImages/BANDAI MG 222415 GUNDAM NEO ZEON MSN04 SAZABI VERSION KA WITH SPECIAL DECAL 1100 SCALE KIT.jpg"></li>
					<li class="new4"><img src="${myProject }images/best-sell-images/plamodelImages/hi-v_main.jpg"></li>
				</ul>
			</div>
		</div>
		<div class="footer1">
			<footer class="main-footer">
				<h3>footer</h3>
			</footer>
		</div>
	</div>
</body>
</html>