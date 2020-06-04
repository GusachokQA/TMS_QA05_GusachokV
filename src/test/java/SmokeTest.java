import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SmokeTest {

    @Test
    public void Test1(){
        //1. Открыть сайт https://www.3crkp.by/информация/полезно-знать/медицинские-калькуляторы/расчет-имт
        System.setProperty("webdriver.chrome.driver", "E:/QA/TMS_QA05_GusachokV/src/driver/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.3crkp.by/информация/полезно-знать/медицинские-калькуляторы/расчет-имт");

        //2. Ввести Рост = 183 см
        WebElement height = driver.findElement(By.name("ht"));
        height.sendKeys("183");

        //3. Ввести Вес = 58 кг
        WebElement weight = driver.findElement(By.name("mass"));
        weight.sendKeys("58");

        //4. Нажать на кнопку ‘Рассчитать’
        WebElement calculate = driver.findElement(By.cssSelector("input[type = 'button']"));
        calculate.click();

        //5. Проверить, что значение в поле ‘ИМТ’ равно 17.32
        WebElement result = driver.findElement(By.name("result"));

        //6. Проверить, что статус равен ’Пониженный вес’
        WebElement status = driver.findElement(By.id("resline"));
        String actualStatus = status.getText();
        if (!actualStatus.equals("Пониженный вес")){
            System.out.println("The value in the fieldIMT is " + actualStatus + "and doesn`t equel to Пониженный вес");
        }

        //7. Закрыть окно браузера
        driver.quit();


    }
}
