package com.transsion.ad.scene;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.transsion.ad.strategy.AdUrlParameterManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    private final String a() {
        return "GlobConfigScene";
    }

    public final int b() {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(a.a());
            obj = Result.constructor-impl(Integer.valueOf((b == null || (jsonElement = b.get("interstitialCd")) == null) ? 5 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = 5;
        }
        return ((Number) obj).intValue();
    }

    public final float c() {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(a.a());
            obj = Result.constructor-impl(Float.valueOf((b == null || (jsonElement = b.get("lowMemoryValue")) == null) ? 1.0f : jsonElement.getAsFloat()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = Float.valueOf(1.0f);
        }
        return ((Number) obj).floatValue();
    }

    public final int d() {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(a.a());
            obj = Result.constructor-impl(Integer.valueOf((b == null || (jsonElement = b.get("nativeCacheUpperLimit")) == null) ? 1 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = 1;
        }
        return ((Number) obj).intValue();
    }

    public final int e() {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(a.a());
            obj = Result.constructor-impl(Integer.valueOf((b == null || (jsonElement = b.get("psLinkInterval")) == null) ? 6 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = 6;
        }
        return ((Number) obj).intValue();
    }

    public final List f() {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(a.a());
            JSONArray jSONArray = new JSONArray((b == null || (jsonElement = b.get("urlParameterReplace")) == null) ? null : jsonElement.getAsString());
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("key");
                Intrinsics.g(string, "getString(...)");
                String string2 = jSONObject.getString("value");
                Intrinsics.g(string2, "getString(...)");
                String string3 = jSONObject.getString("type");
                Intrinsics.g(string3, "getString(...)");
                arrayList.add(new AdUrlParameterManager.a(string, string2, string3));
            }
            obj = Result.constructor-impl(arrayList);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = CollectionsKt.l();
        }
        return (List) obj;
    }

    public final int g() {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(a.a());
            obj = Result.constructor-impl(Integer.valueOf((b == null || (jsonElement = b.get("videoCd")) == null) ? 15 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = 15;
        }
        return ((Number) obj).intValue();
    }

    public final boolean h() {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(a.a());
            obj = Result.constructor-impl(Boolean.valueOf((b == null || (jsonElement = b.get("adLinkOff")) == null) ? false : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = Boolean.FALSE;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final boolean i() {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(a.a());
            obj = Result.constructor-impl(Boolean.valueOf((b == null || (jsonElement = b.get("adTriggerOff")) == null) ? false : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = Boolean.FALSE;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final boolean j() {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(a.a());
            obj = Result.constructor-impl(Boolean.valueOf((b == null || (jsonElement = b.get("adRejectOff")) == null) ? false : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = Boolean.FALSE;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final boolean k() {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(a.a());
            obj = Result.constructor-impl(Boolean.valueOf((b == null || (jsonElement = b.get("isOpenAd")) == null) ? true : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = Boolean.TRUE;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final boolean l() {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(a.a());
            obj = Result.constructor-impl(Boolean.valueOf((b == null || (jsonElement = b.get("showAdTag")) == null) ? false : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = Boolean.FALSE;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final boolean m() {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(a.a());
            obj = Result.constructor-impl(Boolean.valueOf((b == null || (jsonElement = b.get("isVipSkipAd")) == null) ? true : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = Boolean.TRUE;
        }
        return ((Boolean) obj).booleanValue();
    }
}
