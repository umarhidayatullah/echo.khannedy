package com.example.dewiretrovit.modelforecast;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Wind implements Serializable, Parcelable {
    @SerializedName("speed")
    @Expose
    private Double speed;
    @SerializedName("deg")
    @Expose
    private Integer deg;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.speed);
        dest.writeValue(this.deg);
    }

    public void readFromParcel(Parcel source) {
        this.speed = (Double) source.readValue(Double.class.getClassLoader());
        this.deg = (Integer) source.readValue(Integer.class.getClassLoader());
    }

    public Wind() {
    }

    protected Wind(Parcel in) {
        this.speed = (Double) in.readValue(Double.class.getClassLoader());
        this.deg = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<Wind> CREATOR = new Creator<Wind>() {
        @Override
        public Wind createFromParcel(Parcel source) {
            return new Wind(source);
        }

        @Override
        public Wind[] newArray(int size) {
            return new Wind[size];
        }
    };

    public Wind(Double speed, Integer deg) {
        super();
        this.speed = speed;
        this.deg = deg;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }
}
