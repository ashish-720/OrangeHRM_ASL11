package org.OrangeHrmGrids;

import org.OrangeHRMPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmployeeListGrid extends BasePage {

    @FindBy(how = How.CSS, using = "table#employeeListTable")
    private WebElement employeeListTable;

    public EmployeeListGrid(WebDriver driver) {
        super(driver);
    }


}
