package US_305;

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
    public void paymentConfirm() {
        WebElement price = driver.findElement(By.xpath("//*[text()='Demo eBook']//following-sibling::span"));
        String price1 = price.getText().replaceAll("[^0-9,.]", "");

        WebElement addToCart = driver.findElement(By.xpath("//div[@class='column is-one-third-desktop is-one-third-tablet card_box'][2]//div[2]/button"));
        addToCart.click();

        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe1);

        WebElement payDebitCard = driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
        payDebitCard.click();

        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        email.sendKeys("test09@gmail.com");

        WebElement confirmEmail = driver.findElement(By.xpath("//input[@placeholder='Confirm Email']"));
        confirmEmail.sendKeys("test09@gmail.com");

        WebElement nameOnCard = driver.findElement(By.xpath("//input[@placeholder='Name On Card']"));
        nameOnCard.sendKeys("Poseidon Poseidon");

        WebElement iframe2 = driver.findElement(By.xpath("//div[@class='StripeElement StripeElement--empty']//iframe"));
        driver.switchTo().frame(iframe2);

        WebElement cardnumber = driver.findElement(By.xpath("//input[@name='cardnumber']"));
        cardnumber.sendKeys("4242 4242 4242 4242");

        WebElement expDate = driver.findElement(By.xpath("//input[@name='exp-date']"));
        expDate.sendKeys("1226");

        WebElement cvc = driver.findElement(By.xpath("//input[@name='cvc']"));
        cvc.sendKeys("000");
        driver.switchTo().parentFrame();

        MyFunc.Bekle(20);

        WebElement pay = driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        pay.click();

        driver.switchTo().defaultContent();

        MyFunc.Bekle(20);

        WebElement finalprice = driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 col-xs-6 text-right']//span"));

        String price2 = finalprice.getText().replaceAll("[^0-9,.]", "");
        WebElement download = driver.findElement(By.xpath("//*[text()='Download']"));
        download.click();

        Assert.assertEquals(price1, price2, "Toplam fiyat hatali!!!");

    }
}