package com.transsion.ad.scene;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import rh.e;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    public final boolean a(String str) {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(str);
            obj = Result.constructor-impl(Boolean.valueOf((b == null || (jsonElement = b.get("hiOff")) == null) ? false : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = Boolean.FALSE;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final boolean b(String str) {
        Object obj;
        JsonElement jsonElement;
        Intrinsics.h(str, "sceneId");
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(str);
            obj = Result.constructor-impl(Boolean.valueOf((b == null || (jsonElement = b.get("nonOff")) == null) ? false : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = Boolean.FALSE;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final boolean c(String str) {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject b = d.a.b(str);
            obj = Result.constructor-impl(Boolean.valueOf((b == null || (jsonElement = b.get("sceneOff")) == null) ? false : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = Boolean.FALSE;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final boolean d(String str) {
        if (e.a.a()) {
            return b.a.m() || a.a.t(str);
        }
        return false;
    }
}
