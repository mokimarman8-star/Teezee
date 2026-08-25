package com.transsion.shorttv_pugc.utils;

import androidx.lifecycle.b0;
import com.tencent.mmkv.MMKV;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h {
    private static int d;
    private static int e;
    private static vs.b i;
    public static final h a = new h();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.shorttv_pugc.utils.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV i2;
            i2 = h.i();
            return i2;
        }
    });
    private static final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.shorttv_pugc.utils.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV j2;
            j2 = h.j();
            return j2;
        }
    });
    private static final int f = 20;
    private static final int g = 3;
    private static CopyOnWriteArrayList h = new CopyOnWriteArrayList();
    private static final b0 j = new b0();

    private h() {
    }

    private final vs.b c() {
        vs.b bVar = i;
        if (bVar == null) {
            ws.a b2 = cs.a.a.b();
            bVar = b2 != null ? b2.h() : null;
            i = bVar;
        }
        return bVar;
    }

    private final int d() {
        int i2;
        String a2;
        if (d <= 0) {
            try {
                vs.b c2 = c();
                i2 = (c2 == null || (a2 = c2.a()) == null) ? f : new JSONObject(a2).optInt("maxUnlockCount");
            } catch (Exception unused) {
                i2 = f;
            }
            d = i2;
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV i() {
        MMKV I = MMKV.I("short_tv");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV j() {
        MMKV I = MMKV.I("kv_app");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final int e(String subjectId) {
        Intrinsics.h(subjectId, "subjectId");
        return f().getInt(subjectId, d());
    }

    public final MMKV f() {
        return (MMKV) b.getValue();
    }

    public final MMKV g() {
        return (MMKV) c.getValue();
    }

    public final int h() {
        int i2;
        String a2;
        if (e <= 0) {
            try {
                vs.b c2 = c();
                i2 = (c2 == null || (a2 = c2.a()) == null) ? g : new JSONObject(a2).optInt("perUnlockCount");
            } catch (Exception unused) {
                i2 = g;
            }
            e = i2;
        }
        return e;
    }

    public final void k(String subjectId, int i2) {
        Intrinsics.h(subjectId, "subjectId");
        f().putInt(subjectId, i2);
        Iterator it = h.iterator();
        while (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
        }
    }
}
