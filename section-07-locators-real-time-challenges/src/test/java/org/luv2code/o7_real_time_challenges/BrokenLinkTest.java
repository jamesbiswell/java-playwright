package org.luv2code.o7_real_time_challenges;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

import java.util.List;

public class BrokenLinkTest extends BaseTest {
    @Test
    public void brokenLinkTest() {


        
        
        // get all link URLs
        List<String> linkUrls = (List<String>) page.locator("a").evaluateAll(
                "elements => elements.map(el => el.href)"
        );

        System.out.println("Total links found: " + linkUrls.size());

        // create a Playwright request context
        APIRequestContext request = page.context().request();

        for (String linkUrl : linkUrls) {
            try {
                APIResponse response = request.get(linkUrl);
                int status = response.status();
                if(status >= 400) {
                    System.err.println("Broken Link: " + linkUrl + " - Status: " + status);
                } else {
                    System.out.println("Valid Link: " + linkUrl + " - Status: " + status);
                }
            } catch (Exception exc) {
                System.err.println("Error checking link: " + linkUrl + " - " + exc.getMessage());
            }
        }


    }
}
