package com.myHotel.dto;

import com.myHotel.model.Guest;

public class GuestDTO {

	private long id;
	private String nome;
	private String telefone;
	private String documento;

	private int valorTotal = 0;
	private int valorUltimaHospedagem = 0;

	public GuestDTO(Guest guest, int valorTotal, int valorUltimaHospedagem) {
		this.id = guest.getId();
		this.nome = guest.getNome();
		this.telefone = guest.getTelefone();
		this.documento = guest.getDocumento();

		this.valorTotal = valorTotal;
		this.valorUltimaHospedagem = valorUltimaHospedagem;
	}

	public GuestDTO(long id, String nome, String telefone, String documento) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.documento = documento;
	}

	public GuestDTO() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public int getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getValorUltimaHospedagem() {
		return valorUltimaHospedagem;
	}

	public void setValorUltimaHospedagem(int valorUltimaHospedagem) {
		this.valorUltimaHospedagem = valorUltimaHospedagem;
	}
}
