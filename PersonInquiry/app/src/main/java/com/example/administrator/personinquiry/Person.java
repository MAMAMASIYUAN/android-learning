package com.example.administrator.personinquiry;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/4.
 */

public class Person implements Serializable {
    private String number;
    private String password;
    private String name;
    private String gender;
    private String address;
    private String website;
    private String workexperience;
    private int portraitId;



    public Person(String number, String password,String name, String gender, String address,String workexperience,String website,int portraitId) {
        this.number = number;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.workexperience=workexperience;
        this.website=website;
        this.portraitId=portraitId;

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

   public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getWorkexperience() {
        return workexperience;
    }
    public void setWorkexperience(String workexperience) {
        this.workexperience = workexperience;
    }
    public int getPortraitId() {
        return portraitId;
    }
    public void setPortraitId(int portraitId) {
        this.portraitId = portraitId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}
