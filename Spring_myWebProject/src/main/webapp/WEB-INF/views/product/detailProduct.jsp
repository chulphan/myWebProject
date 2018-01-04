<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/mySetting.jsp" %>
<%@ include file="/resources/myQuery.jsp" %>
<script src="${myProject }script.js"></script>
<link type="text/css" rel="stylesheet" href="${myProject }style.css">
<html>
<body>
	<div class="icons-svg-sprite">
		<svg style="position:absolute; width:0; height:0;" width="0" height="0" version="1.1" xmlns="http://www.w3.org/2000/svg" xmnls:xlink="http://www.w3.org/1999/xlink">
			<defs>
				<symbol id="icon-star" viewBox="0 0 1024 1024">
				 <title>star</title>
				 <path class="path1" d="M984.504 339.577c-47.75-21.094-174.154-30.282-283.219-34.282-34.154-98.685-88.749-246.342-134.435-291.469-18.627-18.435-48.374-18.435-67.034 0-45.654 45.158-100.278 192.813-134.403 291.469-109.034 4-235.376 13.187-283.19 34.253-25.818 11.411-36.614 42.838-22.938 68.093 31.126 57.28 110.064 142.531 209.126 226.499-27.094 110.25-45.126 210.938-49.936 279.782-2.682 37.779 36.579 64.221 70.125 46.56 62.013-32.925 141.645-67.862 244.749-132.56 32.006 20.096 237.859 138.093 267.002 138.093 27.814 0 49.875-23.866 47.872-52.093-4.81-68.845-22.842-169.533-49.936-279.782 99.094-84 178.032-169.251 209.126-226.531 13.616-25.072 2.998-56.643-22.909-68.032v0z"></path>
				</symbol>
				<symbol id="icon-arrow-up" viewBox="0 0 1489 1024">
  				<title>arrow-up</title>
  				<path class="path1" d="M1186.251 890.277l-441.599-446.717-441.599 446.717c-69.413 69.413-181.72 69.413-251.133 0-69.041-70.157-69.413-183.581 0-253.738l567.398-572.795c69.041-69.413 181.72-69.413 251.133 0l567.026 572.795c69.32 70.157 69.32 183.581-0.093 253.738-69.413 69.413-181.72 69.413-251.133 0z"></path>
				</symbol>
				<symbol id="icon-arrow-left" viewBox="0 0 683 1024">
				<title>arrow-left</title>
				<path class="path1" d="M611.924 222.907l-292.493 289.142 292.493 289.142c45.449 45.449 45.449 118.983 0 164.432-45.936 45.205-120.202 45.449-166.138 0l-375.044-371.511c-45.449-45.205-45.449-118.983 0-164.432l375.044-371.267c45.936-45.388 120.202-45.388 166.138 0.061 45.449 45.449 45.449 118.983 0 164.432z"></path>
				</symbol>
				<symbol id="icon-arrow-right" viewBox="0 0 634 1024">
  				<title>arrow-right</title>
  				<path class="path1" d="M58.468 801.093l292.493-289.142-292.493-289.142c-45.449-45.449-45.449-118.983 0-164.432 45.936-45.205 120.202-45.449 166.138 0l375.044 371.511c45.449 45.205 45.449 118.983 0 164.432l-375.044 371.267c-45.936 45.388-120.202 45.388-166.138-0.061-45.449-45.449-45.449-118.983 0-164.432z"></path>
				</symbol>
				<symbol id="icon-plus" viewBox="0 0 1024 1024">
				<title>plus</title>
				<path class="path1" d="M133.766 603.15c-44.237 0-80.101-40.816-80.101-91.161v0c0-50.344 35.865-91.161 80.101-91.161h762.774c44.237 0 80.101 40.816 80.101 91.161v0c0 50.344-35.865 91.161-80.101 91.161h-762.774z"></path>
				<path class="path2" d="M515.153 973.477c-50.344 0-91.161-35.865-91.161-80.101v-762.774c0-44.237 40.816-80.101 91.161-80.101s91.161 35.865 91.161 80.101v762.774c0 44.237-40.816 80.101-91.161 80.101z"></path>
				</symbol>			
				<symbol id="icon-minus" viewBox="0 0 1024 1024">
			 	<title>minus</title>
			 	<path class="path1" d="M133.766 603.15c-44.237 0-80.101-40.816-80.101-91.161v0c0-50.344 35.865-91.161 80.101-91.161h762.774c44.237 0 80.101 40.816 80.101 91.161v0c0 50.344-35.865 91.161-80.101 91.161h-762.774z"></path>
				</symbol>
			</defs>
		</svg>
 	</div>
	
	<div class="site-wrapper">
		<div class="part-header">
			<header class="top-menu">
				<div class="menu-bar">
					<ul class="menu-collector">
						<li class="myAccount"><a href="mainSuccess.do">내 계정</a></li>
						<li class="language"><a href="#">언어</a></li>
						<li class="main_logo"><a href="#"><img src="./images/logo.png" style="width:250px; height:59px"></a>
						<li class="order_list"><a href="#">찜 목록</a></li>
						<li class="cart_list"><a href="#">장바구니</a></li>
					</ul>
				</div>
				<div class="navigator">
					<nav class="navigation">	
						<ul class="navi-collector">
							<li class="toMain"><a href="Main.html">HOME</a></li>
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
		<div class="site-canvas" style="padding-top:157px">
			<div class="on-canvas">
				<div class="main-content">
					<div class="breadcrumbs-container">
						<ul class="breadcrumbs" itemscope itemtype="http://schema.org/BreadcrumbList">
							<li class="breadcrumb">
								<a href="mainSuccess.do" itemprop="url" class="breadcrumb-label breadcrumb-link">
									<span itemprop="name">메인</span>
								</a>
							</li>
							<li class="breadcrumb ">
								<a href="cust_myAccount.html" itemprop="url" class="breadcrumb-label breadcrumb-link">
									<span itemprop="name">Action Figure</span>
								</a>
							</li>
							<li class="breadcrumb-is-active">
								<span class="breadcrumb-label">
									<span itemprop="name">BANDAI 143369 FIGUARTS ZERO ONE PIECE MARCO THE PHOENIX FIGURE</span>
								</span>
							</li>
						</ul>
					</div>
					<div itemscope itemtype="http://schema.org/Product">
						<section class="product-details-block-section-single-description-first" data-product-container data-product-title="Bandai 177470 Figuarts ZERO Brook One Piece 20th Anniversary Figure" data-product-id="23920">
							<div class="container">
								<div class="product-details-column">
									<div class="product-images-container">
										<div class="product-images-loader-initialized">
											<svg class="icon-icon-spiner">
												<use xlink:href="#icon-spinner">
													#shadow-root(closed)
														<svg id="icon-spinner" viewBox="0 0 1024 1024" width="100%" height="100%">
														<title>spinner8</title>
														<path class="path1" d="M512 1024c-136.76 0-265.334-53.258-362.040-149.96-96.702-96.706-149.96-225.28-149.96-362.040 0-96.838 27.182-191.134 78.606-272.692 50-79.296 120.664-143.372 204.356-185.3l43 85.832c-68.038 34.084-125.492 86.186-166.15 150.67-41.746 66.208-63.812 142.798-63.812 221.49 0 229.382 186.618 416 416 416s416-186.618 416-416c0-78.692-22.066-155.282-63.81-221.49-40.66-64.484-98.114-116.584-166.15-150.67l43-85.832c83.692 41.928 154.358 106.004 204.356 185.3 51.422 81.558 78.604 175.854 78.604 272.692 0 136.76-53.258 265.334-149.96 362.040-96.706 96.702-225.28 149.96-362.040 149.96z"></path>
														</svg>
												</use>
											</svg>
										</div>
										<div class="product-slides-container">
											<div class="product-slides-wrap-slick-initialized-slick-slider">
												<div class="slick-list-draggable" style="height:600px;">
													<div class="slick-track" style="opacity:1; width:1908px; transform:translate3d(75px, 0px, 0px);">
														<a class="product-image-slick-slide-no-zoom" style="background-image:url('../images/best-sell-images/afImages/BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE.jpg'); width:477px; height:550px;"  href="#" data-product-image data-slick-index="0" aria-hidden="true" tabindex="-1">
															<img src="/WebProject_jsp/a/images/best-sell-images/afImages/BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE.jpg" alt="BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE">
														</a>
														<a class="product-image-slick-slide-no-zoom" style="background-image:url('../images/best-sell-images/afImages/BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE1.jpg'); width:477px; height:550px;" href="#" data-product-image data-slick-index="1" aria-hidden="false" tabindex="0">
															<img src="/WebProject_jsp/a/images/best-sell-images/afImages/BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE1.jpg" alt="BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE">
														</a>
														<a class="product-image-slick-slide-no-zoom" style="background-image:url('../images/best-sell-images/afImages/BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE2.jpg'); width:477px; height:550px;" href="#" data-product-image data-slick-index="2" aria-hidden="true" tabindex="-1">
															<img src="/WebProject_jsp/a/images/best-sell-images/afImages/BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE2.jpg" alt="BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE">
														</a>
														<a class="product-image-slick-slide-current-slick-active-no-zoom" style="background-image:url('../images/best-sell-images/afImages/BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE3.jpg'); width:477px; height:550px;" href="#" data-product-image data-slick-index="3" aria-hidden="true" tabindex="-1">
															<img src="/WebProject_jsp/a/images/best-sell-images/afImages/BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE3.jpg" alt="BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE">
														</a>
													</div>
												</div>
											</div>
											<p style="text-align:center; text-transform:uppercase;">Click to open expanded view</p>
										</div>
										<div class="product-images-pagination-has-arrows-slick-initialized-slick-slider">
											<div class="product-images-pagination-icon-pagination-prev-slick-arrow" aria-disabled="true" style>
												<svg>
													<use xlink:href="#icon-arrow-left">
														#shadow-root (closed)
													</use>
												</svg>
											</div>
											<div class="slick-list-draggable">
												<div class="slick-track" style="opacity:1; width:504px; transform:translate3d(0px, 0px, 0px);">
													<div class="pagination-item-slick-slide-slick-active" data-slick-index="0" aria-hidden="false" tabindex="0" style="width:72px;">
														<img src="/WebProject_jsp/a/images/best-sell-images/afImages/BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE.jpg" alt="BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE">
													</div>
													<div class="pagination-item-slick-slide" data-slick-index="1" aria-hidden="false" tabindex="0" style="width:72px;">
														<img src="/WebProject_jsp/a/images/best-sell-images/afImages/BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE1.jpg" alt="BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE">
													</div>
													<div class="pagination-item-slick-slide" data-slick-index="2" aria-hidden="false" tabindex="0" style="width:72px;">
														<img src="/WebProject_jsp/a/images/best-sell-images/afImages/BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE2.jpg" alt="BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE">
													</div>
													<div class="pagination-item-slick-slide" data-slick-index="3" aria-hidden="true" tabindex="-1" style="width:72px;">
														<img src="/WebProject_jsp/a/images/best-sell-images/afImages/BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE3.jpg" alt="BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE">
													</div>
												</div>
											</div>
											<div class="product-images-pagination-icon-next-slide-arrow-slick-disabled" style aria-disabled="false">
												<svg>
													<use xlink:href="#icon-arrow-right">
														#shadow-root (closed)
													</use>
												</svg>
											</div>
										</div>
									</div>
								</div>
								<div class="product-details-column">
									<span itemprop="brand" itemscope itemtype="http://schema.org/Brand">
										<a class="product-brand" href="#" itemprop="url">
											<span itemprop="name">Bandai</span>
										</a>
									</span>
									<h1 class="product-title" itemprop="name">BANDAI 143369 FIGUARTS ZERO ONE PIECE  MARCO THE PHOENIX FIGURE</h1>
									<div class="product-price" itemprop="offers" itemscope itemtype="http://schema.org/Offer">
										<div>
											<div class="product-price-line" data-product-price-wrapper="without-tax">
												<span class="price-rrp-highlight">KRW00,000</span>
												<meta itemprop="price" content="4810">
												<meta itemprop="priceCurrency" content="KRW">
												<meta itemprop="availability" content="Reservations for this item are Closed.">
												<meta itemprop="itemCondition" itemtype="http://schema.org/OfferItemCondition" content="http://schema.org/Condition">
												<span class="price-value">KRW00,000</span>
											</div>
											<div class="price-you-save" data-product-price-saved>
												"You Save KRW0,000"
												<p style="color: red; font-size: 1.2em; margin:0 10px; display:inline-block; background:#fde6ca; border-radius:20px; padding:0 15px;">
													00% OFF!!
												</p>
											</div>
										</div>
									</div>
									<div class="product-rating-block">
										<div class="product-item-rating">
											<span class>
												<svg class="icon-icon-star">
													<use xlink:href="#icon:star">
														#shadow-root(closed)
															<svg id="icon-star" viewBox="0 0 1024 1024" width="100%" height="100%">
  															<title>star</title>
  															<path class="path1" d="M984.504 339.577c-47.75-21.094-174.154-30.282-283.219-34.282-34.154-98.685-88.749-246.342-134.435-291.469-18.627-18.435-48.374-18.435-67.034 0-45.654 45.158-100.278 192.813-134.403 291.469-109.034 4-235.376 13.187-283.19 34.253-25.818 11.411-36.614 42.838-22.938 68.093 31.126 57.28 110.064 142.531 209.126 226.499-27.094 110.25-45.126 210.938-49.936 279.782-2.682 37.779 36.579 64.221 70.125 46.56 62.013-32.925 141.645-67.862 244.749-132.56 32.006 20.096 237.859 138.093 267.002 138.093 27.814 0 49.875-23.866 47.872-52.093-4.81-68.845-22.842-169.533-49.936-279.782 99.094-84 178.032-169.251 209.126-226.531 13.616-25.072 2.998-56.643-22.909-68.032v0z"></path>
															</svg>
													</use>
												</svg>
											</span>
											<span class>
												<svg class="icon-icon-star">
													<use xlink:href="#icon:star">
														#shadow-root(closed)
															<svg id="icon-star" viewBox="0 0 1024 1024" width="100%" height="100%">
  															<title>star</title>
  															<path class="path1" d="M984.504 339.577c-47.75-21.094-174.154-30.282-283.219-34.282-34.154-98.685-88.749-246.342-134.435-291.469-18.627-18.435-48.374-18.435-67.034 0-45.654 45.158-100.278 192.813-134.403 291.469-109.034 4-235.376 13.187-283.19 34.253-25.818 11.411-36.614 42.838-22.938 68.093 31.126 57.28 110.064 142.531 209.126 226.499-27.094 110.25-45.126 210.938-49.936 279.782-2.682 37.779 36.579 64.221 70.125 46.56 62.013-32.925 141.645-67.862 244.749-132.56 32.006 20.096 237.859 138.093 267.002 138.093 27.814 0 49.875-23.866 47.872-52.093-4.81-68.845-22.842-169.533-49.936-279.782 99.094-84 178.032-169.251 209.126-226.531 13.616-25.072 2.998-56.643-22.909-68.032v0z"></path>
															</svg>
													</use>
												</svg>
											</span>
											<span class>
												<svg class="icon-icon-star">
													<use xlink:href="#icon:star">
														#shadow-root(closed)
															<svg id="icon-star" viewBox="0 0 1024 1024" width="100%" height="100%">
  															<title>star</title>
  															<path class="path1" d="M984.504 339.577c-47.75-21.094-174.154-30.282-283.219-34.282-34.154-98.685-88.749-246.342-134.435-291.469-18.627-18.435-48.374-18.435-67.034 0-45.654 45.158-100.278 192.813-134.403 291.469-109.034 4-235.376 13.187-283.19 34.253-25.818 11.411-36.614 42.838-22.938 68.093 31.126 57.28 110.064 142.531 209.126 226.499-27.094 110.25-45.126 210.938-49.936 279.782-2.682 37.779 36.579 64.221 70.125 46.56 62.013-32.925 141.645-67.862 244.749-132.56 32.006 20.096 237.859 138.093 267.002 138.093 27.814 0 49.875-23.866 47.872-52.093-4.81-68.845-22.842-169.533-49.936-279.782 99.094-84 178.032-169.251 209.126-226.531 13.616-25.072 2.998-56.643-22.909-68.032v0z"></path>
															</svg>
													</use>
												</svg>
											</span>
											<span class>
												<svg class="icon-icon-star">
													<use xlink:href="#icon:star">
														#shadow-root(closed)
															<svg id="icon-star" viewBox="0 0 1024 1024" width="100%" height="100%">
  															<title>star</title>
  															<path class="path1" d="M984.504 339.577c-47.75-21.094-174.154-30.282-283.219-34.282-34.154-98.685-88.749-246.342-134.435-291.469-18.627-18.435-48.374-18.435-67.034 0-45.654 45.158-100.278 192.813-134.403 291.469-109.034 4-235.376 13.187-283.19 34.253-25.818 11.411-36.614 42.838-22.938 68.093 31.126 57.28 110.064 142.531 209.126 226.499-27.094 110.25-45.126 210.938-49.936 279.782-2.682 37.779 36.579 64.221 70.125 46.56 62.013-32.925 141.645-67.862 244.749-132.56 32.006 20.096 237.859 138.093 267.002 138.093 27.814 0 49.875-23.866 47.872-52.093-4.81-68.845-22.842-169.533-49.936-279.782 99.094-84 178.032-169.251 209.126-226.531 13.616-25.072 2.998-56.643-22.909-68.032v0z"></path>
															</svg>
													</use>
												</svg>
											</span>
											<span class>
												<svg class="icon-icon-star">
													<use xlink:href="#icon:star">
														#shadow-root(closed)
															<svg id="icon-star" viewBox="0 0 1024 1024" width="100%" height="100%">
  															<title>star</title>
  															<path class="path1" d="M984.504 339.577c-47.75-21.094-174.154-30.282-283.219-34.282-34.154-98.685-88.749-246.342-134.435-291.469-18.627-18.435-48.374-18.435-67.034 0-45.654 45.158-100.278 192.813-134.403 291.469-109.034 4-235.376 13.187-283.19 34.253-25.818 11.411-36.614 42.838-22.938 68.093 31.126 57.28 110.064 142.531 209.126 226.499-27.094 110.25-45.126 210.938-49.936 279.782-2.682 37.779 36.579 64.221 70.125 46.56 62.013-32.925 141.645-67.862 244.749-132.56 32.006 20.096 237.859 138.093 267.002 138.093 27.814 0 49.875-23.866 47.872-52.093-4.81-68.845-22.842-169.533-49.936-279.782 99.094-84 178.032-169.251 209.126-226.531 13.616-25.072 2.998-56.643-22.909-68.032v0z"></path>
															</svg>
													</use>
												</svg>
											</span>
											<span class="reviews-jumplink-total-reviews" data-scroll="#product-reviews">
												"
																(    "
												<a class="product-reviews-link-link" href="#product-reviews">0 Reviews</a>
												"    )
															"
											</span>
										</div>
									</div>
									<p class="message-neutral" style="text-align:center; border-radius:16px; color: white; font-size: 0.85em; padding:5px 0; background: #ce4e4d;">
										Reservations for this item are closed.
									</p>
									<div class="product-description" itemprop="description">
											<p>
												<span style="font-size:small">
												"This is a FIGUARTS ZERO ONE PIECE MARCO THE PHOENIX FIGURE!"
												</span>
											</p>
											<p>
												<span style="font-size: small;">Height is approx. 210mm</span>
											</p>
									</div>
									<div class="product-stock">
										<span class="product-details-hidden" data-product-stock="">Current stock:</span>
										<span class="product-details-hidden" data-product-stock="" data-product-stock-level="">0</span>
									</div>
									<hr>
									<form class="form-add-to-cart-form" name="detailProduct" method="get" action="buyProductForm"  data-cart-item-add data-product-options-count="0" novalidate="true">
										<input type="hidden" name="product_code" value="B123456" data-product-id>
										<input type="hidden" name="user_id" value="${sessionScope.curr_id}">
										<div class="product-options-container" data-product-option-change>
										
										</div>
										<div class="product-quantity-submit">
											<div class="product-quantity-container">
												<div class="form-field-inline">
													<label class="form-label">
														<strong class="form-label-text">Qty:</strong>
														<input type="text" class="product-quantity-form-input" name="qty" value="1" min="0" pattern="[0-9]" id="_ispbxii_0">
														<div class="product-quantity-toggle-wrapper">
															<span class="product-quantity-toggle-increment">
																<svg class="icon-icon-plus">
																	<use xlink:href="#icon-plus">
																		#shadow-root(closed)
																			<svg id="icon-plus" viewBox="0 0 1024 1024" width="100%" height="100%">
  																			<title>plus</title>
																			<path class="path1" d="M133.766 603.15c-44.237 0-80.101-40.816-80.101-91.161v0c0-50.344 35.865-91.161 80.101-91.161h762.774c44.237 0 80.101 40.816 80.101 91.161v0c0 50.344-35.865 91.161-80.101 91.161h-762.774z"></path>
																			<path class="path2" d="M515.153 973.477c-50.344 0-91.161-35.865-91.161-80.101v-762.774c0-44.237 40.816-80.101 91.161-80.101s91.161 35.865 91.161 80.101v762.774c0 44.237-40.816 80.101-91.161 80.101z"></path>
																			</svg>
																	</use>
																</svg>
															</span>
															<span class="product-quantity-toggle-decrement">
																<svg class="icon-icon-minus">
																	<use xlink:href="#icon-minus">
																		<svg id="icon-minus" viewBox="0 0 1024 1024" width="100%" height="100%">
																		<title>minus</title>
																		<path class="path1" d="M133.766 603.15c-44.237 0-80.101-40.816-80.101-91.161v0c0-50.344 35.865-91.161 80.101-91.161h762.774c44.237 0 80.101 40.816 80.101 91.161v0c0 50.344-35.865 91.161-80.101 91.161h-762.774z"></path>
																		</svg>
																	</use>
																</svg>
															</span>
														</div>
													</label>
												</div>	
											</div>
											<div class="button-primary-button-wide-progress">
												<input type="submit" value="Purchase">
											</div>
											<div class="wishlist-form" data-wishlist-dropdown>
												<!-- <a class="button-secondary-wide-add-to-wishlist" href="cust_wishlists.cart">Add to Wishlist</a> -->
												<input type="button" class="button-secondary-wide-add-to-wishlist" value="장바구니추가" onclick="addWishList();">
											</div>
										</div>
									</form>
									<div class="product-message-area" data-product-alerts>
									</div>
								</div>
							</div>
						</section>
						<section class="product-tabs-section">
						
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>