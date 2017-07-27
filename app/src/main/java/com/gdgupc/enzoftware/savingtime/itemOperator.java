package com.gdgupc.enzoftware.savingtime;

/**
 * Created by enzoftware on 7/26/17.
 */

public class itemOperator {
    int amount;
    String about;
    Boolean income;

    public itemOperator(int amount, String about, Boolean income) {
        this.amount = amount;
        this.about = about;
        this.income = income;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Boolean getIncome() {
        return income;
    }

    public void setIncome(Boolean income) {
        this.income = income;
    }
}
