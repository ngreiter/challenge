package com.myHotel.repository;

import java.util.List;

import com.myHotel.model.HotelRates;

public interface HotelRatesRepositoryCustom {

	HotelRates getLastHotelRateByGuestId(long id);

	List<HotelRates> getAllHotelRatesByGuestId(long id);

	List<HotelRates> findHotelRatesByGuestInHotel();

}
