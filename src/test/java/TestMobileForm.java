
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class TestMobileForm extends BaseRunner {
    @Test
    public void testFirst() {
        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
        driver.findElement(By.xpath("//div[contains(@class, 'ui-form__row_dropdownFIO')]//input[@name='fio']")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'ui-form__row_tel')]//input[@name='phone_mobile']")).click();
        driver.findElement(By.name("email")).click();

        assertEquals("Укажите ваше ФИО", driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия, имя и отчество'])[1]/following::div[3]")).getText());
        assertEquals("Необходимо указать номер телефона", driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Контактный телефон'])[1]/following::div[2]")).getText());
    }

    @Test
    public void testSecond() {
        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
        driver.findElement(By.cssSelector("div.ui-form__row_dropdownFIO input[name=fio]")).click();
        driver.findElement(By.cssSelector("div.ui-form__row_dropdownFIO input[name=fio]")).clear();
        driver.findElement(By.cssSelector("div.ui-form__row_dropdownFIO input[name=fio]")).sendKeys("оналрпстачь");
        driver.findElement(By.cssSelector("div.ui-form__row_tel input[name=phone_mobile]")).click();
        driver.findElement(By.cssSelector("div.ui-form__row_tel input[name=phone_mobile]")).clear();
        driver.findElement(By.cssSelector("div.ui-form__row_tel input[name=phone_mobile]")).sendKeys("+7(537) 837-68-");
        driver.findElement(By.cssSelector("div.ui-form__row_dropdownSuggest input[name=email]")).click();
        driver.findElement(By.cssSelector("div.ui-form__row_dropdownSuggest input[name=email]")).clear();
        driver.findElement(By.cssSelector("div.ui-form__row_dropdownSuggest input[name=email]")).sendKeys("овлровс п");

        assertEquals("Недостаточно информации. Введите фамилию, имя и отчество через пробел (Например: Иванов Иван Алексеевич)", driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия, имя и отчество'])[1]/following::div[3]")).getText());
        assertEquals("Номер телефона должен состоять из 10 цифр, начиная с кода оператора", driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Контактный телефон'])[1]/following::div[2]")).getText());
    }
}
