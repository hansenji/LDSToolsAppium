package LDSToolsAppium;

import LDSToolsAppium.Screen.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LDSToolsApp {
    private final AppiumDriver<MobileElement> driver;

    public LDSToolsApp(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    //Login Page
    public LoginPageScreen loginPage() {
        return new LoginPageScreen(driver);
    }

    //Setings Screen
    public SettingsScreen settingsScreen() {
        return new SettingsScreen(driver);
    }

    //Menu Screen
    public MenuScreen menuScreen() {
        return new MenuScreen(driver);
    }

    //PIN Screen
    public PinScreen pinScreen() {
        return new PinScreen(driver);
    }

    //Directory Screen
    public DirectoryScreen directoryScreen() {
        return new DirectoryScreen(driver);
    }

    //Directory Edit Screen
    public DirectoryEditScreen directoryEditScreen() {
        return new DirectoryEditScreen(driver);
    }

    //Organizations Screen
    public OrganizationsScreen organizationsScreen() {
        return new OrganizationsScreen(driver);
    }

    //Calendars Screen
    public CalendarsScreen calendarsScreen() {
        return new CalendarsScreen(driver);
    }

    //Whats New Screen
    public WhatsNewScreen whatsNewScreen() {
        return new WhatsNewScreen(driver);
    }

    //Reports Screen
    public ReportsScreen reportsScreen() { return new ReportsScreen(driver);
    }

    //Ministering Screen
    public MinisteringScreen ministeringScreen() { return new MinisteringScreen(driver);
    }

    //Temples Screen
    public TemplesScreen templesScreen() { return new TemplesScreen(driver);
    }

    //Missionary Screen
    public MissionaryScreen missionaryScreenScreen() { return new MissionaryScreen(driver);
    }



    //Scanner Screen
    public ScannerScreen scannerScreen() { return new ScannerScreen(driver);
    }

}