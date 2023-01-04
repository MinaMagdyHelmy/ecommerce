package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.driver;

public class D03_Currency {

    String currency;
    @When("user check currency list")
    public void user_check_currency_list() {
        Select dropdowen = new Select(driver.findElement(By.id("customerCurrency")));
     currency =    dropdowen.getFirstSelectedOption().getText();
        System.out.println(currency);

    }
    @Then("Dollar selected by default")
    public void dollar_selected_by_default() {
        Assert.assertEquals(currency,"US Dollar");
    }

    @When("user select euro")
    public void userSelectEuro() {

        Select dropdowen = new Select(driver.findElement(By.id("customerCurrency")));
        dropdowen.selectByVisibleText("Euro");

      String price =   driver.findElements(By.className("price")).get(0).getText();
        System.out.println(price);
        Assert.assertEquals(price , "€1032.00");

        int count = driver.findElements(By.className("price")).size();


        for (int x=0 ; x<count;x++)
        {
           String actualprice =  driver.findElements(By.className("price")).get(x).getText();
            System.out.println(actualprice);
           Assert.assertTrue(actualprice.contains("€"));
        }

    }
}
