package com.example.logonpf.demomapaspoc;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.logonpf.demomapaspoc.api.ApiUtils;
import com.example.logonpf.demomapaspoc.api.MetroAPI;
import com.example.logonpf.demomapaspoc.model.Estacao;
import com.example.logonpf.demomapaspoc.model.Linha;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Linha linha;
    private Estacao estacao;
    private MetroAPI mAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if(getIntent()!=null){


            linha=getIntent().getParcelableExtra("Linha");
            mAPI= ApiUtils.getMetroAPI();

            mAPI.getEstacoes(linha.getCor())
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<List<Estacao>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(List<Estacao> estacoes) {

                    for (Estacao estacao:estacoes){
                        LatLng marcador = new LatLng(
                                Double.parseDouble(estacao.getLatitude()),
                                Double.parseDouble(estacao.getLongitude())
                        );
                        mMap.addMarker(new MarkerOptions().position(marcador).title(estacao.getNome()));

                    }

                }
            });



        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-23.5641085, -46.6524089);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Fiap"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,16));
    }
}
