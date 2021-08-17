package com.example.muazarresources;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Users {

    public static Users uUsers;

    private String sName;
    private String age;
    private String pName;
    private String school;
    private String session;
    private String pId;

    private String sId;



    public Users(String sName, String age, String pName, String school, String session, String pId, String sId) {
        this.sName = sName;
        this.age = age;
        this.pName = pName;
        this.school = school;
        this.session = session;
        this.pId = pId;
        this.sId = sId;
    }



    public Users(){}

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getage() { return age; }

    public void setage(String age) {
        this.age = age;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getschool() {
        return school;
    }

    public void setschool(String school) {
        this.school = school;
    }

    public String getsession() {
        return session;
    }

    public void setsession(String session) {
        this.session = session;
    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "sName='" + sName + '\'' +
//                "age='" + age + '\'' +
//                ", pName='" + pName + '\'' +
//                ", school=" + school + '\'' +
//                ", session=" + session +
//                '}';
//    }
//
//    @Exclude
//    public Map<String, Object> toMap (){
//        HashMap<String,Object> result = new HashMap<>();
//        result.put ("sName",sName);
//        result.put ("age",age);
//        result.put ("pName",pName);
//        result.put ("school",school);
//        result.put ("session",session);
//        return result;
//    }

}

