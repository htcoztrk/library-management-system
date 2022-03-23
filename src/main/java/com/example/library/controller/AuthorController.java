package com.example.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.library.dto.request.AuthorAddRequest;
import com.example.library.dto.request.AuthorRequest;
import com.example.library.dto.response.AuthorResponse;
import com.example.library.entity.Author;
import com.example.library.service.AuthorService;

@RestController
@RequestMapping("/author")
@RequestScope
@CrossOrigin
public class AuthorController {

	private AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}
	@GetMapping(value="/getall")
	public List<AuthorResponse> getAll(){
		return authorService.getAll();
	}
	@GetMapping(value="/getbyId/{id}")
	public AuthorResponse getById(@PathVariable Long id){
		return authorService.getById(id);
	}
	@PostMapping()
	public AuthorResponse addAuthor(@RequestBody AuthorAddRequest request) {
		
		return authorService.add(request);
	}
	@PutMapping(value = "{identity}")
	public AuthorResponse updateAuthor(@PathVariable Long identity,
									   @RequestBody AuthorRequest request) {
		
		return authorService.update(identity, request);
	}
	@DeleteMapping(value="{id}")
	public Author delete(@PathVariable Long id) {

		return authorService.deleteById(id);
	}
}
