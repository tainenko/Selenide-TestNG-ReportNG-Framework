package com.selenium.PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    //SelenideElement
    //手機Email身分證字號
    private SelenideElement loginID=$("input#loginID.n-form--control");
    //密碼
    private SelenideElement password=$("input#password.n-form--control");
    //登入Btn
    private SelenideElement loginBtn=$("button#login.n-btn.sendGA");
    //驗證碼
    private SelenideElement verifySN=$("input#validCode.n-form--control");

    //Title:會員登入
    private SelenideElement loginTitle=$("div.n-title--18.n-m-bottom--xs.n-text--center");
    //手機Email身分字號三擇一
    private SelenideElement loginDescription=$("label.n-form--title");

    //請輸入手機Email身分證字號
    private SelenideElement loginIDLabel=$("span#loginID-error");
    //請輸入密碼
    private SelenideElement passwordLabel=$("span#password-error");
    //忘記帳號密碼
    private SelenideElement forgotIDPW=$("a#forgot.n-blue--link.sendGA");
    //免費註冊
    private SelenideElement registerBtn=$("a#register.n-normal--link.sendGA");
    //大陸會員登入
    private SelenideElement chinaLoginBtn=$(("a#ChLogin.n-normal--link.sendGA"));
    //電視會員登入
    private SelenideElement tvMemberBtn=$("a.n-btn.n-btn--lv2[href='/Register/Cross?url=%2F']");
    //FB登入btn
    private SelenideElement logionFBbtn=$("button#Facebook");
    // 驗證碼圖片
    private SelenideElement varifyCodeImg=$("#CheckPWDIMG");
    // 驗證碼錯誤訊息
    private SelenideElement validationErr=$("span#validCode-error");
    private SelenideElement errors=$("div.validation-summary-errors>ul>li");

    //Action
    public void sendkeys_loginID(String str){loginID.sendKeys(str);}
    public void sendkeys_password(String str){
        password.sendKeys(str);
    }
    public void sendkeys_verifySN(String str){
        verifySN.sendKeys(str);
    }
    public void click_loginBtn() {
        loginBtn.click();
    }

    public void loginaction(){
        sendkeys_loginID("eitctest060");
        sendkeys_password("abc12345");
        sendkeys_verifySN("123456");
        click_loginBtn();

    }

    //assert
    public void element_exist() throws Exception{
        loginID.isDisplayed();
        password.isDisplayed();
        loginBtn.isDisplayed();
    }
    public void loginFail(){
        errors.shouldHave(Condition.text("帳號或密碼錯誤，請重試一次"));

    }
}

