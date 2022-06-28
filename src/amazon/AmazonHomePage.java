package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonHomePage {
    static WebDriver driver;
    String browserName="chrome";
    String url="https://www.amazon.com/";

    //    static String browserName;
    @BeforeTest
    public void setUpAutomation() {
        System.out.println("********** Automation Started ************");
    }

    @AfterTest
    public void tearDownAutomation() {
        System.out.println("********** Automation Ended ************");
    }


    @BeforeTest
    public void setUp(/*String browserName, String url*/) {
        if (this.browserName == "chrome") {
            setUpChromeBrowser();
        } else if (this.browserName == "firefox") {
            setUpFireFoxBrowser();
        }
        driver.get(this.url);
        driver.manage().window().maximize();
    }

    public static void setUpChromeBrowser() {
        String chromeDriverPath = "../Learn_WebAutomation/browserDriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
//        driver.get("https://www.amazon.com/");
//        driver.manage().window().maximize();

    }

    public static void setUpFireFoxBrowser() {
        String fireFoxDriverPath = "../Learn_WebAutomation/browserDriver/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", fireFoxDriverPath);
//        WebDriver driver = new FirefoxDriver();
        driver = new FirefoxDriver();
//        driver.get("https://www.amazon.com/");
//        driver.manage().window().maximize();

    }


    @Test
    public static void testSearchBoxInChrome() /*throws InterruptedException*/ {
//        setUp("chrome", "https://www.amazon.com/");
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone 14");
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
        String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]")).getText();
        System.out.println("actual text=" + actualText);
        String expectedText = "\"iphone 14\"";
        System.out.println("expected text=" + expectedText);
        if (actualText.equals(expectedText)) {
            System.out.println("+Test Passed+");
        } else {
            System.out.println("-Test Failed-");
        }
        String actualProductName = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).getText();
        String expectedProductName = "Apple iPhone 13 Pro Max, 128GB, Sierra Blue - Unlocked (Renewed)";
        System.out.println("actual product name=" + actualProductName);
        System.out.println("expected product name=" + expectedProductName);
        if (actualProductName.equals(expectedProductName)) {
            System.out.println("*Test Passed*");
        } else {
            System.out.println("-Test Failed-");
        }
//        Thread.sleep(1000);
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("flowers decoration");

//        driver.close();
    }

    @Test(enabled = false)
    public static void testSearchBoxInFireFox() throws InterruptedException{
//        Thread.sleep(1000);
//        setUp("firefox", "https://www.amazon.com/");
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone 14");
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
        String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]")).getText();
        System.out.println("actual text=" + actualText);
        String expectedText = "\"iphone 14\"";
        System.out.println("expected text=" + expectedText);
        if (actualText.equals(expectedText)) {
            System.out.println("+Test Passed+");
        } else {
            System.out.println("-Test Failed-");
        }
        String actualProductName = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).getText();
        String expectedProductName = "Apple iPhone 13 Pro Max, 128GB, Sierra Blue - Unlocked (Renewed)";
        System.out.println("actual product name=" + actualProductName);
        System.out.println("expected product name=" + expectedProductName);
        if (actualProductName.equals(expectedProductName)) {
            System.out.println("*Test Passed*");
        } else {
            System.out.println("-Test Failed-");
        }
//        Thread.sleep(1000);
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("flowers decoration");

//        driver.close();
    }

    /**
     * This test method wil verify successful sign in using valid credentials
     * @throws InterruptedException
     */
    @Test
    public static void testSignIn() throws InterruptedException {
//        setUp("chrome", "https://www.amazon.com/");
    driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
    driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("user");
    driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("validPass");
    driver.findElement(By.id("signInSubmit")).click();
    String expectedText="Hello, celia";
    String actualText= driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).getText();
    Assert.assertEquals(actualText,expectedText,"Sign in not successful");
    String expectedPageTitle="Amazon.com. Spend less. Smile more.";
    String actualPageTitle=driver.getTitle();
    Assert.assertEquals(expectedPageTitle,actualPageTitle,"page title doesn't match");
    Thread.sleep(1000);
    driver.close();
    }
    /**
     * This test method wil verify unsuccessful sign in using invalid credentials
     * @throws InterruptedException
     */
    @Test
    public static void testWrongSignIn() throws InterruptedException {
//        setUp("chrome", "https://www.amazon.com/");
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
//        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("user");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Wrongpassword");
        driver.findElement(By.id("signInSubmit")).click();
//        String expectedText="Hello, celia";
//        String actualText= driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).getText();
//        Assert.assertEquals(actualText,expectedText,"Sign in not successful");
        String expectedText="There was a problem";
        String actualText=driver.findElement(By.className("a-alert-heading")).getText();
        Assert.assertEquals(actualText,expectedText,"login successful");
        Thread.sleep(1000);
        driver.close();
    }
}
