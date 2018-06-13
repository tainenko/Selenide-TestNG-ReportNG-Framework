package com.selenium.PageObject;
import java.util.ArrayList;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    public SelenideElement loginbutton=    $("a.sendGA[href='/Login?url=%2F']");

    //h2Title 全站商品分類
    private SelenideElement h2Title=$("div.n-title--16");

    //商品分類
    private ElementsCollection mainNavList=$$("#mainNav>li");

    //FiveBanner
    private SelenideElement FiveBanner=$("div#FiveBanner");

    //FiveBanner Nav
    private SelenideElement FiveBannerbnNav=$("ul#bnNav");


    private SelenideElement superBanner=$("div#mainBanner.n-banner");

    //
    private SelenideElement memberInfoModule=$("div.n-mem-info__wrap");

//	@FindBy(css = ".n-left.n-daily__wrap.n-daily__clock + .n-left.n-daily__wrap.n-daily__day")
//	public SelenideElement dailySale;

    //整點和天天
    private SelenideElement dailyDayClockSale=$("div.n-left.n-hover--img.n-m-right--md");

    //影音專區
    private SelenideElement liveProduct=$("section.n-film__wrap");

    //影音頻道tab
    public ElementsCollection channelTab=$$("#filmTab>li");

    //找不到
    private ElementsCollection rankTabList=$$("#rankTab li");

    //找不到
    private ElementsCollection rankProductList=$$("#rank1 li a");

    //熱銷排行榜
    private SelenideElement ranAll=$("div#HomeChannelPush");


    //找不到
    private SelenideElement channelBanner=$(".n-l-colmb30.n-bannerad__wrap .n-left.n-layout--half");

    //找不到
    private SelenideElement eventBanner=$(".n-l-colmb30.n-bannerad__wrap .n-right.n-layout--half");

    //頻道推薦
    private SelenideElement storeSection=$("#HomeStoreChannel");

    //16館商品
    private ElementsCollection storeSectionList=$$("#HomeStoreChannel>div>section");

    // 16館商品列表，總共76個商品
    private ElementsCollection storeProductList=$$(".n-category__list.n-left>li");

    //銀行活動
    private SelenideElement bankBanner=$("section#_indexBank.n-m-bottom--sm");

    //你可能會喜歡All
    private SelenideElement recommendProducts=$("#RecommendProducts");

    //你可能會喜歡-商品列表
    private ElementsCollection recommendProductsList=$$(".n-ulike__list.n-hover--img>li");


    //更多精選商品
    private SelenideElement bestProducts=$("div#homeHotPdList");

    //找不到
    private ElementsCollection crazyBannerList=$$("#crazyADBanner");

    //找不到
    private SelenideElement crazyBannerCloseBtn=$("#cBtnClose");


    public LoginPage click_loginbutton(){
        loginbutton.click();
        return page(LoginPage.class);
    }
    public void checkStoreProductlist(int num){
        storeProductList.shouldHaveSize(num);
    }
}
