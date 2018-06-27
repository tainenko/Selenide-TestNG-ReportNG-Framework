package com.selenium.Examples;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import com.google.gson.*;
/**
 *
 * 2018.06.27 JsonObject解析範例 by Tony.Ko：
 * 解析ETmall Lab區的手機驗證碼API傳回的Json
 * 取得最新的一筆驗證碼Json Object，並且print出VerifySn的value。
 *
 *
 */

public class GetPhoneSN {
    public static void main(String[] args) throws IOException{
        //"http://172.21.17.24/verify?Mobile="+手機號碼可查Lab區手機驗證碼
        String sURL = "http://172.21.17.24/verify?Mobile=0988888885"; //just a string

        // Connect to the URL using java's native library
        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.connect();

        // Convert to a JSON object to print data
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element

        // 將手機驗證碼API傳回來的內容轉成Json Object
        // {"recordsets":[[{"VerifySN":"63860536","CreateDate":"2018-06-22T12:01:43.320Z"},{"VerifySN":"76683374",
        // "CreateDate":"2018-06-22T12:00:42.047Z"},{"VerifySN":"46012082","CreateDate":"2018-05-02T17:35:09.490Z"}]],
        // "recordset":[{"VerifySN":"63860536","CreateDate":"2018-06-22T12:01:43.320Z"},{"VerifySN":"76683374",
        // "CreateDate":"2018-06-22T12:00:42.047Z"},{"VerifySN":"46012082","CreateDate":"2018-05-02T17:35:09.490Z"}],
        // "output":{},"rowsAffected":[3]}
        JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.

        //取出rootobj裡頭，數據頭為recordset的JsonArray
        JsonArray obj1=rootobj.getAsJsonArray("recordset");
        //取出JsonArray的第一個元素，並轉換成JsonObject
        JsonObject obj2=obj1.get(0).getAsJsonObject();
        //取得key為"VerifySN"的Value值，並轉換為String型態
        String verifySN=obj2.get("VerifySN").getAsString();
        System.out.println(verifySN);
    }
}
