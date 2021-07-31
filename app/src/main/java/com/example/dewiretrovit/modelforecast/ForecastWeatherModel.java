package com.example.dewiretrovit.modelforecast;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ForecastWeatherModel implements Serializable, Parcelable {
    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Integer message;
    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("list")
    @Expose
    private List<List> list = null;
    @SerializedName("city")
    @Expose
    private City city;
    public final static Creator<ForecastWeatherModel> CREATOR = new Creator<ForecastWeatherModel>() {
        @SuppressWarnings({"unchecked"})
        @Override
        public ForecastWeatherModel createFromParcel(Parcel source) {
            return new ForecastWeatherModel(source);
        }

        @Override
        public ForecastWeatherModel[] newArray(int size) {
            return new ForecastWeatherModel[size];
        }
    };

    private final static long serialVersionUID = -1498670793271159682L;
    protected ForecastWeatherModel(Parcel in) {
        this.cod = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cnt = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.list, (List.class.getClassLoader()));
        this.city = ((City) in.readValue((City.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public ForecastWeatherModel() {
    }

    public ForecastWeatherModel(String cod, Integer message, Integer cnt, java.util.List<List> list, City city) {
        super();
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public List<List> getList() {
        return list;
    }

    public void setList(List<List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(cod);
        dest.writeValue(message);
        dest.writeValue(cnt);
        dest.writeList(list);
        dest.writeValue(city);
    }
}
