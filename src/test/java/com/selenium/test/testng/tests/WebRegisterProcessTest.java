package com.selenium.test.testng.tests;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
//Selenide & TestNG
import static com.codeborne.selenide.Selenide.*;

import com.google.gson.JsonObject;
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
import org.testng.collections.MultiMap;

public class WebRegisterProcessTest {
    @Test
    public void RegisterProcessTest() throws Exception{
        String username="";
        String passwd="";
        String phone="0988888885";
        String verifyCode="http://172.21.17.24/verify?Mobile=";
        String res="";
        URL url= new URL(verifyCode+phone);
        res=getVerifyPhoneCode(phone);

        //HomePage homepage = open("", HomePage.class);
        //WebRegisterPage registerpage=homepage.click_RegisterBtn();
        //homepage=registerpage.registerProcess(username,passwd,phone);

        //homepage.loginSuccess();
        //homepage.logOut();
    }

    /**
     public String getVerifyPhoneCode(String phone){
        String urlString = "";
        try
        {
            URL url = new URL("http://172.21.17.24/verify?Mobile="+phone);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if(urlConnection instanceof HttpURLConnection)
            {
                connection = (HttpURLConnection) urlConnection;
            }
            else
            {
                System.out.println("请输入 URL 地址");
                return "";
            }
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            MultiMap multiMap = new MultiMap();
            UrlEncoded.decodeTo(url.substring(url.indexOf("?") + 1), multiMap, "UTF-8");
            System.out.println(multiMap.toString());

            String current;
            while((current = in.readLine()) != null)
            {
                urlString += current;
            }
            System.out.println(urlString);
        }catch(IOException e)
        {
            e.printStackTrace();

        }
        JsonObject json=new JsonObject(urlString);
        json.get("VerifySN");
        return urlString;

    }
     */
}
