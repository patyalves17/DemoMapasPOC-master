package com.example.logonpf.demomapaspoc.api;

import com.example.logonpf.demomapaspoc.model.Linha;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface MetroAPI {

    @GET("/linhas")
    Observable<List<Linha>> getLinhas();

}
