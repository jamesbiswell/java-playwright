package org.luv2code.framework.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.luv2code.framework.utils.ConfigUtil;

public abstract class BasePage {

    protected Page page;

    public BasePage(Page page){
        this.page = page;
    }

    // common actions

    // check presence of element
    public void shouldBeDisplayed(String selector) {
        long startTime = System.currentTimeMillis();
        System.out.println("Finding element: " + selector);
        Locator locator = page.locator(selector);
        locator.waitFor(); // ensures locator is attached & visible

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Element found: " + selector + " in " + duration + " ms");

        if(ConfigUtil.getProperty("debug").equalsIgnoreCase("true")){
            highlightElement(locator);
        }
    }
    
    private void highlightElement(Locator locator) {
        ElementHandle handle = locator.elementHandle();
        if(handle != null) {
            locator.page().evaluate("e => {" +
                    "e.style.border='3px solid red'; " +
                    "e.style.backgroundColor='yellow'; }", handle);
        }
    }

    // click
    public void click(String selector) {
        page.locator(selector).first().click();
    }

    public void click(Locator locator) {
        locator.click();
    }

    // type/fill
    public void type(String selector, String text) {
        page.locator(selector).fill(text);
    }

    // get text
    public String getText(String selector) {
        return page.locator(selector).innerText();
    }

    // get title
    public String getTitle() {
        return page.title();
    }

    // more as required ...

}
