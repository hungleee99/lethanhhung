<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
	<form action="ketqua.jsp" method="post">
		<input id="a" type="text" name="a">
		<input id="b" type="text" name="b">
		<input id="cong" type="submit" name="cong" value="cong">
		<input id="tru" type="submit" name="tru" value="tru">
		<input id="nhan" type="submit" name="nhan" value="nhan">
		<input id="chia" type="submit" name="chia" value="chia">
		<input id="kq" type="text" name="kq">
	</form>
</body>
<script src="jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$("#cong").click(function(){
			var a= parseInt($("#a").val());
			var b = parseInt($("#b").val());
			var c = (a+b);
			$("#kq").val(c);
		});
		$("#tru").click(function(){
			var a= $("#a").val();
			var b = $("#b").val();
			var c = a-b;
			$("#kq").val(c);
		});
		$("#nhan").click(function(){
			var a= $("#a").val();
			var b = $("#b").val();
			var c = a*b;
			$("#kq").val(c);
		});
		$("#chia").click(function(){
			var a= $("#a").val();
			var b = $("#b").val();
			var c = a/b;
			$("#kq").val(c);
		});
	});
</script>
</html>