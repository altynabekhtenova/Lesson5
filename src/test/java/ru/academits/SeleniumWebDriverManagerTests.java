package ru.academits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.System.*;

public class SeleniumWebDriverManagerTests {

    public WebDriver driver;

    @BeforeEach
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        String browser = System.getProperty("browser");

//        if (browser.equals("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        } else if (browser.equals("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        } else if (browser.equals("edge")) {
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//        }

        String url = "https://demoqa.com/automation-practice-form";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }


    @Test
    public void autoTestForFormDemoQA() throws InterruptedException {


        WebElement firstName = driver.findElement(By.cssSelector("input[id='firstName']"));
        String userFirstName = "Altyna";
        firstName.sendKeys(userFirstName);
        Thread.sleep(2000);

        WebElement lastName = driver.findElement(By.cssSelector("input[id='lastName']"));
        String userLastName = "Bekhtenova";
        lastName.sendKeys(userLastName);
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.cssSelector("input[id='userEmail']"));
        String userEmail = "altusha.pin-up@mail.ru";
        email.sendKeys(userEmail);
        Thread.sleep(2000);

        WebElement male = driver.findElement(By.cssSelector("label[for='gender-radio-1']"));
        male.click();
        Thread.sleep(2000);

        WebElement phone = driver.findElement(By.cssSelector("input[id='userNumber']"));
        String userPhone = "8-888-888-88-88";
        phone.sendKeys(userPhone);
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
        String userSubject = "Geology";
        subject.sendKeys(userSubject);
        Thread.sleep(2000);

        WebElement hobby = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']"));
        hobby.click();
        Thread.sleep(2000);

        WebElement currentAddress = driver.findElement(By.cssSelector("textarea[id='currentAddress']"));
        String userCurrentAddress = "Novosibirsk";
        currentAddress.sendKeys(userCurrentAddress);
        Thread.sleep(2000);

        WebElement state = driver.findElement(By.id("react-select-3-input"));
        String userState = "NCR";
        state.sendKeys(userState);
        state.sendKeys(Keys.ENTER);

        WebElement city = driver.findElement(By.id("react-select-4-input"));
        String userCity = "Delhi";
        city.sendKeys(userCity);
        city.sendKeys(Keys.ENTER);

//        JavascriptExecutor js;
//        js.executeScript("window.scrollTo()");
//
//        WebElement submit = driver.findElement(By.cssSelector("button[id='submit']"));
//        submit.click();
//        Thread.sleep(2000);

        Assertions.assertEquals(userFirstName + " " + userLastName,
        driver.findElement(By.xpath("//*[@class='table-responsive']/table/tbody/tr/td[2]")));

        Assertions.assertEquals(userEmail,
        driver.findElement(By.xpath("//*[@class='table-responsive']/table/tbody/tr[2]/td[2]")));

        Assertions.assertEquals(userPhone,
        driver.findElement(By.xpath("//*[@class='table-responsive']/table/tbody/tr[4]/td[2]")));

        Assertions.assertEquals(userSubject,
        driver.findElement(By.xpath("//*[@class='table-responsive']/table/tbody/tr[6]/td[2]")));

        Assertions.assertEquals(userCurrentAddress,
        driver.findElement(By.xpath("//*[@class='table-responsive']/table/tbody/tr[9]/td[2]")));

        Assertions.assertEquals(userState + " " + userCity,
        driver.findElement(By.xpath("//*[@class='table-responsive']/table/tbody/tr[10]/td[2]")));

        driver.quit();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
