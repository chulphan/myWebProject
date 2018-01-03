<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/mySetting.jsp" %>
<%@ include file="/resources/myQuery.jsp" %>
<script src="${myProject }script.js"></script>
<link type="text/css" rel="stylesheet" href="${myProject }style.css">
<html>
<body>

	<div class="account-empty">
		<table class="inventory_table" style="border:1px solid black">
			<tr class="inventory_row" style="background-color:gray;color:white;text-align:center;">
				<td class="inventory_column"> 번호 </td>
				<td class="inventory_column" colspan="2"> 상품코드 </td>
				<td class="inventory_column" colspan="2"> 제조사 </td>
				<td class="inventory_column" colspan="2"> 상품명 </td>
				<td class="inventory_column" colspan="2"> 가격 </td>
				<td class="inventory_column" colspan="2"> 수량 </td>
			</tr>
			<c:if test="${requestScope.cnt != 0 }">
				<c:forEach var="pVo" items="${requestScope.pVo }">
					<tr class="inventory_row" style="text-align:center">
						<td class="inventory_column"> ${pVo.num } </td>
						<td class="inventory_column" colspan="2"> ${pVo.product_code } </td>
						<td class="inventory_column" colspan="2"> ${pVo.product_company } </td>
						<td class="inventory_column" colspan="2"> ${pVo.product_name } </td>
						<td class="inventory_column" colspan="2"> ${pVo.product_price } </td>
						<td class="inventory_column" colspan="2"> ${pVo.product_amount } </td>
						<td class="inventory_column" colspan="2"> ${pVo.img_path }</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${requestScope.cnt == null }">
				<tr>
					<td class="inventory_column" colspan="2"> 상품이 존재하지 않습니다</td>
				</tr>
			</c:if>
		</table>
		<table style="width:1000px" align="center">
			<th align="center">
				<c:if test="${requestScope.cnt > 0 }">
					<c:if test="${startPage > pageBlock }">
						<a href="host_sltInvenView.pdt">[◀◀]</a>
						<a href="host_sltInvenView.pdt?pageNum=${startPage - pageBlock }">[◀]</a>
					</c:if>
					
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<c:if test="${i==currentPage }">
							<span><b>[${i }]</b></span>
						</c:if>
						<c:if test="${i!=currentPage }">
							<a href="host_sltInvenView.pdt?pageNum=${i }">[${i }]</a>
						</c:if>
					</c:forEach>
					<c:if test="${pageCount>endPage}">
						<a href="host_sltInvenView.pdt?pageNum=${startPage+pageBlock }">[▶]</a>
						<a href="host_sltInvenView.pdt?pageNum=${pageCount }">[▶▶]</a>
					</c:if>
				</c:if>
			</th>
		</table>
	</div>
	
	
</body>
</html>