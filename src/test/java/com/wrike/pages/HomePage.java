package com.wrike.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Page {
    @FindBy(xpath = "//*[contains(@class,'wg-header__desktop')]//button[contains(@class, 'free-trial-button')]")
    private WebElement bFreeTrial;

    @FindBy(xpath = "//*[contains(@class,'modal-form-trial__input')]")
    private WebElement fMail;

    @FindBy(xpath = "//*[contains(@class,'modal-form-trial__submit')]")
    private WebElement bCreateAccount;

    public HomePage openFreeTrial() {
        waitClickable(bFreeTrial);
        bFreeTrial.click();
        return this;
    }

    public VerifyPage createWrikeAccount(String mail) {
        waitClickable(fMail, bCreateAccount);
        fMail.sendKeys(mail);
        bCreateAccount.click();
        return new VerifyPage(driver, wait);
    }

    public HomePage checkTwitter() {
        implCheckTwitter();
        return this;
    }

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
}
