package org.jxch.huayi.huayi;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HuaYiEntryExamPageTest {
    private static final HuaYiEntryExamPage HUAYI_LOGIN_PAGE = new HuaYiEntryExamPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        HUAYI_LOGIN_PAGE.openLoginPage();
        HUAYI_LOGIN_PAGE.initElements();
    }

    @Test
    public void entryExam() {
        if (HUAYI_LOGIN_PAGE.isNotLoggedIn()) {
            HUAYI_LOGIN_PAGE.login();
        }
        HUAYI_LOGIN_PAGE.entryExam();
    }


}
