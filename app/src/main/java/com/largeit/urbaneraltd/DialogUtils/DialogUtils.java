package com.largeit.urbaneraltd.DialogUtils;

import android.app.Activity;
import android.app.ProgressDialog;

public class DialogUtils {
    public static ProgressDialog showProgressDialog(Activity activity, String message) {
        ProgressDialog m_Dialog = new ProgressDialog(activity);
        m_Dialog.setMessage(message);
        m_Dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        m_Dialog.setCancelable(false);
        m_Dialog.show();
        return m_Dialog;

    }
}
