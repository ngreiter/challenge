package com.myHotel.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myHotel.dto.GuestDTO;
import com.myHotel.model.Guest;
import com.myHotel.model.HotelRates;
import com.myHotel.repository.HotelRatesRepositoryImpl;
import com.myHotel.utils.HotelPrices;

@Service
public class HotelRatesService {

	@Autowired
	private HotelRatesRepositoryImpl hotelRatesRepositoryImpl;

	public List<GuestDTO> buildGuestDTOList(List<HotelRates> hotelRatesList) {
		if (hotelRatesList.isEmpty())
			return null;

		List<GuestDTO> dtoList = new ArrayList<>();
		hotelRatesList.forEach(hotelRate -> dtoList.add(new GuestDTO(//
				hotelRate.getHospede(), //
				getTotalSpentValue(hotelRate.getHospede()), //
				getLastSpentValue(hotelRate.getHospede()) //
		)));
		return dtoList;
	}

	public GuestDTO buildGuestDTOSingle(List<Guest> guestList) {
		if (guestList.isEmpty())
			return null;

		Guest guest = guestList.get(0);
		GuestDTO dto = new GuestDTO(guest, //
				getTotalSpentValue(guest), //
				getLastSpentValue(guest) //
		);
		return dto;
	}

	// o "valor total gasto" não especifica se é de só uma estadia
	// portanto fiz para buscar todos as estadias que estejam no nome hóspede
	public int getTotalSpentValue(Guest guest) {
		List<HotelRates> hotelRatesList = hotelRatesRepositoryImpl.getAllHotelRatesByGuestId(guest.getId());

		int valor = 0;
		for (HotelRates hotelRates : hotelRatesList) {
			valor += this.getFullHotelRateValue(hotelRates);
		}

		return valor;
	}

	public int getLastSpentValue(Guest guest) {
		HotelRates hotelRates = hotelRatesRepositoryImpl.getLastHotelRateByGuestId(guest.getId());
		return this.getFullHotelRateValue(hotelRates);
	}

	private int getFullHotelRateValue(HotelRates dto) {
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
			DayOfWeek day = lastDay.getDayOfWeek().plus(1);
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
