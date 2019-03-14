package com.mycompany.mynotebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v4.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    DB db;
    SimpleCursorAdapter scAdapter;
    RecyclerView rvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DB(this);
        db.open();

        String[] from = new String[]{DB.COLUMN_TITLE, DB.COLUMN_TEXT};
        int[] to = new int[]{R.id.itemTitle, R.id.itemText};

        scAdapter = new SimpleCursorAdapter(this,R.layout.item, null, from , to);
        rvData = findViewById(R.id.recyclerView);
        rvData.setAdapter(scAdapter);


    }


}
