package com.example.administrator.today;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.Day_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Day_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());


    }

}

    class CustomOnItemSelectedListener implements OnItemSelectedListener{
   public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
       Toast.makeText(parent.getContext(),
               "OnItemSelectedListener : " + parent.getItemAtPosition(position).toString(),
               Toast.LENGTH_SHORT).show();
   };

   public void onNothingSelected(AdapterView<?> parent){};



}