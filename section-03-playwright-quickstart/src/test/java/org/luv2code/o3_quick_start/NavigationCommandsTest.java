package org.luv2code.o3_quick_start;

import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class NavigationCommandsTest extends BaseTest {

    @Test
    public void navigationCommandsTest() {

        // Navigate to a specific URL
        page.navigate("https://www.luv2test.com/#/tables");

        // Wait until a specific URL is loaded
        page.waitForURL("**/tables");
        
        // Go back to the previous page in browser history
        page.goBack();

        // Go forward to the next page in browser history
        page.goForward();

        // Refresh the current page
        page.reload();
        
    }

}
