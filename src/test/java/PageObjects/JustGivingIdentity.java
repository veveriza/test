package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JustGivingIdentity extends JustGivingPage<JustGivingIdentity>{


    @FindBy(id = "Identity-fieldset")
    WebElement fieldSet;

    @FindBy(xpath = "//a[contains(@class,'awesome-continue-button ')]")
    WebElement continueButton;

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(fieldSet);
    }

    @Override
    public String getPageUrl() {
        return "4w350m3/donation/direct/charity/2050#Identity";
    }

    @Override
    public void clickButton(WebElement button) {
        button.click();
    }

    public void clickContinue() {
        clickButton(continueButton);
    }
}
