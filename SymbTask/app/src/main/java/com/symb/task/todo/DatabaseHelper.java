package com.symb.task.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static  final String Database_name="todo.db";
    public static  final String Table_name="todo_table";
   // public static  final String col1="id";
    public static  final String col2="todo_items";
    public static  final String col3="timestamp";

    public DatabaseHelper(@Nullable Context context) {
        super(context, Database_name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+Table_name+"(todo_items text,timestamp text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
db.execSQL("drop table if exists "+Table_name);
onCreate(db);
    }
    public  boolean insertData(String todo_items)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValue=new ContentValues();
        contentValue.put(col2,todo_items);
        contentValue.put(col3,getDateTime());
        long result=db.insert(Table_name,null,contentValue);
        if (result==-1)
            return false;
        else
            return true;

    }
    public ArrayList<todo_object> getallData()
    {
        ArrayList<todo_object> arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select *  from "+Table_name,null);
        if(cursor!=null && cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                String todoitem = (cursor.getString(0));
                String timestamp = (cursor.getString(1));
                //System.out.println(timestamp);
                todo_object object = new todo_object(todoitem, timestamp);
                arrayList.add(object);
            }
        }
        return  arrayList;
    }
    private String getDateTime(){
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat(
                "yyyy-MM-dd:hh:mm:ss", Locale.getDefault());
        Date date= new Date();
        return simpleDateFormat.format(date);

    }

}
