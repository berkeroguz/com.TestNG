package tests.day16_SmokeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Properties;

public class C01_PozitifLoginTest {

    @Test
    public void pozitifLoginTest(){

        //qualitydemy anasayfaya git

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QualitydemyPage qualitydemyPage=new QualitydemyPage();

        qualitydemyPage.ilkSayfaCookieAccept.click();
        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        qualitydemyPage.loginButonu.click();
        ReusableMethods.bekle(2);

        Assert.assertTrue(qualitydemyPage.basariliGirisCoursesLinki.isDisplayed());

        ReusableMethods.bekle(3);

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//*[@href='javascript:;'])[5]"))).perform();
        Driver.getDriver().findElement(By.xpath("(//div/ul/li/a/i)[7]")).click();
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}
