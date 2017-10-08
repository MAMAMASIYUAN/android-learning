package com.example.administrator.personinquiry;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017/10/4.
 */

public class Person implements Parcelable {
    String number;
    String password;
    String name;
    String gender;
    String address;
    String workexperience;


    public Person(String number, String password,String name, String gender, String address,String workexperience) {
        this.number = number;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.workexperience=workexperience;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.number);
        dest.writeString(this.password);
        dest.writeString(this.name);
        dest.writeString(this.gender);
        dest.writeString(this.address);
        dest.writeString(this.workexperience);
    }

    protected Person(Parcel in) {
        this.number = in.readString();
        this.password = in.readString();
        this.name = in.readString();
        this.gender = in.readString();
        this.address = in.readString();
        this.workexperience = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
