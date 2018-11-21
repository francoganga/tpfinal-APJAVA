<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/common.js"></script>

  </head>
  <body>

    <div class="login-page">
      <div class="form">
        <form:form class="register-form" action="">
          <input type="text" placeholder="name"/>
          <input type="password" placeholder="password"/>
          <input type="text" placeholder="email address"/>
          <button>create</button>
          <p class="message">Already registered? <a href="#">Sign In</a></p>
        </form:form>
        <form:form class="login-form" action="${contextPath}/login">
          <input type="text" placeholder="username"/>
          <input type="password" placeholder="password"/>
          <input type="submit" value="LOGIN"/>
          <p class="message">Not registered? <a href="#">Create an account</a></p>
        </form:form>
      </div>
    </div>
    
  </body>


</html>