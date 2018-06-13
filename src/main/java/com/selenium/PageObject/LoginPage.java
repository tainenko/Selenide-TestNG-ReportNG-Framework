package com.selenium.PageObject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    //SelenideElement
    private SelenideElement account=$("input#loginID.n-form--control");

    private SelenideElement password=$("input#password.n-form--control");

    private SelenideElement loginbutton=$("button#login.n-btn.sendGA");

    private SelenideElement verifySN=$("input#validCode.n-form--control");

    private SelenideElement error=$("input#validDode.n-form--control");

    //Action
    public void sendkeys_account(String str){
        account.sendKeys(str);
    }
    public void sendkeys_password(String str){
        password.sendKeys(str);
    }
    public void sendkeys_verifySN(String str){
        verifySN.sendKeys(str);
    }
    public void click_loginbutton() {
        loginbutton.click();
    }

    public void loginaction(){
        sendkeys_account("eitctest060");
        sendkeys_password("abc12345");
        sendkeys_verifySN("123456");
        click_loginbutton();

    }

    //assert
    public void element_exist() throws Exception{
        account.isDisplayed();
        password.isDisplayed();
        loginbutton.isDisplayed();
        error.isDisplayed();
    }
}

