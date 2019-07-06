package com.c4f.demo_lifecycle.counter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class CounterModel {

    public static List<Integer> ITEMS = new ArrayList<>();

    public void addItem(int value) {
        // insert
        ITEMS.add(value);
    }

}
