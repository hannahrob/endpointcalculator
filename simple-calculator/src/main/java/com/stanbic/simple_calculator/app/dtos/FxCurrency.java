package com.stanbic.simple_calculator.app.dtos;

public class FxCurrency {
    private Integer amount;
    private String baseCurrency;
    private String fxCurrency;

    public FxCurrency(Integer amount, String baseCurrency, String fxCurrency) {
        this.amount = amount;
        this.baseCurrency = baseCurrency;
        this.fxCurrency = fxCurrency;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getFxCurrency() {
        return fxCurrency;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public void setFxCurrency(String fxCurrency) {
        this.fxCurrency = fxCurrency;
    }
}
