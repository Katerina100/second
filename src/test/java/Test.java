
import org.openqa.selenium.*;
import static org.junit.Assert.assertEquals;

public class Test extends BaseRunner {
    @Test
    public void testFirst(){
        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
        driver.findElement(By.name("fio")).click();
        driver.findElement(By.name("phone_mobile")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Гражданство'])[1]/following::span[1]")).click();
        assertEquals("Укажите ваше ФИО", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия, имя и отчество'])[1]/following::div[3]")).getText());
        assertEquals("Необходимо указать номер телефона", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Контактный телефон'])[1]/following::div[2]")).getText());
    }
    @Test
    public void testSecond(){
        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
        driver.findElement(By.name("fio")).click();
        driver.findElement(By.name("fio")).clear();
        driver.findElement(By.name("fio")).sendKeys("владрпдв");
        driver.findElement(By.name("phone_mobile")).click();
        driver.findElement(By.name("phone_mobile")).clear();
        driver.findElement(By.name("phone_mobile")).sendKeys("+7(546) 216-35-5");
        driver.findElement(By.name("email")).click();
        assertEquals("Недостаточно информации. Введите фамилию, имя и отчество через пробел (Например: Иванов Иван Алексеевич)", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия, имя и отчество'])[1]/following::div[3]")).getText());
        assertEquals("Номер телефона должен состоять из 10 цифр, начиная с кода оператора", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Контактный телефон'])[1]/following::div[2]")).getText());
        assertEquals("Введите корректный адрес эл. почты", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Электронная почта'])[1]/following::div[3]")).getText());
    }
}