package com.example.library.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.library.dto.request.AuthorRequest;
import com.example.library.dto.response.AuthorResponse;
import com.example.library.entity.Author;
import com.example.library.repository.AuthorRepository;




@Service
public class AuthorService {

	private AuthorRepository authorRepository;
	private ModelMapper modelMapper;

	

	public AuthorService(AuthorRepository authorRepository, ModelMapper modelMapper) {
		this.authorRepository = authorRepository;
		this.modelMapper = modelMapper;
	}
	public AuthorResponse add(AuthorRequest request) {
		var author=modelMapper.map(request, Author.class);
		
		return modelMapper.map(authorRepository.save(author),AuthorResponse.class);
		
		
	}
	/*@Transactional
	public Author deleteById(String id) {
		var findedAuthor=authorRepository.findById(id).orElseThrow();
		authorRepository.deleteById(id);
		return findedAuthor;
	}*/
	
	public AuthorResponse update(Long identity,AuthorRequest request) {
		var updated=authorRepository.findById(identity).orElseThrow();
		modelMapper.map(request, updated);
		updated.setFullName(request.getFullName());
		return modelMapper.map(updated, AuthorResponse.class);
		
	}
	
}
