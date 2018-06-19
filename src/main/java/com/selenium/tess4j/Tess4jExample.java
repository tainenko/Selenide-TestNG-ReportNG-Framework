package com.selenium.tess4j;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.ImageHelper;
import net.sourceforge.tess4j.TesseractException;
/**
 * Tess4j Example
 *
 *
 *
 *
 *
 *
 */
public class Tess4jExample {
    public static void main(String[] args){
        String result = null;
        String filePath="tessdata/386752.png";
        try {
            //對圖片黑白處理，增強識別率
            BufferedImage textImage = ImageIO.read(new File(filePath));
            //裁切想辨識的圖片部分，這裡的圖片已經是辨識碼的部分，所以跳過此步驟
            //BufferedImage textImage =ImageHelper.getSubImage(image, 412, 340, 133, 32));
            // 圖片放大4倍，增強識別率
            textImage = ImageHelper.getScaledInstance(textImage, textImage.getWidth() * 2, textImage.getHeight() * 2);
            //對圖片灰化處理
            //textImage=ImageHelper.convertImageToGrayscale(textImage);
            //將圖片binary化
            textImage = ImageHelper.convertImageToBinary(textImage);
            //處理完的圖片儲存為img-temp.png
            ImageIO.write(textImage, "png", new File("tessdata/img_temp.png"));
            //辨識率不佳時，可以額外引入訓練庫
            //instance.setDatapath(System.getProperty("user.dir"))
            Tesseract instance = new Tesseract();
            //中文字庫
            //instance.setLanguage("chi_sim");
            //英文字庫
            instance.setLanguage("eng");
            result = instance.doOCR(textImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(result);
}
}
