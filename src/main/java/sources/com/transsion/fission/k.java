package com.transsion.fission;

import com.therouter.TheRouter;
import gk.a;
import kg.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class k {
    private static FissionConfig c;
    public static final k a = new k();
    private static final String b = "FissionManager";
    private static final n0 d = o0.a(y0.b());
    private static final Lazy e = LazyKt.b(new Function0() { // from class: com.transsion.fission.g
        public final Object invoke() {
            a f2;
            f2 = k.f();
            return f2;
        }
    });
    private static final Lazy f = LazyKt.b(new Function0() { // from class: com.transsion.fission.h
        public final Object invoke() {
            qx.a e3;
            e3 = k.e();
            return e3;
        }
    });

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a e() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a f() {
        return (a) c.e.a().h(a.class);
    }

    public final String c() {
        return l.a.b();
    }

    public final FissionConfig d() {
        return c;
    }
}
