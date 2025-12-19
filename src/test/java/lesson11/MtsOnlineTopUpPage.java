package lesson11;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
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

    @Step("Открываем главную страницу МТС")
    public void open() {
        driver.get("https://www.mts.by/");
    }

    // ====== Общий блок ======

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

    @Step("Проверяем, что заголовок блока виден")
    public boolean isBlockTitleVisible() {
        return block().findElement(blockTitle).isDisplayed();
    }

    @Step("Проверяем, что логотип Visa виден")
    public boolean isVisaLogoVisible() {
        return block().findElement(visaLogo).isDisplayed();
    }

    @Step("Проверяем, что логотип Verified by Visa виден")
    public boolean isVerifiedVisaLogoVisible() {
        return block().findElement(verifiedVisaLogo).isDisplayed();
    }

    @Step("Проверяем, что логотип MasterCard виден")
    public boolean isMastercardLogoVisible() {
        return block().findElement(mcLogo).isDisplayed();
    }

    @Step("Проверяем, что логотип MasterCard SecureCode виден")
    public boolean isMastercardSecureVisible() {
        return block().findElement(mcSecureLogo).isDisplayed();
    }

    @Step("Проверяем, что логотип БЕЛКАРТ виден")
    public boolean isBelkartLogoVisible() {
        return block().findElement(belkartLogo).isDisplayed();
    }

    @Step("Кликаем по ссылке 'Подробнее о сервисе'")
    public void clickMoreInfo() {
        WebElement link = block().findElement(moreInfoLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
    }

    // ====== Прямое открытие вкладок ======

    @Step("Открываем вкладку Интернет напрямую по URL")
    public void openInternetDirect() {
        driver.get("https://www.mts.by/?product=home_internet");
    }

    @Step("Открываем вкладку Рассрочка напрямую по URL")
    public void openInstalmentDirect() {
        driver.get("https://www.mts.by/?product=instalment");
    }

    @Step("Открываем вкладку Задолженность напрямую по URL")
    public void openArrearsDirect() {
        driver.get("https://www.mts.by/?product=arrears");
    }

    @Step("Переключаемся на вкладку Связь (если нужно)")
    public void openConnectionTab() {
        // если таб открывается кликом по кнопке - можно добавить сюда клик
        // сейчас вкладка открыта по умолчанию, поэтому метод пустой
    }

    // ====== Вкладка Связь ======

    private final By connectionPhone   = By.cssSelector("form#pay-connection input#connection-phone.phone");
    private final By connectionSum     = By.cssSelector("form#pay-connection input#connection-sum.total_rub");
    private final By connectionEmail   = By.cssSelector("form#pay-connection input#connection-email.email");
    private final By connectionSubmit  = By.cssSelector("form#pay-connection button[type='submit']");
    private final By connectionForm    = By.id("pay-connection");

    @Step("Заполняем телефон связи значением: {phone}")
    public void fillConnectionPhone(String phone) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(connectionPhone));
        el.clear();
        el.sendKeys(phone);
    }

    @Step("Заполняем сумму связи значением: {sum}")
    public void fillConnectionSum(String sum) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(connectionSum));
        el.clear();
        el.sendKeys(sum);
    }

    @Step("Заполняем e-mail связи значением: {email}")
    public void fillConnectionEmail(String email) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(connectionEmail));
        el.clear();
        el.sendKeys(email);
    }

    @Step("Нажимаем кнопку 'Продолжить' на форме связи")
    public void submitConnection() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(connectionSubmit));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    @Step("Проверяем, что форма оплаты связи открыта")
    public boolean isConnectionFormOpened() {
        WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(connectionForm));
        return form.getAttribute("class").contains("opened");
    }

    @Step("Получаем плейсхолдер телефона на вкладке Связь")
    public String getConnectionPhonePlaceholder() {
        return driver.findElement(connectionPhone).getAttribute("placeholder");
    }

    @Step("Получаем плейсхолдер суммы на вкладке Связь")
    public String getConnectionSumPlaceholder() {
        return driver.findElement(connectionSum).getAttribute("placeholder");
    }

    @Step("Получаем плейсхолдер e-mail на вкладке Связь")
    public String getConnectionEmailPlaceholder() {
        return driver.findElement(connectionEmail).getAttribute("placeholder");
    }

    // ====== Вкладка Интернет ======

    private final By internetPhone = By.cssSelector("form#pay-internet input#internet-phone.phone");
    private final By internetSum   = By.cssSelector("form#pay-internet input#internet-sum.total_rub");
    private final By internetEmail = By.cssSelector("form#pay-internet input#internet-email.email");

    @Step("Получаем плейсхолдер телефона на вкладке Интернет")
    public String getInternetPhonePlaceholder() {
        return driver.findElement(internetPhone).getAttribute("placeholder");
    }

    @Step("Получаем плейсхолдер суммы на вкладке Интернет")
    public String getInternetSumPlaceholder() {
        return driver.findElement(internetSum).getAttribute("placeholder");
    }

    @Step("Получаем плейсхолдер e-mail на вкладке Интернет")
    public String getInternetEmailPlaceholder() {
        return driver.findElement(internetEmail).getAttribute("placeholder");
    }

    // ====== Вкладка Рассрочка ======

    private final By instalmentScore = By.cssSelector("form#pay-instalment input#score-instalment.score");
    private final By instalmentSum   = By.cssSelector("form#pay-instalment input#instalment-sum.total_rub");
    private final By instalmentEmail = By.cssSelector("form#pay-instalment input#instalment-email.email");

    @Step("Получаем плейсхолдер номера счёта на вкладке Рассрочка")
    public String getInstalmentScorePlaceholder() {
        return driver.findElement(instalmentScore).getAttribute("placeholder");
    }

    @Step("Получаем плейсхолдер суммы на вкладке Рассрочка")
    public String getInstalmentSumPlaceholder() {
        return driver.findElement(instalmentSum).getAttribute("placeholder");
    }

    @Step("Получаем плейсхолдер e-mail на вкладке Рассрочка")
    public String getInstalmentEmailPlaceholder() {
        return driver.findElement(instalmentEmail).getAttribute("placeholder");
    }

    // ====== Вкладка Задолженность ======

    private final By arrearsScore = By.cssSelector("form#pay-arrears input#score-arrears.score");
    private final By arrearsSum   = By.cssSelector("form#pay-arrears input#arrears-sum.total_rub");
    private final By arrearsEmail = By.cssSelector("form#pay-arrears input#arrears-email.email");

    @Step("Получаем плейсхолдер номера счёта на вкладке Задолженность")
    public String getArrearsScorePlaceholder() {
        return driver.findElement(arrearsScore).getAttribute("placeholder");
    }

    @Step("Получаем плейсхолдер суммы на вкладке Задолженность")
    public String getArrearsSumPlaceholder() {
        return driver.findElement(arrearsSum).getAttribute("placeholder");
    }

    @Step("Получаем плейсхолдер e-mail на вкладке Задолженность")
    public String getArrearsEmailPlaceholder() {
        return driver.findElement(arrearsEmail).getAttribute("placeholder");
    }

    // ====== Вложение (по желанию) ======

    @Attachment(value = "Скриншот страницы", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}