package z9;

import android.net.Uri;
import com.google.android.exoplayer2.p1;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import java.util.List;
import z9.k;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class j {
    public final long a;
    public final p1 b;
    public final ImmutableList c;
    public final long d;
    public final List e;
    public final List f;
    public final List g;
    private final i h;

    public static class b extends j implements y9.e {
        final k.a i;

        public b(long j, p1 p1Var, List list, k.a aVar, List list2, List list3, List list4) {
            super(j, p1Var, list, aVar, list2, list3, list4);
            this.i = aVar;
        }

        @Override // y9.e
        public long a(long j, long j2) {
            return this.i.h(j, j2);
        }

        @Override // y9.e
        public long b(long j, long j2) {
            return this.i.d(j, j2);
        }

        @Override // y9.e
        public long c(long j, long j2) {
            return this.i.f(j, j2);
        }

        @Override // y9.e
        public i d(long j) {
            return this.i.k(this, j);
        }

        @Override // y9.e
        public long e(long j, long j2) {
            return this.i.i(j, j2);
        }

        @Override // y9.e
        public long f(long j) {
            return this.i.g(j);
        }

        @Override // y9.e
        public boolean g() {
            return this.i.l();
        }

        @Override // y9.e
        public long getTimeUs(long j) {
            return this.i.j(j);
        }

        @Override // y9.e
        public long h() {
            return this.i.e();
        }

        @Override // y9.e
        public long i(long j, long j2) {
            return this.i.c(j, j2);
        }

        @Override // z9.j
        public String j() {
            return null;
        }

        @Override // z9.j
        public y9.e k() {
            return this;
        }

        @Override // z9.j
        public i l() {
            return null;
        }
    }

    public static class c extends j {
        public final Uri i;
        public final long j;
        private final String k;
        private final i l;
        private final m m;

        public c(long j, p1 p1Var, List list, k.e eVar, List list2, List list3, List list4, String str, long j2) {
            super(j, p1Var, list, eVar, list2, list3, list4);
            this.i = Uri.parse(((z9.b) list.get(0)).a);
            i c = eVar.c();
            this.l = c;
            this.k = str;
            this.j = j2;
            this.m = c != null ? null : new m(new i(null, 0L, j2));
        }

        @Override // z9.j
        public String j() {
            return this.k;
        }

        @Override // z9.j
        public y9.e k() {
            return this.m;
        }

        @Override // z9.j
        public i l() {
            return this.l;
        }
    }

    private j(long j, p1 p1Var, List list, k kVar, List list2, List list3, List list4) {
        com.google.android.exoplayer2.util.a.a(!list.isEmpty());
        this.a = j;
        this.b = p1Var;
        this.c = ImmutableList.copyOf(list);
        this.e = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f = list3;
        this.g = list4;
        this.h = kVar.a(this);
        this.d = kVar.b();
    }

    public static j n(long j, p1 p1Var, List list, k kVar, List list2, List list3, List list4, String str) {
        if (kVar instanceof k.e) {
            return new c(j, p1Var, list, (k.e) kVar, list2, list3, list4, str, -1L);
        }
        if (kVar instanceof k.a) {
            return new b(j, p1Var, list, (k.a) kVar, list2, list3, list4);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    public abstract String j();

    public abstract y9.e k();

    public abstract i l();

    public i m() {
        return this.h;
    }
}
