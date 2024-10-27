package test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.fail;
public class OptTest {
    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void setUp() {
        System.out.println("Настройка теста: открытие браузера и переход на страницу входа.");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://newtemplate-new.isands.ru/");
    }
    @After
    public void tearDown() {
        if (driver != null) {
            System.out.println("Закрытие браузера.");
            driver.quit();
        }
    }
    @Test
    public void testLogin() {
        System.out.println("Запуск теста входа.");
        login("Egor", "2");
        verifyLogin();
    }
    @Test
    public void testInvalidLogin() {
        System.out.println("Запуск теста невалидного входа.");
        login("Egor", "пароль");
        verifyInvalidLogin();
    }
    @Test
    public void testvp1() throws InterruptedException {
        System.out.println("Запуск теста vp1.");
        processRecordTest("2", "2", "Сидоров", "2024-07-02", "МСК", "Кирова", "6");
    }
    @Test
    public void testvp2() throws InterruptedException {
        System.out.println("Запуск теста vp2.");
        processRecordTest("1", "1", "Иванов", "2024-07-01", "МСК", "Ленина", "5");
    }
    @Test
    public void testvp3() throws InterruptedException {
        System.out.println("Запуск теста vp3.");
        processRecordTest("3", "3", "Петров", "2024-07-03", "МСК", "Титова", "7");
    }
    @Test
    public void testvp4() throws InterruptedException {
        System.out.println("Запуск теста vp4.");
        processRecordTest("4", "4", "Ильин", "2024-07-04", "НСК", "Ленина", "8");
    }
    @Test
    public void testvp5() throws InterruptedException {
        System.out.println("Запуск теста vp5.");
        processRecordTest("5", "5", "Серый", "2024-07-05", "НСК", "Кирова", "9");
    }
    @Test
    public void testvp6() throws InterruptedException {
        System.out.println("Запуск теста vp6.");
        processRecordTest("6", "6", "Белых", "2024-07-06", "НСК", "Маркса", "7");
    }
    @Test
    public void testvp7() throws InterruptedException {
        System.out.println("Запуск теста vp7.");
        processRecordTest("7", "7", "Власов", "2024-07-07", "ЕКБ", "Народная", "10");
    }
    @Test
    public void testvp8() throws InterruptedException {
        System.out.println("Запуск теста vp8.");
        processRecordTest("8", "8", "Крылов", "2024-07-08", "НСК", "Ленина", "5");
    }
    @Test
    public void testvp9() throws InterruptedException {
        System.out.println("Запуск теста vp9.");
        processRecordTest("9", "9", "Гриф", "2024-07-09", "НСК", "Ленина", "5");
    }
    @Test
    public void testvp10() throws InterruptedException {
        System.out.println("Запуск теста vp10.");
        processRecordTest("10", "10", "Зельц", "2024-07-10", "МСК", "Кирова", "5");
    }
    @Test
    public void testvp11() throws InterruptedException {
        System.out.println("Запуск теста vp11.");
        processRecordTest("11", "11", "Панов", "2024-07-11", "ЕКБ", "Ленина", "7");
    }
    private void login(String username, String password) {
        System.out.println("Вход в систему: " + username);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("_com_liferay_product_navigation_user_personal_bar_web_portlet_ProductNavigationUserPersonalBarPortlet_fehs____"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_com_liferay_login_web_portlet_LoginPortlet_login"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_com_liferay_login_web_portlet_LoginPortlet_password"))).sendKeys(password);
        WebElement rememberMeCheckbox = driver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_rememberMe"));
        if (!rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Войти')]"))).click();
        System.out.println("Попытка входа выполнена.");
    }
    private void verifyLogin() {
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
        wait.until(ExpectedConditions.urlToBe("https://newtemplate-new.isands.ru/web/guest/home?p_p_id=com_liferay_login_web_portlet_LoginPortlet&p_p_lifecycle=0&p_p_state=maximized&saveLastPath=false"));
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-dismissible.alert-danger")));
        String errorMessage = errorMessageElement.getText().trim();
        assertTrue("Ошибка: Сообщение об ошибке не совпадает.", errorMessage.contains("Ошибка:Аутентификация не пройдена. Пожалуйста, попробуйте снова."));
    }
    private void clickOnElementById(String elementId) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(elementId)));
        element.click();
        System.out.println("Успешный вход: пользователь перенаправлен на домашнюю страницу.");
    }
    private void processRecordTest(String optionLabel, String expectedId, String expectedFio, String expectedDate, String expectedCity, String expectedStreet, String expectedNumber) throws InterruptedException {
        try {
            login("Egor", "2");
            verifyLogin();
            navigateToProcessRecord();
            selectDropdownOptionByLabel(optionLabel);
            Thread.sleep(2000);
            scrollHalfPage();
            WebElement idComponent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("e4ple8j-id")));
            String actualId = idComponent.getAttribute("value");
            System.out.println("Полученное значение ID: " + actualId);
            verifyFieldValue("e4ple8j-id", expectedId);
            WebElement fioComponent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ezx1w5v-fio")));
            String actualFio = fioComponent.getAttribute("value");
            System.out.println("Полученное значение ФИО: " + actualFio);
            verifyFieldValue("ezx1w5v-fio", expectedFio);
            WebElement cityComponent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ef34esi-city")));
            String actualCity = cityComponent.getAttribute("value");
            System.out.println("Полученное значение Город: " + actualCity);
            verifyFieldValue("ef34esi-city", expectedCity);
            WebElement streetComponent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("eppy3l-street")));
            String actualStreet = streetComponent.getAttribute("value");
            System.out.println("Полученное значение Улица: " + actualStreet);
            verifyFieldValue("eppy3l-street", expectedStreet);
            WebElement numberComponent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("et671nx-number")));
            String actualNumber = numberComponent.getAttribute("value");
            System.out.println("Полученное значение Номер: " + actualNumber);
            verifyFieldValue("et671nx-number", expectedNumber);
            List<WebElement> additionalInfoRows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("tbody[ref='datagrid-dop_sved-tbody'] tr")));
            if (!additionalInfoRows.isEmpty()) {
                for (WebElement row : additionalInfoRows) {
                    String child = row.findElement(By.cssSelector("input[name*='[child]']")).getAttribute("value");
                    String age = row.findElement(By.cssSelector("input[name*='[age]']")).getAttribute("value");

                    if (child.isEmpty() && age.isEmpty()) {
                        System.out.println("Дополнительные сведения отсутствуют.");
                    } else {
                        System.out.println("Дополнительные сведения - Ребенок: " + child + ", Возраст: " + age);
                    }
                }
            } else {
                System.out.println("Дополнительные сведения отсутствуют.");
            }
            WebElement hiddenDateInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#ejeyeaf-date[type='hidden']")));
            String actualDate = hiddenDateInput.getAttribute("value");
            System.out.println("Полученное значение Даты: " + actualDate);
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputFormat.parse(actualDate);
            String formattedActualDate = outputFormat.format(date);
            System.out.println("Отформатированное значение Даты: " + formattedActualDate);
            assertEquals("Ошибка: значение даты не совпадает.", expectedDate, formattedActualDate);

        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private void scrollHalfPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long windowHeight = (Long) js.executeScript("return window.innerHeight;");
        js.executeScript("window.scrollBy(0, arguments[0] / 2);", windowHeight);
    }
    private void selectRecordByText(String searchText) {
        WebElement recordsDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select[name='applicationTable_length']")));
        Select select = new Select(recordsDropdown);
        select.selectByVisibleText(searchText);
        System.out.println("Элемент с текстом '" + searchText + "' выбран.");
        wait.until(ExpectedConditions.attributeToBe(recordsDropdown, "value", searchText));
    }
    private void navigateToProcessRecord() {
         System.out.println("Переход к реестру записей процессов.");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Реестр записей процессов')]"))).click();
        selectRecordByText("50");
        scrollHalfPage();
        List<WebElement> processRows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//td[contains(text(), '13815')]")));
        assertFalse("Карточка с ID 13815 не найдена.", processRows.isEmpty());
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
                    System.out.println("Перешли на страницу открытой карточки.");
                } else {
                    fail("Кнопка 'Открыть' не найдена.");
                }
                break;
            }
        }
    }
    private void selectDropdownOptionByLabel(String optionLabel) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Actions actions = new Actions(driver);
            Thread.sleep(2000);
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@id='egtlfaj']//div[contains(@class, 'formio-choices')]")));
            dropdown.click();
            Thread.sleep(2000);
            List<WebElement> dropdownItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//div[@id='egtlfaj']//div[contains(@class, 'choices__list--dropdown')]//div[contains(@class, 'choices__item')]")));
            List<String> listElementsText = new ArrayList<>();
            for (WebElement item : dropdownItems) {
                listElementsText.add(item.getText().trim());
            }
            for (int i = 0; i < listElementsText.size(); i++) {
                if (listElementsText.get(i).equals(optionLabel)) {
                    System.out.println("Найдено соответствие для элемента с текстом '" + optionLabel + "'");
                    WebElement elementToClick = dropdownItems.get(i);
                    actions.moveToElement(elementToClick).click().perform();
                    System.out.println("Элемент с текстом '" + optionLabel + "' выбран.");
                    break;
                }
            }
        } catch (NoSuchElementException e) {
            System.err.println("Элемент не найден: " + e.getMessage());
        } catch (TimeoutException e) {
            System.err.println("Время ожидания истекло:" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
    private void verifyFieldValue(String fieldId, String expectedValue) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldId)));
        assertEquals("Значение поля " + fieldId + " не совпадает.", expectedValue, field.getAttribute("value"));
    }
}