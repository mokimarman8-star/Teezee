package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.LBlendMode;
import java.util.List;
import java.util.Locale;
import s4.b;
import s4.j;
import s4.k;
import s4.n;
import t4.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class Layer {
    private final List a;
    private final h b;
    private final String c;
    private final long d;
    private final LayerType e;
    private final long f;
    private final String g;
    private final List h;
    private final n i;
    private final int j;
    private final int k;
    private final int l;
    private final float m;
    private final float n;
    private final float o;
    private final float p;
    private final j q;
    private final k r;
    private final b s;
    private final List t;
    private final MatteType u;
    private final boolean v;
    private final a w;
    private final w4.j x;
    private final LBlendMode y;

    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List list, h hVar, String str, long j, LayerType layerType, long j2, String str2, List list2, n nVar, int i, int i2, int i3, float f, float f2, float f3, float f4, j jVar, k kVar, List list3, MatteType matteType, b bVar, boolean z, a aVar, w4.j jVar2, LBlendMode lBlendMode) {
        this.a = list;
        this.b = hVar;
        this.c = str;
        this.d = j;
        this.e = layerType;
        this.f = j2;
        this.g = str2;
        this.h = list2;
        this.i = nVar;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = f;
        this.n = f2;
        this.o = f3;
        this.p = f4;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = matteType;
        this.s = bVar;
        this.v = z;
        this.w = aVar;
        this.x = jVar2;
        this.y = lBlendMode;
    }

    public LBlendMode a() {
        return this.y;
    }

    public a b() {
        return this.w;
    }

    h c() {
        return this.b;
    }

    public w4.j d() {
        return this.x;
    }

    public long e() {
        return this.d;
    }

    List f() {
        return this.t;
    }

    public LayerType g() {
        return this.e;
    }

    List h() {
        return this.h;
    }

    MatteType i() {
        return this.u;
    }

    public String j() {
        return this.c;
    }

    long k() {
        return this.f;
    }

    float l() {
        return this.p;
    }

    float m() {
        return this.o;
    }

    public String n() {
        return this.g;
    }

    List o() {
        return this.a;
    }

    int p() {
        return this.l;
    }

    int q() {
        return this.k;
    }

    int r() {
        return this.j;
    }

    float s() {
        return this.n / this.b.e();
    }

    j t() {
        return this.q;
    }

    public String toString() {
        return z("");
    }

    k u() {
        return this.r;
    }

    b v() {
        return this.s;
    }

    float w() {
        return this.m;
    }

    n x() {
        return this.i;
    }

    public boolean y() {
        return this.v;
    }

    public String z(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(j());
        sb.append("\n");
        Layer t = this.b.t(k());
        if (t != null) {
            sb.append("\t\tParents: ");
            sb.append(t.j());
            Layer t2 = this.b.t(t.k());
            while (t2 != null) {
                sb.append("->");
                sb.append(t2.j());
                t2 = this.b.t(t2.k());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!h().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(h().size());
            sb.append("\n");
        }
        if (r() != 0 && q() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(r()), Integer.valueOf(q()), Integer.valueOf(p())));
        }
        if (!this.a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (Object obj : this.a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(obj);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
