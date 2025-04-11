package US_306;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Base64;

public class TC_01 extends BaseDriver {



    @Test
    public void test1(){
        driver.get("https://shopdemo.fatfreeshop.com/?");
        MyFunc.Bekle(2);


        WebElement ContactBtn= driver.findElement(By.xpath("//*[@href='/contact']"));
        ContactBtn.click();

        WebElement name=driver.findElement(By.xpath("//*[@id='sender_name']"));
        name.sendKeys("Ebubekir");

        WebElement Email=driver.findElement(By.xpath("//*[@id='sender_email']"));
        Email.sendKeys("ebubekirduvarci@gmail.com");

        WebElement Subject=driver.findElement(By.xpath("//*[@id='sender_subject']"));
        Subject.sendKeys("Konu");

        WebElement Message=driver.findElement(By.xpath("//*[@id='sender_message']"));
        Message.sendKeys("mesaj");


        WebElement SendMessage= driver.findElement(By.xpath("//*[@id='send_message_button']"));
        SendMessage.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        String baslik=driver.switchTo().alert().getText();
        Assert.assertTrue(baslik.contains("Recaptcha"), "Yazı bulunamdı");









    }
}
