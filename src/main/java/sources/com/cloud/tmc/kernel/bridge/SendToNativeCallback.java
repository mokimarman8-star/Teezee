package com.cloud.tmc.kernel.bridge;

import com.google.gson.JsonObject;
import java.util.HashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface SendToNativeCallback {
    public static final String KEY_CODE = "error";
    public static final String KEY_MESSAGE = "errorMessage";

    void onCallback(JsonObject jsonObject, boolean z, boolean z2);

    void onCallback(HashMap<String, Object> hashMap, boolean z, boolean z2);
}
