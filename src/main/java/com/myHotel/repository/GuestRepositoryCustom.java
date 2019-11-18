package com.myHotel.repository;

import java.util.List;

import com.myHotel.model.Guest;

public interface GuestRepositoryCustom {

	List<Guest> findGuestByNameOrTelefoneOrDocumento(String nome, String documento, String telefone);

}
