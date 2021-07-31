package com.example.dewiretrovit;

import android.app.ProgressDialog;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dewiretrovit.adapter.AdapterListSimple;
import com.example.dewiretrovit.modelforecast.ForecastWeatherModel;
import com.example.dewiretrovit.service.APIClient;
import com.example.dewiretrovit.service.APIInterfacesRest;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForecastActivity extends AppCompatActivity {

    RecyclerView lstForecast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        lstForecast = findViewById(R.id.lstForecast);

        new EasyLocation(ForecastActivity.this, new EasyLocation.EasyLocationCallBack() {
            @Override
            public void permissionDenied() {

            }

            @Override
            public void locationSettingFailed() {

            }

            @Override
            public void getLocation(Location location) {

                callWeatherBasedLocation(location.getLatitude(),location.getLongitude());
            }
        });


    }

    APIInterfacesRest apiInterface;
    ProgressDialog progressDialog;
    public void callWeatherBasedLocation(Double lat, Double lon ){

        apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        progressDialog = new ProgressDialog(ForecastActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.show();
        Call<ForecastWeatherModel> call3 = apiInterface.getForecastBasedLocation(lat,lon,"6c57819f3114a6213bf6a1a0290c4f2c");
        call3.enqueue(new Callback<ForecastWeatherModel>() {
            @Override
            public void onResponse(Call<ForecastWeatherModel> call, Response<ForecastWeatherModel> response) {
                progressDialog.dismiss();
                ForecastWeatherModel dataWeather = response.body();

                if (dataWeather !=null) {



                    AdapterListSimple adapter = new AdapterListSimple(ForecastActivity.this,dataWeather.getList(),dataWeather.getCity().getName());

                    lstForecast.setLayoutManager(new LinearLayoutManager(ForecastActivity.this));
                    lstForecast.setItemAnimator(new DefaultItemAnimator());
                    lstForecast.setAdapter(adapter);




                }else{

                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(ForecastActivity.this, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(ForecastActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<ForecastWeatherModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"Maaf koneksi bermasalah",Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });




    }
}