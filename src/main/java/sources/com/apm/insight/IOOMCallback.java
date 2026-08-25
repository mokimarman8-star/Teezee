package com.apm.insight;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface IOOMCallback {
    void onCrash(@NonNull CrashType crashType, @Nullable Throwable th, @Nullable Thread thread, long j);
}
