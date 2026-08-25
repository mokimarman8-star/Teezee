package androidx.navigation;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final o f12473a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f12474b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f12475c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f12476d;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private o f12477a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f12478b;

        /* renamed from: c, reason: collision with root package name */
        private Object f12479c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f12480d;

        public final d a() {
            o oVar = this.f12477a;
            if (oVar == null) {
                oVar = o.f12545c.c(this.f12479c);
            }
            return new d(oVar, this.f12478b, this.f12479c, this.f12480d);
        }

        public final a b(Object obj) {
            this.f12479c = obj;
            this.f12480d = true;
            return this;
        }

        public final a c(boolean z5) {
            this.f12478b = z5;
            return this;
        }

        public final a d(o oVar) {
            Intrinsics.h(oVar, "type");
            this.f12477a = oVar;
            return this;
        }
    }

    public d(o oVar, boolean z5, Object obj, boolean z6) {
        Intrinsics.h(oVar, "type");
        if (!oVar.c() && z5) {
            throw new IllegalArgumentException(Intrinsics.q(oVar.b(), " does not allow nullable values").toString());
        }
        if (!z5 && z6 && obj == null) {
            throw new IllegalArgumentException(("Argument with type " + oVar.b() + " has null value but is not nullable.").toString());
        }
        this.f12473a = oVar;
        this.f12474b = z5;
        this.f12476d = obj;
        this.f12475c = z6;
    }

    public final o a() {
        return this.f12473a;
    }

    public final boolean b() {
        return this.f12475c;
    }

    public final boolean c() {
        return this.f12474b;
    }

    public final void d(String str, Bundle bundle) {
        Intrinsics.h(str, "name");
        Intrinsics.h(bundle, "bundle");
        if (this.f12475c) {
            this.f12473a.f(bundle, str, this.f12476d);
        }
    }

    public final boolean e(String str, Bundle bundle) {
        Intrinsics.h(str, "name");
        Intrinsics.h(bundle, "bundle");
        if (!this.f12474b && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.f12473a.a(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.c(d.class, obj.getClass())) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f12474b != dVar.f12474b || this.f12475c != dVar.f12475c || !Intrinsics.c(this.f12473a, dVar.f12473a)) {
            return false;
        }
        Object obj2 = this.f12476d;
        return obj2 != null ? Intrinsics.c(obj2, dVar.f12476d) : dVar.f12476d == null;
    }

    public int hashCode() {
        int hashCode = ((((this.f12473a.hashCode() * 31) + (this.f12474b ? 1 : 0)) * 31) + (this.f12475c ? 1 : 0)) * 31;
        Object obj = this.f12476d;
        return hashCode + (obj == null ? 0 : obj.hashCode());
    }
}
