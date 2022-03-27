package com.example.library.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.library.dto.request.GraduateRequest;
import com.example.library.dto.response.GraduateResponse;
import com.example.library.entity.Graduate;
import com.example.library.entity.User;
import com.example.library.repository.GraduateRepository;


@Service
public class GraduateService{

	private final GraduateRepository graduateRepository;
	private final ModelMapper modelMapper;

	public GraduateService(GraduateRepository graduateRepository, ModelMapper modelMapper) {
		this.graduateRepository = graduateRepository;
		this.modelMapper = modelMapper;
	}

	@Transactional
	public GraduateResponse addGraduate(GraduateRequest request) {
		var graduate=modelMapper.map(request,Graduate.class);
		var addedGraduate=graduateRepository.save(graduate);
		return modelMapper.map(addedGraduate,GraduateResponse.class);
	}

	@Transactional
	public GraduateResponse updateGraduate(Long identity,GraduateRequest request) {
		var graduate=graduateRepository.findById(identity).orElseThrow(()->new EntityNotFoundException());
		modelMapper.map(request, graduate);
		return modelMapper.map(graduateRepository.save(graduate), GraduateResponse.class);
	}

	@Transactional
	public GraduateResponse deleteById(Long id) {
		var graduate=graduateRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
		graduateRepository.deleteById(id);
		return modelMapper.map(graduate, GraduateResponse.class);
	}
	@Transactional
	public GraduateResponse findById(Long id) {
		return modelMapper.map(
				graduateRepository.findById(id)
				.orElseThrow(()->new EntityNotFoundException()), 
				GraduateResponse.class);
	}

	public List<GraduateResponse> findAll() {
		return  graduateRepository.findAll()
				.stream()
				.map(graduate->modelMapper.map(graduate, GraduateResponse.class))
				.toList();
	}
	
	
}




