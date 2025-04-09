package US_302;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TC_01 extends BaseDriver {

    @Test
    public void Test () {

        WebElement addToCart = driver.findElement(By.xpath("(//*[text()=' Add To Cart'])[2]"));
        addToCart.click();

        WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(frame1); // Burada odeme seceneklerinin oldugu iframe icine girdim.

        WebElement creditCard = driver.findElement(By.xpath("//button[@class='Payment-Button CC']//span"));
        creditCard.click();

        WebElement payButton = driver.findElement(By.cssSelector("button[class='Pay-Button']"));
        payButton.click();

        WebElement invalidPayment = driver.findElement(By.cssSelector("div[id='SnackBar'] span"));

        String errorMessage = invalidPayment.getText(); // burada odeme seceneginin barasiz olduguna dair, cikan yaziyi aldim.
        System.out.println("Error Message : \n" + errorMessage); // yazdirdim.

        // burada odemenin basarisiz olduguna dair cikan yaziyi explicity ile kontrol ettim. Eger eklenmez ise hata veriyor test.
        wait.until(ExpectedConditions.textToBe(By.cssSelector("div[id='SnackBar'] span"),"Invalid Email\nInvalid Email\nInvalid Billing Name"));
        Assert.assertEquals("Invalid Email\nInvalid Email\nInvalid Billing Name", errorMessage);

        TearDown();

    }
}
