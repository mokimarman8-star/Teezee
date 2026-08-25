package com.transsion.push.notification;

import android.app.Activity;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class h {
    public static final h a = new h();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.push.notification.g
        public final Object invoke() {
            MMKV b2;
            b2 = h.b();
            return b2;
        }
    });
    private static long c;

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV b() {
        MMKV I = MMKV.I("NoticePermission");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public static /* synthetic */ void d(h hVar, Activity activity, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 530;
        }
        hVar.c(activity, i);
    }

    public final void c(Activity activity, int i) {
        Intrinsics.h(activity, "activity");
        if (Build.VERSION.SDK_INT >= 33) {
            c = System.currentTimeMillis();
            ActivityCompat.g(activity, new String[]{"android.permission.POST_NOTIFICATIONS"}, i);
        }
    }
}
