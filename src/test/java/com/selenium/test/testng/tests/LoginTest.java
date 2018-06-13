package com.selenium.test.testng.tests;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import com.selenium.PageObject.HomePage;
import com.selenium.PageObject.LoginPage;



public class LoginTest {
    @Test
    public void loginTest() throws InterruptedException{
        HomePage homepage = open("", HomePage.class);
        LoginPage loginpage=homepage.click_loginbutton();
        sleep(5000);
        loginpage.loginaction();
    }

}
