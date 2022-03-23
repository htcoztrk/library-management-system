package com.example.library.dto.response;

public class CategoryResponse {
    private Long id;
    private String fullname;

    public CategoryResponse(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
