package zk;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    public static final e a = new e();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: zk.d
        public final Object invoke() {
            MMKV c2;
            c2 = e.c();
            return c2;
        }
    });
    public static final int c = 8;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        MMKV I = MMKV.I("home_mmkv");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final MMKV b() {
        return (MMKV) b.getValue();
    }
}
