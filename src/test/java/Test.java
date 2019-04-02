import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;

public class Test  extends BaseRunner {
    @Test
    public void testFirst(){
        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
        driver.findElement(By.name("fio")).click();
        driver.findElement(By.name("phone_mobile")).click();
        driver.findElement(By.name("email")).click();
        driver.close();
    }
    @Test
    public void testSecond(){
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