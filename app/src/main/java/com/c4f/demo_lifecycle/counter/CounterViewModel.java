package com.c4f.demo_lifecycle.counter;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

public class CounterViewModel extends ViewModel {
    private MutableLiveData<Integer> counter = new MutableLiveData<>();
    private CounterModel model;

    CounterViewModel() {
        model = new CounterModel();
    }

    static CounterViewModel of(FragmentActivity fragmentActivity) {
        return ViewModelProviders.of(fragmentActivity).get(CounterViewModel.class);
    }

    public LiveData<Integer> getCounter() {
        return counter;
    }

    public void increment() {
        Integer currentValue = counter.getValue();
        if (currentValue == null) {
            counter.setValue(0);
            return;
        }
        currentValue = currentValue + 1;

        model.addItem(currentValue);

        counter.setValue(currentValue);

    }

    public void decrement() {
        Integer currentValue = counter.getValue();
        if (currentValue == null) {
            counter.setValue(0);
            return;
        }

        if (currentValue == 0) {
            counter.setValue(0);
            return;
        }

        currentValue = currentValue - 1;

        model.addItem(currentValue);
        
        counter.setValue(currentValue);
    }
}