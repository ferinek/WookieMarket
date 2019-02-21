package com.kslodowicz.wookiemarket.bean;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverBean {

    private static WebDriver DRIVER;

    public static WebDriver getWebDriver() {
        if (DRIVER == null) {
            ChromeDriverManager.getInstance().setup();
            DRIVER = new ChromeDriver();
        }
        return DRIVER;
    }
}
