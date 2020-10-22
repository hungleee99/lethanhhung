<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="popper.min.js"></script>
<script type="text/javascript" src="bootstrap.min.js"></script>
</head>
<body>
		<div class="container-lg">
	    <div class="table-responsive">
	        <div class="table-wrapper">
	            <div class="table-title">
	                <div class="row">
	                    <div class="col-sm-12"><h2>Ds nhan vien </h2></div>
	                </div>
	            </div>
	            <table class="table table-bordered">
	                <thead class="thead-dark">
	                    <tr>
	                        <th>Họ Tên</th>
	                        <th>năm sinh</th>
	                        <th>giới tính</th>
	                        <th>sdt</th>
	                    </tr>
	                </thead>
	                <tbody id="myTable">
    	                <td>
	                    	<%
								String name = request.getParameter("name");
								out.print(name);
							%>
	                    </td>
	                    <td>
	                    	<%
								String ns = request.getParameter("ns");
								out.print(ns);
							%>
	                    </td>
	                    <td>
	                    	<%
								String gender = request.getParameter("gender");
								out.print(gender);
							%>
	                    </td>
	                    <td>
	                    	<%
								String sdt = request.getParameter("sdt");
								out.print(sdt);
							%>
	                    </td>
	                </tbody>
	            </table>
	        </div>
	    </div>
</body>
</html>