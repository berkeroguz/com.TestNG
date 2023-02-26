package tests.day19_crossBrowser;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CrossDriver;
import utilities.TestBaseCross;

public class C02_WiseQuarterTest extends TestBaseCross {

    @Test
    public void test01(){

        //Wisequa git
        //gittigini test et

        driver.get("https://www.wisequarter.com");

        Assert.assertTrue(driver.getCurrentUrl().contains("wisequarter"));
    }

}
