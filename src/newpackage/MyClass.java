package newpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.awt.Container;
import javax.swing.*;


///Naser Abdulrahman

public class MyClass {

    public static void main(String[] args){

            /*
            final JFrame parent = new JFrame("Personal Information");
            parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            parent.setBounds(0,0,400,600);
            Container container = parent.getContentPane();
            container.setLayout(null);

            JLabel name = new JLabel("First Name: ");
            name.setBounds(20,30,250,30);
            JTextField name1 = new JTextField();
            name1.setBounds(100,30,250,30);

            JLabel last_name = new JLabel("Last Name");
            last_name.setBounds(20,60,250,30);
            JTextField last1 = new JTextField();
            last1.setBounds(100,60,250,30);

            JLabel uaddress = new JLabel("Address: ");
            uaddress.setBounds(20,90,250,30);
            JTextField add1 = new JTextField();
            add1.setBounds(100,90,250,30);

            JLabel uprovince = new JLabel("Province");
            uprovince.setBounds(20,120,250,30);
            JTextField prov1 = new JTextField("Ontario");
            prov1.setBounds(100,120,250,30);

            JLabel postalCode = new JLabel("Postal Code");
            postalCode.setBounds(20,150,250,30);
            JTextField post = new JTextField();
            post.setBounds(100,150,250,30);

            JLabel uphone = new JLabel("Phone Number");
            uphone.setBounds(20,180,250,30);
            JTextField phone1 = new JTextField();
            phone1.setBounds(100,180,250,30);

            JLabel ccInfo = new JLabel("Credit Card #");
            ccInfo.setBounds(20,210,250,30);
            JTextField ccInfo1 = new JTextField();
            ccInfo1.setBounds(100,210,250,30);

            JLabel expMonth = new JLabel("Exp. Month");
            expMonth.setBounds(20,240,250,30);
            JTextField expMonth1 = new JTextField();
            expMonth1.setBounds(100,240,250,30);

            JLabel expYear = new JLabel("Exp. Year");
            expYear.setBounds(20,270,250,30);
            JTextField expYear1 = new JTextField();
            expYear1.setBounds(100,270,250,30);

            JLabel ccv = new JLabel("ccv");
            ccv.setBounds(20,300,250,30);
            JTextField ccv1 = new JTextField();
            ccv1.setBounds(100,300,250,30);

            JButton button = new JButton("Submit");
            button.setBounds(100,500,100,30);

            container.add(name);
            container.add(last_name);
            container.add(uaddress);
            container.add(uprovince);
            container.add(postalCode);
            container.add(uphone);
            container.add(name1);
            container.add(last1);
            container.add(add1);
            container.add(prov1);
            container.add(post);
            container.add(phone1);
            container.add(ccInfo);
            container.add(ccInfo1);
            container.add(expMonth);
            container.add(expMonth1);
            container.add(expYear);
            container.add(expYear1);
            container.add(ccv);
            container.add(ccv1);
            container.add(button);

            parent.setVisible(true);
*/


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


            //////////////////////////////////////////////////////////////////////////
            //forever loop that checks if the add to cart button is enabled or not///
            //if its not enabled the console will write disabled ///////////////////
            // and will wait 1 minute for the page to refresh//////////////////////
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
