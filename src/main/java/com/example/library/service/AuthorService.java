package com.example.library.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.library.dto.request.AuthorAddRequest;
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

	@Transactional
	public AuthorResponse add(AuthorAddRequest request) {
		var author = modelMapper.map(request, Author.class);
		return modelMapper.map(authorRepository.save(author), AuthorResponse.class);
	}

	@Transactional(dontRollbackOn = RuntimeException.class)
	public Author deleteById(Long id) {
		var deletedAuthor = authorRepository.findById(id).orElseThrow();
		authorRepository.deleteById(id);
		if(id==2)
			throw new RuntimeException();
		return deletedAuthor;
	}

	@Transactional(dontRollbackOn = EntityExistsException.class)
	//veritabanından alıyor, aldığı veriyi yonetiyor
	public AuthorResponse update(Long identity, AuthorRequest request) {
		var updated = authorRepository.findById(identity).orElseThrow(()->new EntityNotFoundException());
		modelMapper.map(request, updated);
		if(identity==2) {
			throw new EntityExistsException();
		}
		
		
		//updated.setFullName(request.getFullName());
		return null;
				//modelMapper.map(authorRepository.save(updated), AuthorResponse.class);

	}

	public AuthorResponse getById(Long id) {
		return modelMapper.map(authorRepository.findById(id), AuthorResponse.class);
	}

	public List<AuthorResponse> getAll() {
		return authorRepository.findAll()
				.stream().map(author -> modelMapper.map(author, AuthorResponse.class))
				.toList();
	}

}
