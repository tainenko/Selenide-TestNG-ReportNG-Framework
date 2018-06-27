package com.selenium.PageObject;
import java.net.*;
import java.io.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static com.codeborne.selenide.Selenide.*;

public class WebRegisterPage {
    private SelenideElement registerColumn=$("div.n-l-bgw-lg");
    //會員同意
    private ElementsCollection registeragree=$$(".n-l-bgw-lg.n-reg__terms");
    //Email
    private SelenideElement inputemail=$("input#signupUserMail.n-form--control");
    //Password
    private SelenideElement inputpasswd=$("input#passwordValue.n-form--control");
    //confirmPassward
    private SelenideElement confirmpasswd=$("#input#confirmPasswordValue.n-form--control");
    //國碼選擇
    private SelenideElement countrycode=$("select.#countryCode.n-form--control");
    //手機號碼
    private SelenideElement inputmobile=$("input#mobilePhone.n-form--control");
    //手機驗證碼
    private SelenideElement phonevalidcode=$("input#phoneVaalidateValue.n-form--control");
    //取得手機驗證碼
    private SelenideElement phonevalidcodeBtn=$("button.n-btn[name='phoneVerificationCodeBtn']");
    //確定註冊
    private SelenideElement submitBtn=$("button.n-btn[name='submitBtn']");
    //臉書登入
    private SelenideElement facebookBtn=$("button#Facebook.n-btn");
    //已有帳號
    private SelenideElement loginBtn=$("a.n-btn[href='/Login']");
    //服務協議
    private SelenideElement memberright=$("a.n-blue--link[href='/HelpCenter/MenberRight']");
    //隱私聲明
    private SelenideElement privacystatement=$("a.n-blue--link[href='/HelpCenter/PrivacyStatement']");
    //我願意接收最新優惠通知
    private SelenideElement marketInfocheck=$("input#marketInfo");
    //我同意得易Ponta聯名
    private SelenideElement pontaInfocheck=$("input#pontaInfo");
    //行銷資訊發送聲明文案
    private SelenideElement marketInfo=$("a.n-blue--link[href='/HelpCenter/MarketInfo']");
    //個資宣告條款
    private SelenideElement pontapersonalIntfo=$("a.n-blue--link[href='/HelpCenter/']");
    //聯名卡會員服務使用辦法
    private SelenideElement pontaservice=$("a.n-blue--link[href='/HelpCenter/PontapersonalInfo']");
    //聲明文案
    private SelenideElement layout=$("div.n-layout--md>div.n-left>p");
    //goTop
    private SelenideElement goTop=$("a#footGoTop");
    //安全機制
    private SelenideElement standardsecurity=$("a[href='/HelpCenter/StandardSecurity']");
    //服務專線
    private SelenideElement servicephone=$("a[title='24H 免費服務專線：0800-057-999']");
    //會員登入/註冊流程說明
    private SelenideElement fnq=$("a.n-signup[href='/HelpCenter/fnq']");
    //資訊安全系統認證
    private SelenideElement BSI=$("a.n-footer--bsi[href='/HelpCenter/BSI']");
    //PCI-DSS 3.1支付卡產業資料安全標準認證
    private SelenideElement PCIDSS=$("a.n-footer--pci[href='HelpCenter/PCIDSS']");

    public void checkServicePhone(){
        //servicephone.shouldHave("[href='tel:0800-057-999']");
    }
    public void checkCountryCode(){
        countrycode.getSelectedOption().shouldBe(Condition.text("台灣 +886"));
    }

    public HomePage registerProcess(String email, String passwd, String phone) throws Exception{
        String verifyCode="";
        inputemail.setValue(email);
        inputpasswd.setValue(passwd);
        confirmpasswd.setValue(passwd);
        inputmobile.setValue(phone);
        phonevalidcodeBtn.click();
        verifyCode=getVerifyPhoneCode(phone);
        phonevalidcode.setValue(verifyCode);
        submitBtn.click();
        return page(HomePage.class);
    }
    public String getVerifyPhoneCode(String phone) throws Exception {
        String verifyURL="http://172.21.17.24/verify?Mobile="+phone;
        String verifySN = "";
        // Connect to the URL using java's native library
        URL url = new URL(verifyURL);
        URLConnection request = url.openConnection();
        request.connect();
        // Convert to a JSON object to print data
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        JsonObject jsonobj=rootobj.getAsJsonArray("recordset").get(0).getAsJsonObject();
        verifySN=jsonobj.get("VerifySN").getAsString();
        return verifySN;

    }
}
