package tests.day19_crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossDriver;
import utilities.Driver;
import utilities.TestBaseCross;

public class C01_AmazonSearch extends TestBaseCross {

    @Test
    public void test01(){
//Bu konunun kısa özeti 19. videonun 1.07. dksında
        //amazon anasayfaya gidelim
        driver.get(ConfigReader.getProperty("amazonUrl"));
        // nutella icin arama yapalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        // sonuçların nutella içerdiğini test edelim
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualSonucYazisi = sonucYaziElementi.getText();
        String expectedSonucYazisi="Nutella";

        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucYazisi));

    }

}
