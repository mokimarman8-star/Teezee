package io;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f {
    public static final f a = new f();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: io.e
        public final Object invoke() {
            MMKV d;
            d = f.d();
            return d;
        }
    });

    private f() {
    }

    private final MMKV b() {
        return (MMKV) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV d() {
        MMKV I = MMKV.I("shorts_progress_cache");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final long c(String str) {
        Intrinsics.h(str, "postId");
        if (str.length() == 0) {
            return 0L;
        }
        return b().h(str, 0L);
    }

    public final void e(String str, long j) {
        Intrinsics.h(str, "postId");
        if (str.length() == 0) {
            return;
        }
        b().t(str, j);
    }
}
