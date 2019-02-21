package com.kslodowicz.wookiemarket.helper;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Sheet;
import com.google.api.services.sheets.v4.model.Spreadsheet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GoogleSheetHelper {
    private static final  String[] SELL_SHEETS=new String[]{"S X","S W","S U","S B","S R","S G","S M","S Art","S Lands",};

    Sheets spreadsheet;

    public List<String> getSellSheetsNames(){
        return Arrays.asList(SELL_SHEETS);
    }

    public GoogleSheetHelper(Sheets spreadsheet) {
        this.spreadsheet = spreadsheet;
    }

    public List<Sheet> getSheet(){
        return spreadsheet.gett;
    }

    public List<List<String>> readWholeSheet() {
        return new LinkedList<>();

    }

    public String readCell(long column, long row) {
        return null;
    }

    public void writeCell(long column, long row, String value) {

    }
}
