package com.symb.task.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BranchActivity extends AppCompatActivity {
    DatabaseHelper mydb;
    EditText editTodo;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);
        mydb=new DatabaseHelper(this);
        editTodo=(EditText)findViewById(R.id.todo);
        save=(Button) findViewById(R.id.save_button);
        saveData();
    }
    public  void saveData()
    {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             boolean isInsert=   mydb.insertData(editTodo.getText().toString());
             if(isInsert=true)
                 Toast.makeText(BranchActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
             else
                 Toast.makeText(BranchActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}