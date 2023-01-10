package tests.day15;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Arrays;

public class C01_SoftAssert {

    @Test
    public void test01(){

        // amazon anasayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");
        // amazon anasayfaya gittiğinizi doğrulayın
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains("amazon"));
        // Nutella aratin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // Arama sonuclarının nutella içerdiğini doğrulayın
        String aramaSonucYazisi= amazonPage.aramaSonucuElementi.getText();
        softAssert.assertTrue(aramaSonucYazisi.contains("Nutella"));

        ReusableMethods.bekle(1);
        // Java aratın
        amazonPage.amazonAramaKutusu.clear();
        amazonPage.amazonAramaKutusu.sendKeys("Java"+Keys.ENTER);

        // Java aratın arama sonuclarının 1000'den fazla oldıugunu doğrulayın
        System.out.println(amazonPage.aramaSonucuElementi.getText());
        //1-48 of over 7,000 results for "Java" 7000'ni almamız lazım

        aramaSonucYazisi=amazonPage.aramaSonucuElementi.getText();
        String[] sonucArr=aramaSonucYazisi.split(" ");
        System.out.println(Arrays.toString(sonucArr));

        String javaSonucElementi = sonucArr[3];

        javaSonucElementi=javaSonucElementi.replaceAll("\\W",""); // 7000
        int sonucSayisiInt= Integer.parseInt(javaSonucElementi);

        softAssert.assertTrue(sonucSayisiInt>1000,"1000'den büyük değil");

        softAssert.assertAll(); //Demezsen raporlama yapmaz.
        Driver.getDriver().close();


    }
}
