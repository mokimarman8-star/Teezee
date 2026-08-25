package com.cloud.tmc.kernel.proxy.network;

import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface IUploadCallback {
    void onFailed(String str, String str2, String str3, String str4);

    void onFinish(@Nullable String str, String str2, String str3);

    void progressUpdate(String str, int i, String str2, long j, long j2);
}
