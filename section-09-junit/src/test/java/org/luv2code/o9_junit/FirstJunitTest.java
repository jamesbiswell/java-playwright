package org.luv2code.o9_junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
@ExtendWith({LoggingExtension.class})
public class FirstJunitTest {

//    @Test @Order(1)
//    public void openApplication() {
//        System.out.println("Step 1: Launch Application");
//    }
//    @Test @Order(2)
//    public void loginTest() {
//        System.out.println("Step 2: Perform Login");
//    }
//    @Test @Order(3)
//    public void logoutTest() {
//        System.out.println("Step 3: Perform Logout");
//    }

    @Test @DisplayName("A")
    public void openApplication() {
        System.out.println("Step 1: Launch Application");
    }
    @Test @DisplayName("B")
    public void loginTest() {
        System.out.println("Step 2: Perform Login");
    }
    @Test @DisplayName("C")
    public void logoutTest() {
        System.out.println("Step 3: Perform Logout");
        Assertions.fail("failed this test");
    }

}
