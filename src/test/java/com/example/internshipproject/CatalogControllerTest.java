package com.example.internshipproject;


import com.example.internshipproject.model.Catalog;
import com.example.internshipproject.model.Supplier;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InternshipProjectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CatalogControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetAllCatalogs() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/catalogs",
                HttpMethod.GET, entity, String.class);

        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void testGetCatalogsById() {
        Catalog catalog = restTemplate.getForObject(getRootUrl() + "/catalogs/1", Catalog.class);
        System.out.println(catalog.getSkuCode());
        Assert.assertNotNull(catalog);
    }

    @Test
    public void testPostSupplier() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/catalogs",
                HttpMethod.POST, entity, String.class);

        Assert.assertNotNull(response.getBody());
    }


}
