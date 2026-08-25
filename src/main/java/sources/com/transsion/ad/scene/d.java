package com.transsion.ad.scene;

import android.text.TextUtils;
import com.blankj.utilcode.util.o;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.mmkv.MMKV;
import com.transsion.ad.monopoly.model.MbAdPlansBean;
import com.transsion.ad.monopoly.model.MbAdPlansDto;
import com.transsion.ad.strategy.e;
import com.transsion.gslb.BuildConfig;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    public static final d a = new d();
    private static final HashMap b = new HashMap();

    private d() {
    }

    private final String a() {
        String simpleName = d.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final JsonObject b(String str) {
        JsonObject asJsonObject;
        String str2;
        JsonObject jsonObject;
        try {
            Result.Companion companion = Result.Companion;
            HashMap hashMap = b;
            if (hashMap.containsKey(str) && (jsonObject = (JsonObject) hashMap.get(str)) != null) {
                return jsonObject;
            }
            JsonArray<JsonElement> jsonArray = (JsonArray) o.d(e.a.c().getString("non_ad_scene_config_data", BuildConfig.FLAVOR), JsonArray.class);
            if (jsonArray != null) {
                for (JsonElement jsonElement : jsonArray) {
                    if (jsonElement != null && (asJsonObject = jsonElement.getAsJsonObject()) != null) {
                        JsonElement jsonElement2 = asJsonObject.get("id");
                        if (jsonElement2 == null || (str2 = jsonElement2.getAsString()) == null) {
                            str2 = BuildConfig.FLAVOR;
                        }
                        b.put(str2, asJsonObject);
                    }
                }
            }
            HashMap hashMap2 = b;
            if (hashMap2.containsKey(str)) {
                return (JsonObject) hashMap2.get(str);
            }
            Result.constructor-impl(Unit.a);
            return null;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
            return null;
        }
    }

    public final String c() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(e.a.c().getString("non_ad_scene_config_data", BuildConfig.FLAVOR));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = null;
        }
        return (String) obj;
    }

    public final String d() {
        return e.a.c().getString("non_ad_scene_version", BuildConfig.FLAVOR);
    }

    public final boolean e() {
        return !TextUtils.isEmpty(e.a.c().getString("non_ad_scene_config_data", BuildConfig.FLAVOR));
    }

    public final void f(String str) {
        Intrinsics.h(str, "assetsString");
        e.a.c().putString("non_ad_scene_config_data", str);
        xh.a.c(xh.a.a, a() + " --> setScene4Assets() --> 场景信息保存到MMKV --> success", 0, false, 6, null);
    }

    public final void g(MbAdPlansDto mbAdPlansDto) {
        Intrinsics.h(mbAdPlansDto, "mbAdPlansDto");
        e eVar = e.a;
        String string = eVar.c().getString("non_ad_scene_version", BuildConfig.FLAVOR);
        MbAdPlansBean data = mbAdPlansDto.getData();
        String versionAdScene = data != null ? data.getVersionAdScene() : null;
        if (TextUtils.equals(string, versionAdScene)) {
            xh.a.c(xh.a.a, a() + " --> setSceneConfig() --> 版本号一致，服务端不会下发list 省流量 --> localAdSceneVersion = " + string + " --> newVersion = " + versionAdScene, 0, false, 6, null);
            return;
        }
        eVar.c().putString("non_ad_scene_version", versionAdScene);
        MMKV c = eVar.c();
        MbAdPlansBean data2 = mbAdPlansDto.getData();
        c.putString("non_ad_scene_config_data", data2 != null ? data2.getAdSceneConfigData() : null);
        xh.a.c(xh.a.a, a() + " --> setSceneConfig() --> 场景信息保存到MMKV --> success --> newVersion = " + versionAdScene, 0, false, 6, null);
    }
}
