package com.baseapp.hiepnn.mybaseproject.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.baseapp.hiepnn.mybaseproject.R;


/**
 * Created by Envy 15T on 6/5/2015.
 */
public class DialogUtil {

    public static android.support.v7.app.AlertDialog createApiErrorDialog(Context context, String title, String message) {
        android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(
                context);

        if (title != null && !title.isEmpty()) {
            alertDialogBuilder.setTitle(title);
        }

        alertDialogBuilder.setMessage(message);

        alertDialogBuilder.setPositiveButton(R.string.dialog_btn_close,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        alertDialogBuilder.setCancelable(false);
        android.support.v7.app.AlertDialog alertDialog = alertDialogBuilder.create();
        return alertDialog;
    }


    /**
     * Show common OK dialog
     *
     * @param context
     * @param title
     * @param message
     * @return
     */
    public static AlertDialog showDialog(final Context context, String title, String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        if (title != null && !title.isEmpty()) {
            alertDialogBuilder.setTitle(title);
        }

        alertDialogBuilder.setMessage(message);

        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        alertDialogBuilder.setCancelable(false);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        return alertDialog;
    }

    /**
     * Show common OK dialog with button click callback
     *
     * @param context
     * @param title
     * @param message
     * @param onClickListener
     * @return
     */
    public static AlertDialog showDialog(final Context context, String title, String message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        if (title != null && !title.isEmpty()) {
            alertDialogBuilder.setTitle(title);
        }

        alertDialogBuilder.setMessage(message);

        alertDialogBuilder.setPositiveButton("OK",
                onClickListener);

        alertDialogBuilder.setCancelable(false);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        return alertDialog;
    }

    public static AlertDialog showDialogPasscode(final Context context, String title, String message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        if (title != null && !title.isEmpty()) {
            alertDialogBuilder.setTitle(title);
        }

        alertDialogBuilder.setMessage(message);

        alertDialogBuilder.setPositiveButton("ディスミス",
                onClickListener);

        alertDialogBuilder.setCancelable(false);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        return alertDialog;
    }

    /**
     * Show common
     *
     * @param context
     * @param title
     * @param message
     * @param onClickListener
     * @return
     */
    public static AlertDialog showDialogCancelable(final Context context, String title, String message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        if (title != null && !title.isEmpty()) {
            alertDialogBuilder.setTitle(title);
        }

        alertDialogBuilder.setMessage(message);

        alertDialogBuilder.setPositiveButton("OK",
                onClickListener);

        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        alertDialogBuilder.setCancelable(false);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        return alertDialog;
    }

    public static AlertDialog showDialogFull(Context context, String title, String message, String okText, String cancelText, DialogInterface.OnClickListener okOnClickListener, DialogInterface.OnClickListener cancelOnClickListener) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        if (title != null && !title.isEmpty()) {
            alertDialogBuilder.setTitle(title);
        }

        alertDialogBuilder.setMessage(message);

        alertDialogBuilder.setPositiveButton(okText, okOnClickListener);

        alertDialogBuilder.setNegativeButton(cancelText, cancelOnClickListener);

        alertDialogBuilder.setCancelable(false);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        return alertDialog;
    }

    public static AlertDialog showApiErrorDialog(final Context context) {
        return showDialog(context, null, context.getString(R.string.apierror));
    }

    public static AlertDialog showApiErrorDialog(final Context context, DialogInterface.OnClickListener onClickListener) {
        return showDialog(context, null, context.getString(R.string.apierror), onClickListener);
    }

    public static AlertDialog showInputErrorDialog(final Context context) {
        return showDialog(context, null, context.getString(R.string.pleaseinputdata));
    }

    public static void showConfirm_JPDialog(Context context, String title, String message,
                                            DialogInterface.OnClickListener onOK, DialogInterface.OnClickListener onCancel) {
        showDialogFull(context, title, message, "はい", "いいえ", onOK, onCancel);
    }
}
