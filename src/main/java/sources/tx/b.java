package tx;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    public static final b a = new b();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: tx.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV c;
            c = b.c();
            return c;
        }
    });

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        MMKV J = MMKV.J("dyso_config", 2);
        Intrinsics.g(J, "mmkvWithID(...)");
        return J;
    }

    public final MMKV b() {
        return (MMKV) b.getValue();
    }
}
