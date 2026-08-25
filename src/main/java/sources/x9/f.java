package x9;

import android.net.Uri;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.i0;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class f implements Loader.d {
    public final long a = v9.h.a();
    public final com.google.android.exoplayer2.upstream.n b;
    public final int c;
    public final p1 d;
    public final int e;
    public final Object f;
    public final long g;
    public final long h;
    protected final i0 i;

    public f(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, int i, p1 p1Var, int i2, Object obj, long j, long j2) {
        this.i = new i0(kVar);
        this.b = (com.google.android.exoplayer2.upstream.n) com.google.android.exoplayer2.util.a.e(nVar);
        this.c = i;
        this.d = p1Var;
        this.e = i2;
        this.f = obj;
        this.g = j;
        this.h = j2;
    }

    public final long a() {
        return this.i.f();
    }

    public final long b() {
        return this.h - this.g;
    }

    public final Map c() {
        return this.i.i();
    }

    public final Uri d() {
        return this.i.h();
    }
}
