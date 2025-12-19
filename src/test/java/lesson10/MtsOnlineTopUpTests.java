package lesson10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MtsOnlineTopUpTests {

    private WebDriver driver;
    private MtsOnlineTopUpPage page;

    @BeforeEach
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
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void blockTitleIsCorrect() {
        assertTrue(page.isBlockTitleVisible());
    }

    @Test
    public void visaLogoIsDisplayed() {
        assertTrue(page.isVisaLogoVisible());
    }

    @Test
    public void verifiedVisaLogoIsDisplayed() {
        assertTrue(page.isVerifiedVisaLogoVisible());
    }

    @Test
    public void mastercardLogoIsDisplayed() {
        assertTrue(page.isMastercardLogoVisible());
    }

    @Test
    public void masterCardSecureCodeLogoIsDisplayed() {
        assertTrue(page.isMastercardSecureVisible());
    }

    @Test
    public void belkartLogoIsDisplayed() {
        assertTrue(page.isBelkartLogoVisible());
    }

    @Test
    public void moreInfoLinkOpensServicePage() {
        page.clickMoreInfo();
        assertTrue(driver.getCurrentUrl()
                .contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    @Test
    public void continueButtonSubmitsForm() {
        page.fillConnectionPhone("297777777");
        page.fillConnectionSum("10");
        page.fillConnectionEmail("rogova@olga.com");
        page.submitConnection();
        assertTrue(page.isConnectionFormOpened());
    }

    @Test
    public void placeholdersOnConnectionTabAreCorrect() {
        assertEquals("Номер телефона", page.getConnectionPhonePlaceholder());
        assertEquals("Сумма", page.getConnectionSumPlaceholder());
        assertEquals("E-mail для отправки чека", page.getConnectionEmailPlaceholder());
    }

    @Test
    public void placeholdersOnInternetTabAreCorrect() {
        page.openInternetDirect();
        assertEquals("Номер абонента", page.getInternetPhonePlaceholder());
        assertEquals("Сумма", page.getInternetSumPlaceholder());
        assertEquals("E-mail для отправки чека", page.getInternetEmailPlaceholder());
    }

    @Test
    public void placeholdersOnInstalmentTabAreCorrect() {
        page.openInstalmentDirect();
        assertEquals("Номер счета на 44", page.getInstalmentScorePlaceholder());
        assertEquals("Сумма", page.getInstalmentSumPlaceholder());
        assertEquals("E-mail для отправки чека", page.getInstalmentEmailPlaceholder());
    }

    @Test
    public void placeholdersOnArrearsTabAreCorrect() {
        page.openArrearsDirect();
        assertEquals("Номер счета на 2073", page.getArrearsScorePlaceholder());
        assertEquals("Сумма", page.getArrearsSumPlaceholder());
        assertEquals("E-mail для отправки чека", page.getArrearsEmailPlaceholder());
    }

    @Test
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