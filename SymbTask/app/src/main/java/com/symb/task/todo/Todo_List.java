package com.symb.task.todo;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

public class Todo_List extends AppCompatActivity {

    DatabaseHelper mydb;
    ArrayList<todo_object>arrayList;
    myAdapter myAdapter1;
    ListView l1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo__list);
        mydb=new DatabaseHelper(this);
        arrayList=new ArrayList<>();
        l1=(ListView)findViewById(R.id.todolist);
        loaddatainList();
    }
    private  void loaddatainList()
    {
        arrayList =mydb.getallData();
       myAdapter1=new myAdapter(this,arrayList);
       l1.setAdapter(myAdapter1);
       myAdapter1.notifyDataSetChanged();
    }

}