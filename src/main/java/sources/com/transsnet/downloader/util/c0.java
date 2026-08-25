package com.transsnet.downloader.util;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c0 {
    public static final c0 a = new c0();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.util.b0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV d;
            d = c0.d();
            return d;
        }
    });

    private c0() {
    }

    private final MMKV b() {
        return (MMKV) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV d() {
        MMKV I = MMKV.I("transfer_tips");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final boolean c() {
        return b().getBoolean("key_transfer_tips_dialog_show", false);
    }

    public final void e(boolean z) {
        b().putBoolean("key_transfer_tips_dialog_show", z);
    }
}
