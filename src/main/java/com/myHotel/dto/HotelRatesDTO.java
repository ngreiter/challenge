package com.myHotel.dto;

import java.time.LocalDateTime;

import com.myHotel.model.Guest;

public class HotelRatesDTO {

	private Guest guest;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private boolean adicionalVeiculo;

	public HotelRatesDTO(Guest guest, LocalDateTime dataEntrada, LocalDateTime dataSaida, boolean adicionalVeiculo) {
		this.guest = guest;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.adicionalVeiculo = adicionalVeiculo;
	}

	public HotelRatesDTO() {
		// TODO Auto-generated constructor stub
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
