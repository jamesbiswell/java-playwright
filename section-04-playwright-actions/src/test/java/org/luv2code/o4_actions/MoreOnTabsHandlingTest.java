package org.luv2code.o4_actions;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

import java.util.List;

public class MoreOnTabsHandlingTest extends BaseTest {
    @Test
    public void moreOnTabsHandlingTest() {

        // navigate to tabs-windows page
        page.navigate("https://www.luv2test.com/#/tabs-windows");

        // store original tab
        Page originalPage = page;

        // open 3 new tabs
        for (int i = 0; i < 3; i++) {
            Page newTab = context.waitForPage(() -> {
                page.locator("//button[@data-test=\"open-home-tab\"]").click();
            });

            // ensure tab is loaded
            newTab.waitForLoadState();

            // switch back to original page
            originalPage.bringToFront();
            waitInSeconds(1);
        }

        // get list of all tabs
        List<Page> allTabs = context.pages();

        // switch to all tabs one-by-one
        for (Page p : allTabs){
            p.bringToFront();
            waitInSeconds(1);
        }

        // open a blank new tab
        Page blankTab = context.newPage();
        blankTab.bringToFront();
        waitInSeconds(1);

        // switch back to original tab
        originalPage.bringToFront();
        waitInSeconds(1);

        // access tabs by index
        if (allTabs.size() > 2) {
            allTabs.get(2).bringToFront();
            waitInSeconds(1);
        }

        // close all tabs except original
        for (Page p : context.pages()) {
            if (p != originalPage) {
                p.close();
            }
        }

        // switch back to original tab
        originalPage.bringToFront();
        waitInSeconds(2);

        // click on 'Uncheck All'
        originalPage.locator("//button[@data-test=\"uncheck-all-button\"]").click();
        waitInSeconds(2);

    }
}
