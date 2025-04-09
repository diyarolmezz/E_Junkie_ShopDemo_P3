package US_301;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_01 extends BaseDriver {

    @Test
    public void test1(){

        WebElement addToCart= driver.findElement(By.xpath("(//*[text()=' Add To Cart'])[2]"));
        addToCart.click();
        MyFunc.Bekle(1);

        WebElement verify=driver.findElement(By.xpath("//*[text()='Demo eBook']"));
        Assert.assertTrue(verify.getText().equals("Demo eBook"), "Sepette Urun Bulunamadi");
        System.out.println("Sepete Eklenen Urun : " + verify.getText());
        MyFunc.Bekle(1);

        WebElement frame=driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(frame);
        MyFunc.Bekle(1);

        WebElement addPromoCode= driver.findElement(By.xpath("//*[text()='Add Promo Code']"));
        addPromoCode.click();
        MyFunc.Bekle(1);

        WebElement promoCode= driver.findElement(By.cssSelector("[class='Promo-Code-Value']"));
        promoCode.sendKeys("0000");
        MyFunc.Bekle(1);

        WebElement applyButton= driver.findElement(By.xpath("//*[text()='Apply']"));
        applyButton.click();
        MyFunc.Bekle(5);

        WebElement addPromoCode2= driver.findElement(By.xpath("//*[text()='Add Promo Code']"));
        addPromoCode2.click();
        MyFunc.Bekle(1);

        WebElement promoCode2= driver.findElement(By.cssSelector("[class='Promo-Code-Value']"));
        promoCode2.sendKeys("1234");
        MyFunc.Bekle(1);

        WebElement applyButton2= driver.findElement(By.xpath("//*[text()='Apply']"));
        applyButton2.click();
        MyFunc.Bekle(5);

        WebElement addPromoCode3= driver.findElement(By.xpath("//*[text()='Add Promo Code']"));
        addPromoCode3.click();
        MyFunc.Bekle(1);

        WebElement promoCode3= driver.findElement(By.cssSelector("[class='Promo-Code-Value']"));
        promoCode3.sendKeys("123456789");
        MyFunc.Bekle(1);

        WebElement applyButton3= driver.findElement(By.xpath("//*[text()='Apply']"));
        applyButton3.click();
        MyFunc.Bekle(5);

        WebElement msj= driver.findElement(By.xpath("//*[text()='Invalid promo code']"));

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(120));
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[text()='Invalid promo code']"),"Invalid promo code"));
        System.out.println("Gecersiz Promosyon Kodu Mesaji dogrulandi : " + msj.getText());

    }

}
