package com.baseapp.hiepnn.utils;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.baseapp.hiepnn.R;


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
//        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.replace(R.id.container, fragment, tag);
        if (isPushInsteadOfReplace) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    public static void popBackStack(Fragment fragment) {
        final FragmentManager fm = fragment.getFragmentManager();
        final int backStackCount = fm.getBackStackEntryCount();
        if (backStackCount > 0) {
            fragment.getFragmentManager().popBackStack();
        } else {
            fragment.getActivity().onBackPressed();
        }
    }

    public static void popEntireFragmentBackStack(Fragment fragment) {
        final int backStackCount = fragment.getFragmentManager().getBackStackEntryCount();
        for (int i = 0; i < backStackCount; i++) {
            fragment.getFragmentManager().popBackStackImmediate();
        }
    }
}
