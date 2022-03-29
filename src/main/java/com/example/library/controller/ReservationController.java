package com.example.library.controller;

import java.util.List;

import com.example.library.dto.request.ReservationRequest;
import com.example.library.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import com.example.library.dto.response.ReservationResponse;
import com.example.library.service.ReservationService;


@RestController
@RequestScope
@RequestMapping("/reservation")
@CrossOrigin
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@GetMapping(value="/getAll")
	public List<ReservationResponse> getAll(){
		return reservationService.getAll();
	}

	@GetMapping(value = "/getById/{id}")
	public ReservationResponse getById(@PathVariable Long identity){
		return reservationService.getById(identity);
	}

	@PostMapping()
	public ReservationResponse add(@RequestBody  ReservationRequest request){
		return reservationService.add(request);
	}
	@PutMapping(value = "{identity}")
	public ReservationResponse update(@PathVariable Long identity ,@RequestBody  ReservationRequest request ) {
		return reservationService.update(identity, request);
	}
	@DeleteMapping
	public Reservation delete(@PathVariable Long identity) {
		return reservationService.deleteById(identity);
	}
}
