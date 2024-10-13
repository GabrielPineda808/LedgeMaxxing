package com.pluralsight;

public class Transaction {
    private String date;
    private String hour;
    private String description;
    private String vendor;
    private String amount;

    public Transaction(String date, String hour, String description, String vendor, String amount) {
        this.date = date;
        this.hour = hour;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String Date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String display(){
        return date +" | "+ hour+" | " + description+" | " + vendor+" | " + amount;
    }
}
