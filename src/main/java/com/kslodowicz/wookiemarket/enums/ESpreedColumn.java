package com.kslodowicz.wookiemarket.enums;

/**
 * Created by Wookie on 21.02.2019.
 */
public enum ESpreedColumn {
    COUNT("A",0),
    PRICE("B",1),
    NAME("C",2),
    EXPANSION("D",3),
    LINK("G",6) ;


    String columnSymbol;
    int columnNumber;

    ESpreedColumn(String columnSymbol, int columnNumber) {
        this.columnSymbol = columnSymbol;
        this.columnNumber = columnNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public String getColumnSymbol() {
        return columnSymbol;
    }
}
