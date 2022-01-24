package com.cybertek;

import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
    protected WebDriver driver;
    protected Faker faker = new Faker();
    protected Actions actions;
     //protected WebDriverWait wait = new WebDriverWait(driver, 2);

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("library.url"));

       // actions= new Actions(driver);

   }
    @AfterMethod
    public void tearDown(){
        //Driver.closeDriver();
    }
}
