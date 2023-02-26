package tests.day18_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_HTML_Reports extends TestBaseRapor {
    @Test
    public void test01(){
        extentTest=extentReports.createTest("Nutella testi ","Kullanici amazonda nutella arayabilmeli");
        bilgilendirmeRapor("Taner","DENEME BASLIK","Test 01 - Nutella");

        //amazona gidelm
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazona gittik");

        //nutella aratalım
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        extentTest.info("Arama kutusuna nutella yazıip arama yapıldı");
        String actualResult = amazonPage.aramaSonucuElementi.getText();
        String expectedResult = "Nutella";
        extentTest.info("Arama sonucları kaydedildi");
        Assert.assertTrue(actualResult.contains(expectedResult));
        extentTest.pass("Arama sonuclarının nutella içerdiği test edildi.");

        //sonucların nutella içerdiğini test edelim


    }
}
