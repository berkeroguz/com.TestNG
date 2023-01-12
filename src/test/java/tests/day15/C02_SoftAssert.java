package tests.day15;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.*;

public class C02_SoftAssert {
    @Test (groups = {"minireg1","minireg2"})
    public void test01(){
        ReusableMethods.bekle(4);
        // 1. "http://zero.webappsecurity.com/" Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));
        // 2. Sign in butonuna basin
        ZeroWebAppPage zeroWebAppPage = new ZeroWebAppPage();
        zeroWebAppPage.signInButonu.click();
        // 3. Login kutusuna "username" yazin
        zeroWebAppPage.usernameKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliUsername"));
        // 4. Password kutusuna "password" yazin
        zeroWebAppPage.passwordKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliPassword"));
        // 5. Sign in tusuna basin
        zeroWebAppPage.signInSubmitButonu.click();
        Driver.getDriver().navigate().back();
        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        zeroWebAppPage.onlineBanking.click();
        zeroWebAppPage.payBillLinki.click();
        // 7. "Purchase Foreign Currency" tusuna basin
        zeroWebAppPage.purchaseFCButonu.click();
        // 8. "Currency" drop down menusunden Eurozone'u secin
        Select select = new Select(zeroWebAppPage.currencyDropdown);
        select.selectByVisibleText("Eurozone (euro)");
        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();

        String expectedWord ="Eurozone (euro)";
        String actualWord = select.getFirstSelectedOption().getText();

        softAssert.assertEquals(actualWord,expectedWord,"Eurozone (euro) seçili değil");

        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin

        List<WebElement> actualOptions = select.getOptions();
        List<String> actualOptionsText = new ArrayList<>();

        //Dropdown üzerindeki tüm text'leri bir liste aldık.
        for (WebElement each : actualOptions)
        {
            actualOptionsText.add(each.getText());
        }

        String [] expectedOptions = {"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};


        List<String> expectedOptionsText = Arrays.asList(expectedOptions);

        Collections.sort(actualOptionsText);
        Collections.sort(expectedOptionsText);
        //actual = actualOptionsText
        //expected = expectedOptionsText

        System.out.println("actual list = " +actualOptionsText);
        System.out.println("expected list = "+ expectedOptionsText);


        softAssert.assertEquals(actualOptionsText,expectedOptionsText,"dropdown beklenen öğeleri içermiyor.");

        // "Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China (yuan)",
        // "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (ypn)
        softAssert.assertAll();
        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }




}
