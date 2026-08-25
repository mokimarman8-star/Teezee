package com.transsion.postdetail.shorttv_pugc.factory;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j implements vs.a {
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.shorttv_pugc.factory.i
        public final Object invoke() {
            gj.c d;
            d = j.d();
            return d;
        }
    });

    private final gj.c c() {
        return (gj.c) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final gj.c d() {
        return (gj.c) gj.a.a.a(gj.c.class);
    }

    public void a(long j) {
        gj.c c = c();
        if (c != null) {
            c.a(j);
        }
    }
}
