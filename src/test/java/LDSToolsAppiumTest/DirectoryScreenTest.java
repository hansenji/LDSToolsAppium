package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

import okhttp3.OkHttpClient;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;



public class DirectoryScreenTest extends BaseDriver {

    //1 = Bishopric
    //2 = Ward Council
    //3 = Special?
    //4 = No Calling


    @Test(dataProvider = "Members", groups = {"smoke2", "smoke", "all2", "all"})
    public void directoryScreenTest(String userName, String passWord, String rightsString, String callingGroup) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");

        //Search and click on Aaron Jane
        myDirectory.searchAndClick("Seuamuli, Alofa");

        //Get all info
        pageSource = myDirectory.getDirectoryUserData();

        //General Information
        myBasePage.rightsCheck("Fagamalo", 4, rights, pageSource);
//        myBasePage.rightsCheck("555-555-5555", 4, rights, pageSource);
//        myBasePage.rightsCheck("555-555-1234", 4, rights, pageSource);
//        myBasePage.rightsCheck("HOUSEHOLD", 4, rights, pageSource);

        //This has visibility set to leadership only
        myBasePage.rightsCheck("alofas@gmail.com", 3, rights, pageSource);

        //Membership Information
        myBasePage.rightsCheck("MEMBERSHIP INFORMATION", 3, rights, pageSource);
        myBasePage.rightsCheck("Seuamuli, Alofa", 4, rights, pageSource);
        myBasePage.rightsCheck("FULL NAME", 3, rights, pageSource);
        myBasePage.rightsCheck("Temple Recommend", 1, rights, pageSource);
        myBasePage.rightsCheck("Mar 2016", 1, rights, pageSource);
        myBasePage.rightsCheck("Record Number", 1, rights, pageSource);
        myBasePage.rightsCheck("052-0013-5325", 1, rights, pageSource);

        //Birth Date
        myBasePage.rightsCheck("August 12, 1961", 2, rights, pageSource);
        myBasePage.rightsCheck("Birth Date", 3, rights, pageSource);
        myBasePage.rightsCheck("57", 2, rights, pageSource);

        //Ordinances
        myBasePage.rightsCheck("Baptism", 1, rights, pageSource);
        myBasePage.rightsCheck("January 31, 1971", 1, rights, pageSource);
        myBasePage.rightsCheck("Confirmation", 1, rights, pageSource);
        myBasePage.rightsCheck("January 31, 1971", 1, rights, pageSource);
        myBasePage.rightsCheck("Endowment", 1, rights, pageSource);
        myBasePage.rightsCheck("January 27, 1994", 1, rights, pageSource);


        //Marriage
        myBasePage.rightsCheck("MARRIAGE", 1, rights, pageSource);
        myBasePage.rightsCheck("Spouse", 1, rights, pageSource);
//        myBasePage.rightsCheck("Seuamuli, Faimeaita", 1, rights, pageSource);
        myBasePage.rightsCheck("Spouse Birth Date", 1, rights, pageSource);
        myBasePage.rightsCheck("November 27, 1957", 1, rights, pageSource);
        myBasePage.rightsCheck("Marriage Date", 1, rights, pageSource);
        myBasePage.rightsCheck("October 20, 1984", 1, rights, pageSource);
        myBasePage.rightsCheck("Marriage Place", 1, rights, pageSource);
        myBasePage.rightsCheck("Fagamalo, Savaii, Samoa", 1, rights, pageSource);
        myBasePage.rightsCheck("Maiden Name", 1, rights, pageSource);
        myBasePage.rightsCheck("Aumoto, Alofa", 1, rights, pageSource);



        //Callings and Classes - New in 3.0.0
        myBasePage.rightsCheck("Relief Society First Counselor", 4, rights, pageSource);
        myBasePage.rightsCheck("Organization - Relief Society Presidency", 4, rights, pageSource);
        myBasePage.rightsCheck("Class Assignments", 3, rights, pageSource);
        myBasePage.rightsCheck("Gospel Doctrine", 3, rights, pageSource);
        myBasePage.rightsCheck("Relief Society", 4, rights, pageSource);
        myBasePage.rightsCheck("Sustained", 3, rights, pageSource);
        myBasePage.rightsCheck("Set Apart", 3, rights, pageSource);



        // myBasePage.rightsCheck("Ordinances", 2, rights, pageSource);
        myBasePage.rightsCheck("Gender", 3, rights, pageSource);
        myBasePage.rightsCheck("Female", 3, rights, pageSource);
        myBasePage.rightsCheck("Birth Country", 1, rights, pageSource);
        myBasePage.rightsCheck("Western Samoa", 1, rights, pageSource);
        myBasePage.rightsCheck("Father", 1, rights, pageSource);
        myBasePage.rightsCheck("Aumoto, Talele", 1, rights, pageSource);
        myBasePage.rightsCheck("Mother", 1, rights, pageSource);
        myBasePage.rightsCheck("Togia, Maria", 1, rights, pageSource);
        myBasePage.rightsCheck("Prior Unit", 1, rights, pageSource);
//        myBasePage.rightsCheck("Fagamalo", 4, rights, pageSource);


    }



    @Test(groups = {"all3", "all"})
    public void directoryMemberInfoHousehold() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        if (myBasePage.getOS().contains("ios")) {
            myDirectory.searchAndClickHousehold("Oline, Vili & Faapepele");
            myBasePage.clickByTextContains("Oline");
        } else {
            myDirectory.searchAndClickHousehold("Oline, Vili");
        }

        checkMemberInfoBishop();

    }

    @Test(groups = {"all3", "all"})
    public void directoryMemberInfoIndividual() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        //Search and click on Aaron Jane
        myDirectory.searchAndClick("Oline, Vili");

        checkMemberInfoBishop();
    }


    private void checkMemberInfoBishop() throws Exception {
        String pageSource;

        // ********* Constructor **********
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Get all info
        pageSource = myDirectory.getDirectoryUserData();

        //General Information
        Assert.assertTrue(myBasePage.checkNoCaseList("Oline", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Vili", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Priesthood Office", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("High Priest", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Record Number", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("052-0013-4906", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birth Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("September 17, 1969", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Baptism", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("September 27, 1980", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Confirmation", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("September 27, 1980", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained Elder", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("November 6, 1988", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained High Priest", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("April 20, 2003", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained Bishop", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("April 23, 2017", pageSource, "Contains"));


        Assert.assertTrue(myBasePage.checkNoCaseList("Sealed to Parents", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("September 9, 1983", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Endowment", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("December 11, 2002", pageSource, "Contains"));



        Assert.assertTrue(myBasePage.checkNoCaseList("Spouse", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Mailata, Faapepele", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Spouse Birth Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("February 18, 1973", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Marriage Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("March 3, 1996", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Marriage Place", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Avao, Savaii, Samoa", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sealing Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("December 11, 2002", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Temple", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Apia Samoa Temple", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Gender", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Male", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birthplace", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Avao, Savaii, Samoa", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birth Country", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Western Samoa", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Father", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lealaiauloto, Sao Oline", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Mother", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Solo, Melesa Asovale", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Priests Quorum President", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Class Assignments", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("High Priests Quorum", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Gospel Doctrine", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Elders Quorum", pageSource, "Contains"));

    }






    @Test(groups = {"all3", "all"})
    public void directoryIndividualHousehold() throws Exception {
        String pageSource;
        Dimension thumbNailDim;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        //Should be Household view by default
        Assert.assertFalse(myBasePage.checkForElement(myDirectory.thumbNail));

        myDirectory.directorySort.click();
        myDirectory.sortIndividual.click();
        //myDirectory.searchBar.sendKeys("Aaron");

//        Thread.sleep(3000);
//        System.out.println(myBasePage.getSourceOfPage());
        //The thumbNail is showing up a visible=false
        if (myBasePage.getOS().equals("ios")) {
            thumbNailDim = myDirectory.thumbNail.getSize();
//            System.out.println("Height: " + thumbNailDim.getHeight());
//            System.out.println("Width: " + thumbNailDim.getWidth());
            Assert.assertTrue(thumbNailDim.getHeight() != 0);
        } else {
            Assert.assertTrue(myBasePage.checkForElement(myDirectory.thumbNail));
        }


        myDirectory.directorySort.click();
        myDirectory.sortHousehold.click();
        //myDirectory.searchBar.sendKeys("Aaron");

        Assert.assertFalse(myBasePage.checkForElement(myDirectory.thumbNail));

    }


    @Test(groups = {"all3", "all"})
    public void directoryMemberInfoNonLeaderNoPassword() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools5", "toolstester");
        myHelper.nonLeaderNoPin();

        //Search and click on Aaron Jane
        myDirectory.searchAndClick("Tools, LDS5");

//        System.out.println(myBasePage.getOS());

        if (myBasePage.getOS().equals("ios")) {
            myBasePage.scrollToTextiOS("Membership Information");
            myDirectory.memebershipInformation.click();
        } else {
            myDirectory.tabMembership.click();
        }



    }

    @Test(groups = {"all2", "all"})
    public void directoryLatLongNoGPS() throws Exception {
        String pageSource;
        Dimension thumbNailDim;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        myDirectory.searchAndClick("Tools, LDS29");

        Assert.assertTrue(myBasePage.checkForElement(myDirectory.gpsHouseholdLocationMissing));

        //Get all info
        pageSource = myDirectory.getDirectoryUserData();
        Assert.assertTrue(myBasePage.checkNoCaseList("Household Location Missing", pageSource, "Contains"));

    }

    @Test(groups = {"all3", "all"})
    public void directoryLatLongNoGPSNoCalling() throws Exception {
        String pageSource;
        Dimension thumbNailDim;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools5", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        myDirectory.searchAndClick("Aanamalili, Kimpley");

        //Get all info
        pageSource = myDirectory.getDirectoryUserData();

        if (myBasePage.getOS().contains("ios")) {
            Assert.assertTrue(myBasePage.checkNoCaseList("Household Location Missing", pageSource, "Contains"));
        } else {
            Assert.assertFalse(myBasePage.checkNoCaseList("Household Location Missing", pageSource, "Contains"));
        }

        Assert.assertFalse(myBasePage.checkNoCaseList("Adjust Household Location", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("We're unable to geo-locate your household. Use your GPS to locate it.", pageSource, "Contains"));



    }


    @Test(groups = {"all3", "all"})
    public void directoryLatLongCheckLocation() throws Exception {
        String pageSource;
        Dimension thumbNailDim;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

//        myDirectory.searchAndClick("Pipi, Mafoe");

        if (myBasePage.getOS().contains("ios")) {
            myDirectory.searchAndClickHousehold("Pipi, Mafoe & Lalotoa");
//            myBasePage.clickByTextContains("Pipi");
            myBasePage.scrollDownIOS();
        } else {
            myDirectory.searchAndClickHousehold("Pipi, Mafoe");
        }

        Assert.assertTrue(myBasePage.checkForElement(myDirectory.gpsAdjustHouseholdLocationLowerCase));
//        Assert.assertFalse(myBasePage.checkForElement(myDirectory.gpsHouseholdLocationMissing));


    }


    @Test(dataProvider = "Members", groups = {"all4", "all", "jft"})
    public void directoryLatLongNoGPSChooseLocation(String userName, String passWord, String rightsString, String callingGroup) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        // Reset the Lat Long
        resetLatLong("8999999998895108", "258598");

        //Login and enter in PIN
        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");



        myDirectory.searchAndClick("Tools, LDS24");

        if (rights <= 3) {
            Assert.assertTrue(myBasePage.checkForElement(myDirectory.gpsHouseholdLocationMissing));

            myDirectory.gpsAdjustHouseholdLocation.click();
            myDirectory.gpsAllowOK.click();

            Thread.sleep(2000);

            if (getRunningOS().equals("ios")) {
                myDirectory.gpsAdjustLocationButton.click();
            } else {
                myBasePage.allowButton.click();
            }

            myDirectory.gpsSearch.setValue("3732 Bryce Canyon Dr, Riverton, Utah");

            Thread.sleep(10000);

            myBasePage.clickByText("3732 Bryce Canyon Dr, Riverton, Utah, USA");
            Thread.sleep(5000);



            if (getRunningOS().equals("ios")) {
                myBasePage.iosClickUseThisLocation();
            } else {
                myDirectory.gpsUseThisLocation.click();
            }

            Thread.sleep(2000);

            pageSource = myBasePage.getSourceOfPage();


            Assert.assertTrue(myBasePage.checkNoCaseList("40.5152", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("-111.9800", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Household Location Missing", pageSource, "Contains"));


            //Log out - Log in check the location
            myBasePage.backToDirectory();

            myMenu.menuLogOut();
            myHelper.loginUAT(userName, passWord);
            myHelper.enterPin("1", "1", "3", "3");

            myDirectory.searchAndClick("Tools, LDS24");

            Thread.sleep(2000);

            pageSource = myBasePage.getSourceOfPage();


            Assert.assertTrue(myBasePage.checkNoCaseList("40.5152", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("-111.9800", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Household Location Missing", pageSource, "Contains"));

        } else {

            pageSource = myBasePage.getSourceOfPage();
            if (getRunningOS().equals("ios")) {
                Assert.assertTrue(myBasePage.checkNoCaseList("Household Location Missing", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Adjust Household Location", pageSource, "Contains"));
            } else {
                Assert.assertFalse(myBasePage.checkNoCaseList("Household Location Missing", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Adjust Household Location", pageSource, "Contains"));
            }
        }




    }

    public void resetLatLong(String headOfHouseId, String unitNumber) {
        OkHttpClient client = new OkHttpClient();

        try {
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n  \"householdLocations\": [\n    {\n      \"headOfHouseIndividualId\": " + headOfHouseId +",\n      \"unitNbr\": " + unitNumber +"\n    }\n  ]\n}\n");
            Request request = new Request.Builder()
                    .url("https://ws-int.ldschurch.org/MLU-Services/v1.9/Services/rest/member/householdLocation?headOfHouseMemberId=%22" + headOfHouseId + "%22&latitude=null&longitude=null&locallyVerifiedCode=null&unitNbr=" + unitNumber)
                    .post(body)
                    .addHeader("authorization", "Basic ZGlyZWN0b3J5OnNlZWtBbmRGaW5k")
                    .addHeader("content-type", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "b82ed705-20f4-ef63-9575-b3b091ffc0bb")
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println("Response Code: " + response.code());



        } catch (IOException e) {
            e.printStackTrace();
        }


    }






    @Test(dataProvider = "Members", groups = {"goat"})
    public void directoryScrollTest(String userName, String passWord, String rightsString, String callingGroup) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");

        //myBasePage.scrollDownTEST(100);


        myBasePage.scrollDownAndroidUIAutomator("0");
        Thread.sleep(10000);
        myBasePage.scrollUpAndroidUIAutomator("0");


    }

}
