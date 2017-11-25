package com.example.iori.inq;

/**
 * Created by IORI on 11/14/2017.
 */

public class Company {

    private int id;
    private String title;
    private int time;
    private float price;
    private int number;
    private float rreturn;
    private String details;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public  String getTitle() {
        return  title;

    }

    public void setTime(int time) {
        this.time = time;
    }
    public int getTime() {
        return time;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public float getPrice() {
        return price;
    }


    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }

    public void setRreturn(float rreturn) {
        this.rreturn = rreturn;
    }
    public float getRreturn() {
        return rreturn;
    }


    public void setDetails(String details) {
        this.details = details;
    }
    public  String getDetails() {
        return details;
    }
}
