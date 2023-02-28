package com.asciencio.controller;

import com.asciencio.model.OccupancyStatus;
import com.asciencio.model.PropertyDTO;
import com.asciencio.model.PropertyType;

import java.net.URI;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class PropertyManagementControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    PropertyDTO mockProperty = PropertyDTO.builder().propertyName("Naveen's Hell")
            .id(1L)
            .propertyType(PropertyType.BUILDER)
            .occupancyStatus(OccupancyStatus.VACANT)
            .propertyDetails("calgary").build();

    private String token ="Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqd3R1c2VybmFtZSIsImV4cCI6MTYxODE1NzY1MiwiaWF0IjoxNjE4MTM5NjUyfQ.P6NCQPCcyEKWpCIVxCul9z_euqbilg7lH3g8vqllPMcGeS1QXZRjieFIYCgUIHb5JPu0SAhsqn_2UpFO6XeupA";


    @Test
    public void testAdd() throws Exception {
        final String baseUrl = "http://localhost:"+randomServerPort+"/pma/api/v1/property/add";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<PropertyDTO> request = new HttpEntity<>(mockProperty, headers);
        ResponseEntity<PropertyDTO> result = this.restTemplate.postForEntity(uri, request, PropertyDTO.class);

        //Verify request succeed
        Assert.assertEquals(201, result.getStatusCodeValue());
    }

    @Test
    public void testUpdate() throws Exception {
        final String baseUrl = "http://localhost:"+randomServerPort+"/pma/api/v1/property/update";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<PropertyDTO> request = new HttpEntity<>(mockProperty, headers);
        ResponseEntity<PropertyDTO> result = this.restTemplate.postForEntity(uri, request, PropertyDTO.class);

        //Verify request succeed
        Assert.assertEquals(201, result.getStatusCodeValue());
    }

    @Test
    public void testAuthorize() throws Exception {
        final String baseUrl = "http://localhost:"+randomServerPort+"/pma/api/v1/property/approve/1";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<PropertyDTO> request = new HttpEntity<>(mockProperty, headers);
        ResponseEntity<PropertyDTO> result = this.restTemplate.postForEntity(uri, request, PropertyDTO.class);

        //Verify request succeed
        Assert.assertEquals(201, result.getStatusCodeValue());
    }

    @Test
    public void testSearch() throws Exception {
        final String baseUrl = "http://localhost:"+randomServerPort+"/pma/api/v1/property/search?searchString=test";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        ResponseEntity<Object> result = this.restTemplate.getForEntity(uri, Object.class);

        //Verify request succeed
        Assert.assertEquals(401, result.getStatusCodeValue());
    }


}
