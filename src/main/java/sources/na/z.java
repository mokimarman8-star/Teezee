package na;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class z implements com.google.android.exoplayer2.k {
    public static final z A;
    public static final z B;
    public static final k.a C;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final boolean k;
    public final ImmutableList l;
    public final int m;
    public final ImmutableList n;
    public final int o;
    public final int p;
    public final int q;
    public final ImmutableList r;
    public final ImmutableList s;
    public final int t;
    public final int u;
    public final boolean v;
    public final boolean w;
    public final boolean x;
    public final ImmutableMap y;
    public final ImmutableSet z;

    public static class a {
        private int a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;
        private boolean k;
        private ImmutableList l;
        private int m;
        private ImmutableList n;
        private int o;
        private int p;
        private int q;
        private ImmutableList r;
        private ImmutableList s;
        private int t;
        private int u;
        private boolean v;
        private boolean w;
        private boolean x;
        private HashMap y;
        private HashSet z;

        @Deprecated
        public a() {
            this.a = Integer.MAX_VALUE;
            this.b = Integer.MAX_VALUE;
            this.c = Integer.MAX_VALUE;
            this.d = Integer.MAX_VALUE;
            this.i = Integer.MAX_VALUE;
            this.j = Integer.MAX_VALUE;
            this.k = true;
            this.l = ImmutableList.of();
            this.m = 0;
            this.n = ImmutableList.of();
            this.o = 0;
            this.p = Integer.MAX_VALUE;
            this.q = Integer.MAX_VALUE;
            this.r = ImmutableList.of();
            this.s = ImmutableList.of();
            this.t = 0;
            this.u = 0;
            this.v = false;
            this.w = false;
            this.x = false;
            this.y = new HashMap();
            this.z = new HashSet();
        }

        public a(Context context) {
            this();
            H(context);
            L(context, true);
        }

        protected a(Bundle bundle) {
            String c = z.c(6);
            z zVar = z.A;
            this.a = bundle.getInt(c, zVar.a);
            this.b = bundle.getInt(z.c(7), zVar.b);
            this.c = bundle.getInt(z.c(8), zVar.c);
            this.d = bundle.getInt(z.c(9), zVar.d);
            this.e = bundle.getInt(z.c(10), zVar.e);
            this.f = bundle.getInt(z.c(11), zVar.f);
            this.g = bundle.getInt(z.c(12), zVar.g);
            this.h = bundle.getInt(z.c(13), zVar.h);
            this.i = bundle.getInt(z.c(14), zVar.i);
            this.j = bundle.getInt(z.c(15), zVar.j);
            this.k = bundle.getBoolean(z.c(16), zVar.k);
            this.l = ImmutableList.copyOf((String[]) com.google.common.base.h.a(bundle.getStringArray(z.c(17)), new String[0]));
            this.m = bundle.getInt(z.c(25), zVar.m);
            this.n = D((String[]) com.google.common.base.h.a(bundle.getStringArray(z.c(1)), new String[0]));
            this.o = bundle.getInt(z.c(2), zVar.o);
            this.p = bundle.getInt(z.c(18), zVar.p);
            this.q = bundle.getInt(z.c(19), zVar.q);
            this.r = ImmutableList.copyOf((String[]) com.google.common.base.h.a(bundle.getStringArray(z.c(20)), new String[0]));
            this.s = D((String[]) com.google.common.base.h.a(bundle.getStringArray(z.c(3)), new String[0]));
            this.t = bundle.getInt(z.c(4), zVar.t);
            this.u = bundle.getInt(z.c(26), zVar.u);
            this.v = bundle.getBoolean(z.c(5), zVar.v);
            this.w = bundle.getBoolean(z.c(21), zVar.w);
            this.x = bundle.getBoolean(z.c(22), zVar.x);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(z.c(23));
            ImmutableList of = parcelableArrayList == null ? ImmutableList.of() : com.google.android.exoplayer2.util.d.b(x.c, parcelableArrayList);
            this.y = new HashMap();
            for (int i = 0; i < of.size(); i++) {
                x xVar = (x) of.get(i);
                this.y.put(xVar.a, xVar);
            }
            int[] iArr = (int[]) com.google.common.base.h.a(bundle.getIntArray(z.c(24)), new int[0]);
            this.z = new HashSet();
            for (int i2 : iArr) {
                this.z.add(Integer.valueOf(i2));
            }
        }

        protected a(z zVar) {
            C(zVar);
        }

        private void C(z zVar) {
            this.a = zVar.a;
            this.b = zVar.b;
            this.c = zVar.c;
            this.d = zVar.d;
            this.e = zVar.e;
            this.f = zVar.f;
            this.g = zVar.g;
            this.h = zVar.h;
            this.i = zVar.i;
            this.j = zVar.j;
            this.k = zVar.k;
            this.l = zVar.l;
            this.m = zVar.m;
            this.n = zVar.n;
            this.o = zVar.o;
            this.p = zVar.p;
            this.q = zVar.q;
            this.r = zVar.r;
            this.s = zVar.s;
            this.t = zVar.t;
            this.u = zVar.u;
            this.v = zVar.v;
            this.w = zVar.w;
            this.x = zVar.x;
            this.z = new HashSet((Collection) zVar.z);
            this.y = new HashMap((Map) zVar.y);
        }

        private static ImmutableList D(String[] strArr) {
            ImmutableList.a builder = ImmutableList.builder();
            for (String str : (String[]) com.google.android.exoplayer2.util.a.e(strArr)) {
                builder.j(p0.D0((String) com.google.android.exoplayer2.util.a.e(str)));
            }
            return builder.n();
        }

        private void I(Context context) {
            CaptioningManager captioningManager;
            if ((p0.a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.t = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.s = ImmutableList.of(p0.Y(locale));
                }
            }
        }

        public z A() {
            return new z(this);
        }

        public a B(int i) {
            Iterator it = this.y.values().iterator();
            while (it.hasNext()) {
                if (((x) it.next()).b() == i) {
                    it.remove();
                }
            }
            return this;
        }

        protected a E(z zVar) {
            C(zVar);
            return this;
        }

        public a F(int i) {
            this.u = i;
            return this;
        }

        public a G(x xVar) {
            B(xVar.b());
            this.y.put(xVar.a, xVar);
            return this;
        }

        public a H(Context context) {
            if (p0.a >= 19) {
                I(context);
            }
            return this;
        }

        public a J(int i, boolean z) {
            if (z) {
                this.z.add(Integer.valueOf(i));
            } else {
                this.z.remove(Integer.valueOf(i));
            }
            return this;
        }

        public a K(int i, int i2, boolean z) {
            this.i = i;
            this.j = i2;
            this.k = z;
            return this;
        }

        public a L(Context context, boolean z) {
            Point O = p0.O(context);
            return K(O.x, O.y, z);
        }
    }

    static {
        z A2 = new a().A();
        A = A2;
        B = A2;
        C = new k.a() { // from class: na.y
            public final com.google.android.exoplayer2.k a(Bundle bundle) {
                return z.b(bundle);
            }
        };
    }

    protected z(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
        this.r = aVar.r;
        this.s = aVar.s;
        this.t = aVar.t;
        this.u = aVar.u;
        this.v = aVar.v;
        this.w = aVar.w;
        this.x = aVar.x;
        this.y = ImmutableMap.copyOf(aVar.y);
        this.z = ImmutableSet.copyOf(aVar.z);
    }

    public static z b(Bundle bundle) {
        return new a(bundle).A();
    }

    protected static String c(int i) {
        return Integer.toString(i, 36);
    }

    public a a() {
        return new a(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        return this.a == zVar.a && this.b == zVar.b && this.c == zVar.c && this.d == zVar.d && this.e == zVar.e && this.f == zVar.f && this.g == zVar.g && this.h == zVar.h && this.k == zVar.k && this.i == zVar.i && this.j == zVar.j && this.l.equals(zVar.l) && this.m == zVar.m && this.n.equals(zVar.n) && this.o == zVar.o && this.p == zVar.p && this.q == zVar.q && this.r.equals(zVar.r) && this.s.equals(zVar.s) && this.t == zVar.t && this.u == zVar.u && this.v == zVar.v && this.w == zVar.w && this.x == zVar.x && this.y.equals(zVar.y) && this.z.equals(zVar.z);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((this.a + 31) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + (this.k ? 1 : 0)) * 31) + this.i) * 31) + this.j) * 31) + this.l.hashCode()) * 31) + this.m) * 31) + this.n.hashCode()) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r.hashCode()) * 31) + this.s.hashCode()) * 31) + this.t) * 31) + this.u) * 31) + (this.v ? 1 : 0)) * 31) + (this.w ? 1 : 0)) * 31) + (this.x ? 1 : 0)) * 31) + this.y.hashCode()) * 31) + this.z.hashCode();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(6), this.a);
        bundle.putInt(c(7), this.b);
        bundle.putInt(c(8), this.c);
        bundle.putInt(c(9), this.d);
        bundle.putInt(c(10), this.e);
        bundle.putInt(c(11), this.f);
        bundle.putInt(c(12), this.g);
        bundle.putInt(c(13), this.h);
        bundle.putInt(c(14), this.i);
        bundle.putInt(c(15), this.j);
        bundle.putBoolean(c(16), this.k);
        bundle.putStringArray(c(17), (String[]) this.l.toArray(new String[0]));
        bundle.putInt(c(25), this.m);
        bundle.putStringArray(c(1), (String[]) this.n.toArray(new String[0]));
        bundle.putInt(c(2), this.o);
        bundle.putInt(c(18), this.p);
        bundle.putInt(c(19), this.q);
        bundle.putStringArray(c(20), (String[]) this.r.toArray(new String[0]));
        bundle.putStringArray(c(3), (String[]) this.s.toArray(new String[0]));
        bundle.putInt(c(4), this.t);
        bundle.putInt(c(26), this.u);
        bundle.putBoolean(c(5), this.v);
        bundle.putBoolean(c(21), this.w);
        bundle.putBoolean(c(22), this.x);
        bundle.putParcelableArrayList(c(23), com.google.android.exoplayer2.util.d.d(this.y.values()));
        bundle.putIntArray(c(24), Ints.o(this.z));
        return bundle;
    }
}
