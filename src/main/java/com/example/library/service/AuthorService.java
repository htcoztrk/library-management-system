package com.example.library.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.library.domain.Author;
import com.example.library.dto.request.AuthorRequest;
import com.example.library.dto.response.AuthorResponse;
import com.example.library.repository.AuthorRepository;

import lombok.experimental.var;


@Service
public class AuthorService {

	private AuthorRepository authorRepository;
	private ModelMapper modelMapper;

	

	public AuthorService(AuthorRepository authorRepository, ModelMapper modelMapper) {
		this.authorRepository = authorRepository;
		this.modelMapper = modelMapper;
	}
	public Author add(Author request) {
		
		return authorRepository.save(request);
		
		
	}
	/*@Transactional
	public Author deleteById(String id) {
		var findedAuthor=authorRepository.findById(id).orElseThrow();
		authorRepository.deleteById(id);
		return findedAuthor;
	}*/
	public Author update(Long identity,Author author) {
		var updated=authorRepository.findById(identity).orElseThrow();
	//	modelMapper.map(request, author);
		updated.setFullName(author.getFullName());
		return authorRepository.saveAndFlush(updated);
		
	}
	
}
