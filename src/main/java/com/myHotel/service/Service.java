package com.myHotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.myHotel.dto.HotelRatesDTO;
import com.myHotel.model.Guest;
import com.myHotel.repository.HotelRatesRepository;

public class Service {
	
	@Autowired
	private HotelRatesRepository hotelRatesRepository;

	public int getTotalSpentValue(Guest guest) {
		List<HotelRatesDTO> hotelRatesList = hotelRatesRepository.getHotelRatesByGuestId(guest.getId());

		int valor = 0;
		for (HotelRatesDTO dto : hotelRatesList) {
			valor += getFullHotelRateValue(dto);
		}

		return valor;
	}

	public int getFullHotelRateValue(HotelRatesDTO dto) {
		
		return 0;
	}

}
