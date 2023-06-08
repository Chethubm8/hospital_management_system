<%@page import="dto.Doctor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image:url('file:///C:/Desktop/project/HOSPITALMANAGEMENTSYSTEM/src/main/webapp/images/doctorimg.jpg') height: 100%,width: 100%; ">
<% List<Doctor>list=(List<Doctor>)request.getAttribute("list");%>
<table border=2px>
<tr>
<th>Id</th>
<th>name</th>
<th>mobile</th>
<th>age</th>
<th>Status</th>
<th>ChangeStatus</th>
</tr>
<% for(Doctor doctor:list){%>
<tr>

<th><%=doctor.getId()%></th>
<th><%=doctor.getName()%></th>
<th><%=doctor.getMobile()%></th>
<th><%=doctor.getAge()%></th>
<th><%=doctor.isStatus()%></th>
<th> <a href="changedoctorstatus?id=<%=doctor.getId()%>"><button>Change</button></a></th>
</tr>
<%} 
%>

</body>
</html>