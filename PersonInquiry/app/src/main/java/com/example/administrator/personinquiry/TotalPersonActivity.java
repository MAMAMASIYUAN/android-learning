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

    private ListView listView1;
    private HashMap<String,Person> personMap_get = new HashMap<String,Person>();
    private int i;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_person);
        listView1=(ListView)findViewById(R.id.listView1);

        //获取MainActivity传来的hashmap
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        SerializableMap sermap_get= (SerializableMap) bundle.getSerializable("sermap_key");
        personMap_get=sermap_get.getMap();





    }
    @Override
    protected void onStart() {
        super.onStart();

        //personMap_get转化为数组
        final Person[] Persons =MaptoArray(personMap_get);


        PersonAdapter madapter = new PersonAdapter(TotalPersonActivity.this, R.layout.person_item, Persons);
        listView1.setAdapter(madapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                i=position;
                Person selectedPerson = Persons[position];
                Intent intent3=new Intent(TotalPersonActivity.this,PersonDetailActivity.class);
                intent3.putExtra("Person", selectedPerson);
                startActivityForResult(intent3,11);}

        });



    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if ( requestCode==11&&resultCode==5) {
            Person p=(Person) data.getSerializableExtra("Person_PD");
            personMap_get.put(Integer.toString(i+2017001),p);
        }
    }

    @Override
    public void onBackPressed(){
//        返回hashmap
        SerializableMap sermapTP=new SerializableMap();
        sermapTP.setMap(personMap_get);
        Bundle bundle = new Bundle();
        bundle.putSerializable("sermapTP_key",sermapTP);

        Intent intent11 = new Intent();
        intent11.putExtras(bundle);
        setResult(55,intent11);
        finish();
    }


    //personMap_get转化为数组
     public Person[] MaptoArray(HashMap<String,Person>changedmap){
         int mapsize=changedmap.size()-1;
         Person[] returnpersons =new Person[mapsize];
//         returnpersons[0]=changedmap.get("admin");
        for(int i=0;i<mapsize;i++){
            String key= String.valueOf(2017001+i);
            returnpersons[i]=changedmap.get(key);
        }
        return returnpersons;

    }


}