package com.itheima.gson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //创建Gson对象
        Gson gson = new Gson();

        //1.Gson实现对象和json相互转换
        //toJson方法将Person对象转json格式
        Person person = new Person("lisi", 101);

        String json = gson.toJson(person);

        if (BuildConfig.DEBUG) Log.d("MainActivity", "Person对象转json格式\n" + json);


        //fromJson方法将json格式字符串转Person对象
        Person person1 = gson.fromJson(json, Person.class);
        
        if (BuildConfig.DEBUG) Log.d("MainActivity", "将json格式字符串转Person对象\n"+person1.toString());


        //2.Gson实现List集合对象和json格式相互转换
        List<Person> persons = new ArrayList<Person>();

        for(int i = 0;i < 3;i++){
            Person p = new Person("lisi" + i, 101 + i);
            persons.add(p);
        }

        //toJson方法将List集合对象转json
        String json1 = gson.toJson(persons);
        if (BuildConfig.DEBUG) Log.d("MainActivity", "List集合对象转json\n"+json1);

        //fromJson方法将json字符串转List集合对象
        List<Person> lists = gson.fromJson(json1,
                new TypeToken<List<Person>>(){}.getType());//泛型类型会被擦擦除

        if (BuildConfig.DEBUG) Log.d("MainActivity", "json字符串转List集合对象\n" + lists.toString());
    }
}
