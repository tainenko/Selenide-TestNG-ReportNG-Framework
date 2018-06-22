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
import com.selenium.PageObject.WebRegisterPage;
public class WebRegisterProcessTest {
    @Test(dataProvider = "register")
    public void loginTest(Map<String,String> data) throws Exception{
        String username=data.get("account");
        String passwd=data.get("passwd");

        HomePage homepage = open("", HomePage.class);
        WebRegisterPage registerpage=homepage.click_RegisterBtn();
        homepage=registerpage.registerProcess(username,passwd);

        homepage.loginSuccess();
        homepage.logOut();
    }
    @DataProvider(name = "register")
    public Iterator<Object[]> Numbers() throws IOException {
        return (Iterator<Object[]>) new CSVData("RegisterAccount.csv");
    }

}
