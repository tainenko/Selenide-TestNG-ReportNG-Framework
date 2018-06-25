package com.selenium.PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.*;

public class WebProductPage {
    //麵包屑
    private SelenideElement mainBreadcrumb=$(".n-breadcrumb__wrap");
    // 麵包屑 list 0.館 1.大分類 2.中分類 3.小分類
    private ElementsCollection breadcrumList ＝$$("ul.n-left li.n-breadcrumb__drop > a");
    //商品圖
    private SelenideElement productImg = $("img.product-image");
    //商品圖slide
    private ElementsCollection productImgList=$$("商品圖slide");
    //現行圖片
    private SelenideElement currentImg=$("#prodPagerUl li.current");
    //品號
    private SelenideElement productGoodId=$("div.n-left.n-prod__info");
    // FB Email Skype
    private ElementsCollection socialList=$$(".n-left.n-prod__social li");
    //商品標題
    private SelenideElement productTitle=$(".n-left.n-prod__right .n-title--18");
    //商品副標
    private SelenideElement productSubTitle=$(".n-left.n-prod__right .n-prod__name .n-left");
    //商品短敘述
    private SelenideElement proShortDesc=$("#ProductShortDesc");
    //市價
    private SelenideElement oricPrice=$("#ProductShortDesc + div .n-price__block .n-left");
    //加入收藏
    private SelenideElement addIntoWishList=$("#ProductShortDesc + div .n-price__block .n-right a");
    //優惠價
    private SelenideElement price=$("#ProductShortDesc + div .n-price__block .n-price__bottom");
    //配送方式
    private SelenideElement shipMethodtTextList=$(".n-choose__radio>ul");
    //配送方式
    private ElementsCollection shipMethodList =$(".n-form--radio label");
    //一般宅配
    private ElementsCollection commonDeliver=$$("input#delivery_1");
    // 快倉超取
    private ElementsCollection DeliverHousCon=$$("input#d_4");
    //快配超取
    private ElementsCollection Deliver24=$$("input#d_3");
    //超取
    private ElementsCollection DeliverCon=$$("input#d_17");
    //規格、樣式、數量
    private SelenideElement colorTypeQty=$("#ProductShortDesc + div > div > ul.n-choose__spec"));
    //數量 Selector
    private ElementsCollection qtySelector=$$("select#quantitySelector");
    //樣式
    private ElementsCollection typeSelector=$$("select#subStyleSeletor.n-form--control");
    //規格
    private ElementsCollection styleSelector=$$("select#styleSelector.n-form--control");
    //立即結帳
    private ElementsCollection buyItNow=$$("button#goToCheckout");
    //加入購物車
    private ElementsCollection addToCart=$$("#goToCheckout + a");
    //付款方式
    private SelenideElement paymentType=$("li#ProductDetailPaymentType");
    //賣貴通報
    private SelenideElement priceReport=$("a[title='賣貴通報']");
    //贈品
    private SelenideElement gifts=$(".n-gifts__wrap.note--box-lv2");
    //尚未開賣
    private ElementsCollection unlisted=$$("button.n-btn.n-btn--disabled");

}
