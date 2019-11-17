package com.myHotel.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HotelRates {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Guest guest;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private boolean adicionalVeiculo;

	public HotelRates(Guest guest, LocalDateTime dataEntrada, LocalDateTime dataSaida, boolean adicionalVeiculo) {
		this.guest = guest;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.adicionalVeiculo = adicionalVeiculo;
	}

	public HotelRates() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDateTime getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}

	public boolean isAdicionalVeiculo() {
		return adicionalVeiculo;
	}

	public void setAdicionalVeiculo(boolean adicionalVeiculo) {
		this.adicionalVeiculo = adicionalVeiculo;
	}

}
