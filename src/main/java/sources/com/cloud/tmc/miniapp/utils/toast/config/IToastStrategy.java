package com.cloud.tmc.miniapp.utils.toast.config;

import android.app.Application;
import com.cloud.tmc.miniapp.utils.toast.ToastParams;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface IToastStrategy {
    void cancelToast();

    IToast createToast(IToastStyle<?> iToastStyle);

    void registerStrategy(Application application);

    void showToast(ToastParams toastParams);
}
