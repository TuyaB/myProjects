package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public LibraryLoginPage faker;
    protected WebDriver driver;

public BasePage(){
    driver = Driver.getDriver();
    PageFactory.initElements(driver, this);
}



}
