package com.example.administrator.personinquiry;

/**
 * Created by Administrator on 2017/10/5.
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 序列化map供Bundle传递map使用
 * Created  on 13-12-9.
 */
public class SerializableMap implements Serializable{

  // private Map<String,Person> map;
//    private Map<String,Person> map = new HashMap<String,Person>();
    private HashMap<String,Person> map;
    public  SerializableMap(){

    }
    public HashMap<String, Person> getMap() {
        return map;
    }

    public void setMap(HashMap<String, Person> map) {
        this.map = map;
    }

}
