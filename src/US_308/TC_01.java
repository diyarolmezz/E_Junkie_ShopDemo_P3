package US_308;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TC_01 extends BaseDriver {

    @Test
    public void TC_308() throws AWTException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://www.e-junkie.com/");

        WebElement seeHowItWorkBtn = driver.findElement(By.cssSelector("[onclick='toggleYoutubeModal(true)']"));
        seeHowItWorkBtn.click();

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.e-junkie.com/"), "Site yanlış");

        Robot rbt = new Robot();
        for (int i = 0; i < 17; i++) {
            try {
                Thread.sleep(100);  //Döngüyü yavaşlatmadığımızda tab'a basma sayısı değişip hata verebiliyor.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            rbt.keyPress(KeyEvent.VK_TAB);
            rbt.keyRelease(KeyEvent.VK_TAB);
        }
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);

        MyFunc.Bekle(10);   //User story'de belirtilen 10 saniye video süresi için eklenmiştir

        WebElement closeBtn = driver.findElement(By.cssSelector("[class='modal-close is-large']"));
        js.executeScript("arguments[0].click();", closeBtn);

        TearDown();
    }

}
