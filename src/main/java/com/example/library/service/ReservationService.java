package com.example.library.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.dto.request.ReservationRequest;
import com.example.library.dto.response.ReservationResponse;
import com.example.library.entity.Reservation;
import com.example.library.repository.ReservationRepository;



@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	public List<ReservationResponse> getAll(){
		return reservationRepository.findAll()
				.stream().map(reservation ->modelMapper.map(reservation, ReservationResponse.class))
				.toList();
	}
	
	public ReservationResponse getById(Long identity) {
		return modelMapper.map(reservationRepository.findById(identity)
				.orElseThrow(() -> new EntityNotFoundException()) ,ReservationResponse.class );
	}
	
	public ReservationResponse add(ReservationRequest request) {
		var reservation = modelMapper.map(request, Reservation.class);
		return modelMapper.map(reservationRepository.save(reservation),ReservationResponse.class);
	}
	
	public ReservationResponse update(Long identity ,ReservationRequest request) {
		var updated = reservationRepository.findById(identity).orElseThrow(()->new EntityNotFoundException());
		modelMapper.map(request, updated);
		
		return modelMapper.map(reservationRepository.save(updated), ReservationResponse.class);
	}
	public Reservation deleteById(Long identity){
		var deleted = reservationRepository.findById(identity).orElseThrow(() -> new EntityNotFoundException());
		reservationRepository.delete(deleted);
		return deleted;
	}
}
