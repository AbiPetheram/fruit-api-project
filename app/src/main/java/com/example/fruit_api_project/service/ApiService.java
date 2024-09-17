package com.example.fruit_api_project.service;

import com.example.fruit_api_project.model.Fruit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET
    Call<List<Fruit>> getAllFruit();
}
