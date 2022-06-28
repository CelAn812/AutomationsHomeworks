package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonHomePage2 {
    public static void main(String[] args) {
        String driverPath = "../Learn_WebAutomation/browserDriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("flowers decoration");
//        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.manage().window().maximize();
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

        driver.close();


    }

}
