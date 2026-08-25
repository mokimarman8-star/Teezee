package com.transsion.baselib.report.launch;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class b {
    public static final b a = new b();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.baselib.report.launch.a
        public final Object invoke() {
            MMKV c;
            c = b.c();
            return c;
        }
    });

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        MMKV I = MMKV.I("kv_app");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final MMKV b() {
        return (MMKV) b.getValue();
    }
}
