package com.myHotel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.myHotel.dto.GuestDTO;
import com.myHotel.model.Guest;
import com.myHotel.repository.GuestRepository;

@Controller
public class GuestController {

	@Autowired
	private GuestRepository guestRepository;

	// ResponseEntity<Object>

	@PutMapping("/guest/{id}")
	public void updateGuest(@RequestBody Guest guest, @PathVariable long id) {
		guestRepository.save(guest);
	}

	@PostMapping("/guest")
	public void addNewGuest(Guest guest) {
		guestRepository.save(guest);
	}

	@DeleteMapping("/guest/{id}")
	public void deleteGuest(long id) {
		guestRepository.deleteById(id);
	}

	@GetMapping("/guest/{id}")
	public GuestDTO getGuest(long id) {
		Optional<Guest> guest = guestRepository.findById(id);
		return new GuestDTO(guest.get());
	}

	@GetMapping("/guest/all")
	public List<GuestDTO> getAllGuest(long id) {
		List<GuestDTO> resultList = new ArrayList<>();
		Iterable<Guest> guestsIterable = guestRepository.findAll();
		guestsIterable.forEach(guest -> resultList.add(new GuestDTO(guest)));
		return resultList;
	}

}
