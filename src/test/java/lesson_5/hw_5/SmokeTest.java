package lesson_5.hw_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {
    private String URL = "https://healthunify.com/bmicalculator/";

    @Test
    public void BMICalculator(){
        String weightValue = "40";
        String heightValue = "158";
        String expectedSIUnits = "16.02";
        String expectedUSUnits = "16.29";
        String expectedUKUnits = "101.73";
        String expectedStatus = "Your category is Underweight";

        //1. Открыть сайт https://healthunify.com/bmicalculator/
        driver.get(URL);
        //driver.get("https://healthunify.com/bmicalculator/");

        //2. Ввести Weight
        WebElement weight = driver.findElement(By.name("wg"));
        weight.sendKeys(weightValue);

        //3. Ввести Height
        WebElement height = driver.findElement(By.name("ht"));
        height.sendKeys(heightValue);

        //4. Нажать кнопку 'Calculate'
        WebElement calculate = driver.findElement(By.name("cc"));
        calculate.click();

        //5. Проверить значение в поле 'SI Units'
        WebElement siUnits = driver.findElement(By.name("si"));
        Assert.assertEquals(siUnits.getAttribute("value"), expectedSIUnits);

        //6. Проверить значение в поле 'US Units'
        WebElement usUSnits = driver.findElement(By.name("us"));
        Assert.assertEquals(usUSnits.getAttribute("value"), expectedUSUnits);

        //7. Проверить значение в поле 'UK Units'
        WebElement ukUnits = driver.findElement(By.name("uk"));
        Assert.assertEquals(ukUnits.getAttribute("value"), expectedUKUnits);

        //8. Проверить статус
        WebElement status = driver.findElement(By.name("desc"));
        Assert.assertEquals(status.getAttribute("value"), expectedStatus);

    }

}
