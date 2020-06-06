package lesson_5.hw_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SmokeTest_2 extends BaseTest{
    private String URL = "https://healthunify.com/bmicalculator/";

    @Test
    public void BMICalculator(){
        String weightValue = "70";
        String heightValue = "5";
        String heightValue_2 = "6";
        String expectedSIUnits = "11.27";
        String expectedUSUnits = "11.46";
        String expectedUKUnits = "71.58";
        String expectedStatus = "Your category is Normal";

        //1. Открыть сайт https://healthunify.com/bmicalculator/
        driver.get(URL);
        //driver.get("https://healthunify.com/bmicalculator/");

        //2. Ввести Weight
        WebElement dropDown = driver.findElement(By.name("opt1"));
        Select sDropDown = new Select(dropDown);
        sDropDown.selectByValue("pounds");

        WebElement weight = driver.findElement(By.name("wg"));
        weight.clear();
        weight.sendKeys(weightValue);

        //3. Ввести Height
        WebElement height = driver.findElement(By.name("opt2"));
        Select sHeight = new Select(height);
        sHeight.selectByValue(heightValue);

        WebElement height_2 = driver.findElement(By.name("opt3"));
        Select sHeight_2 = new Select(height_2);
        sHeight_2.selectByValue(heightValue_2);

        //4. Нажать кнопку 'Calculate'
        WebElement calculate = driver.findElement(By.name("cc"));
        calculate.click();

        //5. Проверить значение в поле 'SI Units'
        WebElement siUnits = driver.findElement(By.name("si"));
        Assert.assertEquals(siUnits.getAttribute("value"), expectedSIUnits);

        //6. Проверить значение в поле 'US Units'
        WebElement usUnits = driver.findElement(By.name("us"));
        Assert.assertEquals(usUnits.getAttribute("value"), expectedUSUnits);

        //7. Проверить значение в поле 'UK Units'
        WebElement ukUnits = driver.findElement(By.name("uk"));
        Assert.assertEquals(ukUnits.getAttribute("value"), expectedUKUnits);

        //8. Проверить статус
        WebElement status = driver.findElement(By.name("desc"));
        Assert.assertEquals(status.getAttribute("value"), expectedStatus);

    }
}
