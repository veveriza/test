package Test;

import PageObjects.JustGivingIdentity;
import PageObjects.JustGivingMessageAndAmountPage;
import org.junit.AfterClass;
import org.junit.Test;

public class SampleTest {

    @AfterClass
    public static void tearDown() {
//        getDriver().close();
    }

    @Test
    public void should_not_login_with_wrong_credentials() {
        //given
        JustGivingMessageAndAmountPage justGivingMessageAndAmountPage = new JustGivingMessageAndAmountPage().open();

        //when
        justGivingMessageAndAmountPage.leaveMessage("some text");
        justGivingMessageAndAmountPage.enterYourName("my name is veveriza");
        JustGivingIdentity justGivingIdentity = justGivingMessageAndAmountPage.clickContinue();


//        //then
//        assertThat(loginPage.isLoginError()).isTrue();
    }
}
