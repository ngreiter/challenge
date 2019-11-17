package com.myHotel.dto;

import java.time.LocalDateTime;

import com.myHotel.model.Guest;
import com.myHotel.model.HotelRates;

public class HotelRatesDTO {

	private long id;
	private Guest guest;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private boolean adicionalVeiculo;

	public HotelRatesDTO(HotelRates hotelRates) {
		this.id = hotelRates.getId();
		this.guest = hotelRates.getGuest();
		this.dataEntrada = hotelRates.getDataEntrada();
		this.dataSaida = hotelRates.getDataSaida();
		this.adicionalVeiculo = hotelRates.isAdicionalVeiculo();
	}

	public HotelRatesDTO(Guest guest, LocalDateTime dataEntrada, LocalDateTime dataSaida, boolean adicionalVeiculo) {
		this.guest = guest;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.adicionalVeiculo = adicionalVeiculo;
	}

	public HotelRatesDTO() {
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
