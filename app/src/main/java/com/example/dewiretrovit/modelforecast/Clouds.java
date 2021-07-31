package com.example.dewiretrovit.modelforecast;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Clouds implements Serializable, Parcelable {
    @SerializedName("all")
    @Expose
    private Integer all;

    public final static Creator<Clouds> CREATOR = new Creator<Clouds>() {
        @SuppressWarnings({"unchecked"})
        @Override
        public Clouds createFromParcel(Parcel source) {
            return new Clouds(source);
        }

        @Override
        public Clouds[] newArray(int size) {
            return new Clouds[size];
        }
    };

    private final static long serialVersionUID = 3420326849102324850L;

    protected Clouds(Parcel in) {
        this.all = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Clouds() {
    }

    public Clouds(Integer all) {
        super();
        this.all = all;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(all);
    }
}
