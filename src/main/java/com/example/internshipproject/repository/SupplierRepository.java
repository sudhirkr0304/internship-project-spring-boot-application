package com.example.internshipproject.repository;

import com.example.internshipproject.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository <Supplier , Long> {
}
