package com.selenium.Examples;

import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.ImageHelper;

import com.selenium.CommonLib.CopyOfCleanLines;
/**
 * 2018.-6.27 Tess4j Example  by Tony.Ko:
 * 展示如何預處理會員登入頁的圖片驗證碼，圖片灰度、去噪、去除干擾線，另存新檔
 * 處理完的圖片使用Tess4j進行影片辨識，得到驗證碼字串。
 * 其中Tess4j的字庫為eng，並且設定只辨識數字字元。如果辨識度不高可以再導入訓練庫。
 *
 * 測試圖片為ETmall會員登入頁的驗證碼圖片(https://etmall.lab.etzone.net/Product/CreateCaptcha?count=1)
 * tessdata/386752.jpg tessdata/467823.jpg tessdata/765324.jpg
 */

public class Tess4jExample {
    public static void main(String[] args){
        String str = null;
        String filePath="tessdata/765324.png";
        String destFile="tessdata/verifyCode.png";
        String result="";

        try {
            //對圖片黑白處理，增強識別率
            BufferedImage textImage = ImageIO.read(new File (filePath));
            //裁切想辨識的圖片部分，這裡的圖片已經是辨識碼的部分，所以跳過此步驟
            //BufferedImage textImage =ImageHelper.getSubImage(image, 412, 340, 133, 32));
            // 圖片放大4倍，增強識別率
            textImage = ImageHelper.getScaledInstance(textImage, textImage.getWidth() * 2, textImage.getHeight() * 2);
            //對圖片去噪、binary、去除干擾線，將處理後的圖片另存為tessdata/verifyCode
            CopyOfCleanLines.cleanLinesInImage(textImage,destFile);

            //以下BufferedImage自帶的method處理效果不佳，改用CopyOfCleanLines.class對圖片優化
            //對圖片灰化處理
            //textImage=ImageHelper.convertImageToGrayscale(textImage);
            //將圖片binary化
            //textImage = ImageHelper.convertImageToBinary(textImage);
            //處理完的圖片儲存為img-temp.png
            //ImageIO.write(textImage, "png", new File("tessdata/img_temp.png"));

            Tesseract instance = new Tesseract();
            //中文字庫
            //instance.setLanguage("chi_sim");
            //英文字庫
            instance.setLanguage("eng");
            //辨識率不佳時，可以額外引入訓練庫
            //instance.setDatapath(System.getProperty("user.dir"))
            //設定只辨識數字
            instance.setTessVariable("tessedit_char_whitelist", "1234567890");
            str = instance.doOCR(new File(destFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //只保留辨識結果的數字部份，濾掉空格
        if(str !=null && !"".equals(str)){
            for (int i=0;i<str.length();i++){
                if(str.charAt(i)>=48 && str.charAt(i)<=57)
                    result+=str.charAt(i);
            }
        }

        System.out.println(result);
}
}
