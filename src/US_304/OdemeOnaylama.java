
package US_304;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.nio.ByteOrder;
import java.time.Duration;

public class OdemeOnaylama extends BaseDriver {
    @Test
    public void Test1() {
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement eBook = driver.findElement(By.xpath("(//*[@class='ion-ios-cart cart_icon']) [2]"));
        eBook.click();
        MyFunc.Bekle(2);

        WebElement frame = driver.findElement(By.xpath("//*[@class='EJIframeV3 EJOverlayV3']"));

        driver.switchTo().frame(frame);
        WebElement paybutton=driver.findElement(By.xpath("//*[@class='Payment-Button CC']"));
        paybutton.click();


        WebElement email=driver.findElement(By.xpath("(//*[@type='email']) [1]"));
        email.sendKeys("leyla.gunes@gmail.com");

        WebElement confirmemail=driver.findElement(By.xpath("//*[@placeholder='Confirm Email']"));
        confirmemail.sendKeys("leyla.gunes@gmail.com");

        WebElement nameoncard=driver.findElement(By.xpath("//*[@placeholder='Name On Card']"));
        nameoncard.sendKeys("Leyla Gunes");

        WebElement phone=driver.findElement(By.xpath("//*[@placeholder='Optional'] [1]"));
        phone.sendKeys("44070000000");


        WebElement frame2= driver.findElement(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[1]"));
        driver.switchTo().frame(frame2);

        WebElement cardnumber=driver.findElement(By.xpath("//*[@class='InputElement is-empty Input Input--empty'] [1]"));
        cardnumber.sendKeys("4242 4242 4242 4242");

        WebElement MMYY=driver.findElement(By.xpath("//*[@name='exp-date']"));
        MMYY.sendKeys("12/25");

        WebElement CVV=driver.findElement(By.xpath("//*[@name='cvc']"));
        CVV.sendKeys("000");
        driver.switchTo().parentFrame();


        MyFunc.Bekle(45);

        WebElement pay=driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        pay.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("https://www.fatfreecartpro.com/"));

        MyFunc.Bekle(10);


















    }
}
