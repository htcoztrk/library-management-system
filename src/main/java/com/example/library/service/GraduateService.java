package com.example.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.library.entity.Graduate;
import com.example.library.entity.User;
import com.example.library.repository.GraduateRepository;

@Service
public class GraduateService{

	private GraduateRepository graduateRepository;

	public GraduateService(GraduateRepository graduateRepository) {
		this.graduateRepository = graduateRepository;
	}

	
	public Graduate add(Graduate graduate) {
		var addedGraduate=graduateRepository.save(graduate);
		return addedGraduate;
	}

	public Optional<Graduate> update(Graduate graduate) {
		var updatedGraduate=graduateRepository.save(graduate);
		return Optional.of(updatedGraduate);
	}

	public Optional<User> findById(int id) {
		var g= graduateRepository.findById(id).get();
		return Optional.of(g);
	}

	public Optional<List<Graduate>> findAll() {
		return  Optional.of(graduateRepository.findAll());
	}
	
	
}
