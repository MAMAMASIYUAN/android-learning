package com.example.iori.downloading;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.InputMismatchException;

/**
 * Created by IORI on 9/26/2017.
 */

public class DownloadTextTask extends AsyncTask<TextView, Void, String> {

    TextView showTextResult = null;
    String url;

    public DownloadTextTask(String url){
        this.url = url;
    }

    @Override
    protected String doInBackground(TextView... textViews) {
         this.showTextResult = textViews[0];
         return downloadText(this.url);

    }

    @Override
    protected void onPostExecute(String result){
        showTextResult.setText(result);
    }

    private String downloadText(String url) {
        String string = null;
        try{

            URL urln = new URL(url);
            HttpURLConnection con =(HttpURLConnection)urln.openConnection();
            InputStream is = con.getInputStream();
            string = getString(is);
        }catch(Exception e){}

        return string;
    }

    private String getString(InputStream is) throws IOException {
        String gettedString = null;
       try {
           BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
           StringBuffer sb = new StringBuffer();
           String line = null;
           while ((line = reader.readLine()) != null) {
               sb.append(line + "\n");
           }
           reader.close();
           gettedString = sb.toString();
           return gettedString;
       }catch(Exception e){}

        return gettedString;
    }


}
