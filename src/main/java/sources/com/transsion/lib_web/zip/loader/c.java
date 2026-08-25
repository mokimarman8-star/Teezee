package com.transsion.lib_web.zip.loader;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface c {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();
        private static final HashMap b = MapsKt.j(new Pair[]{new Pair("Access-Control-Allow-Origin", "*"), new Pair("Access-Control-Allow-Credentials", "*")});
        private static final String c = "versionCode";

        private a() {
        }

        public final HashMap a() {
            return b;
        }
    }

    public static final class b {
        public static Map a(c cVar, Map map) {
            Intrinsics.h(map, "headers");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(map);
            linkedHashMap.putAll(c.a.a());
            return linkedHashMap;
        }
    }

    WebResourceResponse a(WebResourceRequest webResourceRequest);
}
