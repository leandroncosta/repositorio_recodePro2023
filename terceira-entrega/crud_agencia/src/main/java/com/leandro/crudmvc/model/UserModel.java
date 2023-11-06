package com.leandro.crudmvc.model;

public class UserModel {
	private Long id;
	private String nome;
	private String email;
	private String emailSecundario;
	private String tipo;
	private String imagePath;
	private String senha;

	public UserModel(String nome, String email, String emailSecundario, String tipo, String imagePath, String senha) {
		super();

		this.nome = nome;
		this.email = email;
		this.emailSecundario = emailSecundario;
		this.tipo = tipo;
		this.imagePath = imagePath;
		this.senha = senha;
	}
	
	public UserModel() {

	}


	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailSecundario() {
		return emailSecundario;
	}

	public void setEmailSecundario(String emailSecundario) {
		this.emailSecundario = emailSecundario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", nome=" + nome + ", email=" + email + ", emailSecundario=" + emailSecundario
				+ ", tipo=" + tipo + ", senha=" + senha + "]";
	}

}
