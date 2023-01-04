package org.example.stepDefs;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.example.stepDefs.Hooks.driver;

public class D07_socialLink {
    @Given("user click on facebook icon")
    public  void clickOnFacebook () throws InterruptedException {
        driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]")).click();


        WebDriverWait explict = new WebDriverWait(driver , Duration.ofSeconds(10));
        explict.until(ExpectedConditions.numberOfWindowsToBe(2));


        String url = driver.getCurrentUrl();
        System.out.println(url);

        //Define array list
        ArrayList<String> tabs =new ArrayList<String>(driver.getWindowHandles());

        //tab0   tab 1
        driver.switchTo().window(tabs.get(1));
        url = driver.getCurrentUrl();
        System.out.println(url);
        driver.close();
        driver.switchTo().window(tabs.get(0));

    }
    //Difference between driver .quit and driver.close



}
