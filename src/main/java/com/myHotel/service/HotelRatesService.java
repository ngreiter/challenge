package com.myHotel.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import com.myHotel.dto.HotelRatesDTO;
import com.myHotel.model.Guest;
import com.myHotel.repository.HotelRatesRepository;
import com.myHotel.utils.HotelPrices;

public class HotelRatesService {

	@Autowired
	private HotelRatesRepository hotelRatesRepository;

	public int getTotalSpentValue(Guest guest) {
		List<HotelRatesDTO> hotelRatesList = hotelRatesRepository.getAllHotelRatesByGuestId(guest.getId());

		int valor = 0;
		for (HotelRatesDTO dto : hotelRatesList) {
			valor += this.getFullHotelRateValue(dto);
		}

		return valor;
	}

	public int getLastSpentValue(Guest guest) {
		HotelRatesDTO dto = hotelRatesRepository.getHotelRatesByGuestId(guest.getId());
		return this.getFullHotelRateValue(dto);
	}

	private int getFullHotelRateValue(HotelRatesDTO dto) {
		LocalDateTime firstDay = dto.getDataEntrada();
		LocalDateTime lastDay = dto.getDataSaida();
		int value = 0;

		List<LocalDateTime> dates = Stream.iterate(firstDay, date -> date.plusDays(1))
				.limit(ChronoUnit.DAYS.between(firstDay, lastDay)) //
				.collect(Collectors.toList());

		for (LocalDateTime date : dates) {
			DayOfWeek day = date.getDayOfWeek();
			if (day.getValue() == 1 || day.getValue() == 7) {
				value += HotelPrices.DIARIAESPECIAL.getValue();
			} else {
				value += HotelPrices.DIARIASEMANAL.getValue();
			}
		}

		if (dto.isAdicionalVeiculo()) {
			for (LocalDateTime date : dates) {
				DayOfWeek day = date.getDayOfWeek();
				if (day.getValue() == 1 || day.getValue() == 7) {
					value += HotelPrices.VAGAESPECIAL.getValue();
				} else {
					value += HotelPrices.VAGASEMANAL.getValue();
				}
			}
		}

		if (lastDay.getHour() > 16 || (lastDay.getHour() == 16 && lastDay.getMinute() >= 30)) {
			DayOfWeek day = lastDay.getDayOfWeek();
			if (day.getValue() == 1 || day.getValue() == 7) {
				value += HotelPrices.DIARIAESPECIAL.getValue();
			} else {
				value += HotelPrices.DIARIASEMANAL.getValue();
			}

			if (dto.isAdicionalVeiculo()) {
				if (day.getValue() == 1 || day.getValue() == 7) {
					value += HotelPrices.VAGAESPECIAL.getValue();
				} else {
					value += HotelPrices.VAGASEMANAL.getValue();
				}
			}
		}

		return value;
	}

}
