package org.luv2code.o8_advance_features;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

import java.nio.file.Paths;

public class TracingAndVideoRecordingTest extends BaseTest {
    @Test
    public void tracingAndVideoRecordingTest() {

        // start tracing (screenshots, snapshots, sources)
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true)
        );

        // click on "Authentication" link
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions()
                .setName("Authentication").setExact(true)).click();

        // check presence of "Authentication" heading
        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions()
                .setName("Authentication")).isVisible();

        // check presence of "Welcome!" heading
        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions()
                .setName("Welcome!")).isVisible();

        // send username to username text field
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions()
                .setName("username")).fill("admin");

        // send password to password text field
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions()
                .setName("password")).fill("admin");

        // click on "Sign In" button
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
                .setName("Sign In")).click();

        // check presence of "Login Successful" heading
        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions()
                .setName("Login Successful")).isVisible();

        // click on "Logout" button
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
                .setName("Logout")).click();

        // check presence of "Welcome!" heading
        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions()
                .setName("Welcome!")).isVisible();

        // stop tracing and save trace file
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("target/trace.zip")));

        // to show trace
        // npm install playwright
        // npx playwright show-trace target/trace.zip

    }
}
