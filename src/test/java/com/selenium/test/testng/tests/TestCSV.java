package com.selenium.test.testng.tests;

import com.selenium.CommonLib.CSVData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * CSV Parameter test Example
 * csv檔案預設路徑為src/resources，也可以輸入絕對路徑讀取csv檔案。
 * 讀取時會將首行的字串作為注入時的變數名稱。
 *
 */

public class TestCSV {
    @DataProvider(name = "num")
    public Iterator<Object[]> Numbers() throws IOException {
        return (Iterator<Object[]>) new CSVData("testData.csv");
    }

    @Test(dataProvider = "num")
    public void testAdd(Map<String, String> data) {
        float num1 = Float.parseFloat(data.get("num1"));
        float num2 = Float.parseFloat(data.get("num2"));
        float expectedResult = Float.parseFloat(data.get("result"));
        Float actual = num1 + num2;
        Assert.assertEquals(actual, expectedResult);
    }
}
