package com.transsion.subtitle_download.utils;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d {
    public static final d a = new d();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.subtitle_download.utils.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV c;
            c = d.c();
            return c;
        }
    });

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        MMKV I = MMKV.I("kv_subtitle");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final MMKV b() {
        return (MMKV) b.getValue();
    }
}
