package com.myHotel.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.myHotel.model.Guest;

@Repository
public class GuestRepositoryImpl implements GuestRepositoryCustom {

	private EntityManager em;

	@Override
	public List<Guest> findGuestByNameOrTelefoneOrDocumento(String variableName, String value) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Guest> cq = cb.createQuery(Guest.class);

		Root<Guest> guest = cq.from(Guest.class);
		List<Predicate> predicateList = new ArrayList<>();
		predicateList.add(cb.equal(guest.get(variableName), value));
		cq.where(predicateList.toArray(new Predicate[0]));

		return em.createQuery(cq).getResultList();
	}

}
