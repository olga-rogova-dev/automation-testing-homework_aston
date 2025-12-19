package lesson11;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Онлайн‑оплата МТС")
@Feature("Онлайн пополнение без комиссии")
@Owner("Olga Rogova")
public class MtsOnlineTopUpTests {

    private WebDriver driver;
    private MtsOnlineTopUpPage page;

    @BeforeEach
    @Step("Открываем браузер и главную страницу МТС")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        page = new MtsOnlineTopUpPage(driver);
        page.open();
    }

    @AfterEach
    @Step("Закрываем браузер")
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Story("Отображение блока оплаты")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Блок 'Онлайн пополнение без комиссии' виден пользователю")
    @Description("Проверяем, что заголовок блока онлайн‑пополнения отображается на главной странице.")
    public void blockTitleIsCorrect() {
        assertTrue(page.isBlockTitleVisible());
    }

    @Test
    @Story("Отображение логотипов платёжных систем")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Логотип Visa отображается")
    public void visaLogoIsDisplayed() {
        assertTrue(page.isVisaLogoVisible());
    }

    @Test
    @Story("Отображение логотипов платёжных систем")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Логотип Verified by Visa отображается")
    public void verifiedVisaLogoIsDisplayed() {
        assertTrue(page.isVerifiedVisaLogoVisible());
    }

    @Test
    @Story("Отображение логотипов платёжных систем")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Логотип MasterCard отображается")
    public void mastercardLogoIsDisplayed() {
        assertTrue(page.isMastercardLogoVisible());
    }

    @Test
    @Story("Отображение логотипов платёжных систем")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Логотип MasterCard SecureCode отображается")
    public void masterCardSecureCodeLogoIsDisplayed() {
        assertTrue(page.isMastercardSecureVisible());
    }

    @Test
    @Story("Отображение логотипов платёжных систем")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Логотип БЕЛКАРТ отображается")
    public void belkartLogoIsDisplayed() {
        assertTrue(page.isBelkartLogoVisible());
    }

    @Test
    @Story("Переход по ссылке 'Подробнее о сервисе'")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Ссылка 'Подробнее о сервисе' открывает страницу сервиса")
    @Link(name = "Инструкция по оплате", url = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/")
    public void moreInfoLinkOpensServicePage() {
        page.clickMoreInfo();
        assertTrue(driver.getCurrentUrl()
                .contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    @Test
    @Story("Оплата связи")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Кнопка 'Продолжить' открывает форму оплаты связи")
    @Description("Заполняем форму пополнения связи корректными данными и проверяем, что модальное окно оплаты открылось.")
    public void continueButtonSubmitsForm() {
        page.fillConnectionPhone("297777777");
        page.fillConnectionSum("10");
        page.fillConnectionEmail("rogova@olga.com");
        page.submitConnection();
        assertTrue(page.isConnectionFormOpened());
    }

    @Test
    @Story("Плейсхолдеры формы связи")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Плейсхолдеры вкладки 'Связь' корректные")
    public void placeholdersOnConnectionTabAreCorrect() {
        assertEquals("Номер телефона", page.getConnectionPhonePlaceholder());
        assertEquals("Сумма", page.getConnectionSumPlaceholder());
        assertEquals("E-mail для отправки чека", page.getConnectionEmailPlaceholder());
    }

    @Test
    @Story("Плейсхолдеры формы 'Интернет'")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Плейсхолдеры вкладки 'Интернет' корректные")
    public void placeholdersOnInternetTabAreCorrect() {
        page.openInternetDirect();
        assertEquals("Номер абонента", page.getInternetPhonePlaceholder());
        assertEquals("Сумма", page.getInternetSumPlaceholder());
        assertEquals("E-mail для отправки чека", page.getInternetEmailPlaceholder());
    }

    @Test
    @Story("Плейсхолдеры формы 'Рассрочка'")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Плейсхолдеры вкладки 'Рассрочка' корректные")
    public void placeholdersOnInstalmentTabAreCorrect() {
        page.openInstalmentDirect();
        assertEquals("Номер счета на 44", page.getInstalmentScorePlaceholder());
        assertEquals("Сумма", page.getInstalmentSumPlaceholder());
        assertEquals("E-mail для отправки чека", page.getInstalmentEmailPlaceholder());
    }

    @Test
    @Story("Плейсхолдеры формы 'Задолженность'")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Плейсхолдеры вкладки 'Задолженность' корректные")
    public void placeholdersOnArrearsTabAreCorrect() {
        page.openArrearsDirect();
        assertEquals("Номер счета на 2073", page.getArrearsScorePlaceholder());
        assertEquals("Сумма", page.getArrearsSumPlaceholder());
        assertEquals("E-mail для отправки чека", page.getArrearsEmailPlaceholder());
    }

    @Test
    @Story("Оплата связи")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Модальное окно оплаты связи открывается с корректными данными")
    @Description("Заполняем форму связи данными абонента и убеждаемся, что форма оплаты открывается.")
    public void connectionPaymentModalShowsCorrectData() {
        String phone = "297777777";
        String sum = "10";
        String email = "rogova@olga.com";

        page.openConnectionTab();
        page.fillConnectionPhone(phone);
        page.fillConnectionSum(sum);
        page.fillConnectionEmail(email);

        page.submitConnection();

        assertTrue(page.isConnectionFormOpened(), "Форма оплаты не открылась");
    }
}