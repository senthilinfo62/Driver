package com.example.senthil.dirver1.Utilits;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.senthil.dirver1.R;


/**
 * Created by sunakshi.r on 7/31/2015.
 */
public class AppDialogs {

    public static void showConfirmDialog(Context context, final IDialogListener dialogListener, String message, final int requestCode) {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        alertDialogBuilder
                .setMessage(message)
                .setCancelable(true)
                .setTitle(context.getResources().getString(R.string.app_name))
                .setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialogListener.onNegativeButtonClick(requestCode);
                                dialog.dismiss();
                            }
                        })
                .setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialogListener.onPositiveButtonClick(requestCode);
                                dialog.dismiss();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    public static void showConfirmDialogPost(Context context, final IDialogListener dialogListener, String message, final int requestCode) {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        alertDialogBuilder
                .setMessage(message)
                .setCancelable(false)
                .setTitle(context.getResources().getString(R.string.app_name))
                .setNegativeButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialogListener.onNegativeButtonClick(requestCode);
                                dialog.dismiss();
                            }
                        })
                .setPositiveButton("POST",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialogListener.onPositiveButtonClick(requestCode);
                                dialog.dismiss();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public static void showConfirmDialog(Context context, final IDialogListener dialogListener, String message, String pTitle, String nTitle, final int requestCode) {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        alertDialogBuilder
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton(nTitle,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialogListener.onNegativeButtonClick(requestCode);
                                dialog.dismiss();
                            }
                        })
                .setPositiveButton(pTitle,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialogListener.onPositiveButtonClick(requestCode);
                                dialog.dismiss();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public static void showProgressDialog(Context context, String message) {
        ProgressDialog mDialog;
        ProgressDialog.show(context, "", message, true,
                false).setCancelable(true);
    }

    public static void showAlertDialog(Context context, String title, String messgae, final IDialogListener dialogListener, final int requestCode) {
        final AlertDialog alertDialog = new AlertDialog.Builder(
                context).create();
        // Setting Dialog Title
        alertDialog.setTitle(title);
        // Setting Dialog Message
        alertDialog.setMessage(messgae);
        // Setting Icon to Dialog
        //  alertDialog.setIcon(R.drawable.login_username);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
                dialog.dismiss();
                if(dialogListener!=null)
                   dialogListener.onPositiveButtonClick(requestCode);

            }
        });
        alertDialog.show();

    }
        public static void showAlertDialog(Context context, String title, String messgae) {
        final AlertDialog alertDialog = new AlertDialog.Builder(
                context).create();
        // Setting Dialog Title
        alertDialog.setTitle(title);
        // Setting Dialog Message
        alertDialog.setMessage(messgae);
        // Setting Icon to Dialog
        //  alertDialog.setIcon(R.drawable.login_username);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed


            }
        });
        alertDialog.show();

    }

}
