package demo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;
    Wrappers actions;

    /*
     * TODO: Write your tests here with testng @Test annotation.
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

    
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        //WebDriverManager.chromedriver().timeout(30).setup();
        //WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        actions = new Wrappers(driver);
        //WebDriverWait wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testCase01() throws InterruptedException{
        //Navigate to this google form.
        actions.navigateToUrl("https://forms.gle/wjPkzeSEk1CM7KgGA");
        actions.fillTextbox(By.xpath("(//input[@jsname ='YPqjbf' and @type = 'text'])[1]"), "Crio Learner");

        //Write down "I want to be the best QA Engineer! 1710572021'' where 1710572021 is variable - needs to be the current epoch time.
        String epoch = String.valueOf(Instant.now().getEpochSecond());
        actions.textwhyQA(By.xpath("//textarea[@jsname ='YPqjbf']"), "I want to be the best QA Engineer! " + epoch);

        //Enter your Automation Testing experience in the next radio button
        actions.basicSelection(By.xpath("//span[text() = '0 - 2']"));//div[@class ='bzfPab wFGF8']//span[text() = '0 - 2']
        Thread.sleep(1000);
        System.out.println("Echo2");

        //Select Java, Selenium and TestNG from the next check-box
        actions.basicSelection(By.xpath("//span[text() = 'Java']"));
        Thread.sleep(1000);
        actions.basicSelection(By.xpath("//span[text() = 'Selenium']"));
        Thread.sleep(1000);
        actions.basicSelection(By.xpath("//span[text() = 'TestNG']"));
        Thread.sleep(1000);

        //Provide how you would like to be addressed in the next dropdown
        // WebElement dropdownSelects = driver.findElement(By.xpath("//div[@jsname = 'LgbsSe']"));
        // Thread.sleep(15000);
        // actions.clickOnElement(dropdownSelects);
        // Thread.sleep(15000);
        // actions.selectAddressuse("Ms");
        // Thread.sleep(3000);
        actions.selectAddressuse("Ms");
        System.out.println("Echo3");
        
        // WebElement dropdownSelects = driver.findElement(By.xpath("//div[@jsname = 'LgbsSe']"));
        // dropdownSelects.click();
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].click();",dropdownSelects);
        // WebElement dropdownSelects = driver.findElement(By.xpath("//div[@jsname = 'LgbsSe']"));
        // actions.clickOnElement(dropdownSelects);
        // System.out.println("Echo4");
        // Thread.sleep(15000);
        // actions.selectAddressuse("Ms");
        // Thread.sleep(3000);
        // System.out.println("Echo5");

        //Provided the current date minus 7 days in the next date field, it should be dynamically calculated and not hardcoded.
        LocalDate currentDate = LocalDate.now();
        LocalDate pastDate = currentDate.minusDays(7);
        String requiredDate = pastDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Thread.sleep(3000);
        actions.fillTextbox(By.xpath("//input[@type = 'date']"), requiredDate);
        //System.out.println("Echo6");

        //Provide the time 07:30 in the next field (Can also be in 24 hour clock).
        actions.selectTime(By.xpath("(//input[@jsname ='YPqjbf'])[3]"), By.xpath("(//input[@jsname ='YPqjbf'])[4]"), "07" , "30");
        //System.out.println("Echo7");
        Thread.sleep(3000);
        
        //Submit the form.
        actions.submitButton(By.xpath("//span[text() = 'Submit']"));
        Thread.sleep(3000);
        //System.out.println("Echo8");

        //You will see a success message on the website. Print the same message on the console upon successful completion.
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = driver.findElement(By.xpath("//div[text() = 'Thanks for your response, Automation Wizard!']"));
        Thread.sleep(3000);
        //System.out.println("Echo9");
        String submissionMessage  = actions.getText(successMessage);
        Assert.assertEquals(submissionMessage, "Thanks for your response, Automation Wizard!");
        Thread.sleep(3000);

        System.out.println("Form submitted successfully: " + submissionMessage);
        //System.out.println("Echo10");
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}