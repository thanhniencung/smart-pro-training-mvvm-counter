package com.c4f.demo_lifecycle.counter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.c4f.demo_lifecycle.R;

public class CounterActivity extends AppCompatActivity {

    private CounterViewModel counterViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Counter Activity");

        setContentView(R.layout.activity_main);

        counterViewModel = CounterViewModel.of(CounterActivity.this);


        Button btnIncrement = findViewById(R.id.increment);
        Button btnDecrement = findViewById(R.id.decrement);

        final TextView txtResult = findViewById(R.id.result);


        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterViewModel.increment();
            }
        });

        btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterViewModel.decrement();
            }
        });

        counterViewModel.getCounter().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                txtResult.setText(integer.toString());
            }
        });

    }
}
