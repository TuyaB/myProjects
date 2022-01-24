package com.cybertek.pages;

import com.cybertek.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LibrarianDashBoardPage extends BasePage {


    @FindBy(xpath = "//a[@href='#users']")
    public WebElement users;

    @FindBy(xpath = "//a[@href='#books']")
    public WebElement books;




}
