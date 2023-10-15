package com.agencia.model;

import java.util.Date;

public class ClientePassagem {
	private int id;
	private Date dataCompra;
	private Cliente cliente;
	private Passagem passagem;

	public ClientePassagem() {
		super();

	}

	public ClientePassagem(Date dataCompra, Cliente cliente, Passagem passagem) {
		super();
		this.dataCompra = dataCompra;
		this.cliente = cliente;
		this.passagem = passagem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Passagem getPassagem() {
		return passagem;
	}

	public void setPassagem(Passagem passagem) {
		this.passagem = passagem;
	}

}
