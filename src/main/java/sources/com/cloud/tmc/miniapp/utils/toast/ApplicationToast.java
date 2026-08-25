package com.cloud.tmc.miniapp.utils.toast;

import android.app.Application;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ApplicationToast extends CustomToast {
    private final Application application;
    private ToastDialog mToastDialog;

    public ApplicationToast(Application application) {
        Intrinsics.h(application, "application");
        this.application = application;
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
                toastDialog = new ToastDialog(this.application, (CustomToast) this);
                this.mToastDialog = toastDialog;
            }
            toastDialog.show();
        } catch (Throwable th) {
            TmcLogger.e("ApplicationToast", "show", th);
        }
    }
}
