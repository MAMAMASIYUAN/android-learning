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



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_person);
        listView1=(ListView)findViewById(R.id.listView1);

        //获取Personlist
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        ArrayList<Person> Personlist=bundle.getParcelableArrayList("list");
        //Personlist转化为数组
        int listsize=Personlist.size();
        final  Person[] Persons = (Person[])Personlist.toArray(new Person[listsize]);

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


}