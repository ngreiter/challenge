package com.myHotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myHotel.model.Guest;

@Repository
public interface HotelRatesRepository
		extends CrudRepository<Guest, Long>, JpaRepository<Guest, Long>, HotelRatesRepositoryCustom {

}
