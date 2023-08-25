package ru.academits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.System.*;

public class SeleniumWebDriverManagerTests {

    public WebDriver driver;

    @BeforeEach
    public void setUp() throws InterruptedException {

        String browser = System.getProperty("browser");

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        String url = "https://demoqa.com/automation-practice-form";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }


    @Test
    public void autoTestForFormDemoQA() throws InterruptedException {


        WebElement firstName = driver.findElement(By.cssSelector("input[id='firstName']"));
        firstName.sendKeys("Altyna");
        Thread.sleep(2000);

        WebElement lastName = driver.findElement(By.cssSelector("input[id='lastName']"));
        lastName.sendKeys("Bekhtenova");
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.cssSelector("input[id='userEmail']"));
        email.sendKeys("altusha.pin-up@mail.ru");
        Thread.sleep(2000);

        WebElement male = driver.findElement(By.cssSelector("label[for='gender-radio-1']"));
        male.click();
        Thread.sleep(2000);

        WebElement phone = driver.findElement(By.cssSelector("input[id='userNumber']"));
        phone.sendKeys("8-888-888-88-88");
        Thread.sleep(2000);

        WebElement dateOfBirth = driver.findElement(By.cssSelector("input[id='dateOfBirthInput']"));
        dateOfBirth.click();
        Thread.sleep(2000);

        WebElement monthOfBirthPicker = driver.findElement(By.className("react-datepicker__month-select"));
        monthOfBirthPicker.click();
        Thread.sleep(1000);

        WebElement monthOfBirth = driver.findElement(By.cssSelector("option[value='6']"));
        monthOfBirth.click();
        Thread.sleep(1000);

        WebElement yearOfBirthPicker = driver.findElement(By.className("react-datepicker__year-select"));
        yearOfBirthPicker.click();
        Thread.sleep(1000);

        WebElement yearOfBirth = driver.findElement(By.cssSelector("option[value='1995']"));
        yearOfBirth.click();
        Thread.sleep(1000);

        WebElement dayOfBirth = driver.findElement(By.className("react-datepicker__day react-datepicker__day--006"));
        dayOfBirth.click();
        Thread.sleep(1000);

        WebElement subject = driver.findElement(By.className("subjects-auto-complete__placeholder css-1wa3eu0-placeholder"));
        subject.sendKeys("Geology");
        Thread.sleep(2000);

        WebElement hobby = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']"));
        hobby.click();
        Thread.sleep(2000);

        WebElement currentAddress = driver.findElement(By.cssSelector("textarea[id='currentAddress']"));
        currentAddress.sendKeys("Novosibirsk");
        Thread.sleep(2000);

        WebElement state = driver.findElement(By.className("css-19bqh2r"));
        state.click();
        Thread.sleep(2000);


        WebElement submit = driver.findElement(By.cssSelector("button[id='submit']"));
        submit.click();
        Thread.sleep(2000);



//        Assertions.assertEquals("","");


        driver.quit();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
