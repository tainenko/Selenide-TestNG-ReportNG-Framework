package com.selenium.test.testng.tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
/**
 * setBrowser:
 * 提供MultiBrowser的前置作業，配合testNG.xml與Parameters注入所需要測試的Browser
 * 同時設定Browser的基礎頁面與Headless模式。
 * BeforeTest Annotation只會在每個Test前執行一次，之後可以擴充所需要的presetting。
 */
public class SetBrowser {
    @Parameters("browser")
    @BeforeTest
    public void setupBrowser(String browser){
        Configuration.browser=browser;
        Configuration.baseUrl="https://www.etmall.com.tw/";
        Configuration.headless=true;
    }
}
