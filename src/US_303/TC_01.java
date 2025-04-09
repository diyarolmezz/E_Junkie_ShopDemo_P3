package US_303;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TC_01 extends BaseDriver {


    @Test
    public void test1()  throws  AWTException, InterruptedException  {

        Robot robot = new Robot();

        // Add to card a tikla
        for (int i = 0; i < 15; i++) {


            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(200);

        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


        WebElement frame=driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']"));
        wait.until(ExpectedConditions.visibilityOf(frame));
        driver.switchTo().frame(frame);


        WebElement cart= driver.findElement(By.xpath("//*[@class='Payment-Button CC']"));
        cart.click();


        Actions actions = new Actions(driver);

        WebElement Email = driver.findElement(By.cssSelector("input[placeholder='Email']"));
        actions.moveToElement(Email).click().sendKeys("test@email.com").build().perform();

        WebElement Email2 = driver.findElement(By.cssSelector("p[class='Billing-Email-Confirm Inline']>input"));
        actions.moveToElement(Email2).click().sendKeys("test@email.com").build().perform();

        WebElement NameOnCard = driver.findElement(By.cssSelector("p[class='Billing-Name Inline MarginRight']>input"));
        actions.moveToElement(NameOnCard).click().sendKeys("DIYAR").build().perform();

        MyFunc.Bekle(2);

        WebElement FRAME= driver.findElement(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[1]"));
        driver.switchTo().frame(FRAME);

        WebElement Cartnumber = driver.findElement(By.xpath("(//*[@class='InputContainer']/input)[1]"));
        Cartnumber.sendKeys("1111111111111111");


        MyFunc.Bekle(10);


        driver.switchTo().parentFrame();

        WebElement PAY2= driver.findElement(By.xpath("//*[@class='Pay-Button']"));
        PAY2.click();

        WebElement mesaj= driver.findElement(By.cssSelector("ion-icon[class='Close-SnackBar md hydrated'] +span"));

        wait.until(ExpectedConditions.visibilityOf(mesaj));
        System.out.println("Uyari : " + mesaj.getText());
        Assert.assertTrue(mesaj.getText().contains("Kart numaranız geçersiz."),"Gcersiz Mesaj uyarisi Cikmadi");





    }



    }



