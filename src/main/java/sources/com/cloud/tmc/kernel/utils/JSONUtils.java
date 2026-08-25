package com.cloud.tmc.kernel.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class JSONUtils {
    public static JsonArray getJsonArray(JsonObject jsonObject, String str, JsonArray jsonArray) {
        if (jsonObject != null && jsonObject.size() != 0) {
            try {
                return jsonObject.get(str).getAsJsonArray();
            } catch (Exception unused) {
            }
        }
        return jsonArray;
    }

    public static JsonObject getJsonObject(JsonObject jsonObject, String str, JsonObject jsonObject2) {
        if (jsonObject == null || jsonObject.size() != 0 || !jsonObject.has(str)) {
            return jsonObject2;
        }
        try {
            return jsonObject.get(str).getAsJsonObject();
        } catch (Exception unused) {
            return jsonObject2;
        }
    }

    public static String getString(JsonObject jsonObject, String str) {
        return getString(jsonObject, str, "");
    }

    public static String getString(JsonObject jsonObject, String str, String str2) {
        if (jsonObject == null || jsonObject.size() == 0 || !jsonObject.has(str)) {
            return str2;
        }
        try {
            String asString = jsonObject.get(str).getAsString();
            return asString != null ? asString : str2;
        } catch (Exception e) {
            TmcLogger.e(TmcConstants.TAG, "getString exception!", e);
            return str2;
        }
    }

    public static HashMap<String, Object> jsonToMap(JsonObject jsonObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        for (Map.Entry entry : jsonObject.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                hashMap.put(str, null);
            } else if (value instanceof JsonPrimitive) {
                if (value instanceof Boolean) {
                    hashMap.put(str, (Boolean) value);
                } else if (value instanceof Float) {
                    hashMap.put(str, (Float) value);
                } else if (value instanceof Double) {
                    hashMap.put(str, (Double) value);
                } else if (value instanceof BigDecimal) {
                    hashMap.put(str, Double.valueOf(((BigDecimal) value).doubleValue()));
                } else if (value instanceof Integer) {
                    hashMap.put(str, (Integer) value);
                } else if (value instanceof Long) {
                    hashMap.put(str, Double.valueOf(((Long) value).doubleValue()));
                } else if (value instanceof String) {
                    hashMap.put(str, (String) value);
                } else if (value instanceof ByteBuffer) {
                    hashMap.put(str, (ByteBuffer) value);
                } else if (value instanceof byte[]) {
                    hashMap.put(str, (byte[]) value);
                }
            } else if (value instanceof JsonObject) {
                hashMap.put(str, jsonToMap((JsonObject) value));
            } else {
                hashMap.put(str, value);
            }
        }
        return hashMap;
    }

    public static JsonObject parseObject(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return JsonParser.parseString(str).getAsJsonObject();
        } catch (Exception e) {
            TmcLogger.e("parseObject error!", e);
            return null;
        }
    }

    @Nullable
    public static List<String> toStringArray(JsonArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }
        try {
            int size = jsonArray.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                arrayList.add(jsonArray.get(i).getAsString());
            }
            return arrayList;
        } catch (Exception e) {
            TmcLogger.e("toStringArray error!", e);
            return null;
        }
    }
}
