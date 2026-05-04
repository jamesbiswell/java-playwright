package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class KeyboardActionsTest extends BaseTest {
    @Test
    public void keyboardActionsTest() {

        // navigate to key-presses page
        page.navigate("https://www.luv2test.com/#/key-press");

        // perform keyboard events
        page.keyboard().press("A");
        page.keyboard().press("Enter");
        page.keyboard().press("Tab");
        page.keyboard().press("Escape");
        page.keyboard().press("Backspace");
        page.keyboard().press("Z");
        waitInSeconds(3);

        // navigate to authentication page
        page.navigate("https://www.luv2test.com/#/auth");

        // locate username and password fields
        Locator username = page.locator("#username");
        Locator password = page.locator("#password");

        // type 'admin' in username field
        username.fill("admin");
        waitInSeconds(1);

        // select all text in username field (CMD + A)
        username.click();
        page.keyboard().down("Meta"); // for command (MAC) / User Ctrl for (Windows)
        page.keyboard().press("A");
        page.keyboard().up("Meta");
        waitInSeconds(1);

        // copy selected text (CMD + C)
        page.keyboard().down("Meta");
        page.keyboard().press("C");
        page.keyboard().up("Meta");
        waitInSeconds(1);

        // click on password field
        password.click();

        // paste copied text into password field (CMD + V)
        page.keyboard().down("Meta");
        page.keyboard().press("V");
        page.keyboard().up("Meta");
        waitInSeconds(1);

        // submit the form
        password.press("Enter");
        waitInSeconds(3);

    }
}
