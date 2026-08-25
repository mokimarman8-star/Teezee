package com.transsion.ad.strategy;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    public static final e a = new e();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.ad.strategy.d
        public final Object invoke() {
            MMKV d;
            d = e.d();
            return d;
        }
    });

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV d() {
        MMKV I = MMKV.I("one_room_advertising");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final MMKV b() {
        return c();
    }

    public final MMKV c() {
        return (MMKV) b.getValue();
    }
}
