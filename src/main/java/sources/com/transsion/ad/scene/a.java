package com.transsion.ad.scene;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.transsion.gslb.BuildConfig;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public static /* synthetic */ int c(a aVar, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return aVar.b(str, i);
    }

    public static /* synthetic */ int o(a aVar, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 5;
        }
        return aVar.n(str, i);
    }

    public static /* synthetic */ int q(a aVar, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 5;
        }
        return aVar.p(str, i);
    }

    public final String a(String str) {
        JsonElement jsonElement;
        String asString;
        JsonObject b = d.a.b(str);
        return (b == null || (jsonElement = b.get("adActivityStyle")) == null || (asString = jsonElement.getAsString()) == null) ? BuildConfig.FLAVOR : asString;
    }

    public final int b(String str, int i) {
        JsonElement jsonElement;
        JsonObject b = d.a.b(str);
        return (b == null || (jsonElement = b.get("biddingTime")) == null) ? i : jsonElement.getAsInt();
    }

    public final int d(String str) {
        Object obj;
        JsonElement jsonElement;
        Intrinsics.h(str, "sceneId");
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(str);
            obj = Result.constructor-impl(Integer.valueOf((b == null || (jsonElement = b.get("dailyDisplayLimit")) == null) ? -1 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = -1;
        }
        return ((Number) obj).intValue();
    }

    public final int e(String str) {
        Object obj;
        JsonElement jsonElement;
        Intrinsics.h(str, "sceneId");
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(str);
            obj = Result.constructor-impl(Integer.valueOf((b == null || (jsonElement = b.get("delayClose")) == null) ? 0 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = 0;
        }
        return ((Number) obj).intValue();
    }

    public final int f(String str) {
        Object obj;
        JsonElement jsonElement;
        Intrinsics.h(str, "sceneId");
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(str);
            obj = Result.constructor-impl(Integer.valueOf((b == null || (jsonElement = b.get("displayIntervalTime")) == null) ? 0 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = 0;
        }
        return ((Number) obj).intValue();
    }

    public final int g(String str) {
        Object obj;
        JsonElement jsonElement;
        Intrinsics.h(str, "sceneId");
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(str);
            obj = Result.constructor-impl(Integer.valueOf((b == null || (jsonElement = b.get("fillAmount")) == null) ? 1 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = 1;
        }
        return ((Number) obj).intValue();
    }

    public final String h(String str) {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(str);
            obj = Result.constructor-impl((b == null || (jsonElement = b.get("hiId")) == null) ? null : jsonElement.getAsString());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        return (String) (Result.exceptionOrNull-impl(obj) == null ? obj : null);
    }

    public final String i(String str) {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(str);
            obj = Result.constructor-impl((b == null || (jsonElement = b.get("hiSspId")) == null) ? null : jsonElement.getAsString());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        return (String) (Result.exceptionOrNull-impl(obj) == null ? obj : null);
    }

    public final int j(String str) {
        JsonElement jsonElement;
        Intrinsics.h(str, "sceneId");
        JsonObject b = d.a.b(str);
        if (b == null || (jsonElement = b.get("interval")) == null) {
            return 10;
        }
        return jsonElement.getAsInt();
    }

    public final boolean k(String str) {
        Object obj;
        JsonElement jsonElement;
        Intrinsics.h(str, "sceneId");
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(str);
            obj = Result.constructor-impl(Boolean.valueOf((b == null || (jsonElement = b.get("isShowMemberEntrance")) == null) ? true : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = Boolean.TRUE;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final int l(String str) {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(str);
            obj = Result.constructor-impl(Integer.valueOf((b == null || (jsonElement = b.get("nativeCacheUpperLimit")) == null) ? b.a.d() : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = Integer.valueOf(b.a.d());
        }
        return ((Number) obj).intValue();
    }

    public final int m(String str) {
        JsonElement jsonElement;
        JsonObject b = d.a.b(str);
        if (b == null || (jsonElement = b.get("refreshTime")) == null) {
            return 30;
        }
        return jsonElement.getAsInt();
    }

    public final int n(String str, int i) {
        Object obj;
        JsonElement jsonElement;
        Intrinsics.h(str, "sceneId");
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(str);
            obj = Result.constructor-impl(Integer.valueOf((b == null || (jsonElement = b.get("x")) == null) ? i : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = Integer.valueOf(i);
        }
        return ((Number) obj).intValue();
    }

    public final int p(String str, int i) {
        Object obj;
        JsonElement jsonElement;
        Intrinsics.h(str, "sceneId");
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(str);
            obj = Result.constructor-impl(Integer.valueOf((b == null || (jsonElement = b.get("y")) == null) ? i : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = Integer.valueOf(i);
        }
        return ((Number) obj).intValue();
    }

    public final int r(String str) {
        Object obj;
        JsonElement jsonElement;
        Intrinsics.h(str, "sceneId");
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(str);
            obj = Result.constructor-impl(Integer.valueOf((b == null || (jsonElement = b.get("countDown")) == null) ? 5 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = 5;
        }
        return ((Number) obj).intValue();
    }

    public final int s(String str) {
        Object obj;
        JsonElement jsonElement;
        Intrinsics.h(str, "sceneId");
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(str);
            obj = Result.constructor-impl(Integer.valueOf((b == null || (jsonElement = b.get("timeOut")) == null) ? 5 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = 5;
        }
        return ((Number) obj).intValue();
    }

    public final boolean t(String str) {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(str);
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
