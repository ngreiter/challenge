package com.myHotel.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.myHotel.dto.GuestDTO;
import com.myHotel.model.Guest;
import com.myHotel.repository.GuestRepository;
import com.myHotel.service.HotelRatesService;

@Controller
public class GuestController {

	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private HotelRatesService hotelRatesService;

	@PostMapping("/guest")
	public ResponseEntity<?> addNewGuest(@RequestBody Guest guest) {
		guestRepository.save(guest);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/guest")
	public ResponseEntity<?> updateGuest(@RequestBody Guest guest) {
		guestRepository.save(guest);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/guest/{id}")
	public ResponseEntity<?> deleteGuest(long id) {
		guestRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/guest/{id}")
	public ResponseEntity<GuestDTO> getGuest(long id) {
		Optional<Guest> guest = guestRepository.findById(id);
		return ResponseEntity.ok(hotelRatesService.buildGuestDTOSingle(Arrays.asList(guest.get())));
	}

	@GetMapping("/guest/all")
	public ResponseEntity<List<GuestDTO>> getAllGuest(long id) {
		List<GuestDTO> resultList = new ArrayList<>();
		Iterable<Guest> guestsIterable = guestRepository.findAll();
		guestsIterable.forEach(guest -> resultList.add(hotelRatesService.buildGuestDTOSingle(Arrays.asList(guest))));
		return ResponseEntity.ok(resultList);
	}

}
