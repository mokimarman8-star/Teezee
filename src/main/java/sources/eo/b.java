package eo;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: eo.a
        public final Object invoke() {
            boolean c;
            c = b.c();
            return Boolean.valueOf(c);
        }
    });

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c() {
        return false;
    }

    public final boolean b() {
        return ((Boolean) b.getValue()).booleanValue();
    }
}
