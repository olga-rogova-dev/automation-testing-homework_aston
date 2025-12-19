package lesson10;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsOnlineTopUpPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MtsOnlineTopUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void open() {
        driver.get("https://www.mts.by/");
    }

    private final By blockRoot = By.xpath(
            "//h2[contains(.,'Онлайн пополнение без комиссии')]/ancestor::section");

    private WebElement block() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockRoot));
    }

    private final By blockTitle = By.xpath(".//h2[contains(normalize-space(),'Онлайн пополнение без комиссии')]");
    private final By visaLogo = By.xpath(".//img[contains(@src,'visa.svg')]");
    private final By verifiedVisaLogo = By.xpath(".//img[@alt='Verified By Visa']");
    private final By mcLogo = By.xpath(".//img[contains(@src,'mastercard.svg')]");
    private final By mcSecureLogo = By.xpath(".//img[@alt='MasterCard Secure Code']");
    private final By belkartLogo = By.xpath(".//img[contains(@src,'belkart.svg')]");
    private final By moreInfoLink = By.xpath(".//a[contains(normalize-space(),'Подробнее о сервисе')]");

    public boolean isBlockTitleVisible() {
        return block().findElement(blockTitle).isDisplayed();
    }

    public boolean isVisaLogoVisible() {
        return block().findElement(visaLogo).isDisplayed();
    }

    public boolean isVerifiedVisaLogoVisible() {
        return block().findElement(verifiedVisaLogo).isDisplayed();
    }

    public boolean isMastercardLogoVisible() {
        return block().findElement(mcLogo).isDisplayed();
    }

    public boolean isMastercardSecureVisible() {
        return block().findElement(mcSecureLogo).isDisplayed();
    }

    public boolean isBelkartLogoVisible() {
        return block().findElement(belkartLogo).isDisplayed();
    }

    public void clickMoreInfo() {
        WebElement link = block().findElement(moreInfoLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
    }

    public void openInternetDirect() {
        driver.get("https://www.mts.by/?product=home_internet");
    }

    public void openInstalmentDirect() {
        driver.get("https://www.mts.by/?product=instalment");
    }

    public void openArrearsDirect() {
        driver.get("https://www.mts.by/?product=arrears");
    }

    public void openConnectionTab() {
    }

    private final By connectionPhone = By.cssSelector("form#pay-connection input#connection-phone.phone");
    private final By connectionSum = By.cssSelector("form#pay-connection input#connection-sum.total_rub");
    private final By connectionEmail = By.cssSelector("form#pay-connection input#connection-email.email");
    private final By connectionSubmit = By.cssSelector("form#pay-connection button[type='submit']");
    private final By connectionForm = By.id("pay-connection");

    public void fillConnectionPhone(String phone) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(connectionPhone));
        el.clear();
        el.sendKeys(phone);
    }

    public void fillConnectionSum(String sum) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(connectionSum));
        el.clear();
        el.sendKeys(sum);
    }

    public void fillConnectionEmail(String email) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(connectionEmail));
        el.clear();
        el.sendKeys(email);
    }

    public void submitConnection() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(connectionSubmit));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    public boolean isConnectionFormOpened() {
        WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(connectionForm));
        return form.getAttribute("class").contains("opened");
    }

    public String getConnectionPhonePlaceholder() {
        return driver.findElement(connectionPhone).getAttribute("placeholder");
    }

    public String getConnectionSumPlaceholder() {
        return driver.findElement(connectionSum).getAttribute("placeholder");
    }

    public String getConnectionEmailPlaceholder() {
        return driver.findElement(connectionEmail).getAttribute("placeholder");
    }

    private final By internetPhone = By.cssSelector("form#pay-internet input#internet-phone.phone");
    private final By internetSum = By.cssSelector("form#pay-internet input#internet-sum.total_rub");
    private final By internetEmail = By.cssSelector("form#pay-internet input#internet-email.email");

    public String getInternetPhonePlaceholder() {
        return driver.findElement(internetPhone).getAttribute("placeholder");
    }

    public String getInternetSumPlaceholder() {
        return driver.findElement(internetSum).getAttribute("placeholder");
    }

    public String getInternetEmailPlaceholder() {
        return driver.findElement(internetEmail).getAttribute("placeholder");
    }

    private final By instalmentScore = By.cssSelector("form#pay-instalment input#score-instalment.score");
    private final By instalmentSum = By.cssSelector("form#pay-instalment input#instalment-sum.total_rub");
    private final By instalmentEmail = By.cssSelector("form#pay-instalment input#instalment-email.email");

    public String getInstalmentScorePlaceholder() {
        return driver.findElement(instalmentScore).getAttribute("placeholder");
    }

    public String getInstalmentSumPlaceholder() {
        return driver.findElement(instalmentSum).getAttribute("placeholder");
    }

    public String getInstalmentEmailPlaceholder() {
        return driver.findElement(instalmentEmail).getAttribute("placeholder");
    }

    private final By arrearsScore = By.cssSelector("form#pay-arrears input#score-arrears.score");
    private final By arrearsSum = By.cssSelector("form#pay-arrears input#arrears-sum.total_rub");
    private final By arrearsEmail = By.cssSelector("form#pay-arrears input#arrears-email.email");

    public String getArrearsScorePlaceholder() {
        return driver.findElement(arrearsScore).getAttribute("placeholder");
    }

    public String getArrearsSumPlaceholder() {
        return driver.findElement(arrearsSum).getAttribute("placeholder");
    }

    public String getArrearsEmailPlaceholder() {
        return driver.findElement(arrearsEmail).getAttribute("placeholder");
    }
}