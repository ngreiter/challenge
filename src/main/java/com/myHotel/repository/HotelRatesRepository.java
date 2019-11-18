package com.myHotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myHotel.model.HotelRates;

@Repository
public interface HotelRatesRepository
		extends CrudRepository<HotelRates, Long>, JpaRepository<HotelRates, Long>, HotelRatesRepositoryCustom {

}
