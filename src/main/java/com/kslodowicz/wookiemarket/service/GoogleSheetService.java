package com.kslodowicz.wookiemarket.service;

import com.google.api.services.sheets.v4.model.ValueRange;
import com.kslodowicz.wookiemarket.bean.GoogleSpreedSheetBean;
import com.kslodowicz.wookiemarket.domain.CardDomain;
import com.kslodowicz.wookiemarket.helper.GoogleSheetHelper;

import java.util.List;

public class GoogleSheetService {

    CardDataMcmReaderService mcmReaderService;

    public GoogleSheetService() {
        mcmReaderService = new CardDataMcmReaderService();
    }

    public void getCardData() {
        GoogleSheetHelper spreedSheet = GoogleSpreedSheetBean.getSpreedSheet();
        List<String> sellSheetsNames = spreedSheet.getSellSheetsNames();
        for (String sheetName : sellSheetsNames) {
            ValueRange values = spreedSheet.getSheet(sheetName);
            List<List<Object>> rows = values.getValues();
            for (List<Object> row : rows) {
                String link = (String) row.get(5);
                CardDomain dataFromMcm = mcmReaderService.getDataFromMcm(link);
                System.out.println(dataFromMcm);

            }
        }
    }

}
