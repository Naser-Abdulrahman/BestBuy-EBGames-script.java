# ps5BestBuy 

To use this program, run the script.bat file. This script needs the chromedriver to run properly, since it uses Selenium WebDriver and chromedriver is needed to run and manipulate Google Chrome. This will not work if you are logged into BestBuy with an account, since it's coded to skip the log in page. Please sign out before running script.

This script will ask for your shipping and payment information, and then launch the BestBuy.ca and search for the PlayStation 5 console. 
It'll open the product page and try to add it to the cart every minute until available, refreshing the page whenever the add to cart button is disabled. 
Once added, it will checkout and pay with the information provided in the User Information form. 

Please format the information in the way presented in the textbox, this program will not check if the information is correct and will run into an error if it encounters a BestBuy error 

Ex; phone number must be in this format, 9051234567, and not like this, (905)123-4567 or any other way. 
Province must be spelled out, and not written with abbreviations (ex: Ontario vs ON, British Columbia vs BC); 
Do not add dashes in your credit card number. 

Assuming all information is entered properly, the program ill checkout with no problem. 
