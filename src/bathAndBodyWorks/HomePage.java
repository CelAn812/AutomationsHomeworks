package bathAndBodyWorks;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomePage {
    static WebDriver driver;
//    String browserName="chrome";
    String browserName="firefox";
    String url="https://www.bathandbodyworks.com/";

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
    public static void testBathNBodyWorksHomePage() throws InterruptedException {
//    driver.findElement(By.className("dialog-content ui-dialog-content ui-widget-content"));
//        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//        Set<String> windows=driver.getWindowHandles();
//        Iterator<String> iterator= windows.iterator();
//        String parentWindow= iterator.next();
//        Thread.sleep(1000);
//        System.out.println("Parent "+driver.getTitle());
//        String popWindow=iterator.next();
//        driver.switchTo().window(popWindow);
//        System.out.println("Pop up "+driver.getTitle());
//        driver.close();
//        driver.switchTo().window(parentWindow);
//        driver.quit();

        driver.findElement(By.xpath("//*[@id=\"wrapper\"]"));
//        driver.findElement(By.className("dialog-content ui-dialog-content ui-widget-content"));
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();
//        Alert alert=driver.switchTo().alert();
//        alert.dismiss();
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[3]/div[1]/div[2]/ul/div/a/img")).click();
//        driver.findElement(By.xpath("//a[text()='Sign In or Sign Up']")).click();

    }
    @Test
    public static void testSearchBar() throws InterruptedException {
        testBathNBodyWorksHomePage();
        driver.findElement(By.id("q")).sendKeys("body lotion");
        driver.findElement(By.cssSelector("#headersearch > img")).click();
    }
    @Test
    public static void testHomeFragrance() throws InterruptedException {
       testBathNBodyWorksHomePage();
       WebElement homeFragrance=driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/nav/ul/li[4]/a"));
//        Select select=new Select(listEle);
//        select.selectByVisibleText(" Home Fragrance ");
        Actions action=new Actions(driver);
        action.doubleClick(homeFragrance).perform();
        String expectedTitle="Bath & Body Works: Body Care & Home Fragrances You'll Love";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"wrong page");
    }
//    @Test
//    public static void testHomeFragrance() throws InterruptedException {
//        testBathNBodyWorksHomePage();
//        WebElement homeFragrance=driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/nav/ul/li[4]/a"));
////        Select select=new Select(listEle);
////        select.selectByVisibleText(" Home Fragrance ");
//        Actions action=new Actions(driver);
//        action.doubleClick(homeFragrance).perform();
//        String expectedTitle="Bath & Body Works: Body Care & Home Fragrances You'll Love";
//        String actualTitle=driver.getTitle();
//        Assert.assertEquals(actualTitle,expectedTitle,"wrong page");
//    }

}
