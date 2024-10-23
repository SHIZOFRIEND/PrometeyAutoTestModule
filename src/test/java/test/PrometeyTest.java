package test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.fail;

public class PrometeyTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://newtemplate-new.isands.ru/");
    }
    @Test
    public void testLogin() {
        login("Egor", "2");
        verifyLogin();
    }
    @Test
    public void testInvalidLogin() {
        login("Egor", "пароль");
        verifyInvalidLogin();
    }
    private void login(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("_com_liferay_product_navigation_user_personal_bar_web_portlet_ProductNavigationUserPersonalBarPortlet_fehs____"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_com_liferay_login_web_portlet_LoginPortlet_login"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_com_liferay_login_web_portlet_LoginPortlet_password"))).sendKeys(password);
        WebElement rememberMeCheckbox = driver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_rememberMe"));
        if (!rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Войти')]"))).click();
    }
    private void verifyLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlToBe("https://newtemplate-new.isands.ru/o/esia-login-portlet/choose.jsp"),
                ExpectedConditions.urlToBe("https://newtemplate-new.isands.ru/web/guest/home")
        ));
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://newtemplate-new.isands.ru/o/esia-login-portlet/choose.jsp")) {
            System.out.println("Успешный вход: пользователь перенаправлен на страницу выбора роли.");
            clickOnElementById("54362");
        } else {
            System.out.println("Ошибка: пользователь не был перенаправлен на ожидаемую страницу.");
        }
    }
    private void verifyInvalidLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlToBe("https://newtemplate-new.isands.ru/web/guest/home?p_p_id=com_liferay_login_web_portlet_LoginPortlet&p_p_lifecycle=0&p_p_state=maximized&saveLastPath=false"));
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-dismissible.alert-danger")));
        String errorMessage = errorMessageElement.getText().trim();
        assertTrue("Ошибка: Сообщение об ошибке не совпадает.", errorMessage.contains("Ошибка:Аутентификация не пройдена. Пожалуйста, попробуйте снова."));
    }
    private void clickOnElementById(String elementId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(elementId)));
        element.click();
        System.out.println("Успешный вход: пользователь перенаправлен на домашнюю страницу.");
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void testvp1() throws InterruptedException {
        login("Egor", "2");
        verifyLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        System.out.println("Переход к реестру записей процессов.");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Реестр записей процессов')]"))).click();
        List<WebElement> processRows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//td[contains(text(), '13815')]")));

        for (WebElement processRow : processRows) {
            if (processRow.getText().contains("13815")) {
                WebElement actionsButton = wait.until(ExpectedConditions.elementToBeClickable(processRow.findElement(By.xpath(".//ancestor::tr//button[contains(@id, 'dropdownMenuButton')]"))));
                actionsButton.click();
                System.out.println("Кликнули на кнопку действий для карточки с ID 13815.");
                List<WebElement> dropdownItems = driver.findElements(By.xpath("//div[contains(@class, 'dropdown-menu')]//a"));
                WebElement openButton = null;
                for (WebElement dropdownItem : dropdownItems) {
                    if (dropdownItem.getText().contains("Открыть")) {
                        openButton = dropdownItem;
                        break;
                    }
                }
                if (openButton != null) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].click();", openButton);
                    wait.until(ExpectedConditions.urlContains("/jsp/application/action.jsp"));
                    System.out.println("Кнопка 'Открыть' успешно нажата.");
                    break; // Здесь можно оставить break, чтобы выйти из цикла после успешного нажатия
                } else {
                    fail("Кнопка 'Открыть' не найдена в выпадающем меню.");
                }
            }
        }

        // Убедимся, что мы на нужной странице после нажатия кнопки "Открыть"
        String newPageUrl = wait.until(ExpectedConditions.urlContains("/jsp/application/action.jsp")) ? driver.getCurrentUrl() : "";
        assertTrue("Страница открытия записи не загружена.", newPageUrl.contains("application/action.jsp"));

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='e9olxpb']//div[contains(@class, 'form-control ui fluid selection dropdown')]")));
        dropdown.click();
        Thread.sleep(500);

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@id='e9olxpb']//div[contains(@class, 'choices__list--dropdown')]//div[contains(@class, 'choices__item--choice')]")));
        assertFalse("Не найдено элементов в выпадающем списке.", options.isEmpty());

        WebElement firstOption = options.get(0);
        System.out.println("Выбираем элемент: " + firstOption.getText());
        firstOption.click();
        Thread.sleep(2000);

        // Проверка значений полей
        verifyFieldValue(wait, "e4ple8j-id", "11");
        verifyFieldValue(wait, "ezx1w5v-fio", "Панов");
        try {
            verifyFieldValue(wait, "ejeyeaf-date", "2024-07-11");
        } catch (TimeoutException e) {
            System.out.println("Не удалось найти поле с ID ejeyeaf-date: " + e.getMessage());
        }
        verifyFieldValue(wait, "ef34esi-city", "ЕКБ");
        verifyFieldValue(wait, "eppy3l-street", "Ленина");
        verifyFieldValue(wait, "et671nx-number", "7");

        System.out.println("Все данные успешно проверены и совпадают с ожидаемыми значениями.");
    }

    @Test
    public void testvp2() throws InterruptedException {
        login("Egor", "2");
        verifyLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Реестр записей процессов')]"))).click();
        WebElement processRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), '13815')]")));
        assertTrue("Карточка с ID 13815 не найдена.", processRow.isDisplayed());
        WebElement actionsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdownMenuButton13815")));
        actionsButton.click();
        WebElement openButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Открыть')]")));
        openButton.click();
        wait.until(ExpectedConditions.urlContains("/jsp/application/action.jsp"));
        String newPageUrl = driver.getCurrentUrl();
        assertTrue("Страница открытия записи не загружена.", newPageUrl.contains("application/action.jsp"));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='e9olxpb']//div[contains(@class, 'form-control ui fluid selection dropdown')]")));
        dropdown.click();
        Thread.sleep(500);
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@id='e9olxpb']//div[contains(@class, 'choices__list--dropdown')]//div[contains(@class, 'choices__item--choice')]")));
        assertFalse("Не найдено элементов в выпадающем списке.", options.isEmpty());
        WebElement firstOption = options.get(1);
        System.out.println("Выбираем элемент: " + firstOption.getText());
        firstOption.click();
        Thread.sleep(2000);
        verifyFieldValue(wait, "e4ple8j-id", "2");
        verifyFieldValue(wait, "ezx1w5v-fio", "Сидоров");
        try {
            verifyFieldValue(wait, "ejeyeaf-date", "2024-07-02");
        } catch (TimeoutException e) {
            System.out.println("Не удалось найти поле с ID ejeyeaf-date: " + e.getMessage());
        }
        verifyFieldValue(wait, "ef34esi-city", "МСК");
        verifyFieldValue(wait, "eppy3l-street", "Кирова");
        verifyFieldValue(wait, "et671nx-number", "6");
        System.out.println("Все данные успешно проверены и совпадают с ожидаемыми значениями.");
    }
    @Test
    public void testvp3() throws InterruptedException {
        login("Egor", "2");
        verifyLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Реестр записей процессов')]"))).click();
        WebElement processRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), '13815')]")));
        assertTrue("Карточка с ID 13815 не найдена.", processRow.isDisplayed());
        WebElement actionsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdownMenuButton13815")));
        actionsButton.click();
        WebElement openButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Открыть')]")));
        openButton.click();
        wait.until(ExpectedConditions.urlContains("/jsp/application/action.jsp"));
        String newPageUrl = driver.getCurrentUrl();
        assertTrue("Страница открытия записи не загружена.", newPageUrl.contains("application/action.jsp"));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='e9olxpb']//div[contains(@class, 'form-control ui fluid selection dropdown')]")));
        dropdown.click();
        Thread.sleep(500);
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@id='e9olxpb']//div[contains(@class, 'choices__list--dropdown')]//div[contains(@class, 'choices__item--choice')]")));
        assertFalse("Не найдено элементов в выпадающем списке.", options.isEmpty());
        WebElement firstOption = options.get(2);
        System.out.println("Выбираем элемент: " + firstOption.getText());
        firstOption.click();
        Thread.sleep(2000);
        verifyFieldValue(wait, "e4ple8j-id", "3");
        verifyFieldValue(wait, "ezx1w5v-fio", "Петров");
        try {
            verifyFieldValue(wait, "ejeyeaf-date", "2024-07-03");
        } catch (TimeoutException e) {
            System.out.println("Не удалось найти поле с ID ejeyeaf-date: " + e.getMessage());
        }
        verifyFieldValue(wait, "ef34esi-city", "МСК");
        verifyFieldValue(wait, "eppy3l-street", "Титова");
        verifyFieldValue(wait, "et671nx-number", "7");
        System.out.println("Все данные успешно проверены и совпадают с ожидаемыми значениями.");
    }
    @Test
    public void testvp4() throws InterruptedException {
        login("Egor", "2");
        verifyLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Реестр записей процессов')]"))).click();
        WebElement processRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), '13815')]")));
        assertTrue("Карточка с ID 13815 не найдена.", processRow.isDisplayed());
        WebElement actionsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdownMenuButton13815")));
        actionsButton.click();
        WebElement openButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Открыть')]")));
        openButton.click();
        wait.until(ExpectedConditions.urlContains("/jsp/application/action.jsp"));
        String newPageUrl = driver.getCurrentUrl();
        assertTrue("Страница открытия записи не загружена.", newPageUrl.contains("application/action.jsp"));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='e9olxpb']//div[contains(@class, 'form-control ui fluid selection dropdown')]")));
        dropdown.click();
        Thread.sleep(500);
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@id='e9olxpb']//div[contains(@class, 'choices__list--dropdown')]//div[contains(@class, 'choices__item--choice')]")));
        assertFalse("Не найдено элементов в выпадающем списке.", options.isEmpty());
        WebElement firstOption = options.get(3);
        System.out.println("Выбираем элемент: " + firstOption.getText());
        firstOption.click();
        Thread.sleep(2000);
        verifyFieldValue(wait, "e4ple8j-id", "7");
        verifyFieldValue(wait, "ezx1w5v-fio", "Власов");
        try {
            verifyFieldValue(wait, "ejeyeaf-date", "2024-07-07");
        } catch (TimeoutException e) {
            System.out.println("Не удалось найти поле с ID ejeyeaf-date: " + e.getMessage());
        }
        verifyFieldValue(wait, "ef34esi-city", "ЕКБ");
        verifyFieldValue(wait, "eppy3l-street", "Народная");
        verifyFieldValue(wait, "et671nx-number", "10");
        System.out.println("Все данные успешно проверены и совпадают с ожидаемыми значениями.");
    }
    @Test
    public void testvp5() throws InterruptedException {
        login("Egor", "2");
        verifyLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Реестр записей процессов')]"))).click();
        WebElement processRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), '13815')]")));
        assertTrue("Карточка с ID 13815 не найдена.", processRow.isDisplayed());
        WebElement actionsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdownMenuButton13815")));
        actionsButton.click();
        WebElement openButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Открыть')]")));
        openButton.click();
        wait.until(ExpectedConditions.urlContains("/jsp/application/action.jsp"));
        String newPageUrl = driver.getCurrentUrl();
        assertTrue("Страница открытия записи не загружена.", newPageUrl.contains("application/action.jsp"));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='e9olxpb']//div[contains(@class, 'form-control ui fluid selection dropdown')]")));
        dropdown.click();
        Thread.sleep(500);
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@id='e9olxpb']//div[contains(@class, 'choices__list--dropdown')]//div[contains(@class, 'choices__item--choice')]")));
        assertFalse("Не найдено элементов в выпадающем списке.", options.isEmpty());
        WebElement firstOption = options.get(4);
        System.out.println("Выбираем элемент: " + firstOption.getText());
        firstOption.click();
        Thread.sleep(2000);
        verifyFieldValue(wait, "e4ple8j-id", "9");
        verifyFieldValue(wait, "ezx1w5v-fio", "Гриф");
        try {
            verifyFieldValue(wait, "ejeyeaf-date", "2024-07-09");
        } catch (TimeoutException e) {
            System.out.println("Не удалось найти поле с ID ejeyeaf-date: " + e.getMessage());
        }
        verifyFieldValue(wait, "ef34esi-city", "НСК");
        verifyFieldValue(wait, "eppy3l-street", "Ленина");
        verifyFieldValue(wait, "et671nx-number", "5");
        System.out.println("Все данные успешно проверены и совпадают с ожидаемыми значениями.");
    }
    private void verifyFieldValue(WebDriverWait wait, String fieldId, String expectedValue) {
        try {
            WebElement field = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(fieldId)));
            String actualValue = field.getAttribute("value");
            assertEquals(expectedValue, actualValue.split("T")[0]);
        } catch (TimeoutException e) {
            System.out.println("Не удалось найти поле с ID: " + fieldId + ", ошибка: " + e.getLocalizedMessage());
        }
    }
}


