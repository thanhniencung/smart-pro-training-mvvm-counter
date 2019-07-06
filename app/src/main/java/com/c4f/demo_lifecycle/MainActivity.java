package com.c4f.demo_lifecycle;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        //create layout here
        setContentView(R.layout.activity_main);
    }
}
