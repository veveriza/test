package Test;

import PageObjects.JustGivingAuthentication;
import PageObjects.JustGivingIdentity;
import PageObjects.JustGivingMessageAndAmountPage;
import PageObjects.JustGivingPaymentMethod;
import org.junit.AfterClass;
import org.junit.Test;
import utils.MockDataGenerator;

public class SampleTest {

    @AfterClass
    public static void tearDown() {
//        getDriver().close();
    }

    @Test
    public void should_not_login_with_wrong_credentials() {
        String t = MockDataGenerator.generate("4539", 16);

        //given
        JustGivingMessageAndAmountPage justGivingMessageAndAmountPage = new JustGivingMessageAndAmountPage().open();

        //when
        justGivingMessageAndAmountPage.leaveMessage();
        justGivingMessageAndAmountPage.enterYourName();
        JustGivingIdentity justGivingIdentity = justGivingMessageAndAmountPage.clickContinue();

        justGivingIdentity.enterEmailAddress();
        JustGivingAuthentication justGivingAuthentication = justGivingIdentity.clickContinue();
        justGivingAuthentication.enterPassword();

        JustGivingPaymentMethod justGivingPaymentMethod = justGivingAuthentication.clickContinue();

//        //then
//        assertThat(loginPage.isLoginError()).isTrue();
    }
}
