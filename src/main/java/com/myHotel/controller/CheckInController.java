package com.myHotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.myHotel.dto.GuestDTO;
import com.myHotel.model.Guest;
import com.myHotel.repository.GuestRepositoryImpl;
import com.myHotel.repository.HotelRatesRepository;
import com.myHotel.repository.HotelRatesRepositoryImpl;

public class CheckInController {

	@Autowired
	private GuestRepositoryImpl guestRepositoryImpl;

	@Autowired
	private HotelRatesRepositoryImpl hotelRatesRepositoryImpl;

	@Autowired
	private HotelRatesRepository hotelRatesRepository;

	@GetMapping("/check-in/guest")
	public ResponseEntity<GuestDTO> getGuest(GuestDTO dtoFilter) {
		List<Guest> guest = guestRepositoryImpl.findGuestByNameOrTelefoneOrDocumento( //
				dtoFilter.getNome(), //
				dtoFilter.getTelefone(), //
				dtoFilter.getDocumento()); //
		return ResponseEntity.ok(new GuestDTO(guest.get(0)));
	}

}
