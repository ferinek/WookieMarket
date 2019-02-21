package com.kslodowicz.wookiemarket.service;

import com.google.api.services.sheets.v4.model.GridData;
import com.google.api.services.sheets.v4.model.Sheet;
import com.kslodowicz.wookiemarket.bean.GoogleSpreedSheetBean;
import com.kslodowicz.wookiemarket.helper.GoogleSheetHelper;

import java.util.List;

public class GoogleSheetService {


    public void getCardData(){
        GoogleSheetHelper spreedSheet = GoogleSpreedSheetBean.getSpreedSheet();
        List<Sheet> sellSheetsNames = spreedSheet.getSheet();
        for (Sheet sheet:sellSheetsNames){

            List<GridData> data = sheet.getData();

        }
    }

}
