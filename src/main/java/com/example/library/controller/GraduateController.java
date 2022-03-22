package com.example.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.entity.Graduate;
import com.example.library.service.GraduateService;

@RestController
@RequestMapping("/graduate")
public class GraduateController {

	private GraduateService graduateService;

	public GraduateController(GraduateService graduateService) {
		this.graduateService = graduateService;
	} 
	@GetMapping("/getall")
	public Optional<List<Graduate>> getAll(){
	    return graduateService.findAll();	
	}
	@PostMapping("/addGradute")
	public Graduate addUser(@RequestBody Graduate graduate) {
		return graduateService.add(graduate);
	}
}
