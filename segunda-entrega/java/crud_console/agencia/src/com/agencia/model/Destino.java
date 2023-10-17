package com.agencia.model;

import java.util.List;

import com.agencia.dao.ClienteDAO;
import com.agencia.dao.DestinoDAO;
import com.agencia.utils.Colors;

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

	public static void showDatas () {
		List<Destino> destinos = DestinoDAO.read("");

		System.out.println(
				Colors.YELLOW + "----------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%5s %20s %20s %20s", "ID", "CIDADE", "ESTADO", "PAIS");
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		for (Destino d : destinos) {
			System.out.format("%5s %20s %20s %20s", d.getId(), d.getCidade(), d.getEstado(), d.getPais());
			System.out.println();
		}
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------" + Colors.RESET);
	}
}
