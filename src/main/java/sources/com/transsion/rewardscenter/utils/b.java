package com.transsion.rewardscenter.utils;

import com.tencent.mmkv.MMKV;
import com.transsion.gslb.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.utils.a
        public final Object invoke() {
            MMKV f;
            f = b.f();
            return f;
        }
    });
    public static final int c = 8;

    private b() {
    }

    private final MMKV b() {
        return (MMKV) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV f() {
        return MMKV.I("RewardsCenterCache");
    }

    public final String c() {
        String k = b().k("phone_cc");
        return k == null ? BuildConfig.FLAVOR : k;
    }

    public final String d() {
        String k = b().k("phone_iso");
        return k == null ? BuildConfig.FLAVOR : k;
    }

    public final String e() {
        String k = b().k("phone_number");
        return k == null ? BuildConfig.FLAVOR : k;
    }

    public final void g(String str, String str2, String str3) {
        Intrinsics.h(str, "cc");
        Intrinsics.h(str2, "iso");
        Intrinsics.h(str3, "number");
        b().putString("phone_cc", str);
        b().putString("phone_iso", str2);
        b().putString("phone_number", str3);
    }
}
