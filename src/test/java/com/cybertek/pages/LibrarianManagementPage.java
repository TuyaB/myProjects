package com.cybertek.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LibrarianManagementPage extends BasePage{
    @FindBy(xpath = "//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")
    public WebElement addUserBtn;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitBtn;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement userAddedAlert;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement librarianAddedBookAlert;




}
