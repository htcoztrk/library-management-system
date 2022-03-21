package com.example.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.domain.Ogrenci;
import com.example.library.domain.User;
import com.example.library.service.OgrenciService;

@RestController
@RequestMapping("/ogrenci")
public class OgrenciController {
    private OgrenciService ogrenciService;

	public OgrenciController(OgrenciService ogrenciService) {
		
		this.ogrenciService = ogrenciService;
	}
	@GetMapping("/getall")
	public Optional<List<Ogrenci>> getAll(){
	    return ogrenciService.getAll();	
	}
	@PostMapping("/adduser")
	public User addUser(@RequestBody Ogrenci ogrenci) {
		return ogrenciService.add(ogrenci);
	}
}
