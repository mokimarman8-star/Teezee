package ix;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class d {
    public static final d a = new d();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: ix.c
        public final Object invoke() {
            MMKV c;
            c = d.c();
            return c;
        }
    });

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        MMKV J = MMKV.J("kv_login", 2);
        Intrinsics.g(J, "mmkvWithID(...)");
        return J;
    }

    public final MMKV b() {
        return (MMKV) b.getValue();
    }
}
