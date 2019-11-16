package com.myHotel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myHotel.model.Guest;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {

}
