package com.transsion.transfer.wifi.util;

import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e {
    public static final e a = new e();

    private e() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map a(String urlString) {
        LinkedHashMap linkedHashMap;
        Intrinsics.h(urlString, "urlString");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        try {
            Result$Companion result$Companion = Result.Companion;
            Uri parse = Uri.parse(urlString);
            Intrinsics.g(parse, "parse(...)");
            linkedHashMap2.put("urlPath", parse.getPath());
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            Intrinsics.g(queryParameterNames, "getQueryParameterNames(...)");
            for (String str : queryParameterNames) {
                linkedHashMap2.put(str, parse.getQueryParameter(str));
            }
            linkedHashMap = Result.constructor-impl(linkedHashMap2);
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            linkedHashMap = Result.constructor-impl(ResultKt.a(th));
        }
        if (Result.exceptionOrNull-impl(linkedHashMap) == null) {
            linkedHashMap2 = linkedHashMap;
        }
        return linkedHashMap2;
    }
}
