package com.selenium.test.testng.tests;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.selenium.PageObject.HomePage;

public class HomePageTest {
    @Parameters("browser")
    @BeforeTest
    public void setupBrowser(String browser){
        Configuration.browser=browser;
        Configuration.baseUrl="https://etmall.lab.etzone.net/";
        Configuration.headless=true;
    }

    @Test
    public void TestHomePage() throws InterruptedException{


        HomePage homepage=open("", HomePage.class);
        homepage.checkStoreProductlist(76);

        open("測試專用-廠送-一維規格/i/1172424");
        $("input#txtSearchKeyword").setValue("Selenide");
        $("button.n-btn.n-btn--search24");
        sleep(5000);
        System.out.println($("#customerContainer"));
    }
}
