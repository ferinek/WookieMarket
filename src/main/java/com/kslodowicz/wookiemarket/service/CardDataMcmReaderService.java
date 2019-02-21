package com.kslodowicz.wookiemarket.service;

import com.kslodowicz.wookiemarket.bean.DriverBean;
import com.kslodowicz.wookiemarket.domain.CardDomain;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

public class CardDataMcmReaderService {
    private WebDriver driver;

    private WebDriver getDriver() {
        return DriverBean.getWebDriver();
    }

    public CardDomain getDataFromMcm(String link) {
        if (StringUtils.isNotBlank(link)) {
            CardDomain domain = new CardDomain();
            getDriver().navigate().to(link);
            WebElement element = getDriver().findElement(By.cssSelector(".page-title-container h1"));
            domain.setCardName(element.getText().split("\n")[0]);
            domain.setExpansionName(element.findElement(By.cssSelector("span")).getText().split("-")[0]);

            List<WebElement> infos = getDriver().findElement(By.cssSelector(".info-list-container dl")).findElements(By.cssSelector("dd"));
            Collections.reverse(infos);
            domain.setPricaTrend(infos.get(0).getText().split("€")[0]);
            return domain;
        }
        return null;
    }
}
