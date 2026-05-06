package org.luv2code.o7_real_time_challenges;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

import java.util.List;

public class BrokenImagesTest extends BaseTest {
    @Test
    public void brokenImagesTest() {

        // navigate to broken images page
        page.navigate("https://www.luv2test.com/#/broken-images");

        // get all image URLs
        List<String> imageUrls = (List<String>) page.locator("img").evaluateAll(
                "elements => elements.map(el => el.src)"
        );

        System.out.println("Total images found: " + imageUrls.size());

        // create a Playwright request context
        APIRequestContext request = page.context().request();

        for (String imgUrl : imageUrls) {
            try {
                APIResponse response = request.get(imgUrl);
                int status = response.status();
                if (status >= 400) {
                    System.err.println("Broken Image: " + imgUrl + " - Status: " + status);
                } else {
                    System.out.println("Valid Image: " + imgUrl + " - Status: " + status);
                }
            } catch (Exception exc) {
                System.err.println("Error checking image: " + imgUrl + " - " + exc.getMessage());
            }
        }

    }
}
