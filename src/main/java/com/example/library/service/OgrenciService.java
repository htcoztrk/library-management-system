package com.example.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.library.domain.Memur;
import com.example.library.domain.Ogrenci;
import com.example.library.domain.User;
import com.example.library.repository.OgrenciRepository;

@Service
public class OgrenciService {

	OgrenciRepository ogrenciRepository;

	private OgrenciService(OgrenciRepository ogrenciRepository) {
		this.ogrenciRepository = ogrenciRepository;
	}
	public Ogrenci add(Ogrenci ogrenci) {
		var ogr=ogrenciRepository.save(ogrenci);
		return ogr;
	}
	public Optional<List<Ogrenci>> getAll(){
		return Optional.of(ogrenciRepository.findAll());
	}

}
