package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.domain.Graduate;

public interface GraduateRepository extends JpaRepository<Graduate,Integer>{

}
