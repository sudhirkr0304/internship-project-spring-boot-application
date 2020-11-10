package com.example.internshipproject.controller;

import com.example.internshipproject.exceptions.ResourceNotFoundException;
import com.example.internshipproject.model.Catalog;
import com.example.internshipproject.model.Supplier;
import com.example.internshipproject.repository.CatalogRepository;
import com.example.internshipproject.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.module.ResolutionException;
import java.util.Collections;
import java.util.List;

/**
 * @author sudhir kumar
 * @date - 11-11-2020
 *  controller class for "Catalog"
 */

@RestController
public class CatalogController
{

    @Autowired
    private CatalogRepository catalogRepository;
    private SupplierRepository supplierRepository;

    /**
     *
     * mapping to get all the catalog details
     */
    @RequestMapping("/catalogs")
    public List<Catalog> getCatalogs(){
        return catalogRepository.findAll();
    }

    /**
     * mapping to get the catalog details by catalog id.
     * @param skuCode
     * @return catalog
     * @throws ResourceNotFoundException
     */
    @GetMapping("/catalogs/{id}")
    public ResponseEntity<Catalog> getSupplierById(@PathVariable(value = "id") Long skuCode)  throws ResourceNotFoundException{


        Catalog catalog = catalogRepository
                .findById(skuCode)
                .orElseThrow( () -> new ResourceNotFoundException("catalog  not found with skuCode ::" + skuCode));

        return ResponseEntity.ok().body(catalog);
    }

    /**
     * mapping to post the data into the catalogs...
     * post the data that is passed through the body
     * @param catalog
     * @return catalog
     */
    @PostMapping("/catalogs")
    public Catalog createSupplier(@Valid @RequestBody Catalog catalog) {

        System.out.println(catalog.getSupplierId());

        List < Supplier > supplierList= supplierRepository.findAll();
        int flag = 0;

        for(Supplier supplier : supplierList)
        {
            if(supplier.getSupplierId() == catalog.getSupplierId())
            {
                flag = 1;
                break;
            }
        }

        if(flag == 0)
        {
            new ResourceNotFoundException("supplier id doesnot exist");
        }

        return catalogRepository.save(catalog);
    }

}
