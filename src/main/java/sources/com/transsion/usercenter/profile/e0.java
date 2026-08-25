package com.transsion.usercenter.profile;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e0 {
    public static final e0 a = new e0();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.profile.d0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV c;
            c = e0.c();
            return c;
        }
    });

    private e0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        return MMKV.I("profile_kv");
    }

    public final MMKV b() {
        return (MMKV) b.getValue();
    }
}
