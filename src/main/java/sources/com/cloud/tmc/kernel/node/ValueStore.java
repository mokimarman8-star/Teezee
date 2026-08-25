package com.cloud.tmc.kernel.node;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface ValueStore {
    boolean getBooleanValue(String str);

    int getIntValue(String str);

    JsonArray getJsonArrayValue(String str);

    JsonObject getJsonValue(String str);

    long getLongValue(String str);

    String getStringValue(String str);

    void putBooleanValue(String str, boolean z);

    void putIntValue(String str, int i);

    void putJsonArrayValue(String str, JsonArray jsonArray);

    void putJsonValue(String str, JsonObject jsonObject);

    void putLongValue(String str, long j);

    void putStringValue(String str, String str2);
}
