package com.transsion.baselib.helper;

import com.tencent.mmkv.MMKV;
import com.transsion.player.p003enum.ScaleMode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    public static final d a = new d();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.baselib.helper.c
        public final Object invoke() {
            MMKV e;
            e = d.e();
            return e;
        }
    });

    private d() {
    }

    private final MMKV b() {
        return (MMKV) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV e() {
        MMKV I = MMKV.I("LocalVideoPlayerConfig");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final ScaleMode c() {
        int i = b().getInt("ScaleMode", 0);
        ScaleMode scaleMode = ScaleMode.SCALE_ASPECT_FIT;
        if (scaleMode.getValue() == i) {
            return scaleMode;
        }
        ScaleMode scaleMode2 = ScaleMode.SCALE_ASPECT_FILL;
        return scaleMode2.getValue() == i ? scaleMode2 : ScaleMode.SCALE_TO_FILL;
    }

    public final float d() {
        return b().getFloat("speed", 1.0f);
    }

    public final void f(ScaleMode scaleMode) {
        Intrinsics.h(scaleMode, "mode");
        b().putInt("ScaleMode", scaleMode.getValue());
    }

    public final void g(float f) {
        b().putFloat("speed", f);
    }
}
