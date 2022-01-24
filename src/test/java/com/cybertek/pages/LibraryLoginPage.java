package com.cybertek.pages;

import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class LibraryLoginPage extends BasePage {


    @FindBy(id = "inputEmail")
    public WebElement email;

    @FindBy(id = "inputPassword")
    public WebElement password;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInBtn;


    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement errorMsg;

    public void login(String user) {
        if (user.equals("librarian17")) {
            email.sendKeys(ConfigurationReader.getProperty("librarian17"));
            password.sendKeys(ConfigurationReader.getProperty("password"));
            signInBtn.click();
        } else if (user.equals("librarian49")) {
            email.sendKeys(ConfigurationReader.getProperty("librarian49"));
            password.sendKeys(ConfigurationReader.getProperty("password"));
            signInBtn.click();
        } else if (user.equals("student50")) {
            email.sendKeys(ConfigurationReader.getProperty("student50"));
            password.sendKeys(ConfigurationReader.getProperty("password"));
            signInBtn.click();
        } else if( user.equals("student51")){
            email.sendKeys(ConfigurationReader.getProperty("student51"));
            password.sendKeys(ConfigurationReader.getProperty("password"));
            signInBtn.click();
        } else if( user.equals("student52")){
            email.sendKeys(ConfigurationReader.getProperty("student52"));
            password.sendKeys(ConfigurationReader.getProperty("password"));
            signInBtn.click();
        }


    }


}

