package com.google.anamika.masterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView= (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(MainActivity.this,"Hello: "+position,Toast.LENGTH_LONG).show();

                if(position==0)
                {
                    Intent intent=new Intent(MainActivity.this,Calculator.class);
                    startActivity(intent);
                }
                if(position==1)
                {
                    Intent intent=new Intent(MainActivity.this,MusicMedia.class);
                    startActivity(intent);
                }
            }
        });
    }
}
