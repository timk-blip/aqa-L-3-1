package ru.netology.web;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.cssSelector;
class CallbackTest {
    private WebDriver driver;
    private static ChromeOptions options;
    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "driver/linux/chromedriver");
        options = new ChromeOptions();
        options.addArguments("--headless");
    }
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver(options);
    }
    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }
    @Test
    void shouldTestV1() {
        driver.get("http://localhost:9999");
        driver.findElement(cssSelector("[type='text']")).sendKeys("ацпуц");
        driver.findElement(cssSelector("[class='checkbox__box']")).click();
        driver.findElement(cssSelector("[type='tel']")).sendKeys("+79169682127");
        driver.findElement(cssSelector("[role='button']")).click();
        String elementText = driver.findElement(cssSelector("[data-test-id='order-success']")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", elementText.trim());
    }
}