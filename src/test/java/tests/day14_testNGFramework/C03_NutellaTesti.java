package tests.day14_testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C03_NutellaTesti {

    @Test (groups = {"minireg1","minireg2","smoke"})
    public void test01(){

        //amazon anasayfaya gidip

        Driver.getDriver().get("https://www.amazon.com");
        // nutella aratın
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).
                sendKeys("Nutella"+ Keys.ENTER);
        // sonucların nutella içerdiğini test edin
        String expectedWord = "Nutella";
        String actualWord=Driver.getDriver().findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']/span)[3]")).getText();


        Assert.assertTrue(actualWord.contains(expectedWord),"İçermiyor.");

        Driver.closeDriver();


    }
}
