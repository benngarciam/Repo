<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Noticias</title>
    
    <tags:url value="/resources" var="urlResources"></tags:url>
    <tags:url value="/" var="rulRoot"></tags:url>
    
    <link href="${urlResources }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlResources }/bootstrap/css/theme.css" rel="stylesheet">
    
  </head>

  <body>

    <!-- Fixed navbar -->
    
    <jsp:include page="../includes/navbar.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <h3>Listado de Noticias</h3>
      
      <core:if test="${mensaje!=null }">
      	<div class="alert alert-success" role="alert">
  			${mensaje }
		</div>
      </core:if>
      
      <a href="${urlRoot }formPelicula" class="btn btn-success" role="button" title="Nueva Pelicula" >Nueva</a><br><br>

      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Genero</th>
                <th>Clasificación</th>
                <th>Duración</th>
                <th>Fecha</th>              
                <th>Estatus</th>              
                <th>Opciones</th>              
            </tr>
            <core:forEach items="${peliculas }" var="pelicula">
            <tr>
                <td>${pelicula.id }</td>
                <td>${pelicula.titulo }</td>
                <td>${pelicula.genero }</td>
                <td>${pelicula.clasificacion }</td>
                <td>${pelicula.duracion } min.</td>
                <td><fmt:formatDate value="${pelicula.fecha_Estreno }"/></td>
                <core:choose>
                	<core:when test="${pelicula.estatus == 'Activa'}">
                		<td><span class="label label-success">${pelicula.estatus }</span></td>
                	</core:when>
                	<core:otherwise>
                		<td><span class="label label-danger">${pelicula.estatus }</span></td>
                	</core:otherwise>
                </core:choose>
                <td>
                    <a href="#" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="#" class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
                </td>
            </tr>
            </core:forEach>
        </table>
      </div>
      <hr class="featurette-divider">

      <!-- FOOTER -->
      
      <jsp:include page="../includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${urlResources }/bootstrap/js/bootstrap.min.js"></script>     
  </body>
</html>
