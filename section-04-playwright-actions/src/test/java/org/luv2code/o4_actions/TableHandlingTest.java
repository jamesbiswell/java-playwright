package org.luv2code.o4_actions;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

import java.text.MessageFormat;
import java.util.List;

public class TableHandlingTest extends BaseTest {
    @Test
    public void tableHandlingTest() {

        // navigate to Dynamic Tables page
        page.navigate("https://www.luv2test.com/#/tables");

        // find an email in dynamic table
        Locator email1 = page.locator("//td[text()='jeeva@example.com']");
        highlightElement(email1);
        waitInSeconds(2);

        // find all emails and print them
        for (int i = 1; i <= 10; i++){
            String emailsLocator = MessageFormat.format("//td[1][text()=''{0}'']/../td[3]", i);
            Locator emailAddress = page.locator(emailsLocator);
            System.out.println("Emails Address: " + emailAddress.textContent());
        }

        // locate the table and get all rows/columns from table
        Locator table = page.locator("#dynamic-table");
        List<ElementHandle> allRows = table.locator("tbody tr").elementHandles();
        List<ElementHandle> allCols = table.locator("thead tr th").elementHandles();
        System.out.println("Total Rows: " + allRows.size());
        System.out.println("Total Columns: " + allCols.size());

        // print all table data
        for (int i = 1; i < allRows.size(); i++) {
            for (int j = 1; j < allCols.size(); j++) {
                String cellPath = "//tbody/tr[" + i +"]/td[" + j + "]";
                Locator cell = table.locator(cellPath);
                System.out.print(cell.textContent() + " | ");
            }
            System.out.println();
        }

    }
}
