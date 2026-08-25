package com.transsion.postdetail.shorttv.factory;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class m implements ur.a {
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.shorttv.factory.l
        public final Object invoke() {
            gj.c e;
            e = m.e();
            return e;
        }
    });

    private final gj.c d() {
        return (gj.c) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final gj.c e() {
        return (gj.c) gj.a.a.a(gj.c.class);
    }

    @Override // ur.a
    public void a(long j) {
        gj.c d = d();
        if (d != null) {
            d.a(j);
        }
    }

    @Override // ur.a
    public void b(long j) {
        gj.c d = d();
        if (d != null) {
            d.b(j);
        }
    }
}
