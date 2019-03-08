package com.kslodowicz.wookiemarket.config;

import com.kslodowicz.wookiemarket.service.CardDataMcmReaderService;
import com.kslodowicz.wookiemarket.service.GoogleSheetService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kslodowicz.wookiemarket")
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);

//        CardDataMcmReaderService service = new CardDataMcmReaderService();
//        CardDomain dataFromMcm = service.getDataFromMcm("https://www.cardmarket.com/en/Magic/Products/Singles/Modern-Masters-2015/Mox-Opal");
//        System.out.println(dataFromMcm);
        GoogleSheetService service = new GoogleSheetService();
        service.getCardData();
        //       service.writeCell("cosik", "Modern!H1:H1");

    }
}
