package j00;

import io.reactivex.rxjava3.core.Scheduler;
import java.lang.reflect.Type;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class f implements retrofit2.e {
    private final Type a;
    private final Scheduler b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;

    f(Type type, Scheduler scheduler, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.a = type;
        this.b = scheduler;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = z6;
        this.i = z7;
    }

    @Override // retrofit2.e
    public Type a() {
        return this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    @Override // retrofit2.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(retrofit2.d r2) {
        /*
            r1 = this;
            boolean r0 = r1.c
            if (r0 == 0) goto La
            j00.b r0 = new j00.b
            r0.<init>(r2)
            goto Lf
        La:
            j00.c r0 = new j00.c
            r0.<init>(r2)
        Lf:
            boolean r2 = r1.d
            if (r2 == 0) goto L1a
            j00.e r2 = new j00.e
            r2.<init>(r0)
        L18:
            r0 = r2
            goto L24
        L1a:
            boolean r2 = r1.e
            if (r2 == 0) goto L24
            j00.a r2 = new j00.a
            r2.<init>(r0)
            goto L18
        L24:
            io.reactivex.rxjava3.core.Scheduler r2 = r1.b
            if (r2 == 0) goto L2c
            io.reactivex.rxjava3.core.j r0 = r0.E(r2)
        L2c:
            boolean r2 = r1.f
            if (r2 == 0) goto L37
            io.reactivex.rxjava3.core.BackpressureStrategy r2 = io.reactivex.rxjava3.core.BackpressureStrategy.MISSING
            io.reactivex.rxjava3.core.e r2 = r0.F(r2)
            return r2
        L37:
            boolean r2 = r1.g
            if (r2 == 0) goto L40
            io.reactivex.rxjava3.core.p r2 = r0.A()
            return r2
        L40:
            boolean r2 = r1.h
            if (r2 == 0) goto L49
            io.reactivex.rxjava3.core.g r2 = r0.z()
            return r2
        L49:
            boolean r2 = r1.i
            if (r2 == 0) goto L52
            io.reactivex.rxjava3.core.a r2 = r0.s()
            return r2
        L52:
            io.reactivex.rxjava3.core.j r2 = dy.a.o(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j00.f.b(retrofit2.d):java.lang.Object");
    }
}
