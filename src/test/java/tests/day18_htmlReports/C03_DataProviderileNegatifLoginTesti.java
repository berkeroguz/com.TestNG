package tests.day18_htmlReports;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProviderileNegatifLoginTesti {


    @DataProvider
    public static Object[][] gecersizGirisBilgileri() {
        Object[][] kullaniciBilgileriarr={{"A11", "A12345"},{"B12", "B12345"}, {"C13", "C12345"},{"D14", "D12345"},{"E15", "E12345"}};

        return kullaniciBilgileriarr;
    }

    @Test (dataProvider = "gecersizGirisBilgileri")
    public void negatifLoginTesti(String username,String password){
        //QualityDemy anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        //Verilen yanlis kullanici ad ve password kombinasyonları için
        // giriş yapılamadığını test edin
        QualitydemyPage qualitydemyPage =new QualitydemyPage();
        if(qualitydemyPage.ilkSayfaCookieAccept.isDisplayed())
        {
            qualitydemyPage.ilkSayfaCookieAccept.click();
        }
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(username);
        qualitydemyPage.passwordKutusu.sendKeys(password);
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.passwordKutusu.isDisplayed());
        // username password
        // A11      A12345
        // B12      B12345
        // C13      C12345
        // 014      D12345
        // E15      E12345
    }
}
