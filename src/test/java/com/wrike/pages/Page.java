package com.wrike.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "//*[contains(@class, 'wg-footer__group--social')]")
    WebElement footer;

    public Page(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    protected void waitClickable(WebElement... webElements) {
        for (WebElement webElement : webElements) {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        }
    }

    public void implCheckTwitter() {
        WebElement aTwitter = footer.findElement(By.xpath(".//a[@href='https://twitter.com/wrike']"));
        aTwitter.findElement(By.xpath(".//*[contains(@*[name()='xlink:href'],'#twitter')]"));
    }
}
