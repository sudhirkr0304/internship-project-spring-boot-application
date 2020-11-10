package com.example.internshipproject.controller;


import com.example.internshipproject.exceptions.ResourceNotFoundException;
import com.example.internshipproject.model.Supplier;
import com.example.internshipproject.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * This is a supplier controller
 * @author sudhir kumar
 * @date 11-11-2020
 */
@RestController
public class SupplierController {



    @Autowired
    private SupplierRepository supplierRepository;

    /**
      Get all suppliers list ...
      @return the list
     */

    @GetMapping("/suppliers")
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    /**
     *
     * @param supplierId
     * @return supplier id and supplier name
     * @throws ResourceNotFoundException
     */
    @GetMapping("/suppliers/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable(value = "id") Long supplierId)  throws ResourceNotFoundException{


        Supplier supplier = supplierRepository
                .findById(supplierId)
                .orElseThrow( () -> new ResourceNotFoundException("supplier not found with id ::" + supplierId));

        return ResponseEntity.ok().body(supplier);
    }

    /**
     *
     * @param supplier
     * @return added supplier
     */
    @PostMapping("/suppliers")
    public Supplier createSupplier(@Valid @RequestBody Supplier supplier) {

        return supplierRepository.save(supplier);
    }








}
