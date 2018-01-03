/**
 * 
 */
 
var inputEmptyId = "아이디를 입력해주세요!";
var inputEmptyPw = "비밀번호를 입력해주세요!";
var inputEmptyName = "이름을 입력해주세요!";
var inputEmptyBirth = "주민번호를 입력해주세요!";
var inputEmptyEmail = "이메일을 입력해주세요!";
var inputEmptyHp = "휴대전화 번호를 입력해주세요!"
 
var insertError = "회원가입에 실패하였습니다. 잠시후에 다시 시도해주세요."
var insertSuccess = "회원가입에 성공하였습니다. 로그인을 해주세요!"
var dropFailed = "회원탈퇴처리에 실패했습니다. 다시 시도해주세요.";
var ErrorIdOrPw = "아이디 또는 비밀번호가 틀렸습니다 확인해주세요";
// 이거 어떻게 쓰지??.. 써야되는데ㅠㅠㅜㅠㅜㅠㅠㅠㅜㅠㅜㅠㅜㅠㅜㅠㅜ
 
 
function joinCheck(){
	if(!document.join.juser_id.value){
		alert(inputEmptyId);
		document.join.juser_id.focus();
		return false;
	}
	
	if (!document.join.juser_pw.value){
		alert(inputEmptyPw);
		document.join.juser_pw.focus();
		return false;
	}
	
	if (!document.join.juser_rpw.value){
		alert(inputEmptyPw);
		document.join.juser_rpw.focus();
		return false;
	}
	
	if (!document.join.juser_name.value){
		alert(inputEmptyName);
		document.join.juser_name.focus();
		return false;
	}
	
	if (!document.join.juser_birth.value){
		alert(inputEmptyBirth);
		document.join.juser_birth.focus();
		return false;
	}
	
	if (!document.join.juser_email.value){
		alert(inputEmptyEmail);
		document.join.juser_email.focus();
		return false;
	}
	
	if (!document.join.juser_phone.value){
		alert(inputEmptyHp);
		document.join.juser_phone.focus();
		return false;
	}
}
 
function pwdCheck(){
	if (!document.intoAccSetPro.pw.value){
		alert(inputEmptyPw);
		document.intoAccSetPro.pw.focus();
		return false;
	}
}
 
function printMsg(msg){
	alert(msg);
}
 
function printError(msg){
	alert(msg);
	window.history.back();
}
 
function loginFocus(){
	document.login.login_id.focus();
}
 
function loginCheck(){
	if (!document.login.login_id.value){
		alert(inputEmptyId);
		document.login.login_id.focus();
		return false;
	}
	
	if (!document.login.login_pw.value){
		alert(inputEmptyPw);
		document.login.login_pw.focus();
		return false;
	}
}
 
function confirmId(){
	if (!document.join.juser_id.value){
		alert(inputEmptyId);
		document.join.juser_id.focus();
	}
	
	var url="confirmId?id=" + document.join.juser_id.value;
	window.open(url, "confirm", "menubar=no, width=300, height=300");
}
 
function setId(id){
	opener.document.join.juser_id.value=id;
	opener.document.join.juser_pw.focus();
	opener.document.join.hiddenId.value="1";
	self.close();
}
 
function joinFocus(){
	document.join.juser_id.focus();
}
 
function confirmIdCheck(){
	if(!document.confirmForm.id.value){
		alert(inputEmptyId);
		document.confirmForm.id.focus();
		return false;
	}
}
 
function confirmIdFocus(){
	document.confirmForm.id.focus();
}
 
function birthCheck(){
	
}
 
function page_move(pw){
	var f = document.join;
	f.pw.value = pw;
	f.action = "cust_deletePro";
	f.method="post";
	f.submit();
}
 
function goBuyWishlist(mode){
	
	var where = document.wishlistForm;
	
	if (mode == "1"){
		where.action="buyWishListForm.order";
	}else{
		where.action="deleteWishList.cart";
	}
	
	where.submit();
}
 
function addWishList(){
	var path = document.detailProduct;
	
	path.action = "addWishList.cart";
	
	path.submit();
}
 
 
/*function go(where){
	var path1 = document.manageOrderForm;
	
	if (where == "1"){
		path1.action="host_approvalPay.sales";
	}else{
		path1.action="printSalesList.sales";
	}
	path1.submit();
}
*/
 
 
function goHostApproval(){
	document.getElementById("manageOrderForm").action="host_approvalPay.sales";
	document.getElementById("manageOrderForm").submit();
}
 
function goPrintSalesList(){
	document.getElementById("manageOrderForm").action="printSalesList.sales";
	document.getElementById("manageOrderForm").submit();
}

function cust_refundPro(){
	
}

function cust_printSales(){
	document.getElementById("cust_myAccountForm").action="cust_printSales.sales";
	document.getElementById("cust_myAccountForm").submit();
}