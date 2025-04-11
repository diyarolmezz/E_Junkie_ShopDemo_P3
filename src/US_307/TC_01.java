package US_307;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01 extends BaseDriver {


    @Test
    public void test(){


        driver.get("https://shopdemo.fatfreeshop.com/?");
        MyFunc.Bekle(2);

        WebElement Ebutton=driver.findElement(By.xpath("//*[@class='EJ-ShopLink']"));
        Ebutton.click();

        WebElement logo=driver.findElement(By.xpath("//*[@class='column is-2-desktop is-4-tablet is-4-mobile']//img"));
        logo.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.e-junkie.com/"));




    }
}
