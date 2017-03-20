package com.baseapp.hiepnn.mybaseproject.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentStatePagerAdapter;


import com.baseapp.hiepnn.mybaseproject.callback.OnFillBackgroundListener;

import java.util.ArrayList;

/**
 * Created by V4-OS01 on 14/10/2016.
 */

public class Event implements Parcelable {
    private OnFillBackgroundListener mOnEventListener;

    protected Event(Parcel in) {
    }

    public Event() {

    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public void setOnFillBackgroundListener(OnFillBackgroundListener listener) {
        mOnEventListener = listener;
    }

    public void doFillBackground(String nameTable) {
        if (mOnEventListener != null) {
            mOnEventListener.onFillBackground(nameTable);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
