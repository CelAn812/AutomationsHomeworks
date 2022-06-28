package ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

//Test Cases
//1) Test Ebay Home Page
//2) Test Sign in
//3) Test Search Bar
//4) Test Shopping Cart
//5) Test Sign up
//6) Test Menu
//7) Test Sales
//8) Test Ebay Logo
//9) Test Saved
//10) Test Shop By Category

public class HomePage {

    static WebDriver driver;
    //    String browserName="chrome";
    String browserName="firefox";
    String url="https://www.ebay.com/";

    @BeforeTest
    public static void startAutomation(){
        System.out.println("**** Our Automation Starts Now ****");
    }
    @AfterTest
    public static void tearDownAutomation(){
        System.out.println("**** Automation Ended ****");
    }

    @BeforeTest
    public void setUp(){
        if(this.browserName=="chrome"){
            setUpChromeBrowser();
        }else{
            setUpFireFoxBrowser();
        }
        driver.get(this.url);
        driver.manage().window().maximize();
    }


    public static void setUpChromeBrowser(){
        String chromeBrowserPath="browserDrivers/chromeWebDriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromeBrowserPath);
        driver=new ChromeDriver();
    }
    public static void setUpFireFoxBrowser(){
        String fireFoxBrowserPath="browserDrivers/geckoWebDriver/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver",fireFoxBrowserPath);
        driver=new FirefoxDriver();
    }
    @Test
    public static void testHomePage(){
        String expectedTitle="Electronics, Cars, Fashion, Collectibles & More | eBay";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle,"wrong web page title");
    }
    @Test
    public static void testSearchBar(){
        testHomePage();
        driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("la vie est belle");
        driver.findElement(By.id("gh-btn")).click();
        System.out.println(driver.getTitle());

    }
    @Test
    public static void testEmptyShoppingCart(){
        testHomePage();
        driver.findElement(By.className("gh-cart-icon")).click();
        String actualText=driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[1]/div/div[1]/span/span/span")).getText();
        String expectedText="You don't have any items in your cart.";
        Assert.assertEquals(actualText,expectedText,"text doesn't match");


    }
    @Test
    public static void testUserIsAbleToAddToCart() throws InterruptedException {
        testHomePage();
        testSearchBar();
        driver.findElement(By.cssSelector("#srp-river-results > ul > li:nth-child(3) > div > div.s-item__image-section > div > a > div > img")).click();
//        String expectedItemTitle="La Vie Est Belle Eau de Parfum Perfume Spray for WOMENS 3.4 OZ 100ml NEW SEALED!";
//        String actualItemTitle= driver.findElement(By.cssSelector("#LeftSummaryPanel > div.vi-swc-lsp > div:nth-child(1) > div > h1 > span"));
//        Assert.assertEquals(actualItemTitle,expectedItemTitle,"item title doesn't match");
//        Thread.sleep(10000);
        String parentW= driver.getWindowHandle();
        System.out.println("parentTitle= "+driver.getTitle());
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> iterator= windows.iterator();
        String childW = iterator.next();
//        driver.switchTo().window(childW);//considers it parent
//      while(iterator.hasNext()) {
//          String childW = iterator.next();
//          if (!parentW.equalsIgnoreCase(childW)) {
//              driver.switchTo().window(childW);
//          }
//      }
        System.out.println("childTitle= "+driver.getTitle());
//        driver.findElement(By.xpath("//*[@id=\"atcRedesignId_btn\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"atcRedesignId_btn\"]")).click();

    }
    @Test
    public static void testSignInWithWrongUserName(){
    testHomePage();
    driver.findElement(By.linkText("Sign in")).click();
    String expectedTitle="Sign in or Register | eBay";
    String actualTitle= driver.getTitle();
    Assert.assertEquals(actualTitle,expectedTitle,"wrong page");
    driver.findElement(By.id("userid")).sendKeys("invalidUsername");
    driver.findElement(By.id("signin-continue-btn")).click();
    String expectedTexteError="Oops, that's not a match.";
    String actualTextError=driver.findElement(By.id("signin-error-msg")).getText();
    Assert.assertEquals(actualTextError,expectedTexteError);

    }
    @Test
    public static void testSignInWithValidCredentials(){
        testHomePage();
        driver.findElement(By.linkText("Sign in")).click();
        String expectedTitle="Sign in or Register | eBay";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"wrong page");
        driver.findElement(By.id("userid")).sendKeys("validUsername");
        driver.findElement(By.id("signin-continue-btn")).click();
//        String expectedText="Welcome";
//        String actualText=driver.findElement(By.xpath("//*[@id=\"welcome-msg\"]")).getText();
//        Assert.assertEquals(actualText,expectedText,"wrong page");
        driver.findElement(By.id("pass")).sendKeys("validPassword");//element is not reachable by keyboard???
        driver.findElement(By.id("sgnBt")).click();


    }
}
