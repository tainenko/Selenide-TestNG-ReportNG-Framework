package com.selenium.test.testng.tests;
//Selenide & TestNG
import static com.codeborne.selenide.Selenide.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//CSV Dataprovider
import com.selenium.CommonLib.CSVData;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
//Page Object
import com.selenium.PageObject.HomePage;
import com.selenium.PageObject.LoginPage;


public class LoginTest {
    @Test(dataProvider = "account")
    public void loginTest(Map<String,String> data) throws Exception{
        String username=data.get("account");
        String passwd=data.get("passwd");

        HomePage homepage = open("", HomePage.class);
        LoginPage loginpage=homepage.click_loginbutton();
        loginpage.loginAction(username,passwd,loginpage.getVerifyCode());
        homepage.loginSuccess();
        homepage.click_LogoutButton();
    }
    @DataProvider(name = "account")
    public Iterator<Object[]> Numbers() throws IOException {
        return (Iterator<Object[]>) new CSVData("LoginAccount.csv");
    }

}
