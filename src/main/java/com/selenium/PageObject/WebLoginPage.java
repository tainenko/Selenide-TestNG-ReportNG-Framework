package com.selenium.PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.screenshot;

import com.selenium.CommonLib.CopyOfCleanLines;
import org.openqa.selenium.Point;

//驗証碼辨識api
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.ImageHelper;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import org.apache.commons.io.FileUtils;

import static com.codeborne.selenide.Selenide.*;

public class WebLoginPage {
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
    public void sendkeys_LoginID(String str){loginID.setValue(str);}
    public void sendkeys_Password(String str){
        password.setValue(str);
    }
    public void sendkeys_VerifySN(String str){
        verifySN.setValue(str);
    }
    public void click_LoginBtn() {
        loginBtn.click();
    }

    public HomePage loginAction(String username,String passwd,String verifyCode){
        sendkeys_LoginID(username);
        sendkeys_Password(passwd);
        sendkeys_VerifySN(verifyCode);
        click_LoginBtn();
        return page(HomePage.class);

    }

    //assert
    public void element_exist() throws Exception{
        loginID.isDisplayed();
        password.isDisplayed();
        loginBtn.isDisplayed();
    }
    public String getVerifyCode() throws Exception{
        String str = null;
        String result="";
        String destFile="tessdata/verifyCode.png";
        //對登入頁截圖，並裁切出驗証碼的部份。
        screenshot("verifyImage");
        File image = new File("build/reports/tests/verifyImage.png");
        BufferedImage fullImg = ImageIO.read(image);
        Point point = varifyCodeImg.getLocation();
        int width = varifyCodeImg.getSize().getWidth();
        int height = varifyCodeImg.getSize().getHeight();
        BufferedImage textImage = fullImg.getSubimage(point.getX(),point.getY(),width,height);
        // 圖片放大4倍、除噪、去除干擾線
        textImage = ImageHelper.getScaledInstance(textImage, textImage.getWidth() * 2, textImage.getHeight() * 2);
        CopyOfCleanLines.cleanLinesInImage(textImage,destFile);
        Tesseract instance = new Tesseract();
        //英文字庫，限制辨識結果為數字
        instance.setLanguage("eng");
        instance.setTessVariable("tessedit_char_whitelist", "1234567890");
        str = instance.doOCR(new File(destFile));

        //濾掉辨識結果的空格與其他字元
        if(str !=null && !"".equals(str)){
            for (int i=0;i<str.length();i++){
                if(str.charAt(i)>=48 && str.charAt(i)<=57)
                    result+=str.charAt(i);
            }
        }
        return result;
    }
    public void loginFail(){
        errors.shouldHave(Condition.text("帳號或密碼錯誤，請重試一次"));
    }
}

