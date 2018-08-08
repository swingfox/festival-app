package com.example.project.festivalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        InitializePoints();
    }

    final MapsActivity main = this;

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
        Marker marker1 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(18.723183, 116.675271))
                .draggable(false).visible(false));
        Marker marker2 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.072321, 127.938289))
                .draggable(false).visible(false));
        Marker marker3 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(18.808840, 126.897930))
                .draggable(false).visible(false));
        Marker marker4 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(6.117299, 127.169328))
                .draggable(false).visible(false));



        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent = new Intent(main,FestivalInfoActivity.class);
                intent.putExtra("txtFestival",marker.getTitle());
                intent.putExtra("txtInfo",marker.getTag().toString());
                startActivity(intent);
            }
        });
        ArrayList<Marker> festivals = new ArrayList<Marker>();

        Marker sinulog = mMap.addMarker(points.get(0));
        Marker tuna = mMap.addMarker(points.get(1));
        Marker aswang = mMap.addMarker(points.get(2));
        Marker atiatihan = mMap.addMarker(points.get(3));
        Marker surigao = mMap.addMarker(points.get(4));
        Marker iloilo = mMap.addMarker(points.get(5));
        Marker bukidnon = mMap.addMarker(points.get(6));
        Marker davao = mMap.addMarker(points.get(7));
        Marker cagayan = mMap.addMarker(points.get(8));
        Marker pampanga = mMap.addMarker(points.get(9));
        Marker camiguin = mMap.addMarker(points.get(10));
        Marker bacolod = mMap.addMarker(points.get(11));
        Marker marinduque = mMap.addMarker(points.get(12));
        Marker bulacan = mMap.addMarker(points.get(13));
        Marker tacloban = mMap.addMarker(points.get(14));
        Marker negros = mMap.addMarker(points.get(15));
        Marker samar = mMap.addMarker(points.get(16));
        Marker zamboanga = mMap.addMarker(points.get(17));
        Marker agusan = mMap.addMarker(points.get(18));
        Marker lucban = mMap.addMarker(points.get(19));
        Marker tagbilaran = mMap.addMarker(points.get(20));
        Marker dagupan = mMap.addMarker(points.get(21));

        festivals.add(sinulog);
        festivals.add(tuna);
        festivals.add(aswang);
        festivals.add(atiatihan);
        festivals.add(surigao);
        festivals.add(iloilo);
        festivals.add(bukidnon);
        festivals.add(davao);
        festivals.add(cagayan);
        festivals.add(pampanga);
        festivals.add(bacolod);
        festivals.add(marinduque);
        festivals.add(bulacan);
        festivals.add(tacloban);
        festivals.add(negros);
        festivals.add(samar);
        festivals.add(zamboanga);
        festivals.add(agusan);
        festivals.add(lucban);
        festivals.add(tagbilaran);
        festivals.add(dagupan);

        sinulog.setTag(getString(R.string.sinulog_description));
        tuna.setTag(getString(R.string.tuna_description));
        aswang.setTag(getString(R.string.aswang_description));
        atiatihan.setTag(getString(R.string.atiatihan_description));
        surigao.setTag(getString(R.string.sandugo_description));
        iloilo.setTag(getString(R.string.dinagyang_description));
        bukidnon.setTag(getString(R.string.kaamulan_description));
        davao.setTag(getString(R.string.kadayawan_description));
        cagayan.setTag(getString(R.string.kagayan_description));
        pampanga.setTag(getString(R.string.kuraldal_description));
        camiguin.setTag(getString(R.string.lanzones_description));
        bacolod.setTag(getString(R.string.masskara_description));
        marinduque.setTag(getString(R.string.moriones_description));
        bulacan.setTag(getString(R.string.obando_description));
        negros.setTag(getString(R.string.pintaflores_description));
        samar.setTag(getString(R.string.sarakiki_description));
        tacloban.setTag(getString(R.string.pintados_description));
        zamboanga.setTag(getString(R.string.hermosa_description));
        agusan.setTag(getString(R.string.naliyagan_description));
        lucban.setTag(getString(R.string.pahiyas_description));
        tagbilaran.setTag(getString(R.string.sandugo_description));
        dagupan.setTag(getString(R.string.bangus_description));

        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        //the include method will calculate the min and max bound.
        builder.include(marker1.getPosition());
        builder.include(marker2.getPosition());
        builder.include(marker3.getPosition());
        builder.include(marker4.getPosition());

        for(int i = 0; i < festivals.size(); i++){
            builder.include(festivals.get(i).getPosition());
        }

        LatLngBounds bounds = builder.build();

        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        int padding = (int) (width * 0.10); // offset from edges of the map 12% of screen

        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);

        mMap.animateCamera(cu);
    }

    private ArrayList<MarkerOptions> points;
    private void InitializePoints(){
        points = new ArrayList();
        points.add(getPlace(new LatLng(10.294248, 123.902065),R.string.sinulog));   // 0 sinulog
        points.add(getPlace(new LatLng(6.1164, 125.1716),R.string.tuna));           // 1 tuna
        points.add(getPlace(new LatLng(11.5529, 122.7407),R.string.aswang));        // 2 aswang
        points.add(getPlace(new LatLng(11.6892, 122.3674),R.string.atiatihan));     // 3 ati atihan
        points.add(getPlace(new LatLng(9.7571, 125.5138),R.string.bonokbonok));     // 4 surigao
        points.add(getPlace(new LatLng(10.7202, 122.5621),R.string.dinagyang));     // 5 ilo ilo
        points.add(getPlace(new LatLng(8.1306, 125.1277),R.string.kaamulan));       // 6 bukidnon
        points.add(getPlace(new LatLng(7.1907, 125.4553),R.string.kadayawan));      // 7 davao
        points.add(getPlace(new LatLng(8.4542, 124.6319),R.string.kagayan));        // 8 kagayan
        points.add(getPlace(new LatLng(14.8876, 120.6142),R.string.kuraldal));      // 9 pampanga
        points.add(getPlace(new LatLng(9.1732, 124.7299),R.string.lanzones));       // 10 camiguin
        points.add(getPlace(new LatLng(10.6407, 122.9690),R.string.masskara));       // 11 bacolod
        points.add(getPlace(new LatLng(13.4767, 121.9032),R.string.moriones));       // 12 marinduque
        //points.add(getPlace(new LatLng(13.4767, 121.9032),R.string.nilagyan));     // 11 bacolod
        points.add(getPlace(new LatLng(14.9968, 121.1710),R.string.obando));         // 13 bulacan
        points.add(getPlace(new LatLng(11.2543, 124.9617),R.string.pintados));       // 14 tacloban
        points.add(getPlace(new LatLng(10.4837, 123.4129),R.string.pintaflores));    // 15 negros occidental
        points.add(getPlace(new LatLng(12.0676, 124.5930),R.string.sarakiki));       // 16 western samar
        points.add(getPlace(new LatLng(8.1541, 123.2588),R.string.hermosa));         // 17 zamboanga
        points.add(getPlace(new LatLng(8.0464, 126.0615),R.string.naliyagan));       // 18 agusan
        points.add(getPlace(new LatLng(14.1344, 121.5598),R.string.pahiyas));        // 19 lucban
        points.add(getPlace(new LatLng(9.6729, 123.8730),R.string.sandugo));        // 20 tagbilaran
        points.add(getPlace(new LatLng(16.0433, 120.3333),R.string.bangus));        // 21 Dagupan City
    }

    private MarkerOptions getPlace(LatLng points, int stringId){
        return new MarkerOptions()
                .position(points).title(getString(stringId))
                .draggable(false).visible(true);
    }
}
