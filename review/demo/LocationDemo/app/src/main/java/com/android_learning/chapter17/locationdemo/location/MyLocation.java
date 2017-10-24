package com.android_learning.chapter17.locationdemo.location;

import android.app.Activity;
import android.view.View;

/**
 * Created by xincunli on 11/11/16.
 */

public class MyLocation {
    Activity mContext;
    View view;
    public MyLocation(Activity ctx, View view) {
        this.mContext = ctx;
        this.view = view;
    }

    public Address getCurrentLocation() {
        // check if GPS enabled
        GPSTracker gpsTracker = new GPSTracker(mContext, view);
        Address address = new Address();

        if (gpsTracker.getIsGPSTrackingEnabled())
        {
            address.stringLatitude = String.valueOf(gpsTracker.latitude);

            address.stringLongitude = String.valueOf(gpsTracker.longitude);

            address.country = gpsTracker.getCountryName(mContext);

            address.city = gpsTracker.getLocality(mContext);

            address.postalCode = gpsTracker.getPostalCode(mContext);

            address.addressLine = gpsTracker.getAddressLine(mContext);
        }
        else
        {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gpsTracker.showSettingsAlert();
        }
        return address;
    }
}
