package com.myHotel.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.myHotel.model.HotelRates;

public class HotelRatesRepositoryImpl implements HotelRatesRepositoryCustom {

	EntityManager em;

	@Override
	public List<HotelRates> findHotelRatesByGuestInHotel() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<HotelRates> cq = cb.createQuery(HotelRates.class);

		Root<HotelRates> hotelRates = cq.from(HotelRates.class);
		List<Predicate> predicateList = new ArrayList<>();

		predicateList.add(cb.greaterThanOrEqualTo(hotelRates.get("dataEntrada"), LocalDateTime.now()));
		predicateList.add(cb.lessThanOrEqualTo(hotelRates.get("endDate"), LocalDateTime.now()));

		cq.where(predicateList.toArray(new Predicate[0]));

		return em.createQuery(cq).getResultList();
	}

	@Override
	public List<HotelRates> getAllHotelRatesByGuestId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelRates getLastHotelRateByGuestId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
