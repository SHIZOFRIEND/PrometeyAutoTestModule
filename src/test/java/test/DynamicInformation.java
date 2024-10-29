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
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.fail;
public class DynamicInformation {
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
    public void test12525() throws InterruptedException {
        System.out.println("Запуск теста выбора элемента из выпадающего списка.");
        loginAndNavigateToRegistry("Egor", "2");
        performSearch("107_v1 | ФИЛЬТРАЦИЯ ДАННЫЕ | ТЕСТИРОВАНИЕ");
        selectRecordByText("25");
        scrollHalfPage();
        navigateToProcessRecord("12525");
        gatherInformationFromCard();
        System.out.println("Тест завершен.");
    }
    @Test
    public void test13827() throws InterruptedException {
        System.out.println("Запуск теста выбора элемента из выпадающего списка.");
        loginAndNavigateToRegistry("Egor", "2");
        performSearch("107_v1 | ФИЛЬТРАЦИЯ ДАННЫЕ | ТЕСТИРОВАНИЕ");
        selectRecordByText("25");
        scrollHalfPage();
        navigateToProcessRecord("13827");
        gatherInformationFromCard();
        System.out.println("Тест завершен.");
    }
    @Test
    public void test5926() throws InterruptedException {
        System.out.println("Запуск теста выбора элемента из выпадающего списка.");
        loginAndNavigateToRegistry("Egor", "2");
        performSearch("107_v1 | ФИЛЬТРАЦИЯ ДАННЫЕ | ТЕСТИРОВАНИЕ");
        selectRecordByText("25");
        scrollHalfPage();
        navigateToProcessRecord("5926");
        gatherInformationFromCard();
        System.out.println("Тест завершен.");
    }
    @Test
    public void test5891() throws InterruptedException {
        System.out.println("Запуск теста выбора элемента из выпадающего списка.");
        loginAndNavigateToRegistry("Egor", "2");
        performSearch("107_v1 | ФИЛЬТРАЦИЯ ДАННЫЕ | ТЕСТИРОВАНИЕ");
        selectRecordByText("25");
        scrollHalfPage();
        navigateToProcessRecord("5891");
        gatherInformationFromCard();
        System.out.println("Тест завершен.");
    }
    @Test
    public void test5865() throws InterruptedException {
        System.out.println("Запуск теста выбора элемента из выпадающего списка.");
        loginAndNavigateToRegistry("Egor", "2");
        performSearch("107_v1 | ФИЛЬТРАЦИЯ ДАННЫЕ | ТЕСТИРОВАНИЕ");
        selectRecordByText("25");
        scrollHalfPage();
        navigateToProcessRecord("5865");
        gatherInformationFromCard();
        System.out.println("Тест завершен.");
    }
    @Test
    public void test5796() throws InterruptedException {
        System.out.println("Запуск теста выбора элемента из выпадающего списка.");
        loginAndNavigateToRegistry("Egor", "2");
        performSearch("107_v1 | ФИЛЬТРАЦИЯ ДАННЫЕ | ТЕСТИРОВАНИЕ");
        selectRecordByText("25");
        scrollHalfPage();
        navigateToProcessRecord("5796");
        gatherInformationFromCard();
        System.out.println("Тест завершен.");
    }
    @Test
    public void test5795() throws InterruptedException {
        System.out.println("Запуск теста выбора элемента из выпадающего списка.");
        loginAndNavigateToRegistry("Egor", "2");
        performSearch("107_v1 | ФИЛЬТРАЦИЯ ДАННЫЕ | ТЕСТИРОВАНИЕ");
        selectRecordByText("25");
        scrollHalfPage();
        navigateToProcessRecord("5795");
        gatherInformationFromCard();
        System.out.println("Тест завершен.");
    }
    @Test
    public void test5794() throws InterruptedException {
        System.out.println("Запуск теста выбора элемента из выпадающего списка.");
        loginAndNavigateToRegistry("Egor", "2");
        performSearch("107_v1 | ФИЛЬТРАЦИЯ ДАННЫЕ | ТЕСТИРОВАНИЕ");
        selectRecordByText("25");
        scrollHalfPage();
        navigateToProcessRecord("5794");
        gatherInformationFromCard();
        System.out.println("Тест завершен.");
    }
    @Test
    public void test5793() throws InterruptedException {
        System.out.println("Запуск теста выбора элемента из выпадающего списка.");
        loginAndNavigateToRegistry("Egor", "2");
        performSearch("107_v1 | ФИЛЬТРАЦИЯ ДАННЫЕ | ТЕСТИРОВАНИЕ");
        selectRecordByText("25");
        scrollHalfPage();
        navigateToProcessRecord("5793");
        gatherInformationFromCard();
        System.out.println("Тест завершен.");
    }
    @Test
    public void test5792() throws InterruptedException {
        System.out.println("Запуск теста выбора элемента из выпадающего списка.");
        loginAndNavigateToRegistry("Egor", "2");
        performSearch("107_v1 | ФИЛЬТРАЦИЯ ДАННЫЕ | ТЕСТИРОВАНИЕ");
        selectRecordByText("25");
        scrollHalfPage();
        navigateToProcessRecord("5792");
        gatherInformationFromCard();
        System.out.println("Тест завершен.");
    }
    @Test
    public void test5791() throws InterruptedException {
        System.out.println("Запуск теста выбора элемента из выпадающего списка.");
        loginAndNavigateToRegistry("Egor", "2");
        performSearch("107_v1 | ФИЛЬТРАЦИЯ ДАННЫЕ | ТЕСТИРОВАНИЕ");
        selectRecordByText("25");
        scrollHalfPage();
        navigateToProcessRecord("5791");
        gatherInformationFromCard();
        System.out.println("Тест завершен.");
    }
    @Test
    public void test5790() throws InterruptedException {
        System.out.println("Запуск теста выбора элемента из выпадающего списка.");
        loginAndNavigateToRegistry("Egor", "2");
        performSearch("107_v1 | ФИЛЬТРАЦИЯ ДАННЫЕ | ТЕСТИРОВАНИЕ");
        selectRecordByText("25");
        scrollHalfPage();
        navigateToProcessRecord("5790");
        gatherInformationFromCard();
        System.out.println("Тест завершен.");
    }
    private void loginAndNavigateToRegistry(String username, String password) {
        login(username, password);
        verifyLogin();
        System.out.println("Переход к реестру записей процессов.");
        WebElement registryLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Реестр записей процессов')]")));
        new Actions(driver).moveToElement(registryLink).perform();
        registryLink.click();
        WebElement navbarToggle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.navbar-toggler")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", navbarToggle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", navbarToggle);
        System.out.println("Кнопка 'navbar-toggler' нажата.");
    }
    private void performSearch(String searchText) throws InterruptedException {
        WebElement selectizeInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#BusinessModelIdSearchElement-selectized")));
        selectizeInput.click();
        selectizeInput.sendKeys(searchText);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.selectize-dropdown.multi")));
        List<WebElement> dropdownItems = driver.findElements(By.cssSelector("div.selectize-dropdown.multi .option[data-selectable]"));
        System.out.println("Найдено элементов в выпадающем списке: " + dropdownItems.size());
        if (dropdownItems.isEmpty()) {
            System.err.println("Выпадающий список пуст.");
            return;
        }
        boolean found = false;
        for (WebElement item : dropdownItems) {
            try {
                if (item.getText().equals(searchText)) {
                    new Actions(driver).moveToElement(item).perform();
                    item.click();
                    System.out.println("Элемент '" + item.getText() + "' выбран.");
                    found = true;
                    break;
                }
            } catch (StaleElementReferenceException e) {
                dropdownItems = driver.findElements(By.cssSelector("div.selectize-dropdown.multi .option[data-selectable]"));
            }
        }
        if (!found) {
            return;
        }
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-primary[name='fwe']")));
        new Actions(driver).moveToElement(searchButton).perform();
        searchButton.click();
        System.out.println("Кнопка 'Поиск' нажата.");
    }
    private void selectRecordByText(String searchText) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.dataTables_length")));
        WebElement recordsDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.dataTables_length select[name='applicationTable_length']")));
        recordsDropdown.click();
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.dataTables_length select[name='applicationTable_length'] option")));
        boolean found = false;
        for (WebElement option : options) {
            if (option.getText().contains(searchText)) {
                option.click();
                System.out.println("Элемент с текстом '" + searchText + "' выбран.");
                found = true;
                Thread.sleep(3000);
                break;
            }
        }
        if (!found) {
            System.err.println("Элемент с текстом '" + searchText + "' не найден.");
        }
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
    private void scrollHalfPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long windowHeight = (Long) js.executeScript("return window.innerHeight;");
        js.executeScript("window.scrollBy(0, arguments[0] / 2);", windowHeight);
    }
    private void clickOnElementById(String elementId) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(elementId))).click();
        System.out.println("Успешный вход: пользователь перенаправлен на домашнюю страницу.");
    }
    private void navigateToProcessRecord(String processId) {
        List<WebElement> processRows = driver.findElements(By.xpath("//td[contains(text(), '" + processId + "')]"));
        assertFalse("Карточка с ID " + processId + " не найдена.", processRows.isEmpty());
        for (WebElement processRow : processRows) {
            if (processRow.getText().contains(processId)) {
                WebElement actionsButton = processRow.findElement(By.xpath(".//ancestor::tr//button[contains(@id, 'dropdownMenuButton')]"));
                actionsButton.click();
                System.out.println("Кликнули на кнопку действий для карточки с ID " + processId + ".");
                WebElement openButton = processRow.findElement(By.xpath(".//ancestor::tr//a[contains(text(), 'Открыть')]"));
                if (openButton.isDisplayed() && openButton.isEnabled()) {
                    openButton.click();
                    System.out.println("Нажали на кнопку 'Открыть'.");
                } else {
                    System.out.println("Кнопка 'Открыть' не доступна для нажатия.");
                }
                break;
            }
        }
    }
    private void gatherInformationFromCard() {
        System.out.println("Сбор данных из карточки.");
        WebElement idComponent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exjkrp-id")));
        String actualId = idComponent.getAttribute("value");
        System.out.println("Полученное значение ID: " + actualId);
        WebElement fioComponent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ekmbi7j-fio")));
        String actualFio = fioComponent.getAttribute("value");
        System.out.println("Полученное значение ФИО: " + actualFio);
        WebElement cityComponent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ecgus3-city")));
        String actualCity = cityComponent.getAttribute("value");
        System.out.println("Полученное значение Город: " + actualCity);
        WebElement streetComponent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ex77c2lj-street")));
        String actualStreet = streetComponent.getAttribute("value");
        System.out.println("Полученное значение Улица: " + actualStreet);
        WebElement numberComponent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("egnm5l-number")));
        String actualNumber = numberComponent.getAttribute("value");
        System.out.println("Полученное значение Номер: " + actualNumber);
        List<WebElement> additionalInfoRows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("tbody[ref='datagrid-dop_sved-tbody'] tr")));
        List<String> additionalInfo = new ArrayList<>();
        if (!additionalInfoRows.isEmpty()) {
            for (WebElement row : additionalInfoRows) {
                String child = row.findElement(By.cssSelector("input[name*='[child]']")).getAttribute("value");
                String age = row.findElement(By.cssSelector("input[name*='[age]']")).getAttribute("value");
                if (!child.isEmpty() && !age.isEmpty()) {
                    additionalInfo.add("Ребенок: " + child + ", Возраст: " + age);
                    System.out.println("Дополнительные сведения - Ребенок: " + child + ", Возраст: " + age);
                }
            }
        } else {
            System.out.println("Дополнительные сведения отсутствуют.");
        }
        WebElement hiddenDateInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("e73vhgk-date")));
        String actualDate = hiddenDateInput.getAttribute("value");
        System.out.println("Полученное значение Даты: " + actualDate);
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedActualDate = "";
        try {
            Date date = inputFormat.parse(actualDate);
            formattedActualDate = outputFormat.format(date);
            System.out.println("Отформатированное значение Даты: " + formattedActualDate);
        } catch (ParseException e) {
            System.err.println("Ошибка разбора даты: " + e.getMessage());
        }
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.addOrUpdateRecord(actualId, actualFio, actualCity, actualStreet, actualNumber, additionalInfo, formattedActualDate);
        dbHandler.printAllRecords();
        dbHandler.close();
    }
}