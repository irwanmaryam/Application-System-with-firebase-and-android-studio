package com.example.muazarresources;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Payment {

    public static Payment pPayment;

    private String Name;
    private String spinnerMonth;
    private String spinnerStatus;
    private String amount;
    private String date;

    public Payment(String Name, String spinnerMonth, String spinnerStatus, String amount, String date) {
        this.Name = Name;
        this.spinnerMonth = spinnerMonth;
        this.spinnerStatus = spinnerStatus;
        this.amount = amount;
        this.date = date;
    }

    public Payment(){}

    public String getName() {
        return Name;
    }

    public void setName(String spinnerName) {
        this.Name = Name;
    }

    public String getspinnerMonth() { return spinnerMonth; }

    public void setspinnerMonth(String spinnerMonth) {
        this.spinnerMonth = spinnerMonth;
    }

    public String getspinnerStatus() {
        return spinnerStatus;
    }

    public void setspinnerStatus(String spinnerStatus) {
        this.spinnerStatus = spinnerStatus;
    }

    public String getamount() {
        return amount;
    }

    public void setamount(String amount) {
        this.amount = amount;
    }

    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "Name='" + Name + '\'' +
                "spinnerMonth='" + spinnerMonth + '\'' +
                ", spinnerStatus='" + spinnerStatus + '\'' +
                ", amount=" + amount + '\'' +
                ", date=" + date +
                '}';
    }

    @Exclude
    public Map<String, Object> toMap (){
        HashMap<String,Object> result = new HashMap<>();
        result.put ("Name",Name);
        result.put ("spinnerMonth",spinnerMonth);
        result.put ("spinnerStatus",spinnerStatus);
        result.put ("amount",amount);
        result.put ("date",date);
        return result;
    }

}
