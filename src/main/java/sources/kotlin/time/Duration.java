package kotlin.time;

import androidx.collection.s;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Http2Connection;

@SinceKotlin
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b&\b\u0087@\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001QB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u0018\u0010\u0012\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0018\u0010\u0013J\r\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u000fJ\r\u0010\u001a\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u000fJ\r\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u000fJ\r\u0010\u001c\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u000fJ\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J?\u0010-\u001a\u00020,*\u00060&j\u0002`'2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010 \u001a\u00020#2\u0006\u0010+\u001a\u00020\u000bH\u0002¢\u0006\u0004\b-\u0010.J\r\u0010/\u001a\u00020#¢\u0006\u0004\b/\u0010%R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010$R\u0014\u00102\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0005R\u0014\u00105\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0011\u00107\u001a\u00020\u00008F¢\u0006\u0006\u001a\u0004\b6\u0010\u0005R\u001a\u0010<\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\b:\u0010;\u001a\u0004\b8\u00109R\u001a\u0010?\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\b>\u0010;\u001a\u0004\b=\u00109R\u001a\u0010B\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\bA\u0010;\u001a\u0004\b@\u00109R\u001a\u0010E\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\bD\u0010;\u001a\u0004\bC\u00109R\u0011\u0010G\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bF\u0010\u0005R\u0011\u0010I\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bH\u0010\u0005R\u0011\u0010K\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bJ\u0010\u0005R\u0011\u0010M\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bL\u0010\u0005R\u0011\u0010O\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bN\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006R"}, d2 = {"Lkotlin/time/Duration;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "rawValue", "j", "(J)J", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", "()I", HttpUrl.FRAGMENT_ENCODE_SET, "other", HttpUrl.FRAGMENT_ENCODE_SET, "equals", "(Ljava/lang/Object;)Z", "B", "(J)Z", "A", "K", "G", "(JJ)J", "thisMillis", "otherNanos", "e", "(JJJ)J", "F", "D", "E", "C", "z", "i", "(JJ)I", "Lkotlin/time/DurationUnit;", "unit", "I", "(JLkotlin/time/DurationUnit;)J", HttpUrl.FRAGMENT_ENCODE_SET, "J", "(J)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", HttpUrl.FRAGMENT_ENCODE_SET, "f", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "H", "a", "x", "value", "w", "(J)Lkotlin/time/DurationUnit;", "storageUnit", "m", "absoluteValue", "n", "(J)I", "getHoursComponent$annotations", "()V", "hoursComponent", "t", "getMinutesComponent$annotations", "minutesComponent", "v", "getSecondsComponent$annotations", "secondsComponent", "u", "getNanosecondsComponent$annotations", "nanosecondsComponent", "o", "inWholeDays", "p", "inWholeHours", "r", "inWholeMinutes", "s", "inWholeSeconds", "q", "inWholeMilliseconds", "b", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@JvmInline
@WasExperimental
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class Duration implements Comparable<Duration> {

    /* renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long c = j(0);
    private static final long d;
    private static final long e;

    /* renamed from: a, reason: from kotlin metadata */
    private final long rawValue;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lkotlin/time/Duration$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "value", "Lkotlin/time/Duration;", "d", "(Ljava/lang/String;)J", "ZERO", "J", "c", "()J", "INFINITE", "a", "NEG_INFINITE", "b", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return Duration.d;
        }

        public final long b() {
            return Duration.e;
        }

        public final long c() {
            return Duration.c;
        }

        public final long d(String value) {
            long p;
            Intrinsics.h(value, "value");
            try {
                p = DurationKt.p(value, true);
                return p;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }
    }

    static {
        long j;
        long j2;
        j = DurationKt.j(4611686018427387903L);
        d = j;
        j2 = DurationKt.j(-4611686018427387903L);
        e = j2;
    }

    private /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    private static final boolean A(long j) {
        return (((int) j) & 1) == 1;
    }

    private static final boolean B(long j) {
        return (((int) j) & 1) == 0;
    }

    public static final boolean C(long j) {
        return j == d || j == e;
    }

    public static final boolean D(long j) {
        return j < 0;
    }

    public static final boolean E(long j) {
        return j > 0;
    }

    public static final long F(long j, long j2) {
        return G(j, K(j2));
    }

    public static final long G(long j, long j2) {
        long k;
        long m;
        if (C(j)) {
            if (z(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (C(j2)) {
            return j2;
        }
        if ((((int) j) & 1) != (((int) j2) & 1)) {
            return A(j) ? e(j, x(j), x(j2)) : e(j, x(j2), x(j));
        }
        long x = x(j) + x(j2);
        if (B(j)) {
            m = DurationKt.m(x);
            return m;
        }
        k = DurationKt.k(x);
        return k;
    }

    public static final String H(long j) {
        StringBuilder sb = new StringBuilder();
        if (D(j)) {
            sb.append('-');
        }
        sb.append("PT");
        long m = m(j);
        long p = p(m);
        int t = t(m);
        int v = v(m);
        int u = u(m);
        if (C(j)) {
            p = 9999999999999L;
        }
        boolean z = false;
        boolean z2 = p != 0;
        boolean z3 = (v == 0 && u == 0) ? false : true;
        if (t != 0 || (z3 && z2)) {
            z = true;
        }
        if (z2) {
            sb.append(p);
            sb.append('H');
        }
        if (z) {
            sb.append(t);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            f(j, sb, v, u, 9, "S", true);
        }
        return sb.toString();
    }

    public static final long I(long j, DurationUnit unit) {
        Intrinsics.h(unit, "unit");
        if (j == d) {
            return Long.MAX_VALUE;
        }
        if (j == e) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.b(x(j), w(j), unit);
    }

    public static String J(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == d) {
            return "Infinity";
        }
        if (j == e) {
            return "-Infinity";
        }
        boolean D = D(j);
        StringBuilder sb = new StringBuilder();
        if (D) {
            sb.append('-');
        }
        long m = m(j);
        long o = o(m);
        int n = n(m);
        int t = t(m);
        int v = v(m);
        int u = u(m);
        int i = 0;
        boolean z = o != 0;
        boolean z2 = n != 0;
        boolean z3 = t != 0;
        boolean z4 = (v == 0 && u == 0) ? false : true;
        if (z) {
            sb.append(o);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(n);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(t);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (v != 0 || z || z2 || z3) {
                f(j, sb, v, u, 9, "s", false);
            } else if (u >= 1000000) {
                f(j, sb, u / 1000000, u % 1000000, 6, "ms", false);
            } else if (u >= 1000) {
                f(j, sb, u / 1000, u % 1000, 3, "us", false);
            } else {
                sb.append(u);
                sb.append("ns");
            }
            i = i4;
        }
        if (D && i > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }

    public static final long K(long j) {
        long i;
        i = DurationKt.i(-x(j), ((int) j) & 1);
        return i;
    }

    private static final long e(long j, long j2, long j3) {
        long o;
        long j4;
        long n;
        long n2;
        long l;
        o = DurationKt.o(j3);
        long j5 = j2 + o;
        if (-4611686018426L > j5 || j5 >= 4611686018427L) {
            j4 = DurationKt.j(RangesKt.m(j5, -4611686018427387903L, 4611686018427387903L));
            return j4;
        }
        n = DurationKt.n(o);
        long j6 = j3 - n;
        n2 = DurationKt.n(j5);
        l = DurationKt.l(n2 + j6);
        return l;
    }

    private static final void f(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String A0 = StringsKt.A0(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = A0.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (A0.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (z || i6 >= 3) {
                sb.append((CharSequence) A0, 0, ((i4 + 3) / 3) * 3);
                Intrinsics.g(sb, "append(...)");
            } else {
                sb.append((CharSequence) A0, 0, i6);
                Intrinsics.g(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    public static final /* synthetic */ Duration g(long j) {
        return new Duration(j);
    }

    public static int i(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return Intrinsics.k(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return D(j) ? -i : i;
    }

    public static long j(long j) {
        if (DurationJvmKt.a()) {
            if (B(j)) {
                long x = x(j);
                if (-4611686018426999999L > x || x >= 4611686018427000000L) {
                    throw new AssertionError(x(j) + " ns is out of nanoseconds range");
                }
            } else {
                long x2 = x(j);
                if (-4611686018427387903L > x2 || x2 >= 4611686018427387904L) {
                    throw new AssertionError(x(j) + " ms is out of milliseconds range");
                }
                long x3 = x(j);
                if (-4611686018426L <= x3 && x3 < 4611686018427L) {
                    throw new AssertionError(x(j) + " ms is denormalized");
                }
            }
        }
        return j;
    }

    public static boolean k(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).getRawValue();
    }

    public static final boolean l(long j, long j2) {
        return j == j2;
    }

    public static final long m(long j) {
        return D(j) ? K(j) : j;
    }

    public static final int n(long j) {
        if (C(j)) {
            return 0;
        }
        return (int) (p(j) % 24);
    }

    public static final long o(long j) {
        return I(j, DurationUnit.DAYS);
    }

    public static final long p(long j) {
        return I(j, DurationUnit.HOURS);
    }

    public static final long q(long j) {
        return (A(j) && z(j)) ? x(j) : I(j, DurationUnit.MILLISECONDS);
    }

    public static final long r(long j) {
        return I(j, DurationUnit.MINUTES);
    }

    public static final long s(long j) {
        return I(j, DurationUnit.SECONDS);
    }

    public static final int t(long j) {
        if (C(j)) {
            return 0;
        }
        return (int) (r(j) % 60);
    }

    public static final int u(long j) {
        if (C(j)) {
            return 0;
        }
        return (int) (A(j) ? DurationKt.n(x(j) % 1000) : x(j) % Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
    }

    public static final int v(long j) {
        if (C(j)) {
            return 0;
        }
        return (int) (s(j) % 60);
    }

    private static final DurationUnit w(long j) {
        return B(j) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    private static final long x(long j) {
        return j >> 1;
    }

    public static int y(long j) {
        return s.a(j);
    }

    public static final boolean z(long j) {
        return !C(j);
    }

    /* renamed from: L, reason: from getter */
    public final /* synthetic */ long getRawValue() {
        return this.rawValue;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return h(duration.getRawValue());
    }

    public boolean equals(Object other) {
        return k(this.rawValue, other);
    }

    public int h(long j) {
        return i(this.rawValue, j);
    }

    public int hashCode() {
        return y(this.rawValue);
    }

    public String toString() {
        return J(this.rawValue);
    }
}
