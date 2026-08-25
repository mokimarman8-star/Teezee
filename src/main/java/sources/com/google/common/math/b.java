package com.google.common.math;

import com.google.common.base.m;
import java.math.RoundingMode;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class b {
    private static final double a = Math.log(2.0d);
    static final double[] b = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static boolean a(double d, double d2, double d3) {
        g.d("tolerance", d3);
        return Math.copySign(d - d2, 1.0d) <= d3 || d == d2 || (Double.isNaN(d) && Double.isNaN(d2));
    }

    public static boolean b(double d) {
        return c.c(d) && (d == 0.0d || 52 - Long.numberOfTrailingZeros(c.b(d)) <= Math.getExponent(d));
    }

    public static boolean c(double d) {
        if (d <= 0.0d || !c.c(d)) {
            return false;
        }
        long b2 = c.b(d);
        return (b2 & (b2 - 1)) == 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int d(double d, RoundingMode roundingMode) {
        boolean c;
        m.e(d > 0.0d && c.c(d), "x must be positive and finite");
        int exponent = Math.getExponent(d);
        if (!c.d(d)) {
            return d(d * 4.503599627370496E15d, roundingMode) - 52;
        }
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                g.g(c(d));
                return !r1 ? exponent + 1 : exponent;
            case 2:
                if (!r1) {
                }
                break;
            case 3:
                r1 = !c(d);
                if (!r1) {
                }
                break;
            case 4:
                r1 = exponent < 0;
                c = c(d);
                r1 &= !c;
                if (!r1) {
                }
                break;
            case 5:
                r1 = exponent >= 0;
                c = c(d);
                r1 &= !c;
                if (!r1) {
                }
                break;
            case 6:
            case 7:
            case 8:
                double e = c.e(d);
                if (e * e > 2.0d) {
                    r1 = true;
                }
                if (!r1) {
                }
                break;
            default:
                throw new AssertionError();
        }
    }

    static double e(double d, RoundingMode roundingMode) {
        if (!c.c(d)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                g.g(b(d));
                return d;
            case 2:
                return (d >= 0.0d || b(d)) ? d : ((long) d) - 1;
            case 3:
                return (d <= 0.0d || b(d)) ? d : ((long) d) + 1;
            case 4:
                return d;
            case 5:
                if (b(d)) {
                    return d;
                }
                return ((long) d) + (d > 0.0d ? 1 : -1);
            case 6:
                return Math.rint(d);
            case 7:
                double rint = Math.rint(d);
                return Math.abs(d - rint) == 0.5d ? d + Math.copySign(0.5d, d) : rint;
            case 8:
                double rint2 = Math.rint(d);
                return Math.abs(d - rint2) == 0.5d ? d : rint2;
            default:
                throw new AssertionError();
        }
    }

    public static long f(double d, RoundingMode roundingMode) {
        double e = e(d, roundingMode);
        g.a(((-9.223372036854776E18d) - e < 1.0d) & (e < 9.223372036854776E18d), d, roundingMode);
        return (long) e;
    }
}
