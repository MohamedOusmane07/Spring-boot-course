package com.dadi.springbootcourse.school;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SchoolMapperTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inside before all method ");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Before each test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Inside after each method");
    }

    @Test
    public void testMethod1(){
        System.out.println("testMethod1");
    }


    @Test
    public void testMethod2(){
        System.out.println("testMethod2");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Inside after all method ");
    }
}