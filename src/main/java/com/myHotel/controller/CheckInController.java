package com.myHotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.myHotel.dto.GuestDTO;
import com.myHotel.model.Guest;
import com.myHotel.model.HotelRates;
import com.myHotel.repository.GuestRepositoryImpl;
import com.myHotel.repository.HotelRatesRepositoryImpl;
import com.myHotel.service.HotelRatesService;

public class CheckInController {

	@Autowired
	private GuestRepositoryImpl guestRepositoryImpl;

	@Autowired
	private HotelRatesService hotelRatesService;

	@Autowired
	private HotelRatesRepositoryImpl hotelRatesRepositoryImpl;

	@GetMapping("/check-in/get-guest/{nome}")
	public ResponseEntity<GuestDTO> getGuestByNome(@PathVariable("nome") String nome) {
		List<Guest> guestList = guestRepositoryImpl.findGuestByNameOrTelefoneOrDocumento("nome", nome);
		GuestDTO guest = hotelRatesService.buildGuestDTOSingle(guestList);
		return ResponseEntity.ok(guest);
	}

	@GetMapping("/check-in/get-guest/{telefone}")
	public ResponseEntity<GuestDTO> getGuestByTelefone(@PathVariable("telefone") String telefone) {
		List<Guest> guestList = guestRepositoryImpl.findGuestByNameOrTelefoneOrDocumento("telefone", telefone);
		GuestDTO guest = hotelRatesService.buildGuestDTOSingle(guestList);
		return ResponseEntity.ok(guest);
	}

	@GetMapping("/check-in/get-guest/{documento}")
	public ResponseEntity<GuestDTO> getGuestByDocumento(@PathVariable("documento") String documento) {
		List<Guest> guestList = guestRepositoryImpl.findGuestByNameOrTelefoneOrDocumento("documento", documento);
		GuestDTO guest = hotelRatesService.buildGuestDTOSingle(guestList);
		return ResponseEntity.ok(guest);
	}

	@GetMapping("/check-in/guest-out")
	public ResponseEntity<List<GuestDTO>> getGuestOut() {
		List<HotelRates> hotelRatesList = hotelRatesRepositoryImpl.findHotelRatesByGuestOutHotel();
		return ResponseEntity.ok(hotelRatesService.buildGuestDTOList(hotelRatesList));
	}

	@GetMapping("/check-in/guest-in")
	public ResponseEntity<List<GuestDTO>> getGuestIn() {
		List<HotelRates> hotelRatesList = hotelRatesRepositoryImpl.findHotelRatesByGuestInHotel();
		return ResponseEntity.ok(hotelRatesService.buildGuestDTOList(hotelRatesList));
	}

}
