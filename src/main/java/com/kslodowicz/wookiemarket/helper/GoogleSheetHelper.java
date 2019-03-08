package com.kslodowicz.wookiemarket.helper;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GoogleSheetHelper {
    private static final String OPTIONS = "USER_ENTERED";
    private static final String[] SELL_SHEETS = new String[]{"S G", "S M", "S Art", "S Lands",};
    private final String id;
    Sheets spreadsheet;

    public List<String> getSellSheetsNames() {
        return Arrays.asList(SELL_SHEETS);
    }

    public GoogleSheetHelper(Sheets spreadsheet, String id) {
        this.spreadsheet = spreadsheet;
        this.id = id;
    }

    public ValueRange getSheet(String name) {
        String range = name.concat("!A2:G200");
        try {
            return spreadsheet.spreadsheets().values().get(id, range).execute();
        } catch (IOException e) {
            return null;
        }
    }


    public String generateRange(String sheetName, int size) {
        return new StringBuilder(sheetName).append("!B2").append(":D").append(size + 1).toString();
    }

    public void updateSheet(String sheetName, List<List<Object>> cards) {
        ValueRange body = new ValueRange().setValues(cards);
        String range = generateRange(sheetName, cards.size());
        try {
            spreadsheet.spreadsheets().values().update(id, range, body).setValueInputOption(OPTIONS).execute();
        } catch (IOException e) {
            System.err.println("ZAPIS SIE ZJEBAL");
            e.printStackTrace();
        }
    }
}
