package PageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

import static DriverSetup.SeleniumSetup.getDriver;

public abstract class JustGivingPage<T> {
    private static final String BASE_URL = "https://www.justgiving.com";
    private static final int LOAD_TIMEOUT = 30;
    private static final int REFRESH_RATE = 2;

    public T openPage(Class<T> clazz) {
        T page = PageFactory.initElements(getDriver(), clazz);
        getDriver().get(BASE_URL + getPageUrl());
        ExpectedCondition pageLoadCondition = ((JustGivingPage) page).getPageLoadCondition();
        waitForPageToLoad(pageLoadCondition);
        return page;
    }

    public void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
        Wait wait = new FluentWait(getDriver())
                .withTimeout(LOAD_TIMEOUT, TimeUnit.SECONDS)
                .pollingEvery(REFRESH_RATE, TimeUnit.SECONDS);

        wait.until(pageLoadCondition);
    }

    /**
     * Provides condition when page can be considered as fully loaded.
     *
     * @return
     */
    protected abstract ExpectedCondition getPageLoadCondition();

    /**
     * Provides page relative URL/
     *
     * @return
     */
    public abstract String getPageUrl();

    public abstract void clickButton(WebElement button);
}
