package com.example.fruit_api_project.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.fruit_api_project.model.Fruit;
import com.example.fruit_api_project.model.FruitRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    FruitRepository fruitRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.fruitRepository = new FruitRepository(application);
    }

    public MutableLiveData<List<Fruit>> getAllFruit(){
        return fruitRepository.getMutableLiveData();
    }
}
