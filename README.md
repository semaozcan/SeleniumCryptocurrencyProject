# Selenium Cryptocurrency Test Automation Project

## About the Project
This project is developed to automate certain actions on the Binance cryptocurrency exchange website using Selenium WebDriver and TestNG.

## Requirements
- Java Development Kit (JDK) 8 or above
- Maven
- Selenium WebDriver
- TestNG
- ChromeDriver

## Installation
1. Clone the project:

## Test Cases
1 - BinanceAvaxTest:
  * Go to the Binance main page.
    
    * Expected Outcome: The Binance main page should be successfully loaded.
  
  * Click on the Markets menu and select Market Overview.
    
    * Expected Outcome: The Market Overview page should be opened.
  
  * Find and click on AVAX/USDT from the Spot-Margin Markets > USDT list.
  
    * Expected Outcome: The AVAX/USDT page should be opened.
  * Verify that the page is opened correctly. 
    * Expected Outcome: The AVAX/USDT page should be displayed without any errors.
  

2 - BinanceInvalidLoginTest:
  * Go to the Binance main page.
    * Expected Outcome: The Binance main page should be successfully loaded.
  * Click on Spot from the Buy-Sell menu.
    * Expected Outcome: The Spot trading page should be opened.
  * Click on the Login button.
    * Expected Outcome: The login page should be opened.
  * Attempt to login with incorrect credentials and verify the error message.
    * Expected Outcome: An error message should be displayed indicating incorrect login information.



3 - BinanceRandomLinksTest:
      
* Go to the Binance main page.
    * Expected Outcome: The Binance main page should be successfully loaded.
* Click on random 5 out of 14 links listed under About Us at the bottom of the page.
    * Expected Outcome: Each clicked link should open a page without any errors.
      

4 - BinanceGetDataToExcelTest:

* Go to the Binance main page.
  * Expected Outcome: The Binance main page should be successfully loaded.
* Click on the Markets menu and select Market Overview.
  * Expected Outcome: The Market Overview page should be opened.
* Select All Cryptos > All and sort by 24-hour volume.
  * Expected Outcome: The list of cryptocurrencies should be sorted by 24-hour volume.
* Transfer the first 3 pages of the listed coins to an Excel file with coin name, price change percentage, and volume information.
  * Expected Outcome: The Excel file should contain the required information for the first 3 pages of listed coins.