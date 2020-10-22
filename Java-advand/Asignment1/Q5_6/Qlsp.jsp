<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>qlsp</title>
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
	                    <div class="col-sm-12"><h2>Ds sản phẩm </h2></div>
	                </div>
	            </div>
	            <input id="myInput" type="text" placeholder="Search..">
	            <table class="table table-bordered">
	                <thead class="thead-dark">
	                    <tr>
	                    	<th>stt</th>
	                        <th>Tên VXL</th>
	                        <th>Hãng</th>
	                        <th>Ngày ra mắt</th>
	                        <th>Giá</th>
	                    </tr>
	                </thead>
	                <tbody id="myTable">
	                    <td>
	                    	<%
								int stt = 0;
	                    		stt++;
								out.print(stt);
							%>
	                    </td>
    	                <td>
	                    	<%
								String name = request.getParameter("name");
								out.print(name);
							%>
	                    </td>
	                    <td>
	                    	<%
								String hang = request.getParameter("hang");
								out.print(hang);
							%>
	                    </td>
	                    <td>
	                    	<%
								String ngay = request.getParameter("date");
								out.print(ngay);
							%>
	                    </td>
	                    <td>
	                    	<%
								String gia = request.getParameter("gia");
								out.print(gia);
							%>
	                    </td>
	                </tbody>
	            </table>
	        </div>
	    </div>

    <div id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modal-title">Add San Phẩm</h5>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                <form action="Qlsp.jsp">
	                    <div class="modal-container">                   
	                        <label for="name"><b>Tên VXL:</b></label>
	                        <input type="text" placeholder="Enter Name" name="name" id="name" required> 	
	                        <label for="hãng"><b>Hãng:</b></label>
	                        <input type="text" placeholder="Enter hãng" name="hang" id="hang" required> 	                                      
	                        <label for="date"><b>Ngày ra mắt</b></label>
	                        <input type="datetime-local"  name="date" id="date" required></div>
	                        <label for="gia"><b>Giá:</b></label>
	                        <input type="text" placeholder="Enter gia" name="gia" id="gia" required>               
		                    <input type="submit" class="btn btn-primary" value="Thêm" >
		                    <input type="reset" class="btn btn-secondary" value="Huy">
		                </div>
                </form>
            </div>
        </div>
    </div>
</div>     
</body>
</html>