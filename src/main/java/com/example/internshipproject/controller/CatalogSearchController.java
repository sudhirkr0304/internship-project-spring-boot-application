package com.example.internshipproject.controller;

import com.example.internshipproject.exceptions.ResourceNotFoundException;
import com.example.internshipproject.model.Catalog;
import com.example.internshipproject.model.Supplier;
import com.example.internshipproject.repository.CatalogRepository;
import com.example.internshipproject.repository.SupplierRepository;
import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;




/**
 * @author sudhir kumar
 * @lastChanged - 11-11-2020
 * Controller to get catalog details by supplier id.
 */
@RestController
public class CatalogSearchController {

    @Autowired
    private CatalogRepository catalogRepository;
    private SupplierRepository supplierRepository;

    /**
     * mapping to get the catalog SKU NAME when
     * sku name is passed as arguments (partial , full )
     *
     * @param skuSearch
     * @return
     * @throws ResourceNotFoundException
     */

    @GetMapping("/catalogs/catalogs/{skuSearch}")
    public ResponseEntity< List < String  > > getCatalogsBySkuName(@PathVariable( value = "skuSearch") String skuSearch) throws ResourceNotFoundException {
        List < String > list  = new ArrayList<>();

        System.out.println(skuSearch);
        List < Catalog > catalogList = catalogRepository.findAll();

        for( Catalog catalogNum : catalogList) {

            if(catalogNum.getSkuName().contains(skuSearch))
            {
                list.add(catalogNum.getSkuName());
            }
        }

        return ResponseEntity.ok().body(list);
    }

    /**
     * mapping to get the SKU NAME by supplier id
     * @param supplierId
     * @return
     * @throws ResourceNotFoundException
     */

    @GetMapping("/catalogs/suppliers/{id}")
    public ResponseEntity< List < String > > getCatalogsBySupplierId(@PathVariable( value = "id") Long supplierId) throws ResourceNotFoundException {
        List < String > list  = new ArrayList<>();

        System.out.println(supplierId);
        List < Catalog > catalogList = catalogRepository.findAll();

        for( Catalog catalogNum : catalogList) {

            if(catalogNum.getSupplierId() == supplierId)
            {
                list.add(catalogNum.getSkuName());
            }
        }

        return ResponseEntity.ok().body(list);

    }
}
