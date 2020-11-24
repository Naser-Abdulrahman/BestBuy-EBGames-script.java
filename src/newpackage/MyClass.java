package newpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

///Naser Abdulrahman

public class MyClass {

    public static void main(String[] args){
            /////////////////////////////////////////////////////////////////
            //declaration of variables & launches browser
            /////////////////////////////////////////////////////////////////
            System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            WebDriverWait waiting = new WebDriverWait(driver,5);
            String baseUrl = "http://bestbuy.ca/en-ca";
            driver.get(baseUrl);
            WebElement search = driver.findElement(By.name("search"));

            ///////////////////////////////
            //searches for PS5
            ///////////////////////////////
            search.sendKeys("PS5");
            search.submit();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //////////////////////////////////////
            //Selecting Console and adding to cart
            //////////////////////////////////////
            WebElement console = driver.findElement(By.cssSelector("a[href = '/en-ca/product/playstation-5-digital-edition-console-online-only/14962184']"));
            //WebElement controller = driver.findElement(By.cssSelector("a[href = \"/en-ca/product/playstation-5-dualsense-wireless-controller-white/14962193\""));
            console.click();
            //controller.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement addToCart = driver.findElement(By.xpath("//button[contains(.,'Add to Cart')]"));
            if (addToCart.isEnabled()){
                System.out.println("Enabled");
            } else {
                System.out.println("Disabled");
            }


            //////////////////////////////////////////////////////////////////////////
            //forever loop that checks if the add to cart button is enabled or not///
            //if its not enabled the console will write disabled ///////////////////
            // and will wait 2 minutes for the page to refresh/////////////////////
            //if enabled the rest of the code resumes normally////////////////////
            /////////////////////////////////////////////////////////////////////
            for ( ; ; ) {

                    if ( addToCart.isEnabled()){
                            break;
                    }
                    else {
                            driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
                            driver.navigate().refresh();
                            waiting.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(.,'Add to Cart')]")));
                            addToCart = driver.findElement(By.xpath("//button[contains(.,'Add to Cart')]"));
                            System.out.println("Disabled");
                    }
            }
            addToCart.click();

            //////////////
            //Checking out
            //////////////
            waiting.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[1]/div/div/div[1]/div/div/p")));
            WebElement checkout = driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]"));
            checkout.click();
            driver.navigate().to("https://www.bestbuy.ca/en-ca/basket");
            waiting.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[2]/section/div/section/section[2]/div[2]/div/a")));
            WebElement contin = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[2]/section/div/section/section[2]/div[2]/div/a"));
            contin.click();

            ////////////////
            //Guest Checkout
            ////////////////
            waiting.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div/div[2]/div/div[2]")));
            WebElement guest = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div/div[2]/div/div[2]/a"));
            guest.click();


            /////////////////
            //Shipping Screen
            /////////////////
            WebElement email = driver.findElement(By.id("email"));
            email.sendKeys("fake.email@gmail.com");
            WebElement FName = driver.findElement(By.id("firstName"));
            FName.sendKeys("Naser");
            WebElement lastName = driver.findElement(By.id("lastName"));
            lastName.sendKeys("Abdulrahman");
            WebElement address = driver.findElement(By.id("addressLine"));
            address.sendKeys("374 Mohawk Rd E");
            Select province = new Select(driver.findElement(By.id("regionCode")));
            province.selectByVisibleText("Ontario");
            WebElement postal = driver.findElement(By.id("postalCode"));
            postal.sendKeys("L8V 2H7");
            WebElement phone = driver.findElement(By.id("phone"));
            phone.sendKeys("905-999-9999");
            WebElement con = driver.findElement(By.xpath("//button[contains(.,'Continue')]"));
            WebElement city = driver.findElement(By.id("city"));
            city.sendKeys("Hamilton");
            con.click();



            ////////////////////
            //Credit Card Screen
            ///////////////////
            waiting.until(ExpectedConditions.elementToBeClickable(By.id("shownCardNumber")));
            WebElement cardNumber = driver.findElement(By.id("shownCardNumber"));
            cardNumber.sendKeys("4111111111111111");
            Select month = new Select(driver.findElement(By.id("expirationMonth")));
            month.selectByVisibleText("12");
            Select year = new Select((driver.findElement(By.id("expirationYear"))));
            year.selectByVisibleText("2030");
            WebElement cvv = driver.findElement(By.id("cvv"));
            cvv.sendKeys("123");
            WebElement con2 = driver.findElement(By.xpath("//button[contains(.,'Continue')]"));
            con2.click();

            ////////////////////////
            //closes the application
            ////////////////////////
            // driver.close();
    }

}
