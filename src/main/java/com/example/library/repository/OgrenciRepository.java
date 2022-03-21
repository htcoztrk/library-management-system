package com.example.library.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.domain.Ogrenci;
public interface OgrenciRepository extends JpaRepository<Ogrenci,Integer>{

}
