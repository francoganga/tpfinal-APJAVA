<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sistema de Tutorias Online</title>

    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="mm/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/page1.css" rel="stylesheet">

    

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form:form  method="POST" action="${contextPath}/register" modelAttribute="alumnoForm">
                            <fieldset>

                                <div class="form-group">
                                    <form:input path="username" type="text" class="form-control" placeholder="Username" autofocus="true"></form:input>
                                </div>

                                <div class="form-group">
                                    <form:input path="password" class="form-control" placeholder="Password"  type="password" value=""></form:input>
                                </div>
                                <div class="form-group">
                                    <form:input path="firstname" type="text" class="form-control" placeholder="First Name" ></form:input>
                                </div>
                                <div class="form-group">
                                    <form:input path="lastname" type="text" class="form-control" placeholder="Last Name" ></form:input>
                                </div>
                                <div class="form-group">
                                    <form:input path="email" type="text" class="form-control" placeholder="E-mail" ></form:input>
                                </div>
                                <div class="form-group">
                                    <label><form:radiobutton class="form-check-input" path="type" name="optradio" value="tutor" checked="true"/>Tutor</label>
                                </div>
                                <div class="form-group">
                                    <label><form:radiobutton class="form-check-input" path="type" name="optradio" value="alumno"/>Alumno</label>
                                </div>
                                <p>Ya tiene un cuenta? <a href="/login">inicie sesion aqui!</a></p>
                                <br> 
                                <span>${error}</span>
                                
                                <!-- Change this to a button or input when using this as a form -->
                                <input class="btn btn-lg btn-success btn-block" type="submit" value="Register"/>
                            </fieldset>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="js/jquery-3.3.1.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="mm/metisMenu.min.js"></script>

   
    

    <!-- Custom Theme JavaScript -->
    <script src="js/page1.js"></script>

</body>

</html>
