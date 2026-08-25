package com.apm.insight;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface ICrashCallback {
    void onCrash(@NonNull CrashType crashType, @Nullable String str, @Nullable Thread thread);
}
