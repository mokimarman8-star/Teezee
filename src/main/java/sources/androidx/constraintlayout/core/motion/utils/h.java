package androidx.constraintlayout.core.motion.utils;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class h extends c {

    /* renamed from: d, reason: collision with root package name */
    double f5760d;

    /* renamed from: e, reason: collision with root package name */
    double f5761e;

    h(String str) {
        this.f5734a = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.f5760d = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        int i5 = indexOf2 + 1;
        this.f5761e = Double.parseDouble(str.substring(i5, str.indexOf(44, i5)).trim());
    }

    private double d(double d5) {
        double d6 = this.f5761e;
        if (d5 < d6) {
            double d7 = this.f5760d;
            return ((d7 * d6) * d6) / ((((d6 - d5) * d7) + d5) * ((d7 * (d6 - d5)) + d5));
        }
        double d8 = this.f5760d;
        return (((d6 - 1.0d) * d8) * (d6 - 1.0d)) / (((((-d8) * (d6 - d5)) - d5) + 1.0d) * ((((-d8) * (d6 - d5)) - d5) + 1.0d));
    }

    private double e(double d5) {
        double d6 = this.f5761e;
        return d5 < d6 ? (d6 * d5) / (d5 + (this.f5760d * (d6 - d5))) : ((1.0d - d6) * (d5 - 1.0d)) / ((1.0d - d5) - (this.f5760d * (d6 - d5)));
    }

    @Override // androidx.constraintlayout.core.motion.utils.c
    public double a(double d5) {
        return e(d5);
    }

    @Override // androidx.constraintlayout.core.motion.utils.c
    public double b(double d5) {
        return d(d5);
    }
}
