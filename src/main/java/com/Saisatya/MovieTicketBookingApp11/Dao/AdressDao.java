package com.Saisatya.MovieTicketBookingApp11.Dao;

import com.Saisatya.MovieTicketBookingApp11.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressDao extends JpaRepository<Address,Integer> {
}
