<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="challenge.DAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"></script>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
<script>
$(document).ready(function(){
	$("#tablediv").hide();
	$("#list").click(function(event){
		$.get('Controller', function(responseJson) {
			if(responseJson != null){
				$("#ticketTable").find("tr:gt(0)").remove();
				var table1 = $("#ticketTable");
				$.each(responseJson, function(key, value) {
// 				console.log(value['id']);
// 				console.log(value['subject']);
// 				console.log(value['description']);
				$("#result").text(value['id']);
				var rowNew = $("<tr><td></td><td></td><td></td></tr>");
					rowNew.children().eq(0).text(value['id']);
					rowNew.children().eq(1).text(value['subject']);
					rowNew.children().eq(2).text(value['description']);
					rowNew.appendTo(table1);
					
				
			});
			}
		});
		$("#tablediv").show();
	});
});
</script>

</head>
<body class="container">
<h1> Zendesk Mobile Ticket Views</h1>
<input type="button" value = "View Ticket List" id="list">
<div id="tablediv">
<table cellspacing="5" id="ticketTable">
	<tr>
		<th scope="col">ID</th>
		<th scope="col">SUBJECT</th>
		<th scope="col">DESCRIPTION</th>
	</tr>
</table>
<div id="result">
</div>
</div>
</body>
</html>