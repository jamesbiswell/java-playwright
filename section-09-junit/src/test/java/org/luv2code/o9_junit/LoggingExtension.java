package org.luv2code.o9_junit;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.lang.reflect.Field;
import java.nio.file.Paths;

public class LoggingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback,
        TestWatcher {

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        System.out.println("[LOG] Test Finished -> " + extensionContext.getDisplayName());
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        System.out.println("[LOG] Test Started -> " + extensionContext.getDisplayName());

    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("[LOG] Test Successful -> " + context.getDisplayName());
    }
    
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("[LOG] Test Failed -> " + context.getDisplayName());
        
        Object testInstance = context.getRequiredTestInstance();
        try {
            Field pageField = testInstance.getClass().getSuperclass().getDeclaredField("page");
            pageField.setAccessible(true);
            Page page = (Page) pageField.get(testInstance);
            if (page == null) {
                System.out.println("[ERROR] Page is null, cannot take screenshot.");
            } else {
                if (page.isClosed()) {
                    page = page.context().pages().getFirst();
                    System.out.println("[LOG] Page is closed, using fallback page for screenshot.");
                }
                String fileName = context.getDisplayName().replace("()", "")
                        + "-" + System.currentTimeMillis() + ".png";
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/" + fileName)));
                System.out.println("[LOG] Screenshot saved: screenshots/" + fileName);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    
}
