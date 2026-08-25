package fq;

import com.tencent.mmkv.MMKV;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final a a = new a(null);
    private static final Lazy b = LazyKt.b(new Function0() { // from class: fq.a
        public final Object invoke() {
            MMKV c2;
            c2 = b.c();
            return c2;
        }
    });
    private static List c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a() {
            return b.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        MMKV I = MMKV.I("search_mmKv");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }
}
