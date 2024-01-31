package br.com.page;

import br.com.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static br.com.core.DriverFactory.driver;

public class SplashPage extends BasePage {

    public boolean isTelaSplashVisivel(){
        return existeElementPorTexto("Splash!");
    }

    public void aguardarSplashSumir(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
                "//*[@text='Splash!']")));
    }
}
