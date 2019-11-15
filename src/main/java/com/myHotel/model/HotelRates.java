package com.myHotel.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HotelRates {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Guest guest;
	private Date dataEntrada;
	private Date dataSaida;
	private boolean adicionalVeiculo;

	public HotelRates(Guest guest, Date dataEntrada, Date dataSaida, boolean adicionalVeiculo) {
		this.guest = guest;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.adicionalVeiculo = adicionalVeiculo;
	}

	public HotelRates() {
		// TODO Auto-generated constructor stub
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public boolean isAdicionalVeiculo() {
		return adicionalVeiculo;
	}

	public void setAdicionalVeiculo(boolean adicionalVeiculo) {
		this.adicionalVeiculo = adicionalVeiculo;
	}

}
