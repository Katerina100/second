import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GooglePageTestMobileForm extends BaseRunner{
    @Test
    public void test1() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://www.google.ru/");
        driver.findElement(By.name("q")).sendKeys("Тинькофф мобайл тарифы");
        driver.findElements(By.xpath("//ul[@role='listbox']/li"));


        wait
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Что-то пошло не так...")
                .pollingEvery(Duration.ofMillis(500))
                .until(d -> {

                    By listItems = By.xpath("//ul[@role='listbox']/li[@role='presentation' and .//*[@role='option']]");
                    List<WebElement> elements = driver.findElements(listItems);
                    for (WebElement el : elements) {
                        System.out.println(el.getText());

                        if (el.getText().equals("тинькофф мобайл тарифы")) el.click();
                        break;
                    }

                    return d.getTitle().equals("тинькофф мобайл тарифы - Поиск в Google");
                });


        String tinkoffLink = "https://www.tinkoff.ru/mobile-operator/tariffs/";

        wait.until(d -> xpathSearcherByText(tinkoffLink).size() > 0);
        xpathSearcherByText(tinkoffLink).get(0).click();

        wait.until(d -> {
            boolean check = false;
            for (String title : driver.getWindowHandles()) {
                driver.switchTo().window(title);
                System.out.println(d.getTitle());
                check = d.getTitle().equals("Тарифы Тинькофф Мобайла");
            }
            return check;
        });



        driver.close();


        driver.switchTo().window(driver.getWindowHandles().iterator().next());

    }

        private List<WebElement> xpathSearcherByText(String searchText) {
            String xpath = String.format("//*[contains(text(),'%s')]", searchText);
            return driver.findElements(By.xpath(xpath));
    }

}
