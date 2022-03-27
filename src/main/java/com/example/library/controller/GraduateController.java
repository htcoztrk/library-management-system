package com.example.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.dto.request.GraduateRequest;
import com.example.library.dto.request.StudentUpdateRequest;
import com.example.library.dto.response.GraduateResponse;
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
	public List<GraduateResponse> getAll(){
	    return graduateService.findAll();	
	}
	@PostMapping("/addGradute")
	public GraduateResponse addGraduate(@RequestBody GraduateRequest graduate) {
		return graduateService.addGraduate(graduate);
	}
	@PutMapping(value="{identity}")
	public GraduateResponse updateGraduate(@PathVariable Long identity,
			@RequestBody @Validated GraduateRequest request) {
		return graduateService.updateGraduate(identity, request);
	}
}
