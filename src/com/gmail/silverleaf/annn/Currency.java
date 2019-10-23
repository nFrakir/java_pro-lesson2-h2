package com.gmail.silverleaf.annn;

public class Currency {
    private String base_currency;
    private String currency;
    private Double buy;
    private Double sale;

    public Currency(String base_currency, String currency, Double buy, Double sale) {
        super();
        this.base_currency = base_currency;
        this.currency = currency;
        this.buy = buy;
        this.sale = sale;
    }

    public Currency() {
        super();
    }

    public String getBase_currency() {
        return base_currency;
    }

    public void setBase_currency(String base_currency) {
        this.base_currency = base_currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBuy() {
        return buy;
    }

    public void setBuy(Double buy) {
        this.buy = buy;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "base_currency='" + base_currency + '\'' +
                ", currency='" + currency + '\'' +
                ", buy=" + buy +
                ", sale=" + sale +
                '}';
    }
}