package com.example.internshipproject;


import com.example.internshipproject.controller.SupplierController;
import com.example.internshipproject.model.Supplier;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InternshipProjectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SupplierControllerTest {


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
    public void testGetAllSuppliers() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/suppliers",
                HttpMethod.GET, entity, String.class);

        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void testGetSupplierById() {
        Supplier supplier = restTemplate.getForObject(getRootUrl() + "/suppliers/1", Supplier.class);
        System.out.println(supplier.getSupplierId());
        Assert.assertNotNull(supplier);
    }

    @Test
    public void testPostSupplier() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/suppliers",
                HttpMethod.POST, entity, String.class);

        Assert.assertNotNull(response.getBody());
    }


}
