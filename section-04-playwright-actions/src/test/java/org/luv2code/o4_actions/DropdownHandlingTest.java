package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class DropdownHandlingTest extends BaseTest {
    @Test
    public void dropdownHandlingTest() {

        // navigate to dropdown page
        page.navigate("https://www.luv2test.com/#/dropdowns");

        // normal dropdown
        Locator normalDropdown = page.locator("#normal-dropdown");
        normalDropdown.selectOption(new SelectOption().setLabel("Apple"));
//        normalDropdown.selectOption(new SelectOption().setValue("apple"));
//        normalDropdown.selectOption(new SelectOption().setIndex(1));

        // multi-select dropdown (select by value)
//        page.locator("#multi-dropdown")
//                        .selectOption(new String[] {"apple", "grapes", "banana"});

        // multi-select dropdown (select by visible text)
        page.locator("#multi-dropdown")
                .selectOption(new SelectOption[]{
                        new SelectOption().setLabel("Apple"),
                        new SelectOption().setLabel("Grapes"),
                        new SelectOption().setLabel("Orange"),
                });

        // searchable dropdown
        page.locator("#search-input").fill("Python");
        page.locator("#searchable-dropdown")
                        .selectOption(new SelectOption().setLabel("Python"));

        // add option + select
        page.locator("#add-option-input").fill("C++");
        page.locator("#add-option-button").click();
        page.locator("#addable-dropdown")
                        .selectOption(new SelectOption().setLabel("C++"));

        // hover dropdown
        Locator hoverMenu = page.locator("//div[text()='Hover over this box to choose a language']");
        hoverMenu.hover();

        page.locator("//li[text()='Go']").click();

        // hover away
//        page.locator("html").hover();
        page.locator("body").hover();

        System.out.println("SUCCESS");

    }
}
