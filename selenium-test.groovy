import org.openqa.selenium.firefox.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.*;

test_url = "http://172.17.0.2"

System.setProperty(
    "webdriver.gecko.driver",
    "C:\\Scripts\\Webdriver\\geckodriver.exe");
//Set Firefox as headless
FirefoxOptions options = new FirefoxOptions();
options.setHeadless(true);

WebDriver driver = new FirefoxDriver(options);

driver.get(test_url);
try {
    
    driver.get(test_url);
    sleep(7000);
    
    try {
        String bodyText = driver.findElement(By.tagName("body")).getText();
        elements = driver.findElements(By.cssSelector("#pwdbean__xc_ .x2v"));
        assert(elements.size() > 0);
        assert(bodyText.contains("About"));
        println "found_site=1";
    } catch (Exception e) {
        println "found_site=0"
    }
    try {
        driver.findElement(By.xpath("//a[contains(.,'About')]")).click();
        sleep(7000);
        println "logged_in=1";
    } catch (Exception e) {
        println e
        println "logged_in=0"
    }

    try {
            sleep(7000);
            String bodyText = driver.findElement(By.tagName("body")).getText();
            assert(bodyText.contains("Copyright"));
            println "found_text=1";
        } catch (Exception e) {
            println "found_text=0"
        }
    }
    catch (Exception e) {
        println "Exiting with exception"
    }
finally {
driver.quit()
}

return 0;