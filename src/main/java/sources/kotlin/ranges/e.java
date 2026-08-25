package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntProgression;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class e extends d {
    public static float d(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    public static int e(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static long f(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static float g(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    public static int h(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static long i(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static double j(double d, double d2, double d3) {
        if (d2 <= d3) {
            return d < d2 ? d2 : d > d3 ? d3 : d;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d3 + " is less than minimum " + d2 + '.');
    }

    public static float k(float f, float f2, float f3) {
        if (f2 <= f3) {
            return f < f2 ? f2 : f > f3 ? f3 : f;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f3 + " is less than minimum " + f2 + '.');
    }

    public static int l(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static long m(long j, long j2, long j3) {
        if (j2 <= j3) {
            return j < j2 ? j2 : j > j3 ? j3 : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j3 + " is less than minimum " + j2 + '.');
    }

    public static Comparable n(Comparable comparable, ClosedFloatingPointRange range) {
        Intrinsics.h(comparable, "<this>");
        Intrinsics.h(range, "range");
        if (!range.isEmpty()) {
            return (!range.c(comparable, range.j()) || range.c(range.j(), comparable)) ? (!range.c(range.e(), comparable) || range.c(comparable, range.e())) ? comparable : range.e() : range.j();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    public static IntProgression o(int i, int i2) {
        return IntProgression.INSTANCE.a(i, i2, -1);
    }

    public static int p(IntRange intRange, Random random) {
        Intrinsics.h(intRange, "<this>");
        Intrinsics.h(random, "random");
        try {
            return kotlin.random.Random.f(random, intRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static IntProgression q(IntProgression intProgression) {
        Intrinsics.h(intProgression, "<this>");
        return IntProgression.INSTANCE.a(intProgression.getLast(), intProgression.getFirst(), -intProgression.getStep());
    }

    public static IntProgression r(IntProgression intProgression, int i) {
        Intrinsics.h(intProgression, "<this>");
        d.a(i > 0, Integer.valueOf(i));
        IntProgression.Companion companion = IntProgression.INSTANCE;
        int first = intProgression.getFirst();
        int last = intProgression.getLast();
        if (intProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.a(first, last, i);
    }

    public static IntRange s(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? IntRange.INSTANCE.a() : new IntRange(i, i2 - 1);
    }
}
