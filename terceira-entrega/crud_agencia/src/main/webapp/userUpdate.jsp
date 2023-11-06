<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<jsp:include page="fragments/head.jsp">
	<jsp:param name="t" value="ViageMais | Atualizar" />
</jsp:include>
	<link rel="stylesheet" href="../css/style.css" />
</head>
<body>

	<jsp:include page="fragments/header/header.jsp" />

	<br />
	<div class="container">
		<div class="row">
			<div class="cold-md-7">
				<hr />
				<h3>Atualizar usuário</h3>
				<hr />
				<form action="./update" method="POST">
					<input value="${user.id}" name="id" type="number"
						style="visibility: hidden" />
					<div class="form-floating mb-3">
						<input value="${user.nome}" name="name" maxlength="40" type="text"
							class="form-control" id="floatingInput1" /> <label>Nome
							completo</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${user.email}" name="email" maxlength="11"
							type="email" class="form-control" /> <label>E-mail</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${user.emailSecundario}" name="email2"
							maxlength="11" type="email" class="form-control" /> <label>E-mail
							secundário</label>
					</div>
					<select name="type" class="form-select mb-3"
						aria-label="Default select example">
						<option value="DEFAULT" selected>Selecione o tipo</option>
						<option value="${user.tipo}" selected>${user.tipo}</option>
						<option value="ADMIN">ADMIN</option>
						<option value="DEFAULT">DEFAULT</option>
					</select>

					<button class="btn btn-success" type="submit">Atualizar
						Dados</button>
					<button class="btn btn-secondary reset" type="reset">
						Limpar Formulário</button>
				</form>
				<br />
			</div>
		</div>
		<br>
			<h5>
				<a href="../users"> &#10094; Sair</a>

			</h5>
	</div>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script>
            const buttonReset = document.querySelector('.reset');
            const form = document.querySelector('form');

            buttonReset.addEventListener('click', (e) => {});
        </script>
</body>
</html>