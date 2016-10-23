package com.example.hiepnn.mydemoapplication.utils;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.example.hiepnn.mydemoapplication.R;


/**
 * Created by LinhNguyen on 5/18/2015.
 */
public class FragmentUtil {

    public static void pushFragment(FragmentActivity activity, @NonNull Fragment fragment, @Nullable Bundle data) {
        showFragment(activity, fragment, true, data, null);
    }

    public static void replaceFragment(FragmentActivity activity, @NonNull Fragment fragment, @Nullable Bundle data) {
        showFragment(activity, fragment, false, data, null);
    }

    public static void showFragment(FragmentActivity activity, @NonNull Fragment fragment, boolean isPushInsteadOfReplace, @Nullable Bundle data, @Nullable String tag) {
        if (activity == null) {
            return;
        }

        if (data != null) {
            fragment.setArguments(data);
        }

        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();

//        if (isShowAnimation) {
//            fragmentTransaction.setCustomAnimations(R.anim.slide_in_up,
//                    R.anim.slide_out_up);
//        }

        fragmentTransaction.replace(R.id.container, fragment, tag);
        if (isPushInsteadOfReplace) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commitAllowingStateLoss();
    }



}
