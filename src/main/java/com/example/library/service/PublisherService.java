package com.example.library.service;


import com.example.library.dto.request.AuthorRequest;
import com.example.library.dto.request.PublisherAddRequest;
import com.example.library.dto.request.PublisherRequest;
import com.example.library.dto.response.AuthorResponse;
import com.example.library.dto.response.PublisherResponse;
import com.example.library.entity.Author;
import com.example.library.entity.Publisher;
import com.example.library.repository.PublisherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PublisherService {

    private PublisherRepository publisherRepository;
    private ModelMapper modelMapper;

    public PublisherService(PublisherRepository publisherRepository, ModelMapper modelMapper) {
        this.publisherRepository = publisherRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public PublisherResponse add(PublisherAddRequest request){
        var publisher=modelMapper.map(request,Publisher.class);
        return modelMapper.map(publisherRepository.save(publisher),PublisherResponse.class);

    }
    @Transactional(dontRollbackOn = RuntimeException.class)
    public Publisher deleteById(Long id) {
        var deletedPublisher = publisherRepository.findById(id).orElseThrow();
        publisherRepository.deleteById(id);
        //if(id==2)
          //  throw new RuntimeException();
        return deletedPublisher;
    }

    @Transactional(dontRollbackOn = EntityExistsException.class)
    //veritabanından alıyor, aldığı veriyi yonetiyor
    public PublisherResponse update(Long identity, PublisherRequest request) {
        var updated = publisherRepository.findById(identity).orElseThrow(()->new EntityNotFoundException());
        modelMapper.map(request, updated);
        if(identity==2) {
            throw new EntityExistsException();
        }


        //updated.setFullName(request.getFullName());
        return null;
        //modelMapper.map(authorRepository.save(updated), AuthorResponse.class);

    }

    public PublisherResponse getById(Long id) {
        return modelMapper.map(publisherRepository.findById(id), PublisherResponse.class);
    }

    public List<PublisherResponse> getAll() {
        return publisherRepository.findAll()
                .stream().map(publisher -> modelMapper.map(publisher, PublisherResponse.class))
                .toList();
    }

}
