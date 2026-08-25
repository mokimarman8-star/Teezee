package cm;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class d {
    public static final d a = new d();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: cm.a
        public final Object invoke() {
            MMKV i;
            i = d.i();
            return i;
        }
    });
    private static final Lazy c = LazyKt.b(new Function0() { // from class: cm.b
        public final Object invoke() {
            MMKV h;
            h = d.h();
            return h;
        }
    });
    private static final Lazy d = LazyKt.b(new Function0() { // from class: cm.c
        public final Object invoke() {
            MMKV d2;
            d2 = d.d();
            return d2;
        }
    });

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV d() {
        MMKV I = MMKV.I("kv_bucket_config");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV h() {
        MMKV I = MMKV.I("kv_local_config");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV i() {
        MMKV I = MMKV.I("kv_app_config");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final MMKV e() {
        return (MMKV) d.getValue();
    }

    public final MMKV f() {
        return (MMKV) c.getValue();
    }

    public final MMKV g() {
        return (MMKV) b.getValue();
    }
}
