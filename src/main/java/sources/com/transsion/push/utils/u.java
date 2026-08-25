package com.transsion.push.utils;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class u {
    public static final u a = new u();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.push.utils.t
        public final Object invoke() {
            MMKV c;
            c = u.c();
            return c;
        }
    });

    private u() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        MMKV I = MMKV.I("notification");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final MMKV b() {
        return (MMKV) b.getValue();
    }
}
