package com.myHotel.dto;

import com.myHotel.model.Guest;

public class GuestDTO {

	private long id;
	private String nome;
	private String telefone;
	private String documento;

	public GuestDTO(Guest guest) {
		this.id = guest.getId();
		this.nome = guest.getNome();
		this.telefone = guest.getTelefone();
		this.documento = guest.getDocumento();
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

}
