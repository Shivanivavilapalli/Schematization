<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="Bootstrap.jsp" %>
</head>
<body>
<section>
  <div class="container">
    <div class="row">
      <div class="col-md-8">
        <div class="card">
          <div class="card-content">
            <form action="register" method="post">
              <input type="text" placeholder="enter your name" class="form-control" name="username">
              <input type="email" placeholder="email" class="form-control" name="email">
              <input type="password" placeholder="password" class="form-control" name="password">
              <input type="password" placeholder="confirm password" class="form-control" name="confirmpassword">
              <button class = "btn btn-outline-primary">Register</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>