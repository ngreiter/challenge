package com.myHotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.myHotel.dto.GuestDTO;
import com.myHotel.model.Guest;
import com.myHotel.model.HotelRates;
import com.myHotel.repository.GuestRepositoryImpl;
import com.myHotel.repository.HotelRatesRepository;
import com.myHotel.repository.HotelRatesRepositoryImpl;
import com.myHotel.service.HotelRatesService;

@Controller
public class CheckInController {

	@Autowired
	private HotelRatesRepository hotelRatesRepository;

	@Autowired
	private GuestRepositoryImpl guestRepositoryImpl;

	@Autowired
	private HotelRatesService hotelRatesService;

	@Autowired
	private HotelRatesRepositoryImpl hotelRatesRepositoryImpl;

	@PostMapping("/check-in")
	public ResponseEntity<?> addHotelRates(@RequestBody HotelRates hotelRates) {
		hotelRatesRepository.save(hotelRates);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/check-in/guests")
	public ResponseEntity<GuestDTO> getGuestByNameOrTelefoneOrDocumento(@RequestBody Guest guest) {
		List<Guest> guestList = guestRepositoryImpl.findGuestByNameOrTelefoneOrDocumento( //
				guest.getNome(), guest.getDocumento(), guest.getTelefone());
		GuestDTO guestDto = hotelRatesService.buildGuestDTOSingle(guestList);
		return ResponseEntity.ok(guestDto);
	}

	@GetMapping("/check-in/guests-out")
	public ResponseEntity<List<GuestDTO>> getGuestOut() {
		List<HotelRates> hotelRatesList = hotelRatesRepositoryImpl.findHotelRatesByGuestOutHotel();
		return ResponseEntity.ok(hotelRatesService.buildGuestDTOList(hotelRatesList));
	}

	@GetMapping("/check-in/guests-in")
	public ResponseEntity<List<GuestDTO>> getGuestIn() {
		List<HotelRates> hotelRatesList = hotelRatesRepositoryImpl.findHotelRatesByGuestInHotel();
		return ResponseEntity.ok(hotelRatesService.buildGuestDTOList(hotelRatesList));
	}

}
