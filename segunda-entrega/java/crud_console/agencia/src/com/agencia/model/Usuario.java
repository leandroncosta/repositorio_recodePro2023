package com.agencia.model;

public class Usuario {
	private int id;
	private String email;
	private String senha;
	private String emailSecundario;
	private String tipo;

	public Usuario() {
		super();

	}

	public Usuario(String email, String senha, String emailSecundario, String tipo) {
		super();
		this.email = email;
		this.senha = senha;
		this.emailSecundario = emailSecundario;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

}
