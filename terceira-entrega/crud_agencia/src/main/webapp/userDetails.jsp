<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="fragments/head.jsp">
	<jsp:param name="t" value="ViageMais | Detalhes" />
</jsp:include>
<link rel="stylesheet" href="./fragments/header/header.css" />
<link rel="stylesheet" href="/crud_agencia/src/main/webapp/css/style.css" />
</head>
<body>
	<jsp:include page="fragments/header/header.jsp" />

 <div class="container">
 
	<div class="container-details">
		<div>
			<img  class="user-photo" src="${user.imagePath}" alt="" />
		</div>

		<div class="info">
			<p>#${user.id}</p>
			<p>Nome: ${user.nome}</p>
			<p>E-mail: ${user.email}</p>
			<p>Tipo: ${user.tipo}</p>
			<a  href="/crud_agencia/users" class="btn btn-secondary">Voltar</a>
		</div>
	</div>
 </div>
	

	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script>
		</body>
		</html>
	