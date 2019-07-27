package com.wrike.pages;

import com.wrike.FirstTest;
import com.wrike.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class VerifyPage extends Page {
    private static final String OTHER_INPUT_TEXT = "Other";

    private final Random random = new Random();

    @FindBy(xpath = "//*[contains(@name,'survey-form')]//*[@class='radio' or @class='survey-question']")
    private List<WebElement> questions;

    @FindBy(xpath = "//button[contains(@class, 'survey')]")
    private WebElement bSubmit;

    @FindBy(xpath = "//*[contains(@class, 'survey-success') or contains(@class, 'cell--success')]")
    private WebElement successCell;

    public VerifyPage chooseRandomAnswers() {
        for (WebElement question : questions) {
            List<WebElement> answers = question.findElements(By.xpath(".//*[contains(@class, 'button')]"));
            WebElement answer = answers.get(random.nextInt(answers.size()));
            waitClickable(answer);
            answer.click();
            String parentAnswerClass = answer.findElement(By.xpath("..")).getAttribute("class");
            if (parentAnswerClass.contains("radio--with-input") || parentAnswerClass.contains("switch--text")) {
                answer
                        .findElement(By.xpath(".//input[contains(@class, 'input')]"))
                        .sendKeys(Util.generateRandomString());
            }
        }
        return this;
    }

    public VerifyPage submitAnswers() {
        waitClickable(bSubmit);
        bSubmit.click();
        return this;
    }

    public VerifyPage checkSuccess() {
        waitClickable(successCell);
        return this;
    }

    public VerifyPage checkTwitter() {
        implCheckTwitter();
        return this;
    }

    public VerifyPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
}
