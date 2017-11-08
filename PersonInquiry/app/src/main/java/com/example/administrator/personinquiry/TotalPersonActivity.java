package com.example.administrator.personinquiry;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalPersonActivity extends AppCompatActivity {

//    private Map<String,Person> personMap1 = new HashMap<String,Person>();
    private ListView listView1;
    private HashMap<String,Person> personMap_get = new HashMap<String,Person>();



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_person);
        listView1=(ListView)findViewById(R.id.listView1);

        //获取
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        SerializableMap sermap_get= (SerializableMap) bundle.getSerializable("sermap_key");
        personMap_get=sermap_get.getMap();

        //personMap_get转化为数组
        final Person[] Persons =MaptoArray(personMap_get);


        PersonAdapter madapter = new PersonAdapter(TotalPersonActivity.this, R.layout.person_item, Persons);
        listView1.setAdapter(madapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Person selectedPerson = Persons[position];
                Intent intent3=new Intent(TotalPersonActivity.this,PersonDetailActivity.class);
                intent3.putExtra("Person", selectedPerson);
                startActivity(intent3);}

        });


    }

    //personMap_get转化为数组
     public Person[] MaptoArray(HashMap<String,Person>changedmap){
         int mapsize=changedmap.size()-1;
         Person[] returnpersons =new Person[mapsize];
        for(int i=0;i<mapsize;i++){
            String key= String.valueOf(2017001+i);
            returnpersons[i]=changedmap.get(key);
        }
        return returnpersons;

    }


}