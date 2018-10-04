package com.baseapp.hiepnn.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Envy 15T on 6/5/2015.
 */
public class UiUtil {

    /**
     * Convert px to dp
     *
     * @param dp
     * @return
     */
    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    /**
     * Convert dp to px
     *
     * @param px
     * @return
     */
    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    /**
     * Get device screen width in pixel
     *
     * @return
     */
    @SuppressWarnings("deprecation")
    @SuppressLint("NewApi")
    public static int getScreenWidthInPixel(Activity activity) {
        Point size = new Point();
        WindowManager w = activity.getWindowManager();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            w.getDefaultDisplay().getSize(size);
            return size.x;
        } else {
            Display d = w.getDefaultDisplay();
            return d.getWidth();
        }
    }

    /**
     * Safety hide view
     *
     * @param view
     */
    public static void hideView(View view, boolean isGone) {
        if (view != null) {
            if (isGone) {
                view.setVisibility(View.GONE);
            } else {
                view.setVisibility(View.INVISIBLE);
            }
        }
    }

    /**
     * Safety show view
     *
     * @param view
     */
    public static void showView(View view) {
        if (view != null) {
            view.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Check EditText is empty
     *
     * @param etText
     * @return
     */
    public static boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    /**
     * Check TextView is empty
     *
     * @param tvText
     * @return
     */
    public static boolean isEmpty(TextView tvText) {
        return tvText.getText().toString().trim().length() == 0;
    }

}
