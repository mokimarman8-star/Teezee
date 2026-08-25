package com.pgl.ssdk;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class m<A, B> {
    private final A a;
    private final B b;

    public m(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public static <A, B> m<A, B> a(A a, B b) {
        return new m<>(a, b);
    }

    public A a() {
        return this.a;
    }

    public B b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        A a = this.a;
        if (a == null) {
            if (mVar.a != null) {
                return false;
            }
        } else if (!a.equals(mVar.a)) {
            return false;
        }
        B b = this.b;
        if (b == null) {
            if (mVar.b != null) {
                return false;
            }
        } else if (!b.equals(mVar.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a = this.a;
        int hashCode = ((a == null ? 0 : a.hashCode()) + 31) * 31;
        B b = this.b;
        return hashCode + (b != null ? b.hashCode() : 0);
    }
}
