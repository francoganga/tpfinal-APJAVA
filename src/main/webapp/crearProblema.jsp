<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%

if (session.getAttribute("userLogged") == null || session.getAttribute("userLogged").equals("")){
    session.setAttribute("error","Necesita estar logueado para ingresar");
    response.sendRedirect("/login");
}



%>

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

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/alumno">Bienvenido ${userLogged}!!</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    
                
                
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> Perfil de Usuario</a>
                        </li>                        
                        <li class="divider"></li>
                        <li><a id="logout" href="/logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>                        
                        <li>
                            <a href="crearproblema.jsp"><i class="fa fa-dashboard fa-fw"></i> Crear problema</a>
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> Buscar Problemas<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a class="materia_search" id="0" href="#">Matematica</a>
                                </li>
                                <li>
                                    <a class="materia_search" id="1" href="#">Lengua</a>
                                </li>
                                <li>
                                    <a class="materia_search" id="2" href="#">S. Sociales</a>
                                </li>
                                <li>
                                    <a class="materia_search" id="3" href="#">Geografia</a>
                                </li>
                                
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> Buscar Tutores<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a class="tutor_search" id="0" href="#">Matematica</a>
                                </li>
                                <li>
                                    <a class="tutor_search" id="1" href="#">Lengua</a>
                                </li>
                                <li>
                                    <a class="tutor_search" id="2" href="#">S. Sociales</a>
                                </li>
                                <li>
                                    <a class="tutor_search" id="3" href="#">Geografia</a>
                                </li>
                                
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                       
                        
                        
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Creacion de Problemas</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Creacion de Problemas
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-10">
                                    <form:form method="POST" action="/crearProblema" modelAttribute="problemaForm">
                                        <div class="form-group">
                                            <label>Titulo del problema</label>
                                            <form:input type="text" path="title" class="form-control" placeholder="Titulo"></form:input>
                                        </div>
                                        <div class="form-group">
                                            <label>Describe tu problema</label>
                                            <form:textarea path="text" rows="5"  class="form-control" placeholder="Mi problema es..."></form:textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Elije la materia</label>
                                            <div class="form-group">
                                                <label><form:radiobutton class="form-check-input" path="materiaTitle" name="optradio" value="Matematica" checked="true"></form:radiobutton> Matematica</label>
                                            </div>
                                            <div class="form-group">
                                                <label><form:radiobutton class="form-check-input" path="materiaTitle" name="optradio" value="Lengua"></form:radiobutton> Lengua</label>
                                            </div>
                                            <div class="form-group">
                                                <label><form:radiobutton class="form-check-input" path="materiaTitle" name="optradio" value="S. Sociales"></form:radiobutton> S. Sociales</label>
                                            </div>
                                            <div class="form-group">
                                                <label><form:radiobutton class="form-check-input" path="materiaTitle" name="optradio" value="Geografia"></form:radiobutton> Geografia</label>
                                            </div>
                                            <div class="form-group">
                                            <input class="btn btn-lg btn-success btn-block" type="submit" value="Continuar"/>
                                            </div>
                                        </div>
                                        
                                    </form:form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                                
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="js/jquery-3.3.1.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="mm/metisMenu.min.js"></script>
    <script src="js/common.js"></script>

   
    

    <!-- Custom Theme JavaScript -->
    <script src="js/crearproblema.js"></script>

</body>

</html>