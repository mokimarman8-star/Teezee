package com.cloud.tmc.miniapp.utils.toast;

import android.app.Activity;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ActivityToast extends CustomToast {
    private final Activity activity;
    private ToastDialog mToastDialog;

    public ActivityToast(Activity activity) {
        Intrinsics.h(activity, "activity");
        this.activity = activity;
    }

    @Override // com.cloud.tmc.miniapp.utils.toast.config.IToast
    public void cancel() {
        ToastDialog toastDialog = this.mToastDialog;
        if (toastDialog != null) {
            toastDialog.cancel();
        }
    }

    @Override // com.cloud.tmc.miniapp.utils.toast.CustomToast
    public boolean isShow() {
        ToastDialog toastDialog = this.mToastDialog;
        if (toastDialog != null) {
            return toastDialog.isShow();
        }
        return false;
    }

    @Override // com.cloud.tmc.miniapp.utils.toast.config.IToast
    public void show() {
        try {
            ToastDialog toastDialog = this.mToastDialog;
            if (toastDialog == null) {
                toastDialog = new ToastDialog(this.activity, (CustomToast) this);
                this.mToastDialog = toastDialog;
            }
            toastDialog.show();
        } catch (Throwable th) {
            TmcLogger.e("ActivityToast", "show", th);
        }
    }
}
