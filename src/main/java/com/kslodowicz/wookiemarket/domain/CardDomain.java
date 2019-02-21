package com.kslodowicz.wookiemarket.domain;

public class CardDomain {

    private String cardName;
    private String expansionName;
    private String pricaTrend;
    private String link;

    public CardDomain() {
    }

    public CardDomain(String cardName, String expansionName, String pricaTrend, String link) {
        this.cardName = cardName;
        this.expansionName = expansionName;
        this.pricaTrend = pricaTrend;
        this.link = link;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getExpansionName() {
        return expansionName;
    }

    public void setExpansionName(String expansionName) {
        this.expansionName = expansionName;
    }

    public String getPricaTrend() {
        return pricaTrend;
    }

    public void setPricaTrend(String pricaTrend) {
        this.pricaTrend = pricaTrend;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "CardDomain{" + "cardName='" + cardName + '\'' + ", expansionName='" + expansionName + '\'' + ", pricaTrend='" + pricaTrend + '\'' + '}';
    }
}
