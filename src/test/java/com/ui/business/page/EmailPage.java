package com.ui.business.page;

import com.ui.business.page.base.ContentPage;
import com.ui.business.page.module.TableModule;
import org.openqa.selenium.WebDriver;

public class EmailPage extends ContentPage {

    private TableModule tableModule;

    public EmailPage(WebDriver driver) {
        super(driver);
        tableModule = new TableModule(driver);
    }

    public TableModule tableModule() {
        return tableModule;
    }
}
