package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    static c f5732b = new c();

    /* renamed from: c, reason: collision with root package name */
    public static String[] f5733c = {"standard", "accelerate", "decelerate", "linear"};

    /* renamed from: a, reason: collision with root package name */
    String f5734a = "identity";

    static class a extends c {

        /* renamed from: h, reason: collision with root package name */
        private static double f5735h = 0.01d;

        /* renamed from: i, reason: collision with root package name */
        private static double f5736i = 1.0E-4d;

        /* renamed from: d, reason: collision with root package name */
        double f5737d;

        /* renamed from: e, reason: collision with root package name */
        double f5738e;

        /* renamed from: f, reason: collision with root package name */
        double f5739f;

        /* renamed from: g, reason: collision with root package name */
        double f5740g;

        a(String str) {
            this.f5734a = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.f5737d = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i5 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i5);
            this.f5738e = Double.parseDouble(str.substring(i5, indexOf3).trim());
            int i6 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i6);
            this.f5739f = Double.parseDouble(str.substring(i6, indexOf4).trim());
            int i7 = indexOf4 + 1;
            this.f5740g = Double.parseDouble(str.substring(i7, str.indexOf(41, i7)).trim());
        }

        private double d(double d5) {
            double d6 = 1.0d - d5;
            double d7 = 3.0d * d6;
            return (this.f5737d * d6 * d7 * d5) + (this.f5739f * d7 * d5 * d5) + (d5 * d5 * d5);
        }

        private double e(double d5) {
            double d6 = 1.0d - d5;
            double d7 = 3.0d * d6;
            return (this.f5738e * d6 * d7 * d5) + (this.f5740g * d7 * d5 * d5) + (d5 * d5 * d5);
        }

        @Override // androidx.constraintlayout.core.motion.utils.c
        public double a(double d5) {
            if (d5 <= 0.0d) {
                return 0.0d;
            }
            if (d5 >= 1.0d) {
                return 1.0d;
            }
            double d6 = 0.5d;
            double d7 = 0.5d;
            while (d6 > f5735h) {
                d6 *= 0.5d;
                d7 = d(d7) < d5 ? d7 + d6 : d7 - d6;
            }
            double d8 = d7 - d6;
            double d9 = d(d8);
            double d10 = d7 + d6;
            double d11 = d(d10);
            double e5 = e(d8);
            return (((e(d10) - e5) * (d5 - d9)) / (d11 - d9)) + e5;
        }

        @Override // androidx.constraintlayout.core.motion.utils.c
        public double b(double d5) {
            double d6 = 0.5d;
            double d7 = 0.5d;
            while (d6 > f5736i) {
                d6 *= 0.5d;
                d7 = d(d7) < d5 ? d7 + d6 : d7 - d6;
            }
            double d8 = d7 - d6;
            double d9 = d7 + d6;
            return (e(d9) - e(d8)) / (d(d9) - d(d8));
        }
    }

    public static c c(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new a(str);
        }
        if (str.startsWith("spline")) {
            return new k(str);
        }
        if (str.startsWith("Schlick")) {
            return new h(str);
        }
        switch (str) {
            case "accelerate":
                return new a("cubic(0.4, 0.05, 0.8, 0.7)");
            case "decelerate":
                return new a("cubic(0.0, 0.0, 0.2, 0.95)");
            case "anticipate":
                return new a("cubic(0.36, 0, 0.66, -0.56)");
            case "linear":
                return new a("cubic(1, 1, 0, 0)");
            case "overshoot":
                return new a("cubic(0.34, 1.56, 0.64, 1)");
            case "standard":
                return new a("cubic(0.4, 0.0, 0.2, 1)");
            default:
                System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(f5733c));
                return f5732b;
        }
    }

    public double a(double d5) {
        return d5;
    }

    public double b(double d5) {
        return 1.0d;
    }

    public String toString() {
        return this.f5734a;
    }
}
