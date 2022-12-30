<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List, com.winter.to.User" %>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="masterPage">Master</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="">About Us</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="">Contact Us</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Logout</a>
        </li>
       
      </ul>
    </div>
  </div>
</nav>
<br><br>

<%
	List<User> users = (List<User>)request.getAttribute("allUsers");
%>


<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Username</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
       <th scope="col">delete</th>
        <th scope="col">Update</th>
    </tr>
  </thead>
  <tbody>
  <% for(int i = 0; i < users.size(); i++) {%>
  
  <tr>
      <th scope="row"><%=i+1 %></th>
      <td><%=users.get(i).getUsername() %></td>
      <td><%=users.get(i).getName() %></td>
      <td><%=users.get(i).getEmail() %></td>
      <td><a href = "/delete/<%=users.get(i).getUsername() %>">delete</a></td>
      <td><a href = "">update</a></td>
    </tr>
  <%} %>
    
  </tbody>
</table>

</body>
</html>