package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.Reservation;

public interface ReservationRepository  extends JpaRepository<Reservation, Long>{

}
