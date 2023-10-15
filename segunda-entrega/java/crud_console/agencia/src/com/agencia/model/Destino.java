package com.agencia.model;

public class Destino {
	private int id;
	private String cidade;
	private String estado;
	private String pais;
	private String imagem;

	public Destino() {
		super();
	}

	public Destino(String cidade, String estado, String pais, String imagem) {
		super();
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.imagem = imagem;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}