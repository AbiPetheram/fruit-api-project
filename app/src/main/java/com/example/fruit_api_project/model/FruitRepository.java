package com.example.fruit_api_project.model;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.fruit_api_project.service.ApiService;
import com.example.fruit_api_project.service.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FruitRepository {
    private MutableLiveData<List<Fruit>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public FruitRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Fruit>> getMutableLiveData(){
        ApiService apiService = RetrofitInstance.getService();
        Call<List<Fruit>> call = apiService.getAllFruit();
        call.enqueue(new Callback<List<Fruit>>() {
            @Override
            public void onResponse(Call<List<Fruit>> call, Response<List<Fruit>> response) {
                List<Fruit> fruits = response.body();
                mutableLiveData.setValue(fruits);
            }

            @Override
            public void onFailure(Call<List<Fruit>> call, Throwable t) {
                Log.i("HTTP Failure", t.getMessage());

            }
        });
        return mutableLiveData;
    }
}
