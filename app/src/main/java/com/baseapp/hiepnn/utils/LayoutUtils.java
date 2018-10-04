package com.baseapp.hiepnn.utils;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hex0r on 5/25/15.
 */
public class LayoutUtils {
    public static
    @NonNull
    View inflate(@NonNull ViewGroup viewGroup, int layoutId, boolean attachToRoot) {
        return LayoutInflater
                .from(viewGroup.getContext())
                .inflate(layoutId, viewGroup, attachToRoot);
    }
}
