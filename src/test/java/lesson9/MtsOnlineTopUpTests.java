package lesson9;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsOnlineTopUpTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void blockTitleIsCorrect() {
        WebElement title = driver.findElement(By.xpath(
                "//div[contains(@class,'pay__wrapper')]" +
                        "//h2[contains(normalize-space(),'Онлайн пополнение без комиссии')]\n"));

        assertTrue(title.isDisplayed());
    }

    @Test
    public void visaLogoIsDisplayed() {
        WebElement visaLogo = driver.findElement(By.xpath(
                "//h2[contains(normalize-space(),'Онлайн пополнение без комиссии')]/ancestor::section" +
                        "//img[contains(@src,'visa.svg')]"));

        assertTrue(visaLogo.isDisplayed());
    }

    @Test
    public void verifiedVisaLogoIsDisplayed() {
        WebElement verifiedVisaLogo = driver.findElement(By.xpath(
                "//h2[contains(normalize-space(),'Онлайн пополнение без комиссии')]/ancestor::section" +
                        "//img[@alt='Verified By Visa']"));

        assertTrue(verifiedVisaLogo.isDisplayed());
    }

    @Test
    public void mastercardLogoIsDisplayed() {
        WebElement mcLogo = driver.findElement(By.xpath(
                "//h2[contains(normalize-space(),'Онлайн пополнение без комиссии')]/ancestor::section" +
                        "//img[contains(@src,'mastercard.svg')]"));

        assertTrue(mcLogo.isDisplayed());
    }

    @Test
    public void masterCardSecureCodeLogoIsDisplayed() {
        WebElement mcSecureLogo = driver.findElement(By.xpath(
                "//h2[contains(normalize-space(),'Онлайн пополнение без комиссии')]/ancestor::section" +
                        "//img[@alt='MasterCard Secure Code']"));

        assertTrue(mcSecureLogo.isDisplayed());
    }

    @Test
    public void belkartLogoIsDisplayed() {
        WebElement belkartLogo = driver.findElement(By.xpath(
                "//h2[contains(normalize-space(),'Онлайн пополнение без комиссии')]/ancestor::section" +
                        "//img[contains(@src,'belkart.svg')]"));

        assertTrue(belkartLogo.isDisplayed());
    }

    @Test
    public void moreInfoLinkOpensServicePage() {
        WebElement moreInfoLink = driver.findElement(By.xpath(
                "//h2[contains(normalize-space(),'Онлайн пополнение без комиссии')]/ancestor::section" +
                        "//a[contains(normalize-space(),'Подробнее о сервисе')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", moreInfoLink);

        assertTrue(driver.getCurrentUrl()
                .contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    @Test
    public void continueButtonSubmitsForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement phoneInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@placeholder='Номер телефона']")));
        phoneInput.sendKeys("297777777");

        WebElement amountInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@placeholder='Сумма']")));
        amountInput.clear();
        amountInput.sendKeys("10");

        WebElement emailInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@id='connection-email'='E-mail для отправки чека']")));
        emailInput.sendKeys("rogova@olga.com");

        WebElement continueButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//form[@id='pay-connection']//button[@type='submit']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);

        WebElement form = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("pay-connection")));
        String formClass = form.getAttribute("class");

        assertTrue(formClass.contains("opened"));
    }
}