package com.cloud.tmc.kernel.proxy.network;

import androidx.annotation.Nullable;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface PackageDownloadCallback {
    void onCancel(String str, String str2);

    void onFailed(String str, String str2, String str3, IOException iOException, String str4);

    void onFinish(@Nullable String str, String str2);

    void onPrepare(String str, String str2);

    void onProgress(String str, int i, String str2);

    void progressUpdate(String str, int i, String str2, long j, long j2);
}
