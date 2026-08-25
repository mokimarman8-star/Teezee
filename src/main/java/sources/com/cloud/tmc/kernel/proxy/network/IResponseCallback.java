package com.cloud.tmc.kernel.proxy.network;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;
import okhttp3.Cookie;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface IResponseCallback {
    void onFailure(String str, @Nullable String str2, @Nullable String str3);

    void onSuccess(int i, @Nullable String str, Map<String, String> map, List<Cookie> list, @Nullable String str2);
}
