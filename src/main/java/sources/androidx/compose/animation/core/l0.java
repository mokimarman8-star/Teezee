package androidx.compose.animation.core;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class l0 {
    public static final long a(double d5, double d6, double d7, double d8, double d9) {
        double d10;
        double d11;
        double d12;
        double d13;
        double d14;
        double d15;
        double d16;
        double d17;
        double sqrt = 2.0d * d6 * Math.sqrt(d5);
        double d18 = (sqrt * sqrt) - (4.0d * d5);
        double d19 = -sqrt;
        s a5 = t.a(d18);
        d10 = a5.f1490a;
        a5.f1490a = d10 + d19;
        d11 = a5.f1490a;
        a5.f1490a = d11 * 0.5d;
        d12 = a5.f1491b;
        a5.f1491b = d12 * 0.5d;
        s a6 = t.a(d18);
        d13 = a6.f1490a;
        double d20 = -1;
        a6.f1490a = d13 * d20;
        d14 = a6.f1491b;
        a6.f1491b = d14 * d20;
        d15 = a6.f1490a;
        a6.f1490a = d15 + d19;
        d16 = a6.f1490a;
        a6.f1490a = d16 * 0.5d;
        d17 = a6.f1491b;
        a6.f1491b = d17 * 0.5d;
        return d(a5, a6, d6, d7, d8, d9);
    }

    public static final long b(float f5, float f6, float f7, float f8, float f9) {
        if (f6 == 0.0f) {
            return 9223372036854L;
        }
        return a(f5, f6, f7, f8, f9);
    }

    private static final double c(s sVar, double d5, double d6, double d7) {
        double d8;
        int i5;
        double d9 = d7;
        double f5 = sVar.f();
        double d10 = f5 * d5;
        double d11 = d6 - d10;
        double log = Math.log(Math.abs(d9 / d5)) / f5;
        double log2 = Math.log(Math.abs(d9 / d11));
        double d12 = log2;
        for (int i6 = 0; i6 < 6; i6++) {
            d12 = log2 - Math.log(Math.abs(d12 / f5));
        }
        double d13 = d12 / f5;
        if (!((Double.isInfinite(log) || Double.isNaN(log)) ? false : true)) {
            log = d13;
        } else if ((Double.isInfinite(d13) || Double.isNaN(d13)) ? false : true) {
            log = Math.max(log, d13);
        }
        double d14 = (-(d10 + d11)) / (f5 * d11);
        double d15 = f5 * d14;
        double exp = (Math.exp(d15) * d5) + (d11 * d14 * Math.exp(d15));
        if (!Double.isNaN(d14) && d14 > 0.0d) {
            if (d14 <= 0.0d || (-exp) >= d9) {
                log = (-(2.0d / f5)) - (d5 / d11);
                d8 = Double.MAX_VALUE;
                i5 = 0;
                while (d8 > 0.001d && i5 < 100) {
                    i5++;
                    double d16 = f5 * log;
                    double d17 = d9;
                    double exp2 = log - ((((d5 + (d11 * log)) * Math.exp(d16)) + d9) / ((((1 + d16) * d11) + d10) * Math.exp(d16)));
                    d8 = Math.abs(log - exp2);
                    log = exp2;
                    d9 = d17;
                }
                return log;
            }
            if (d11 < 0.0d && d5 > 0.0d) {
                log = 0.0d;
            }
        }
        d9 = -d9;
        d8 = Double.MAX_VALUE;
        i5 = 0;
        while (d8 > 0.001d) {
            i5++;
            double d162 = f5 * log;
            double d172 = d9;
            double exp22 = log - ((((d5 + (d11 * log)) * Math.exp(d162)) + d9) / ((((1 + d162) * d11) + d10) * Math.exp(d162)));
            d8 = Math.abs(log - exp22);
            log = exp22;
            d9 = d172;
        }
        return log;
    }

    private static final long d(s sVar, s sVar2, double d5, double d6, double d7, double d8) {
        double d9 = d6;
        if (d7 == 0.0d && d9 == 0.0d) {
            return 0L;
        }
        if (d7 < 0.0d) {
            d9 = -d9;
        }
        double abs = Math.abs(d7);
        return (long) ((d5 > 1.0d ? e(sVar, sVar2, abs, d9, d8) : d5 < 1.0d ? g(sVar, abs, d9, d8) : c(sVar, abs, d9, d8)) * 1000.0d);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final double e(s sVar, s sVar2, double d5, double d6, double d7) {
        double d8;
        double d9;
        double d10;
        double d11 = d7;
        double f5 = sVar.f();
        double f6 = sVar2.f();
        double d12 = f5 - f6;
        double d13 = ((f5 * d5) - d6) / d12;
        double d14 = d5 - d13;
        double log = Math.log(Math.abs(d11 / d14)) / f5;
        double log2 = Math.log(Math.abs(d11 / d13)) / f6;
        if ((Double.isInfinite(log) || Double.isNaN(log)) ? false : true) {
            if ((Double.isInfinite(log2) || Double.isNaN(log2)) ? false : true) {
                log = Math.max(log, log2);
            }
            d8 = log;
        } else {
            d8 = log2;
        }
        double d15 = d14 * f5;
        double log3 = Math.log(d15 / ((-d13) * f6)) / (f6 - f5);
        if (!Double.isNaN(log3) && log3 > 0.0d) {
            if (log3 > 0.0d) {
                d9 = d13;
                if ((-f(d14, f5, log3, d13, f6)) < d11) {
                    if (d9 > 0.0d && d14 < 0.0d) {
                        d8 = 0.0d;
                    }
                }
            } else {
                d9 = d13;
            }
            d8 = Math.log((-((d9 * f6) * f6)) / (d15 * f5)) / d12;
            d10 = d9 * f6;
            if (Math.abs((Math.exp(f5 * d8) * d15) + (Math.exp(f6 * d8) * d10)) >= 1.0E-4d) {
                return d8;
            }
            double d16 = Double.MAX_VALUE;
            int i5 = 0;
            while (d16 > 0.001d && i5 < 100) {
                i5++;
                double d17 = f5 * d8;
                double d18 = f6 * d8;
                double exp = d8 - ((((Math.exp(d17) * d14) + (Math.exp(d18) * d9)) + d11) / ((Math.exp(d17) * d15) + (Math.exp(d18) * d10)));
                double abs = Math.abs(d8 - exp);
                d8 = exp;
                d16 = abs;
            }
            return d8;
        }
        d9 = d13;
        d11 = -d11;
        d10 = d9 * f6;
        if (Math.abs((Math.exp(f5 * d8) * d15) + (Math.exp(f6 * d8) * d10)) >= 1.0E-4d) {
        }
    }

    private static final double f(double d5, double d6, double d7, double d8, double d9) {
        return (d5 * Math.exp(d6 * d7)) + (d8 * Math.exp(d9 * d7));
    }

    private static final double g(s sVar, double d5, double d6, double d7) {
        double f5 = sVar.f();
        double e5 = (d6 - (f5 * d5)) / sVar.e();
        return Math.log(d7 / Math.sqrt((d5 * d5) + (e5 * e5))) / f5;
    }
}
