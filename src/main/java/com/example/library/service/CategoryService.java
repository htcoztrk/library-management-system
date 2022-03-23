package com.example.library.service;

import com.example.library.dto.request.CategoryAddRequest;
import com.example.library.dto.request.CategoryRequest;
import com.example.library.dto.response.CategoryResponse;
import com.example.library.entity.Category;
import com.example.library.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public CategoryResponse add(CategoryAddRequest request) {
        var category = modelMapper.map(request, Category.class);
        return modelMapper.map(categoryRepository.save(category), CategoryResponse.class);

    }
    @Transactional (dontRollbackOn = RuntimeException.class)
    public Category deleteById(Long id) {
        var deletedCategory = categoryRepository.findById(id).orElseThrow();
        categoryRepository.deleteById(id);
        //if(id==2)
        //  throw new RuntimeException();
        return deletedCategory;
    }
    @Transactional(dontRollbackOn = EntityExistsException.class)
    //veritabanından alıyor, aldığı veriyi yonetiyor
    public CategoryResponse update(Long identity, CategoryRequest request) {
        var updated = categoryRepository.findById(identity).orElseThrow(() -> new EntityNotFoundException());
        modelMapper.map(request, updated);

        return modelMapper.map(categoryRepository.save(updated), CategoryResponse.class);



    }
    public CategoryResponse getById(Long id) {
        return modelMapper.map(categoryRepository.findById(id), CategoryResponse.class);
    }

    public List<CategoryResponse> getAll() {
        return categoryRepository.findAll()
                .stream().map(publisher -> modelMapper.map(publisher, CategoryResponse.class))
                .toList();
    }

}
