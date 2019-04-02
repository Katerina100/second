import java.util.regex.Pattern;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
public class Tests  extends BaseRunner {
    @Test
    public void testFirst(){
        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
        driver.findElement(By.name("fio")).click();
        driver.findElement(By.name("phone_mobile")).click();
        driver.findElement(By.name("email")).click();
        driver.close();
    }
    }
    @Test
    public void testSecond() throws Exception {
        driver.findElement(By.name("fio")).click();
        driver.findElement(By.name("fio")).clear();
        driver.findElement(By.name("fio")).sendKeys("блаоабовбепс");
        driver.findElement(By.name("phone_mobile")).click();
        driver.findElement(By.name("phone_mobile")).clear();
        driver.findElement(By.name("phone_mobile")).sendKeys("+7(547) 357-");
        driver.findElement(By.name("email")).click();
        driver.close();
    }
}