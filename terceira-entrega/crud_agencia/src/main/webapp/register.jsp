<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<jsp:include page="fragments/head.jsp">
	<jsp:param name="t" value="ViageMais | Cadastrar" />
</jsp:include>

<link rel="stylesheet" href="../css/style.css" />
</head>
<body>
	<jsp:include page="fragments/header/header.jsp" />

	<div class="container" style="margin-top: 3rem; margin-bottom: 3rem">
		
		<div class="row">
			<div class="cold-md-7">
				<hr />
				<h3>Cadastro</h3>
				<hr />
				<form action="create" method="POST" enctype="multipart/form-data">
					<div class="form-floating mb-3">
						<input name="name" maxlength="40" type="text" class="form-control"
							id="floatingInput1" required /> <label>Nome completo</label>
					</div>
					<div class="form-floating mb-3">
						<input name="email" maxlength="30" type="email"
							class="form-control" required /> <label>E-mail</label>
					</div>
					<div class="form-floating mb-3">
						<input name="email2" maxlength="30" type="email"
							class="form-control" required /> <label>E-mail
							secundário</label>
					</div>
					<div class="form-floating mb-3">
						<input name="file"  type="file"
							class="form-control"  /> <label>Foto</label>
					</div>
					<select name="type" class="form-select mb-3"
						aria-label="Default select example" required>
						<option value="DEFAULT" selected>Selecione o tipo</option>
						<option value="ADMIN">ADMIN</option>
						<option value="DEFAULT">DEFAULT</option>
					</select>
					<div class="form-floating mb-3">
						<input name="password" maxlength="30" type="password"
							class="form-control" required /> <label>Crie uma senha</label>
					</div>

					<button class="btn btn-dark" type="submit">Criar usuário</button>
					<button class="btn btn-secondary" type="reset">Limpar
						Formulário</button>
				</form>
				<br />
				<h5>
					<a href="../users"> Lista de usuários &#10095;</a>
				</h5>
			</div>
		</div>
	</div>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>
