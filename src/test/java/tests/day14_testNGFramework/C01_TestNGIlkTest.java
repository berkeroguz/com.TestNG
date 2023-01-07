package tests.day14_testNGFramework;

import org.testng.annotations.Test;

public class C01_TestNGIlkTest {

    //TestNG'de methodlar isim sırasına göre çalışır.

    @Test (priority = 3)
    public void ilkTest(){
        System.out.println("ilk test çalıştı");
    }
    @Test (priority = 2)
    public void ikinciTest(){
        System.out.println("2. test çalıştı");
    }
    @Test (priority = 1)
    public void ucuncuTest(){
        System.out.println("3. test çalıştı");
    }

}
