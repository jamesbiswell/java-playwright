package org.luv2code.o9_junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AllAssertionsTest {
    @Test
    public void allAssertionsTest() {

        // 1. assertEquals - compare values
        String expected = "Luv2Test";
        String actual = "Luv2Test";
        Assertions.assertEquals(expected, actual);

        // 2. assertNotEquals - values must differ
        int a = 5, b = 10;
        Assertions.assertNotEquals(a, b);

        // 3. assertTrue - condition must be true
        Assertions.assertTrue(5 < 10, "Condition should be true!");

        // 4. assertFalse - condition must be false
        Assertions.assertFalse(5 > 10, "Condition should be false!");

        // 5. assertNull - object must be null
        String strNull = null;
        Assertions.assertNull(strNull, "Object should be null!");

        // 6. assertNotNull - object must not be null
        String strNotNull = "Luv2Test";
        Assertions.assertNotNull(strNotNull);

        // 7. assertSame - must be same reference
        String str1 = "Luv2Code";
        String str2 = str1;
        Assertions.assertSame(str1, str2, "Objects are not same reference");

        // 8. assertNotSame - must be different objects
        String str3 = new String("Luv2Code");
        String str4 = new String("Luv2Code");
        Assertions.assertNotSame(str3, str4);

        // 9. Soft assertions (JUnit 5) - using assertAll for multiple validations
        Assertions.assertAll("Soft assertions example",
                () -> Assertions.assertEquals("Title", "Title", "Title Mismatch"),
                () -> Assertions.assertTrue(5 < 10, "Condition Failed"),
                () -> Assertions.assertNotNull("Hello", "Object should not be null")
        );

        // 10. fail() - forcefully fail test
//        Assertions.fail("Forcefully failing this test!");

    }
}
