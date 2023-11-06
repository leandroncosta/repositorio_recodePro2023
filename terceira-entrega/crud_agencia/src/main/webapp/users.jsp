<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" type="text/css"
	href="./fragments/header/header.css" />
<jsp:include page="fragments/head.jsp">
	<jsp:param name="t" value="ViageMais | Usuarios" />
</jsp:include>

</head>

<body>
	<jsp:include page="fragments/header/header.jsp" />
	<br />
	<div class="container">

		<form action="users" method="GET"
			class="d-flex justify-content-center w-50">
			<input name="search" class="form-control me-2" type="search"
				placeholder="Digite o nome ou email" aria-label="Search" />
			<button class="btn btn-outline-success" type="submit">
				Buscar</button>
		</form>


		<div class="row">
			<div class="cold-md-7">
				<hr />
				<h3>Usuários Cadastrados</h3>
				<hr />
				<div class="table-responsive-sm">
					<table class="table table-hover">
						<thead class="table-dark">
							<tr>
								<th>#</th>
								<th>Nome</th>
								<th>E-mail</th>
								<th>Tipo</th>
								<th>Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users}">

								<tr>
									<!-- <a class="click" href="user"> ${user.id} </a> -->
									<td>${user.id}</td>
									<td>${user.nome}</td>
									<td>${user.email}</td>
									<td>${user.tipo}</td>

									<td><a class="details" href="user?userId=${user.id}"> <i class="fas fa-eye"></i>
									</a> <a class="delete"
										onClick="return confirm('Deseja mesmo excluir?')"
										href="user/delete?userId=${user.id}"><i
											class="fas fa-trash"></i></a> <a class="update"
										href="user/update?userId=${user.id}"> <i
											class="fas fa-edit"></i>
									</a></td>

								</tr>


							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
			<br>
			<h5>
				<a href="user/create"> &#10094; Cadastrar usuário</a>

			</h5>
		</div>
	</div>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>
