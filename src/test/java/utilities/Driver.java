package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
NOTE: all of our current codes still works, because this driver is class is good for squential and parallel testing
 */
public class Driver {
    private Driver(){}
    //    private static WebDriver driver;
//    1. Use ThreadLocal WebDriver for parallel testing.
//    Type of the driver is still WebDriver, but this driver is now ThreadLocal
//    driver is thread safe variable to make sure each thread can create a copy of its own driver instance
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //    2 Driver.getDriver() will be used in the test classes
//    This will return copy of the driver instance for each thread(browser)
    public static WebDriver getDriver(){
        if (driver.get()==null){
            initializeDriver();
        }
        return driver.get();
    }

    //    3. initialize the WebDriver instance
    public static void initializeDriver(){
        switch (ConfigReader.getProperty("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
//                    driver=new ChromeDriver();
                driver.set(ThreadGuard.protect(new ChromeDriver()));
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(ThreadGuard.protect(new FirefoxDriver()));
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(ThreadGuard.protect(new EdgeDriver()));
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver.set(ThreadGuard.protect(new SafariDriver()));
                break;
            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                driver.set(ThreadGuard.protect(new ChromeDriver(new ChromeOptions().addArguments("--headless=new"))));
                break;
        }

//            driver -> driver.get()
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get().manage().window().maximize();
    }
    //    4. close driver
    public static void closeDriver(){
        if (driver!=null){
            driver.get().quit();
            driver.remove();
        }
    }
    public static void dropdownSelectByIndex(By locator, int index){
        WebElement dropdownElement = driver.get().findElement((locator));
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
    }
    public static void dropdownSelectByIndex(String xpath,int index){
        WebElement dropdownElement = driver.get().findElement((By.xpath(xpath)));
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
    }
    public static void dropdownSelectByVisibleText(WebElement dropdownElement, String text){
        Select select =new Select(dropdownElement);
        for (int i =0;i<select.getOptions().size();i++){
            if(select.getOptions().get(i).getText().equalsIgnoreCase(text)){
                select.getOptions().get(i).click();
                break;
            }
        }
    }
    public static void dropdownSelectByValue(WebElement dropdownElement, String value) {
        Select objSelect = new Select(dropdownElement);
        objSelect.selectByValue(value);
    }
    public static void dropdownSelectCustomMethod(WebElement dropdownElement,String textOfDropdown){
        List<WebElement> options = dropdownElement.findElements(By.tagName("option"));
        for (WebElement option : options){
            System.out.println(option.getText());
            if (option.getText().equals(textOfDropdown)){
                option.click();
                break;
            }
        }
    }
    public static WebElement dropdownSelectRandomly(Select select) {
        Random random = new Random();
        List<WebElement> list = select.getOptions();
        int optionIndex = 1 + random.nextInt(list.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }
    public ArrayList<String> dropdownGetSelectedOptions(WebElement dropdownElement) throws Exception {
        if (dropdownElement!=null){
            Select list = new Select(dropdownElement);
            ArrayList<WebElement> allSelectedOptions = (ArrayList<WebElement>) list.getAllSelectedOptions();
            ArrayList<String> result = new ArrayList<String>();
            for (WebElement eachSelected : allSelectedOptions){
                result.add(eachSelected.getText());
            }
            return result;
        }


        return null;
    }
}