package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.BoundingBox;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class RetrievingElementInfoAndStatesTest extends BaseTest {
    @Test
    public void retrievingElementInfoAndStatesTest() {

        // Retrieving element Information
        Locator heading = page.locator("h1");
        System.out.println("Text: " + heading.innerText());
        System.out.println("Tag Name: " + heading.evaluate("el => el.tagName.toLowerCase()"));
        System.out.println("Attributes (class): " + heading.getAttribute("class"));
        System.out.println("Css value (color): " +
                heading.evaluate("el => getComputedStyle(el).color"));
        BoundingBox box = heading.boundingBox();
        System.out.println("Location: (x: " + box.x + ", y: " + box.y + ")");
        System.out.println("Size: (width: " + box.width + ", height: " + box.height + ")");
        System.out.println("\n");

        // Navigate to "Tab Window & Checkboxes"
        page.navigate("https://www.luv2test.com/#/tabs-windows");

        // Checking Element States
        Locator checkbox1 = page.locator("#checkbox1");
        System.out.println("Checkbox 1");
        System.out.println("Visible: " + checkbox1.isVisible());
        System.out.println("Enabled: " + checkbox1.isEnabled());
        System.out.println("Checked: " + checkbox1.isChecked());
        
        System.out.println();
        
        Locator checkbox4 = page.locator("#checkbox4");
        System.out.println("Checkbox 4");
        System.out.println("Visible: " + checkbox4.isVisible());
        System.out.println("Enabled: " + checkbox4.isEnabled());
        System.out.println("Checked: " + checkbox4.isChecked());

        System.out.println("Editable: " + checkbox4.isEditable());
        System.out.println("Disabled: " + checkbox4.isDisabled());
        System.out.println("Hidden: " + checkbox4.isHidden());

    }

}
