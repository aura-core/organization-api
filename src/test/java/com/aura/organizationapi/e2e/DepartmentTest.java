package com.aura.organizationapi.e2e;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@DisplayName("Department e2e tests")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DepartmentTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    @DisplayName("create team")
    void testCreate() {

    }

    @Test
    void testFindOne() {
    }

    @Test
    void testFindAll() {
    }

    @Test
    void testUpdate() {
    }

    @Test
    void testDelete() {
    }

}
