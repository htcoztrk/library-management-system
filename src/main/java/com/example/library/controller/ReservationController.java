package com.example.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.library.service.ReservationService;

@RestController
@RequestScope
@RequestMapping("/reservation")
@CrossOrigin
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
}
