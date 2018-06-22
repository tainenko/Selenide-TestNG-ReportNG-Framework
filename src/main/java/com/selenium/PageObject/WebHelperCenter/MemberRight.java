package com.selenium.PageObject.WebHelperCenter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;
public class MemberRight {
    public String memberright="/MemberRight";
    //請告訴我們您的問題
    private SelenideElement contact=$("a.n-blue--link[href='/HelpCenter/Contact']");
    //會員權益
    private SelenideElement memberrightTitle=$("h2.n-title--18.n-mem--title");
    public void checkPageTitle(){
        memberrightTitle.shouldHave(Condition.text("會員權益"));
    }

}
