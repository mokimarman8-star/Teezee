package im;

import androidx.lifecycle.b0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class i {
    public static final i a = new i();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: im.h
        public final Object invoke() {
            b0 c;
            c = i.c();
            return c;
        }
    });

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 c() {
        return new b0();
    }

    public final b0 b() {
        return (b0) b.getValue();
    }
}
