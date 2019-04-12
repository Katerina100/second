
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;


public class TestMobileFormRegion extends BaseRunner  {
    @Test
    public void test2() {
            driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Да'])[1]/following::span[1]")).click();
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Город'])[1]/following::div[5]")).click();

            assertEquals("Москва и Московская область", driver
                    .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Точки продаж'])[1]/following::div[13]")).getText());

            driver.navigate().refresh();

            assertEquals("Москва и Московская область", driver
                    .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Точки продаж'])[1]/following::div[13]")).getText());

        String priceDefaultPackageMoskow= driver.findElement(By.xpath("//div[@class='ui-form__field ui-form__field_title']")).getText();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Точки продаж'])[1]/following::div[13]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Костромская обл.'])[1]/following::div[2]")).click();

        String priceDefaultPackageKrasnodar = driver.findElement(By.xpath("//div[@class='ui-form__field ui-form__field_title']")).getText();

        Assert.assertFalse(priceDefaultPackageMoskow.equals(priceDefaultPackageKrasnodar));

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Точки продаж'])[1]/following::div[13]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Город'])[1]/following::div[5]")).click();

        Checkbox();

        String priceMaxPackageMoskow = driver.findElement(By.xpath("//div[@class='ui-form__field ui-form__field_title']")).getText();

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Точки продаж'])[1]/following::div[13]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Костромская обл.'])[1]/following::div[2]")).click();

        Checkbox();

        String priceMaxPackageKrasnodar = driver.findElement(By.xpath("//div[@class='ui-form__field ui-form__field_title']")).getText();

        Assert.assertTrue(priceMaxPackageMoskow.equals(priceMaxPackageKrasnodar));
    }
    private void Checkbox() {

        WebElement Mess = driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//label[contains(text(),'Мессенджеры')]/..//div[@class='Checkbox__inputOuter_5tJV0']//input"));
        if (!Mess.isSelected()) {
            driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//label[contains(text(),'Мессенджеры')]")).click();
        }

        WebElement SNetworks = driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//label[contains(text(),'Социальные сети')]/..//div[@class='Checkbox__inputOuter_5tJV0']//input"));
        if (!SNetworks.isSelected()) {
            driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//label[contains(text(),'Социальные сети')]")).click();
        }

        WebElement checkboxMusic = driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//label[contains(text(),'Музыка')]/..//div[@class='Checkbox__inputOuter_5tJV0']//input"));
        if (!checkboxMusic.isSelected()) {
            driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//label[contains(text(),'Музыка')]")).click();
        }

        WebElement checkboxVideo = driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//label[contains(text(),'Видео')]/..//div[@class='Checkbox__inputOuter_5tJV0']//input"));
        if (!checkboxVideo.isSelected()) {
            driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//label[contains(text(),'Видео')]")).click();
        }

        WebElement SMS = driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//label[contains(text(),'Безлимитные СМС')]/..//div[@class='Checkbox__inputOuter_5tJV0']//input"));
        if (!SMS.isSelected()) {
            driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//label[contains(text(),'Безлимитные СМС')]")).click();

        }

        driver.findElement(By.xpath("//div[contains(@class, 'ui-dropdown-select_mobile_native')]//span[contains(text(),'Интернет')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'ui-dropdown-select_mobile_native')]//span[contains(text(),'Безлимитный интернет')]")).click();


        driver.findElement(By.xpath("//div[contains(@class, 'ui-dropdown-select_mobile_native')]//span[contains(text(),'Звонки')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'ui-dropdown-select_mobile_native')]//span[contains(text(),'Безлимитные минуты')]")).click();


        WebElement modem = driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//label[contains(text(),'Режим модема')]/..//div[@class='Checkbox__inputOuter_5tJV0']//input"));
        if (!modem.isSelected()) {
            driver.findElement(By.xpath("//div[@class='CheckboxSet__root_3OLWA']//label[contains(text(),'Режим модема')]")).click();
        }

    }
}
