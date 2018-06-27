package com.selenium.test.testng.tests;
//Selenide & TestNG
import static com.codeborne.selenide.Selenide.*;
import org.testng.annotations.Test;
//Page Object
import com.selenium.PageObject.HomePage;
import com.selenium.PageObject.WebRegisterPage;

public class WebRegisterProcessTest {
    @Test
    public void RegisterProcessTest() throws Exception{
        String username="";
        String passwd="";
        String phone="0988888885";

        HomePage homepage = open("", HomePage.class);
        WebRegisterPage registerpage=homepage.click_RegisterBtn();
        homepage=registerpage.registerProcess(username,passwd,phone);
        homepage.loginSuccess();
        homepage.logOut();
    }
}
