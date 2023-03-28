package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * parent class for concrete Page object classes
 * provides constructor with initElements method for re-usability
 * abstract - to prevent instantiation.
 */
public abstract  class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(tagName = "h3")
    public WebElement pageHeader;

    @FindBy(css = "#navbarDropdown>span")
    public WebElement accountHolderName;

    @FindBy(linkText = "Log Out")
    public WebElement logOutLink;

    @FindBy(xpath = "//i[@class='fa fa-book']")
    public WebElement booksPageLink;

    @FindBy(xpath = "//i[@class='fa fa-user']")
    public WebElement userPageLink;

    @FindBy(xpath = "//i[@class='fa fa-home']")
    public WebElement dashboardPageLink;

    public void booksPage(String page){

        booksPageLink.click();

    }

    public void userPage(String page){

        userPageLink.click();

    }

    public void dashboardPage(String page){

        dashboardPageLink.click();

    }

    public void logOut(){
        accountHolderName.click();
        logOutLink.click();
    }

    //i[@class='fa fa-book']

    public void navigateModule(String moduleName){
        Driver.getDriver().findElement(By.xpath("//span[@class='title'][.='"+moduleName+"']")).click();
    }
}
