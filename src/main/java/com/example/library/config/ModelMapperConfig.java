package com.example.library.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.library.dto.request.AuthorRequest;
import com.example.library.dto.response.AuthorResponse;
import com.example.library.entity.Author;

@Configuration
public class ModelMapperConfig {
	private static final Converter<AuthorRequest, Author>
	CONVERT_AUTHOR_REQUEST_TO_AUTHOR = (context) -> {
		
		var updatedAuthorReq = context.getSource();
		var author =
				context.getDestination();
		author.setFullName(updatedAuthorReq.getFullName());
		//author.setId(updatedAuthorReq.getId());
		return author;

	};
	private static final Converter<Author,AuthorResponse> 
	CONVERT_AUTHOR_TO_AUTHOR_RESPONSE = (context) -> {
		var response = new AuthorResponse();
				//context.getDestination();
		var author = context.getSource();
		response.setFullName(author.getFullName());
		response.setId(author.getId());
		return response;

	};
	
//	private static final Converter<Student, StudentAddResponse> 
//		STUDENT_TO_STUDENT_RESPONSE = (context) -> {
//			var response = new StudentAddResponse();
//			var student = context.getSource();
//			response.setStudentId(student.getUserId());
//		return response;
//	};

	@Bean
	public ModelMapper mapper() {
		var mapper = new ModelMapper();

		mapper.addConverter(CONVERT_AUTHOR_REQUEST_TO_AUTHOR, AuthorRequest.class, Author.class);
		mapper.addConverter(CONVERT_AUTHOR_TO_AUTHOR_RESPONSE, Author.class, AuthorResponse.class);
//		mapper.addConverter(STUDENT_TO_STUDENT_RESPONSE, Student.class, StudentAddResponse.class);
		return mapper;
	}
	
}

