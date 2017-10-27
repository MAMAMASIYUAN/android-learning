package com.android_learning.chapter17.locationdemo.location;

/**
 * Created by xincunli on 11/12/16.
 */

public class Address {
    public String stringLatitude;
    public String stringLongitude;
    public String country;
    public String city;
    public String postalCode;
    public String addressLine;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(addressLine).append(" ");
        sb.append(city).append(" ");
        sb.append(country).append(" ");
        //sb.append(postalCode);
        return sb.toString();
    }
}
