package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class DragAndDropTest extends BaseTest {
    @Test
    public void dragAndDropTest() {

        // navigate to "drag and drop" page
        page.navigate("https://www.luv2test.com/#/drag-drop");

        // locate source and target elements
        Locator apple = page.locator("#sortable-item-Apple");
        Locator dropArea = page.locator("#dropped-area");

        // drag and drop is built-in in playwright
        apple.dragTo(dropArea);
        waitInSeconds(1);

        Locator pineapple = page.locator("#sortable-item-Pineapple");
        pineapple.dragTo(dropArea);
        waitInSeconds(1);

        Locator banana = page.locator("#sortable-item-Banana");
        banana.dragTo(dropArea);
        waitInSeconds(2);

        // advanced actions: clickAndHold -> moveByOffset -> release
        Locator orange = page.locator("#sortable-item-Orange");

        // click and hold
        orange.hover();
        page.mouse().move(
                orange.boundingBox().x + orange.boundingBox().width / 2,
                orange.boundingBox().y + orange.boundingBox().height / 2
        );
        page.mouse().down();
        waitInSeconds(1);

        // move by offset (200, 300)
        page.mouse().move(
                orange.boundingBox().x + 200,
                orange.boundingBox().y + 300
        );
        waitInSeconds(1);

        // release
        page.mouse().up();
        waitInSeconds(3);

    }
}
