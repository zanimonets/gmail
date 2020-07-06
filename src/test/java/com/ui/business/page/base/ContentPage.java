package com.ui.business.page.base;

import com.ui.business.page.NewLetterPage;
import com.ui.business.page.module.HeaderModule;
import com.ui.business.page.module.LeftPanelModule;
import org.openqa.selenium.WebDriver;

public class ContentPage extends BasePage {

    private NewLetterPage newLetterPage;
    private HeaderModule headerModule;
    private LeftPanelModule leftPanelModule;

    public ContentPage(WebDriver driver) {
        super(driver);
        headerModule = new HeaderModule(driver);
        newLetterPage = new NewLetterPage(driver);
        leftPanelModule = new LeftPanelModule(driver);
    }

    public HeaderModule headerModule() {
        return headerModule;
    }

    public LeftPanelModule leftPanelModule() {
        return leftPanelModule;
    }

    public NewLetterPage newLetterPage() { return newLetterPage;}
}
