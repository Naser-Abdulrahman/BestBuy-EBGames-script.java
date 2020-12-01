package AutoBuyer;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

///Naser Abdulrahman

public class script {
    public static String url;
    public static String url2;
    private static WebDriver bb;
    private static WebDriver eb;


        public static void oBB () {
            bb = new ChromeDriver();
            WebDriverWait waiting = new WebDriverWait(bb,10);
            bb.get(url);
            chooseConsole(bb,waiting);
        }
        public static void oEB() {
            eb = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(eb,10);
            eb.get(url);
            ebCheckout(eb,wait);
        }
        public static void refresher(){
            bb = new ChromeDriver();
            eb = new ChromeDriver();
            WebDriverWait waitBB = new WebDriverWait(bb,10);
            WebDriverWait waitEB = new WebDriverWait(eb,10);
            bb.get(url);
            eb.get(url2);
            WebElement bbAdd = bb.findElement(By.xpath("//button[contains(.,'Add to Cart')]"));
            try {
                eb.findElement(By.xpath("//body/div[11]/div[1]/button[1]")).click();
            } catch (Exception e){
                System.out.println("No alert");
            }
            WebElement goToCart = eb.findElement(By.id("btnAddToCart"));
            for ( ; ; ) {
                if (bbAdd.isEnabled()){
                    bbAdd.click();
                    eb.close();
                    bbCheckout(bb,waitBB);
                    break;
                } else if(goToCart.isDisplayed()){
                    bb.close();
                    ebCheckout(eb,waitEB);
                    break;
                } else {
                    bb.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
                    eb.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
                    bb.navigate().refresh();
                    bbAdd = bb.findElement(By.xpath("//button[contains(.,'Add to Cart')]"));
                    eb.navigate().refresh();
                    try {
                        eb.findElement(By.xpath("//body/div[11]/div[1]/button[1]")).click();
                    } catch (Exception e){
                        System.out.println("No alert");
                    }
                    goToCart = eb.findElement(By.id("btnAddToCart"));
                }
            }

        }
        /*
        This method will search for PS5 then depending on the radiobutton choice, will search for that specific console.
         */
        public static void chooseConsole(WebDriver driver, WebDriverWait waiting) {
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                WebElement addToCart = driver.findElement(By.xpath("//button[contains(.,'Add to Cart')]"));
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
                bbCheckout(driver, waiting);
        }
        /*
        This method checks out the console, then will wait for the "item has been added to cart" notification, then will continue to the cart
        and select self checkout. Without the wait, we can go to the cart before BestBuy processes and adds it. And will checkout with nothing
         */
        private static void ebCheckout(WebDriver driver, WebDriverWait waiting) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            try {
                driver.findElement(By.xpath("//body/div[11]/div[1]/button[1]")).click();
            } catch (Exception e){
                System.out.println("No alert");
            }
            waiting.until(ExpectedConditions.elementToBeClickable(By.id("btnAddToCart")));
            WebElement goToCart = driver.findElement(By.id("btnAddToCart"));
            goToCart.click();
            waiting.until(ExpectedConditions.elementToBeClickable(By.id("productGoToCart")));
            driver.findElement(By.id("productGoToCart")).click();
            waiting.until(ExpectedConditions.elementToBeClickable(By.id("cartGoToCheckout")));
            driver.findElement(By.id("cartGoToCheckout")).click();
            waiting.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[3]/div/a/button")));
            driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[3]/div/a/button")).click();
            ebShipping(driver,waiting);
        }
        private static void bbCheckout (WebDriver driver, WebDriverWait waiting) {
                waiting.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[1]/div/div/div[1]/div/div/p")));
                WebElement checkout = driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]"));
                checkout.click();
                driver.navigate().to("https://www.bestbuy.ca/en-ca/basket");
                waiting.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[2]/section/div/section/section[2]/div[2]/div/a")));
                WebElement contin = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[2]/section/div/section/section[2]/div[2]/div/a"));
                contin.click();
                waiting.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div/div[2]/div/div[2]")));
                WebElement guest = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div/div[2]/div/div[2]/a"));
                guest.click();
                bbShipping(driver, waiting);
        }
        /*
        Adds the user information from the GUI to the shipping screen
         */
        public static void ebShipping(WebDriver driver,WebDriverWait waiting){
            waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-delivery-details/div/div/div/div/div/div/app-home-delivery/div/app-gs-address/form/div")));
            driver.findElement(By.xpath("/html/body/app-root/app-delivery-details/div/div/div/div/div/div/app-home-delivery/div/app-gs-address/form/div/div[1]/input")).sendKeys(userInfoForm.getFname());
            driver.findElement(By.xpath("/html/body/app-root/app-delivery-details/div/div/div/div/div/div/app-home-delivery/div/app-gs-address/form/div/div[2]/input")).sendKeys(userInfoForm.getLname());
            driver.findElement(By.id("addressPhoneNumber")).sendKeys(userInfoForm.getPhone());
            driver.findElement(By.id("addressLine1")).sendKeys(userInfoForm.getAddy());
            driver.findElement(By.id("addressZip")).sendKeys(userInfoForm.getPostal());
            driver.findElement(By.id("addressCity")).sendKeys(userInfoForm.getCity());
            Select province = new Select(driver.findElement(By.id("addressProvince")));
            province.selectByVisibleText(userInfoForm.getProv());
            waiting.until(ExpectedConditions.elementToBeClickable(By.id("addressGoToShippingOptions")));
            driver.findElement(By.id("addressGoToShippingOptions")).click();
            waiting.until(ExpectedConditions.elementToBeClickable(By.id("deliveryGoToPaymentOptions")));
            driver.findElement(By.id("deliveryGoToPaymentOptions")).click();
            EBpayment(driver, waiting);
        }
        public static void bbShipping(WebDriver driver, WebDriverWait waiting){
                waiting.until(ExpectedConditions.elementToBeClickable(By.id("email")));
                WebElement email = driver.findElement(By.id("email"));
                email.sendKeys(userInfoForm.email);
                WebElement FName = driver.findElement(By.id("firstName"));
                FName.sendKeys(userInfoForm.getFname());
                WebElement lastName = driver.findElement(By.id("lastName"));
                lastName.sendKeys(userInfoForm.getLname());
                WebElement address = driver.findElement(By.id("addressLine"));
                address.sendKeys(userInfoForm.getAddy());
                Select province = new Select(driver.findElement(By.id("regionCode")));
                province.selectByVisibleText(userInfoForm.getProv());
                WebElement post = driver.findElement(By.id("postalCode"));
                post.sendKeys(userInfoForm.getPostal());
                WebElement ephone = driver.findElement(By.id("phone"));
                ephone.sendKeys(userInfoForm.getPhone());
                WebElement ecity = driver.findElement(By.id("city"));
                ecity.sendKeys(userInfoForm.getCity());
                WebElement con = driver.findElement(By.xpath("//button[contains(.,'Continue')]"));
                con.click();
                bbPayment(driver,waiting);
        }
        /*
        Adds the payment information and checks out
         */
        public static void EBpayment(WebDriver driver, WebDriverWait waiting) {
            waiting.until(ExpectedConditions.elementToBeClickable(By.id("paymentTypeCreditCard")));
            driver.findElement(By.id("paymentTypeCreditCard")).click();
            waiting.until(ExpectedConditions.elementToBeClickable(By.id("txtNameOnCard")));
            driver.findElement(By.id("txtNameOnCard")).sendKeys(userInfoForm.getFname() + " " + userInfoForm.getLname());
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            waiting.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/app-root[1]/app-payment[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/app-cybersource[1]/div[1]/iframe[1]")));
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-payment[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/app-cybersource[1]/div[1]/iframe[1]")).sendKeys(userInfoForm.getCc());
            Select ccm = new Select(driver.findElement(By.id("ccExpMonth")));
            ccm.selectByVisibleText(userInfoForm.getEmonth());
            Select ccy = new Select(driver.findElement(By.id("ccExpYear")));
            ccy.selectByVisibleText(userInfoForm.getEyear());
            driver.findElement(By.name("ccCCV")).sendKeys(userInfoForm.getCvv());
            waiting.until(ExpectedConditions.elementToBeClickable(By.id("creditCardPayButton")));
            driver.findElement(By.id("creditCardPayButton")).click();
            waiting.until(ExpectedConditions.elementToBeClickable(By.name("txtEmail")));
            driver.findElement(By.name("txtEmail")).sendKeys(userInfoForm.getEmail());
            driver.findElement(By.xpath("/html/body/app-root/app-review-order/div/div/div/div/div/div/div/div/div[1]/app-gs-checkbox/div/label/span[3]")).click();
            driver.findElement(By.id("reviewOrderConfirm")).click();
            //driver.close();
        }
        public static void bbPayment(WebDriver driver, WebDriverWait waiting){
                waiting.until(ExpectedConditions.elementToBeClickable(By.id("shownCardNumber")));
                WebElement cardNumber = driver.findElement(By.id("shownCardNumber"));
                cardNumber.sendKeys(userInfoForm.getCc());
                Select month = new Select(driver.findElement(By.id("expirationMonth")));
                month.selectByVisibleText(userInfoForm.getEmonth());
                Select year = new Select((driver.findElement(By.id("expirationYear"))));
                year.selectByVisibleText(userInfoForm.getEyear());
                WebElement ecvv = driver.findElement(By.id("cvv"));
                ecvv.sendKeys(userInfoForm.getCvv());
                WebElement con2 = driver.findElement(By.xpath("//button[contains(.,'Continue')]"));
                con2.click();
                waiting.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"posElement\"]/section/section[1]/button")));
                driver.findElement(By.xpath("//*[@id=\"posElement\"]/section/section[1]/button")).click();
                //driver.close();
        }
        /*
        Loads the website and calls the other methods
         */
        public static void buyConsole(){
           //     WebDriver driver = new ChromeDriver();
                WebDriver driver2 = new ChromeDriver();
            //    WebDriverWait waiting = new WebDriverWait(driver,10);
                WebDriverWait waitingEB = new WebDriverWait(driver2,15);
           //     driver.get(url);
                driver2.get("https://www.ebgames.ca/PS5/Games/877522");
                ebCheckout(driver2,waitingEB);
           //     chooseConsole(driver,waiting);
           //     checkout(driver,waiting);
           //     shipping(driver);
            //    payment(driver,waiting);
                //driver.close(); //uncomment this line to close the application after checkout
        }

        public static void main(String[] args){
            System.setProperty("webdriver.chrome.driver","chromedriver.exe");
            userInfoForm input = new userInfoForm();
    }
}
