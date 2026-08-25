package com.transsion.shorttv.utils;

import androidx.lifecycle.b0;
import com.tencent.mmkv.MMKV;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h {
    public static final h a = new h();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.utils.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV g2;
            g2 = h.g();
            return g2;
        }
    });
    private static final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.utils.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV h;
            h = h.h();
            return h;
        }
    });
    private static final int d = 20;
    private static final int e = 3;
    private static CopyOnWriteArrayList f = new CopyOnWriteArrayList();
    private static final b0 g = new b0();

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV g() {
        MMKV I = MMKV.I("short_tv");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV h() {
        MMKV I = MMKV.I("kv_app");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final boolean c() {
        return System.currentTimeMillis() - d().getLong("k_download_guide_bubble_last_show_time", 0L) >= 259200000;
    }

    public final MMKV d() {
        return (MMKV) b.getValue();
    }

    public final MMKV e() {
        return (MMKV) c.getValue();
    }

    public final void f() {
        d().putLong("k_download_guide_bubble_last_show_time", System.currentTimeMillis());
    }
}
