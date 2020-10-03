package com.symb.task.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class myAdapter extends BaseAdapter {
    Context context;
    ArrayList<todo_object> arrayList;

    public myAdapter(Context context, ArrayList<todo_object> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.mycustomlistview, null);
            TextView todo = (TextView) view.findViewById(R.id.toto_text);
            TextView date = (TextView) view.findViewById(R.id.date_text);


            todo_object t = arrayList.get(i);
            todo.setText(t.getTodo());
            date.setText(t.getTimestamp());


            return view;



    }

        @Override
        public int getCount () {
            return this.arrayList.size();
        }
    }

