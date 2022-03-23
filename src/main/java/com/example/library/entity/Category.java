package com.example.library.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name="category")
public class Category {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message ="name can not be null")
    @NotBlank(message ="name can not be blank")
    @Column(name="fullname")
    private String fullname;

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
    public Category(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id && fullname.equals(category.fullname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullname);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                '}';
    }
}
