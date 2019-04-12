import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public enum  BrowsersFactory {
    chrome {
        public WebDriver create() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            return  new ChromeDriver(options);
        }
    },
    chrome_invisible {
        public WebDriver create() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--headless");
            return new ChromeDriver(options);
        }
    };

    public WebDriver create() {
        return null;
    }
}
