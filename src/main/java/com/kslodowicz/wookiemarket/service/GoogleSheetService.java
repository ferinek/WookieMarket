package com.kslodowicz.wookiemarket.service;

import com.google.api.services.sheets.v4.model.ValueRange;
import com.kslodowicz.wookiemarket.bean.GoogleSpreedSheetBean;
import com.kslodowicz.wookiemarket.domain.CardDomain;
import com.kslodowicz.wookiemarket.enums.ESpreedColumn;
import com.kslodowicz.wookiemarket.helper.GoogleSheetHelper;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class GoogleSheetService {

    private static final Double EURO_COST = 4.0d;
    CardDataMcmReaderService mcmReaderService;
    GoogleSheetHelper googleSheetHelper;

    public GoogleSheetService() {
        mcmReaderService = new CardDataMcmReaderService();
        googleSheetHelper = GoogleSpreedSheetBean.getSpreedSheet();
    }

    public void getCardData() {
        List<String> sellSheetsNames = googleSheetHelper.getSellSheetsNames();
        for (String sheetName : sellSheetsNames) {
            parseSheet(sheetName);
        }
    }

    private void parseSheet(String sheetName) {
        ValueRange values = googleSheetHelper.getSheet(sheetName);
        List<List<Object>> rows = values.getValues();
        List<List<Object>> cards = new LinkedList<>();
        for (int i = 0; i < rows.size(); i++) {
            parseRow(rows.get(i), cards, sheetName);
        }
        googleSheetHelper.updateSheet(sheetName, cards);
    }

    private void parseRow(List<Object> row, List<List<Object>> cards, String sheetName) {
        if (row.size()==7){
            String link = (String) row.get(ESpreedColumn.LINK.getColumnNumber());
            LinkedList<Object> cardValues = new LinkedList<>();
            if (StringUtils.isNotBlank(link)) {

                CardDomain dataFromMcm = mcmReaderService.getDataFromMcm(link);
                cardValues.add(convertPrice(dataFromMcm.getPriceTrend()));
                cardValues.add(dataFromMcm.getCardName());
                cardValues.add(dataFromMcm.getExpansionName());
                cards.add(cardValues);
            }else{
                cards.add(new LinkedList<>());
            }
        }else{
            cards.add(new LinkedList<>());
        }

    }

    private String convertPrice(String priceString) {
        Double priceInEuro = Double.parseDouble(priceString.replace(",", "."));
        return Double.toString(priceInEuro * EURO_COST).replace(".", ",");
    }
}
