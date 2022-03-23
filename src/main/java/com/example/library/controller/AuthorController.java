package com.example.library.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

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
	@PostMapping()
	public AuthorResponse addAuthor(@RequestBody AuthorRequest request) {
		
		return authorService.add(request);
	}
	/*@PutMapping(value = "{identity}")
	public Author updateAuthor(@PathVariable Long identity,@RequestBody Author request) {
		
		return authorService.update(identity, request);
	}*/
}
