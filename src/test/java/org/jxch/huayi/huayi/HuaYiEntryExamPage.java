package org.jxch.huayi.huayi;


import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class HuaYiEntryExamPage {
    public static final String LOGIN_PAGE_URL = "https://cme23.91huayi.com/cme/index.html";
    private static final String USERNAME = "mawenjing0615";
    private static final String PASSWD = "19940615a";

    @FindBy(xpath = "//a[@class='login_btn']")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[@id='loginAccessName']")
    public WebElement userName;

    @FindBy(xpath = "//*[@id='loginAccessPwd']")
    public WebElement password;

    @FindBy(xpath = "//*[@id='agree']")
    public WebElement agree;

    @FindBy(xpath = "//img[@src='/images/sd_public.png']")
    public WebElement examImg;

    @FindBy(xpath = "//input[@value='进入考试']")
    public WebElement examButton;

    @FindBy(xpath = "//a[contains(@href, 'peid')]")
    public WebElement continueTheExam;

    @FindBy(xpath = "/html/body/form/div[4]/div/div[1]/div[2]/p/span")
    public WebElement entryExamSuccess;

    public final void initElements() {
        PageFactory.initElements(WebDriverRunner.getWebDriver(), this);
    }

    public void openLoginPage() {
        open(HuaYiEntryExamPage.LOGIN_PAGE_URL);
    }

    public boolean isNotLoggedIn() {
        return loginBtn.isDisplayed();
    }

    public boolean isEntryExamNotSuccess() {
        return !entryExamSuccess.isDisplayed();
    }

    public void login() {
        userName.sendKeys(USERNAME);
        password.sendKeys(PASSWD);
        agree.click();

        while (isNotLoggedIn()) {
            TimeUtil.sleep(TimeUnit.SECONDS, 1);
        }
    }

    public void switchToNewWindow() {
        String newHandle = new LinkedList<>(WebDriverRunner.getWebDriver().getWindowHandles()).peekLast();
        WebDriverRunner.getWebDriver().switchTo().window(newHandle);
    }

    public void entryExam() {
        examImg.click();
        switchToNewWindow();
        examButton.click();
        continueTheExam.click();
        while (isEntryExamNotSuccess()) {
            TimeUtil.sleep(TimeUnit.SECONDS, 1);
        }
    }


}
