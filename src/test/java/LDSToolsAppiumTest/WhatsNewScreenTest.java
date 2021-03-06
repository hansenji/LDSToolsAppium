package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.PinScreen;
import LDSToolsAppium.Screen.WhatsNewScreen;
import org.testng.Assert;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;


public class WhatsNewScreenTest extends BaseDriver {

    @Test (groups = {"all1", "all", "smoke", "smoke1", "jft"})
    public void whatsNewSimple() throws Exception {
        String pageSource;
        HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);

        //Todo: Android won't pop up the Whats New Page with automation
        if (getRunningOS().equals("ios")) {
            myHelper.loginUAT("LDSTools32", "password1");
            myHelper.enterPinKeepWhatsNew("1", "1", "3", "3");

            Thread.sleep(2000);

            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("What's New", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Version 3.5", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Temple Recommend Information", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Service Missionaries", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Household Locations", pageSource, "Contains"));

            myWhatsNew.whatsNewDone.click();
        }

    }




}
