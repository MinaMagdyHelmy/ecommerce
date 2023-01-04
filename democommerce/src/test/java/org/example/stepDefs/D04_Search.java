package org.example.stepDefs;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.driver;

public class D04_Search {





    @Given("test step {string}")
    public void testStep(String arg0) {
        driver.findElement(By.id("small-searchterms")).sendKeys(arg0);
        driver.findElement(By.id("small-searchterms")).sendKeys(Keys.ENTER);

        //count number of search results
        int count  = driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).size();
        for (int x= 0 ; x< count ; x++)
        {
String product =  driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).get(x).getText();
            System.out.println(arg0);

            System.out.println(product);
            Assert.assertTrue(product.toLowerCase().contains(arg0));


        }
    }

    @Given("sku step {string}")
    public void skuStep(String arg0) {
        driver.findElement(By.id("small-searchterms")).sendKeys(arg0);
        driver.findElement(By.id("small-searchterms")).sendKeys(Keys.ENTER);
        int count  = driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).size();

       Assert.assertEquals(count,1);
        driver.findElement(By.cssSelector("h2[class=\"product-title\"] a")).click();
        String productSku = driver.findElement(By.cssSelector("span[id*=\"sku\"]")).getText();
        Assert.assertEquals(productSku,arg0);
    }
}
