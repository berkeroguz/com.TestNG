package tests.day15;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_PozitifLoginTesti {

    @Test (groups = "smoke")
    public void test01(){

        // https://www.qualitydemy.com anasayfasına gidin
        Driver.getDriver().get((ConfigReader.getProperty("qdUrl")));
        // login linkine basin
        QualitydemyPage qdp = new QualitydemyPage();
        qdp.ilkLoginLinki.click();
        // Kullanici email'i olarak valid email girin
        qdp.kullaniciEmailKutusu.sendKeys("denemeogz123@gmail.com");
        // kullanici sifresi olarak valid sifre girin
        qdp.passwordKutusu.sendKeys("Wisequarter123");
        // Login butonuna basarak login olun
        qdp.loginButonu.click();
        // Basarılı olarak giris yapabildigini test edin.
        Assert.assertTrue(qdp.basariliGirisCoursesLinki.isDisplayed(),"Başarılı giriş yapılamadı.");
        Driver.quitDriver();
    }

}
