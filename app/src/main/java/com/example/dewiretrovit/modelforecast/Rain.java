package com.example.dewiretrovit.modelforecast;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Rain implements Serializable, Parcelable {
    @SerializedName("3h")
    @Expose
    private Double _3h;
    public final static Creator<Rain> CREATOR = new Creator<Rain>() {
        @SuppressWarnings({"unchecked"})
        @Override
        public Rain createFromParcel(Parcel source) {
            return new Rain(source);
        }

        @Override
        public Rain[] newArray(int size) {
            return new Rain[size];
        }
    };
    private final static long serialVersionUID = -5501315112659640117L;

    protected Rain(Parcel in) {
        this._3h = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Rain() {
    }

    public Rain(Double _3h) {
        super();
        this._3h = _3h;

    }

    public Double get_3h() {
        return _3h;
    }

    public void set_3h(Double _3h) {
        this._3h = _3h;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_3h);
    }
}
