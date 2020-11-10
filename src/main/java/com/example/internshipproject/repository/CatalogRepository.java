package com.example.internshipproject.repository;


import com.example.internshipproject.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository <Catalog , Long> {

}
