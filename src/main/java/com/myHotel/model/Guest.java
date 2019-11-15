package com.myHotel.model;

import javax.persistence.Id;

public class Guest {

	@Id
	private long id;
	private String nome;
	private String telefone;
	private Integer documento;

	public Guest(String nome, String telefone, Integer documento) {
		this.nome = nome;
		this.telefone = telefone;
		this.documento = documento;
	}

	public Guest() {
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

	public Integer getDocumento() {
		return documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

}
