package newpackage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.awt.Container;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
///Naser Abdulrahman

public class MyClass extends DocumentFilter{

        private static String uemail;
        private static String fname;
        private static String lname;
        private static String addy;
        private static String postal;
        private static String prov;
        private static String phone;
        private static String cc;
        private static String emonth;
        private static String eyear;
        private static String cvv;
        private static String ucity;
        private static String url;


        public static void buyPS5(){
                /////////////////////////////////////////////////////////////////
                //declaration of variables & launches browser
                /////////////////////////////////////////////////////////////////
                System.setProperty("webdriver.chrome.driver","chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                WebDriverWait waiting = new WebDriverWait(driver,10);
                String baseUrl = "http://bestbuy.ca/en-ca";
                driver.get(baseUrl);
                WebElement search = driver.findElement(By.name("search"));

                ///////////////////////////////
                //searches for PS5
                ///////////////////////////////
                search.sendKeys("PS5");
                search.submit();
                waiting.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href = '/en-ca/product/playstation-5-digital-edition-console-online-only/14962184']")));

                //////////////////////////////////////
                //Selecting Console and adding to cart
                //////////////////////////////////////
                WebElement console = driver.findElement(By.cssSelector(url));
               // WebElement controller = driver.findElement(By.cssSelector("a[href = \"/en-ca/product/playstation-5-dualsense-wireless-controller-white/14962193\""));
                console.click();
                //controller.click();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
                email.sendKeys(uemail);
                WebElement FName = driver.findElement(By.id("firstName"));
                FName.sendKeys(fname);
                WebElement lastName = driver.findElement(By.id("lastName"));
                lastName.sendKeys(lname);
                WebElement address = driver.findElement(By.id("addressLine"));
                address.sendKeys(addy);
                Select province = new Select(driver.findElement(By.id("regionCode")));
                province.selectByVisibleText(prov);
                WebElement post = driver.findElement(By.id("postalCode"));
                post.sendKeys(postal);
                WebElement ephone = driver.findElement(By.id("phone"));
                ephone.sendKeys(phone);
                WebElement ecity = driver.findElement(By.id("city"));
                ecity.sendKeys(ucity);
                WebElement con = driver.findElement(By.xpath("//button[contains(.,'Continue')]"));
                con.click();



                ////////////////////
                //Credit Card Screen
                ///////////////////
                waiting.until(ExpectedConditions.elementToBeClickable(By.id("shownCardNumber")));
                WebElement cardNumber = driver.findElement(By.id("shownCardNumber"));
                cardNumber.sendKeys(cc);
                Select month = new Select(driver.findElement(By.id("expirationMonth")));
                month.selectByVisibleText(emonth);
                Select year = new Select((driver.findElement(By.id("expirationYear"))));
                year.selectByVisibleText(eyear);
                WebElement ecvv = driver.findElement(By.id("cvv"));
                ecvv.sendKeys(cvv);
                WebElement con2 = driver.findElement(By.xpath("//button[contains(.,'Continue')]"));
                con2.click();

                //////////////////
                //Checkout Screen/
                //////////////////
                waiting.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"posElement\"]/section/section[1]/button")));
                driver.findElement(By.xpath("//*[@id=\"posElement\"]/section/section[1]/button")).click();

                ////////////////////////
                //closes the application
                ////////////////////////
                //driver.close(); //uncomment this line to close the application after checkout


        }
    public static void main(String[] args){

            ///////////////////////////
            //GUI for user information/
            ///////////////////////////
            final JFrame parent = new JFrame("User Information");
            parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            parent.setBounds(500,300,400,600);
            Container container = parent.getContentPane();
            container.setLayout(null);

            JLabel name = new JLabel("First Name: ");
            name.setBounds(20,30,250,30);
            JTextField name1 = new JTextField("First");
            name1.setBounds(100,30,250,30);

            JLabel last_name = new JLabel("Last Name");
            last_name.setBounds(20,60,250,30);
            JTextField last1 = new JTextField("Last");
            last1.setBounds(100,60,250,30);

            JLabel uaddress = new JLabel("Address: ");
            uaddress.setBounds(20,90,250,30);
            JTextField add1 = new JTextField("999 Upper Wentworth St");
            add1.setBounds(100,90,250,30);

            JLabel uprovince = new JLabel("Province");
            uprovince.setBounds(20,120,250,30);
            JTextField prov1 = new JTextField("Ontario");
            prov1.setBounds(100,120,250,30);

            JLabel town = new JLabel("City");
            town.setBounds(20,150,250,30);
            JTextField townl = new JTextField("Hamilton");
            townl.setBounds(100,150,250,30);

            JLabel postalCode = new JLabel("Postal Code");
            postalCode.setBounds(20,180,250,30);
            JTextField post = new JTextField("L9A 4X5");
            post.setBounds(100,180,250,30);

            JLabel uphone = new JLabel("Phone Number");
            uphone.setBounds(20,210,250,30);
            JTextField phone1 = new JTextField("9053874455");
            phone1.setBounds(100,210,250,30);
            ((AbstractDocument)phone1.getDocument()).setDocumentFilter(new DocumentFilter(){});

            JLabel ccInfo = new JLabel("Credit Card #");
            ccInfo.setBounds(20,240,250,30);
            JTextField ccInfo1 = new JTextField("4111111111111111");
            ccInfo1.setBounds(100,240,250,30);

            JLabel expMonth = new JLabel("Exp. Month");
            expMonth.setBounds(20,270,250,30);
            JTextField expMonth1 = new JTextField("12");
            expMonth1.setBounds(100,270,250,30);

            JLabel expYear = new JLabel("Exp. Year");
            expYear.setBounds(20,300,250,30);
            JTextField expYear1 = new JTextField("2030");
            expYear1.setBounds(100,300,250,30);

            JLabel ccv = new JLabel("ccv");
            ccv.setBounds(20,330,250,30);
            JTextField ccv1 = new JTextField("123");
            ccv1.setBounds(100,330,250,30);

            JLabel em = new JLabel("email");
            em.setBounds(20,360,250,30);
            JTextField em1 = new JTextField("youremail@domain.com");
            em1.setBounds(100,360,250,30);

            ButtonGroup type = new ButtonGroup();
            JRadioButton digital  = new JRadioButton();
            JRadioButton tray = new JRadioButton();
            digital.setText("PS5 Digital Version");
            tray.setText("PS5 with disk tray, more expensive one");
            digital.setBounds(20,390,250,30);
            tray.setBounds(20,410,250,30);
            type.add(tray);
            type.add(digital);


            JButton button = new JButton("Submit");
            button.setBounds(100,500,100,30);
            button.addActionListener(e -> {

                    fname = name1.getText();
                    lname = last1.getText();
                    addy = add1.getText();
                    postal = post.getText();
                    prov = prov1.getText();
                    phone = phone1.getText();
                    uemail = em1.getText();
                    cc = ccInfo1.getText();
                    emonth = expMonth1.getText();
                    eyear = expYear1.getText();
                    cvv = ccv1.getText();
                    ucity = townl.getText();
                    if (digital.isSelected()){
                            url = "a[href = '/en-ca/product/playstation-5-digital-edition-console-online-only/14962184']";
                    } else {
                            url = "a[href = '/en-ca/product/playstation-5-console-online-only/14962185']";
                    }
                    parent.dispose();
                    buyPS5();

            });

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
            container.add(town);
            container.add(townl);
            container.add(em);
            container.add(em1);
            container.add(tray);
            container.add(digital);
            parent.setVisible(true);

    }

}
