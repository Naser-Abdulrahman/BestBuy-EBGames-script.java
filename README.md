# Outdated, might not work

# BestBuy-PS5-XBOX-script

To use this program, run the script.bat file. This script needs the chromedriver to run properly, since it uses Selenium WebDriver and chromedriver is needed to run and manipulate Google Chrome. This will not work if you are logged into BestBuy with an account, since it's coded to skip the login page. Please sign out before running script.

# Requirements
Java 11+

# Installation
This Repo has all necessary files, just clone or download the zip, keep all files together and it should work.

# How To Use
Enter all information required for shipping and payment, then select the desired console or pick other and enter your own link! Select the domain and the script will launch and go to the website, refreshing until the item is available. Once available, the script will checkout and purchase the desired item. 

Please format the information in the way presented in the text box, this program will not check if the information is correct and will run into an error if it encounters a BestBuy error. Do not add dashes in your credit card number. 

# How To Test
The Credit Card number is a fake, it was used only in testing. To try yourself; 

-Find an item on either BestBuy Canada or EB Games

-Enter the EXP as 12/30 (or google and use your own VISA/Mastercard generator)

-Select other and copy/paste the link in the text box, select the domain.

-Then script will run like normal until the website realizes the card won't work and ask for a new one. 


# Known errors

If no chrome browser opens when launching the script.bat, please update chrome, then it should work properly 
