package com.tn.lib.net.dns.or;

import android.text.TextUtils;
import com.blankj.utilcode.util.o;
import com.google.gson.reflect.TypeToken;
import com.tencent.mmkv.MMKV;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class CacheIpPool {
    private static ArrayList b;
    public static final CacheIpPool a = new CacheIpPool();
    private static final ConcurrentHashMap c = new ConcurrentHashMap();
    private static volatile String d = "";
    private static volatile String e = "api6.aoneroom.com";
    private static volatile String f = "test-mse-api.aoneroom.com";
    private static volatile String g = "https";
    private static final Lazy h = LazyKt.b(new Function0() { // from class: com.tn.lib.net.dns.or.a
        public final Object invoke() {
            String e3;
            e3 = CacheIpPool.e();
            return e3;
        }
    });
    private static final Lazy i = LazyKt.b(new Function0() { // from class: com.tn.lib.net.dns.or.b
        public final Object invoke() {
            String f2;
            f2 = CacheIpPool.f();
            return f2;
        }
    });
    private static final Lazy j = LazyKt.b(new Function0() { // from class: com.tn.lib.net.dns.or.c
        public final Object invoke() {
            String d2;
            d2 = CacheIpPool.d();
            return d2;
        }
    });

    private CacheIpPool() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String d() {
        if (ag.a.a.d()) {
            return "https://" + f;
        }
        return "https://" + e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String e() {
        return "[\n{\n\"host\": \"" + e + "\",\n\"ip\": \"\",\n\"scheme\": \"https\"\n}\n]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f() {
        return "[{\n    \"host\": \"" + f + "\",\n    \"ip\": \"8.219.92.106\",\n    \"scheme\": \"https\"\n}]";
    }

    private final String i() {
        return (String) j.getValue();
    }

    private final String j() {
        return (String) h.getValue();
    }

    private final String k() {
        return (String) i.getValue();
    }

    public final String g() {
        if (TextUtils.isEmpty(d)) {
            d = i();
        }
        return d;
    }

    public final void h() {
        String str;
        AddressItem addressItem;
        AddressItem addressItem2;
        try {
            ArrayList<AddressItem> arrayList = (ArrayList) o.e(ag.c.a.a("key_ip_list", ag.a.a.d() ? k() : j()), new TypeToken<ArrayList<AddressItem>>() { // from class: com.tn.lib.net.dns.or.CacheIpPool$getCacheUrlList$type$1
            }.getType());
            b = arrayList;
            if (arrayList != null) {
                for (AddressItem addressItem3 : arrayList) {
                    String host = addressItem3.getHost();
                    if (host != null && host.length() > 0) {
                        addressItem3.setIpEnable(true);
                        c.put(addressItem3.getHost(), addressItem3);
                    }
                }
            }
            if (b == null || !(!r0.isEmpty())) {
                str = d;
            } else {
                ArrayList arrayList2 = b;
                String str2 = null;
                g = String.valueOf((arrayList2 == null || (addressItem2 = (AddressItem) arrayList2.get(0)) == null) ? null : addressItem2.getScheme());
                ArrayList arrayList3 = b;
                if (arrayList3 != null && (addressItem = (AddressItem) arrayList3.get(0)) != null) {
                    str2 = addressItem.getHost();
                }
                e = String.valueOf(str2);
                str = g + "://" + e;
            }
            d = str;
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final String l() {
        MMKV c2 = mg.a.a.c();
        String string = c2 != null ? c2.getString("mock_host_key", "") : null;
        if (!TextUtils.isEmpty(string)) {
            e = String.valueOf(string);
        }
        return e;
    }

    public final String m() {
        return g;
    }

    public final void n(String str) {
        if (!TextUtils.isEmpty(str)) {
            ag.c.a.b("key_ip_list", String.valueOf(str));
        }
        h();
    }

    public final void o(String str) {
        Intrinsics.h(str, "host");
        e = str;
    }
}
