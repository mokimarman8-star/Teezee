package com.transsnet.downloader.util;

import com.tencent.mmkv.MMKV;
import com.transsion.mb.config.manager.ConfigBean;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a0 {
    private static int c;
    private static int d;
    public static final a0 a = new a0();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.util.z
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV f2;
            f2 = a0.f();
            return f2;
        }
    });
    private static final int e = 20;
    private static final int f = 3;
    private static CopyOnWriteArrayList g = new CopyOnWriteArrayList();
    private static final androidx.lifecycle.b0 h = new androidx.lifecycle.b0();

    private a0() {
    }

    private final int b() {
        int i;
        String value;
        if (c <= 0) {
            try {
                ConfigBean c2 = cm.f.c.a().c("shorts_unlock_config", true);
                i = (c2 == null || (value = c2.getValue()) == null) ? e : new JSONObject(value).optInt("maxUnlockCount");
            } catch (Exception unused) {
                i = e;
            }
            c = i;
        }
        return c;
    }

    private final MMKV d() {
        return (MMKV) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV f() {
        MMKV I = MMKV.I("short_tv");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final int c(String subjectId) {
        Intrinsics.h(subjectId, "subjectId");
        return d().getInt(subjectId, b());
    }

    public final int e() {
        int i;
        String value;
        if (d <= 0) {
            try {
                ConfigBean c2 = cm.f.c.a().c("shorts_unlock_config", true);
                i = (c2 == null || (value = c2.getValue()) == null) ? f : new JSONObject(value).optInt("perUnlockCount");
            } catch (Exception unused) {
                i = f;
            }
            d = i;
        }
        return d;
    }

    public final void g(String subjectId, int i) {
        Intrinsics.h(subjectId, "subjectId");
        d().putInt(subjectId, i);
        Iterator it = g.iterator();
        while (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
        }
    }
}
