package org.luv2code.o9_junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class ParameterizedExampleTest {

    // 1. Using @ValueSource (single parameter)
    @ParameterizedTest
    @ValueSource(strings = {"admin1", "user2", "admin3"})
    public void loginWithValueSource(String username) {
        System.out.println("1. Logging in with user: " + username);
    }

    // 2. Using @CsvSource (multiple parameters)
    @ParameterizedTest
    @CsvSource( {
            "user1, pass1",
            "user2, pass2",
            "user3, pass3",
    } )
    public void loginWithCsvSource(String username, String password) {
        System.out.println("2. Logging in with user: " + username + " and pass: " + password);
    }

    // 3. Using @CsvFileSource (data from CSV file)
    // CSV file: src/test/resources/loginData.csv
    // Contents:
    // admin,admin123
    // user2,pass2
    // user3,pass3
    @ParameterizedTest
    @CsvFileSource(resources = "/loginData.csv", numLinesToSkip = 0)
    public void loginWithCsvFileSource(String username, String password) {
        System.out.println("3. Logging in with user: " + username + " and pass: " + password);
    }

    // Using @MethodSource (dynamic data provider)
    static Stream<Arguments> loginDataProvider() {
        return Stream.of(
                Arguments.of("user1", "password123"),
                Arguments.of("user2", "password2"),
                Arguments.of("user3", "password3")
        );
    }

    @ParameterizedTest
    @MethodSource("loginDataProvider")
    public void loginWithMethodSource(String username, String password) {
        System.out.println("4. Logging in with user: " + username + " and pass: " + password);
    }

    // Using @EnumSource (if you have enum for users)
    enum User {
        ADMIN, USER, USER2
    }

    @ParameterizedTest
    @EnumSource(User.class)
    public void loginWithEnumSource(User user) {
        System.out.println("5. Logging with user: " + user);
    }

}
