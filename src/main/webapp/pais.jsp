<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<title>Aplicacion Gestion de Usuarios</title>
</head>
<body>
 <header><nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">Gestion de Usuarios</a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="<%=request.getContextPath()%>/list">paises</a>
    </li>
   
  </ul>
</nav>
                
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">

                        <c:if test="${pais != null}">
                            <form action="update" method="get">
                        </c:if>
                        <c:if test="${pais == null}">
                            <form action="insert" method="get">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${pais != null}">
                                    Editar Pais
                                </c:if>
                                <c:if test="${pais == null}">
                                    Agregar Nuevo Pais
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${pais != null}">
                            <input type="hidden" name="id" value="<c:out value='${pais.id}' />" />
                        </c:if>
                         <c:if test="${pais == null}">
						  <label>id</label><input type="text" name="id" value=""  class="form-control"/>
                       </c:if>
                        <fieldset class="form-group">
                            <label>Nombre de Pais</label> <input type="text" value="<c:out value='${pais.nombre}' />" class="form-control" name="nombre" required="required">
                        </fieldset>
						<br>
                       
						<br>
                        <button type="submit" class="btn btn-success">Guardar</button>
                        </form>
                    </div>
                </div>
            </div>

</body>
</html>