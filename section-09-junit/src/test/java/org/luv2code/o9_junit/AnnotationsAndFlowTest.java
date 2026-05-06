package org.luv2code.o9_junit;

import org.junit.jupiter.api.*;

public class AnnotationsAndFlowTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll - Initialize DB/Config");
    }
    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll - Disconnect DB/Config");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("@BeforeEach - Login before test");
    }
    @AfterEach
    public void afterEachTest() {
        System.out.println("@AfterEach - Logout after test");
    }

    @Test @Tag("smoke")
    public void testCase1() {
        System.out.println("@Test - Execute testcase1 (smoke)");
    }
}
