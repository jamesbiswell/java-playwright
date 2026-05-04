package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

import java.nio.file.Paths;

public class FileHandlingTest extends BaseTest {
    @Test
    public void fileHandlingTest() {

        // navigate to file upload page
        page.navigate("https://www.luv2test.com/#/file-upload");
        page.waitForTimeout(2000);

        // file upload with absolute path
        Locator fileField = page.locator("#file-upload");
        fileField.setInputFiles(Paths.get("C:\\Users\\james\\Documents\\Udemy\\Java Playwright\\java-playwright\\section-04-playwright-actions\\src\\main\\resources\\files\\can_do.jpg"));

        waitInSeconds(2);
        page.reload();
        waitInSeconds(2);

        // upload file using relative path
        String path = System.getProperty("user.dir");
        String filePath = path + "/src/main/resources/files/butterfly.webp";
        System.out.println("Relative file path: " + filePath);
        page.locator("#file-upload").setInputFiles(Paths.get(filePath));

        waitInSeconds(3);

    }
}
