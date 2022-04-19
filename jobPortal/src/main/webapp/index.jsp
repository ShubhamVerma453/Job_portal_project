<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jab Portal</title>
<%@include file="all_component/all_css.jsp"%>
<style type="text/css">
.back-img {
	background: url("image/job3.jpg");
	width: 100%;
	height: 91vh;
	background-repeat: no-report;
	background-size: cover;
}
</style>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	

	<div class="container-fluid back-img">
		<div class="text-center">
			<h1 class="text-white p-5">
				<i class="fa-solid fa-person-to-portal ">Job  Portal</i> 
			</h1>
		</div>
	</div>
</body>
</html>