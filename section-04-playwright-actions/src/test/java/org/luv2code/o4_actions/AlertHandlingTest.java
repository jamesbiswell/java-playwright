package org.luv2code.o4_actions;

import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class AlertHandlingTest extends BaseTest {
    @Test
    public void alertHandlingTest() {

        // navigate to Alerts page
        page.navigate("https://www.luv2test.com/#/alerts");

        // check presence of "Alerts" heading
        highlightElement(page.locator("//h1[text()='JavaScript Alerts']"));

        // Simple Alert
        page.onceDialog(dialog -> {
            System.out.println("Simple Alert Text: " + dialog.message());
            dialog.accept();
        });
        page.locator("//button[@data-test='alert-button']").click();

        // Confirmation Alert
        page.onceDialog(dialog -> {
            System.out.println("Confirmation Alert Text: " + dialog.message());
            dialog.dismiss();
        });
        page.locator("//button[@data-test='confirm-button']").click();

        // Prompt Alert
        page.onceDialog(dialog -> {
            System.out.println("Prompt Alert Text: " + dialog.message());
            dialog.accept("Tester of Playwright");
        });
        page.locator("//button[@data-test='prompt-button']").click();

        System.out.println("Success");

    }

}
