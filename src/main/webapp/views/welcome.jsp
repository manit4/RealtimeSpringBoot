<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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


<%-- <h2>Welcome ${username }</h2> --%>

<h2>Welcome ${userData.getName() }</h2>

<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Username</th>
      <th scope="col">Complete Name</th>
      <th scope="col">Email</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>${userData.getUsername() }</td>
      <td>${userData.getName() }</td>
      <td>${userData.getEmail() }</td>
    </tr>
    
  </tbody>
</table>
</body>
</html>