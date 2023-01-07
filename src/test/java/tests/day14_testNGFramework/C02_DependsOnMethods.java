package tests.day14_testNGFramework;

import org.testng.annotations.Test;

public class C02_DependsOnMethods {

    @Test ()
    public void ilkTest(){
        System.out.println("ilk test çalıştı");
    }
    @Test (dependsOnMethods = "ilkTest")
    public void ikinciTest(){
        System.out.println("2. test çalıştı");
    }
    @Test (dependsOnMethods = "ikinciTest")
    public void ucuncuTest(){
        System.out.println("3. test çalıştı");
    }
}
