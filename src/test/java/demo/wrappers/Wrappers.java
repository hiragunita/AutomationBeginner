package demo.wrappers;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wrappers {
    ChromeDriver driver;
    WebDriverWait wait;

    public Wrappers(ChromeDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void fillTextbox(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public void textwhyQA(By locator, String textQA) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(textQA);
    }

    public void basicSelection(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void selectAddressuse(String text) {
        try {
            WebElement addressElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R']")));
            addressElement.click();
            WebElement addressDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='OA0qNb ncFHed QXL7Te']")));
            List<WebElement> addressOptions = addressDropdown.findElements(By.xpath(".//div/span"));
            for (WebElement element : addressOptions) {
                if (element.getText().equalsIgnoreCase(text)) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error in selectAddressuse: " + e.getMessage());
        }
    }

    public void selectTime(By hourLocator, By minuteLocator, String hour, String minute) {
        WebElement hourField = wait.until(ExpectedConditions.visibilityOfElementLocated(hourLocator));
        WebElement minuteField = wait.until(ExpectedConditions.visibilityOfElementLocated(minuteLocator));
        hourField.sendKeys(hour);
        minuteField.sendKeys(minute);
    }

    public void submitButton(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}


// package demo.wrappers;

// import java.util.List;

// import org.openqa.selenium.By;
// import org.openqa.selenium.JavascriptExecutor;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;

// public class Wrappers {
//     ChromeDriver driver;

//     //Use Wrapper for each Action.
//     public Wrappers(ChromeDriver driver){
//         this.driver = driver;
//     }

//     // Navigate to this google form.
//     public void navigateToUrl(String url){
//         driver.get(url);
//     }

//     //Fill in Crio Learner in the 1st text box.
//     public void fillTextbox(By locator, String text){
//         WebElement nameBox = driver.findElement(locator);
//         nameBox.clear();
//         nameBox.sendKeys(text);
//     }
    
//     //Write down "I want to be the best QA Engineer! 1710572021'' where 1710572021 is variable - needs to be the current epoch time.
//     public void textwhyQA(By locator, String textQA){
//         WebElement textwhyQA = driver.findElement(locator);
//         textwhyQA.clear();
//         textwhyQA.sendKeys(textQA);
//     }

//     //Enter your Automation Testing experience in the next radio button and  //Select Java, Selenium and TestNG from the next check-box
//     public void basicSelection(By locator){
//         WebElement radioChekboxselection = driver.findElement(locator);
//         if(!radioChekboxselection.isSelected()){
//             radioChekboxselection.click();
//         }
//     }

//     //Select Java, Selenium and TestNG from the next check-box
//     // public void checkBoxes(By locator){
//     //     WebElement checkBoxesselection = driver.findElement(locator);
//     //     if(!checkBoxesselection.isSelected()){
//     //         checkBoxesselection.click();
//     //     }
//     //}

//     //Provide how you would like to be addressed in the next dropdown
//     public void selectAddressuse(String text) {
//         try {
//             WebElement addressElement = driver.findElement(By.xpath("//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R']"));
//             addressElement.click();
//             WebElement addressDropdown = driver.findElement(By.xpath("//div[@class='OA0qNb ncFHed QXL7Te']"));
//             List<WebElement> addressOptions = addressDropdown.findElements(By.xpath(".//div/span"));
//             for (WebElement element : addressOptions) {
//                 if (element.getText().equalsIgnoreCase(text)) {
//                     ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//                     break;
//                 }
//             }
//         } catch (Exception e) {
//             System.out.println("Error in selectAddressuse: " + e.getMessage());
//         }
//     }
// //     public void dropDownClick(String dropdownOption) {
// //         try {
// //             WebElement dropdownSelection = driver.findElement(By.xpath("(//div[@class='MocG8c HZ3kWc mhLiyf OIC90c LMgvRb' and @data-value='Ms']/span\r\n" + //
// // ""));
// //             dropdownSelection.click();
// //         } catch (Exception e) {
// //             System.out.println("Error in dropDownClick: " + e.getMessage());
// //         }
// //     }

//     //Provided the current date minus 7 days in the next date field, it should be dynamically calculated and not hardcoded.

//     //Provide the time 07:30 in the next field (Can also be in 24 hour clock)
//     public void selectTime(By hourLocator, By minuteLocator, String hour, String minute) {
//         WebElement hourField = driver.findElement(hourLocator);
//         WebElement minuteField = driver.findElement(minuteLocator);
//         hourField.sendKeys(hour);
//         minuteField.sendKeys(minute);
//     }
//     //Submit the form
//     public void submitButton(By locator){
//         driver.findElement(locator).click();
//     }

//     //You will see a success message on the website. Print the same message on the console upon successful completion
//     public String getText(WebElement element){
//         return element.getText();
//     }

//     public void clickOnElement(WebElement element) {
//         element.click();
//     }
//     /*
//      * Write your selenium wrappers here
//      */
// }
