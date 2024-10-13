package com.pluralsight;

public class transaction {
    private String time;
    private String hour;
    private String description;
    private String vendor;
    private String amount;

    public transaction(String time, String hour, String description, String vendor, String amount) {
        this.time = time;
        this.hour = hour;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
}
