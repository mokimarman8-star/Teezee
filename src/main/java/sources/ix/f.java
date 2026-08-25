package ix;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f {
    public static final f a = new f();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: ix.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV c;
            c = f.c();
            return c;
        }
    });

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        MMKV I = MMKV.I("kv_login_sms");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final MMKV b() {
        return (MMKV) b.getValue();
    }
}
