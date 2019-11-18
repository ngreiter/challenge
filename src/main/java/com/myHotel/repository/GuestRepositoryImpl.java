package com.myHotel.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.myHotel.model.Guest;

@Repository
public class GuestRepositoryImpl implements GuestRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Guest> findGuestByNameOrTelefoneOrDocumento(String nome, String documento, String telefone) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Guest> cq = cb.createQuery(Guest.class);

		Root<Guest> guest = cq.from(Guest.class);
		List<Predicate> predicateList = new ArrayList<>();

		if (!nome.isEmpty()) {
			predicateList.add(cb.equal(guest.get("nome"), nome));
		} else if (!documento.isEmpty()) {
			predicateList.add(cb.equal(guest.get("documento"), documento));
		} else if (!telefone.isEmpty()) {
			predicateList.add(cb.equal(guest.get("telefone"), telefone));
		}

		cq.where(predicateList.toArray(new Predicate[0]));

		return em.createQuery(cq).getResultList();
	}

}
