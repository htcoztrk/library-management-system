package com.example.library.controller;

import com.example.library.dto.request.PublisherAddRequest;
import com.example.library.dto.request.PublisherRequest;
import com.example.library.dto.response.PublisherResponse;
import com.example.library.entity.Publisher;
import com.example.library.service.PublisherService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/publisher")
@RequestScope
@CrossOrigin

public class PublisherController {

    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping()
    public PublisherResponse addPublisher(@RequestBody PublisherAddRequest request){
        return publisherService.add(request);
    }
    @PutMapping(value = "{identity}")
    public PublisherResponse updatePublisher(@PathVariable Long identity, @RequestBody PublisherRequest request ){
        return publisherService.update(identity,request);
    }
    @DeleteMapping(value = "{id}")
    public Publisher delete(@PathVariable Long id){
        return publisherService.deleteById(id);
    }
}
