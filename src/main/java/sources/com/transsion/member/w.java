package com.transsion.member;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class w {
    public static final w a = new w();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.member.v
        public final Object invoke() {
            MMKV c2;
            c2 = w.c();
            return c2;
        }
    });
    public static final int c = 8;

    private w() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        return MMKV.I("member_kv");
    }

    public final MMKV b() {
        return (MMKV) b.getValue();
    }
}
