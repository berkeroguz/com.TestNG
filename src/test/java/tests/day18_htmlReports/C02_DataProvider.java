package tests.day18_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {
    @DataProvider
    public static Object[][] AmazonAranacakKelimeler() {
        /*
        @DataProvider istediğimiz test method'una test datasi sağlamak icin
        kullanılır. Sadece bir sartı vardır,

        - 2 katli bir Object array'i dondurmelidir.

         */
        Object[][] amazonAranacakKelimelerArrayi={{"Nutella"},{"Java"},{"Apple"},{"Samsung"},{"Armut"}};
        return amazonAranacakKelimelerArrayi;
    }

    // Amazona gidelim
    // Nutella, java , apple , samsung , armut , kelimeleri için arama yapalım
    // sonuçların bu kelimeleri içerdiğini test edelim.

    @Test(dataProvider = "AmazonAranacakKelimeler")
    public void aramaTesti(String aranacakKelime){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys(aranacakKelime+ Keys.ENTER);
        String actualSonucYazisi = amazonPage.aramaSonucuElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(aranacakKelime));

    }

}
