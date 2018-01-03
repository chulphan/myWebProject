<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.js"></script>
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
</script>