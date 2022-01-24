package com.cybertek.tests;

import com.cybertek.TestBase;
import com.cybertek.pages.LibrarianDashBoardPage;
import com.cybertek.pages.LibrarianManagementPage;
import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LibraryTest extends TestBase {
    LibraryLoginPage loginPage = new LibraryLoginPage();
    LibrarianDashBoardPage dashBoardPage = new LibrarianDashBoardPage();
    LibrarianManagementPage managementPage = new LibrarianManagementPage();

    @Test
    public void loginAsLibrarianPositive() { //US - 1 , AC#1
        assertEquals(driver.getTitle(), "Login - Library");
        System.out.println("Title= " + driver.getTitle());

        loginPage.login("librarian49");
        BrowserUtils.sleep(3);

        List<WebElement> threeModels = driver.findElements(By.xpath("//div[@class='col p-r-0 align-self-center']"));
        Assert.assertEquals(threeModels.size(), 3);
    }

    @Test
    public void asStudentPositiveTest() { //US-1, AC2

        loginPage.login("student50");

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://library2.cybertekschool.com/login.html");

        BrowserUtils.sleep(2);
        List<WebElement> modules = driver.findElements(By.xpath("//a[@class='nav-link']"));
        BrowserUtils.sleep(2);

        Assert.assertEquals(modules.size(), 2);
    }

    @Test
    public void negativeTest() { //US-1, AC#3

        loginPage.email.sendKeys(faker.internet().emailAddress());
        loginPage.password.sendKeys(faker.internet().password());
        loginPage.signInBtn.click();

        BrowserUtils.sleep(3);
        assertTrue(loginPage.errorMsg.isDisplayed());
    }

    @Test
    public void asLibrarianAddNewUser() { //US-2, AC#1

        loginPage.login("librarian17");

        BrowserUtils.sleep(2);
        dashBoardPage.users.click();

        BrowserUtils.sleep(2);
        managementPage.addUserBtn.click();

        BrowserUtils.sleep(1);
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys(faker.name().fullName());

        BrowserUtils.sleep(1);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(faker.internet().password());

        BrowserUtils.sleep(1);
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(faker.internet().emailAddress());

        BrowserUtils.sleep(1);
        WebElement address = driver.findElement(By.name("address"));
        address.sendKeys(faker.address().fullAddress());

        BrowserUtils.sleep(1);
        managementPage.submitBtn.click();

        BrowserUtils.sleep(2);
        Assert.assertTrue(managementPage.userAddedAlert.isDisplayed());


    }

    @Test
    public void asLibrarianAddNewBook() {

        loginPage.login("librarian17");

        BrowserUtils.sleep(2);
        WebElement books = driver.findElement(By.xpath("//a[@href='#books']"));
        books.click();

        BrowserUtils.sleep(2);
        WebElement addBooksBtn = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sm add_book_btn']"));
        addBooksBtn.click();

        BrowserUtils.sleep(1);
        WebElement bookName = driver.findElement(By.xpath("//input[@placeholder='Book Name']"));
        bookName.sendKeys(faker.book().title());

        BrowserUtils.sleep(1);
        WebElement isbn = driver.findElement(By.name("isbn"));
        isbn.sendKeys(faker.number().digit());

        BrowserUtils.sleep(1);
        WebElement year = driver.findElement(By.name("year"));

        String yearStr = String.valueOf(faker.date().birthday().getYear());
        year.sendKeys(yearStr);

        WebElement author = driver.findElement(By.xpath("//input[@name='author']"));
        author.sendKeys(faker.name().fullName());

        WebElement description = driver.findElement(By.id("description"));
        description.sendKeys("The most popular book");
        BrowserUtils.sleep(2);

        WebElement saveChangesBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        saveChangesBtn.click();

        BrowserUtils.sleep(2);
        Assert.assertTrue(managementPage.librarianAddedBookAlert.isDisplayed());

    }
}