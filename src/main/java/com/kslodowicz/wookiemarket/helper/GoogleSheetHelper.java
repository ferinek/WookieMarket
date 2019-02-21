package com.kslodowicz.wookiemarket.helper;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GoogleSheetHelper {
    private static final String[] SELL_SHEETS = new String[] { "S X", "S W", "S U", "S B", "S R", "S G", "S M", "S Art", "S Lands", };
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
        String range = name.concat("!A2:F200");
        try {
            return spreadsheet.spreadsheets().values().get(id, range).execute();
        } catch (IOException e) {
            return null;
        }
    }
}
