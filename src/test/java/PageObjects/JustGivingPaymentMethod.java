package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.MockDataGenerator;

public class JustGivingPaymentMethod extends JustGivingPage<JustGivingPaymentMethod>{

    public static final String[] VISA_PREFIX_LIST = new String[] { "4539",
            "4556", "4916", "4532", "4929", "40240071", "4485", "4716", "4" };

    public static final String[] MASTERCARD_PREFIX_LIST = new String[] { "51",
            "52", "53", "54", "55" };


    @FindBy(id = "Payment-fieldset")
    WebElement fieldSet;

    @FindBy(xpath = "//a[contains(@class,'awesome-continue-button ')]")
    WebElement continueButton;

    @FindBy(id = "Payment_CardType")
    WebElement selectCard;

    @FindBy(id = "Payment_CardNumber")
    WebElement cardNumber;

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(fieldSet);
    }

    @Override
    public String getPageUrl() {
        return "";
    }

    //make invisible for the test
    @Override
    public void clickButton(WebElement button) {
        button.click();
    }

    public void selectCardType(){
        Select dropDown = new Select(selectCard);
        dropDown.selectByValue("Visa Debit");
    }

    public void setCardNumber() {
        //make it to select randomly form the array
        //http://codytaylor.org/2009/11/this-is-how-credit-card-numbers-are-generated.html
        //http://euro.ecom.cmu.edu/resources/elibrary/everycc.htm
        cardNumber.sendKeys(MockDataGenerator.generate(VISA_PREFIX_LIST[0], 16));
    }

    public JustGivingAuthentication clickContinue() {
        clickButton(continueButton);
        JustGivingAuthentication justGivingAuthentication = new JustGivingAuthentication();
        justGivingAuthentication.waitForPageToLoad(getPageLoadCondition());
        return justGivingAuthentication;
    }
}
