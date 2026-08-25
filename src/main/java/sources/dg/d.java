package dg;

import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.m;
import io.reactivex.rxjava3.core.n;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class d {
    public static final d a = new d();

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m d(j jVar) {
        Intrinsics.h(jVar, "observable");
        return jVar.E(ey.a.c()).v(io.reactivex.rxjava3.android.schedulers.b.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m f(j jVar) {
        Intrinsics.h(jVar, "observable");
        return jVar.E(ey.a.c()).v(ey.a.c());
    }

    public final n c() {
        return new n() { // from class: dg.b
            public final m a(j jVar) {
                m d;
                d = d.d(jVar);
                return d;
            }
        };
    }

    public final n e() {
        return new n() { // from class: dg.c
            public final m a(j jVar) {
                m f;
                f = d.f(jVar);
                return f;
            }
        };
    }
}
