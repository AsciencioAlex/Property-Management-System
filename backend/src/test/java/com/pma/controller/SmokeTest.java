package com.asciencio.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private PropertyManagementController propertyManagementController;

    @Test
    public void contextLoads() throws Exception{
        assertThat(propertyManagementController).isNull();
    }
}
