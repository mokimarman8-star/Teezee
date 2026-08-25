package com.google.common.math;

import com.google.common.base.m;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class e {

    public static final class b {
        private final double a;
        private final double b;

        private b(double d, double d2) {
            this.a = d;
            this.b = d2;
        }

        public e a(double d) {
            m.d(!Double.isNaN(d));
            return com.google.common.math.c.c(d) ? new d(d, this.b - (this.a * d)) : new C0015e(this.a);
        }
    }

    private static final class c extends e {
        static final c a = new c();

        private c() {
        }

        public String toString() {
            return "NaN";
        }
    }

    private static final class d extends e {
        final double a;
        final double b;
        e c = null;

        d(double d, double d2) {
            this.a = d;
            this.b = d2;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.a), Double.valueOf(this.b));
        }
    }

    /* renamed from: com.google.common.math.e$e, reason: collision with other inner class name */
    private static final class C0015e extends e {
        final double a;
        e b = null;

        C0015e(double d) {
            this.a = d;
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.a));
        }
    }

    public static e a() {
        return c.a;
    }

    public static e b(double d2) {
        m.d(com.google.common.math.c.c(d2));
        return new d(0.0d, d2);
    }

    public static b c(double d2, double d3) {
        m.d(com.google.common.math.c.c(d2) && com.google.common.math.c.c(d3));
        return new b(d2, d3);
    }

    public static e d(double d2) {
        m.d(com.google.common.math.c.c(d2));
        return new C0015e(d2);
    }
}
