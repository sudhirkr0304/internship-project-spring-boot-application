package com.example.internshipproject.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "catalog")
@EntityListeners(AuditingEntityListener.class)
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "skucode" , nullable = false)
    private long skuCode = 0;

    @Column(name = "skuname" , nullable = false)
    private String skuName = "";

    @Column(name = "skudescription" , nullable = false)
    private String skuDescription = "";

    @Column( name = "brandname",nullable = false)
    private String brandName = "";

    @Column(name = "branddescription" , nullable = false)
    private String brandDescription = "";

    @Column( name = "supplierId",nullable = false)
    private long supplierId = 0;



    public Catalog() {

    }

    public Catalog(long skuCode, String skuName, String skuDescription, String brandName, String brandDescription, Long supplierId) {
        this.skuCode = skuCode;
        this.skuName = skuName;
        this.skuDescription = skuDescription;
        this.brandName = brandName;
        this.brandDescription = brandDescription;
        this.supplierId = supplierId;
    }

    public long getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(long skuCode) {
        this.skuCode = skuCode;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuDescription() {
        return skuDescription;
    }

    public void setSkuDescription(String skuDescription) {
        this.skuDescription = skuDescription;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandDescription() {
        return brandDescription;
    }

    public void setBrandDescription(String brandDescription) {
        this.brandDescription = brandDescription;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "skuCode=" + skuCode +
                ", skuName='" + skuName + '\'' +
                ", skuDescription='" + skuDescription + '\'' +
                ", brandName='" + brandName + '\'' +
                ", brandDescription='" + brandDescription + '\'' +
                ", supplierId='" + supplierId + '\'' +
                '}';
    }
}
