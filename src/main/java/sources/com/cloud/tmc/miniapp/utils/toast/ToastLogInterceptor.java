package com.cloud.tmc.miniapp.utils.toast;

import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.utils.toast.config.IToastInterceptor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ToastLogInterceptor implements IToastInterceptor {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ToastLogInterceptor";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.cloud.tmc.miniapp.utils.toast.config.IToastInterceptor
    public boolean intercept(ToastParams toastParams) {
        Intrinsics.h(toastParams, "params");
        TmcLogger.d(TAG, String.valueOf(toastParams.getText()));
        return false;
    }
}
