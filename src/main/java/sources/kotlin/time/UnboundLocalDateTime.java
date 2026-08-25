package kotlin.time;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class UnboundLocalDateTime {
    public static final Companion h = new Companion(null);
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/time/UnboundLocalDateTime$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "<init>", "()V", "Lkotlin/time/Instant;", "instant", "Lkotlin/time/UnboundLocalDateTime;", "a", "(Lkotlin/time/Instant;)Lkotlin/time/UnboundLocalDateTime;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UnboundLocalDateTime a(Instant instant) {
            long j;
            Intrinsics.h(instant, "instant");
            long epochSeconds = instant.getEpochSeconds();
            long j2 = epochSeconds / 86400;
            if ((epochSeconds ^ 86400) < 0 && j2 * 86400 != epochSeconds) {
                j2--;
            }
            long j3 = epochSeconds % 86400;
            int i = (int) (j3 + (86400 & (((j3 ^ 86400) & ((-j3) | j3)) >> 63)));
            long j4 = (j2 + 719528) - 60;
            if (j4 < 0) {
                long j5 = 146097;
                long j6 = ((j4 + 1) / j5) - 1;
                j = Sdk$SDKError.Reason.CONCURRENT_PLAYBACK_UNSUPPORTED_VALUE * j6;
                j4 += (-j6) * j5;
            } else {
                j = 0;
            }
            long j7 = Sdk$SDKError.Reason.CONCURRENT_PLAYBACK_UNSUPPORTED_VALUE;
            long j8 = ((j7 * j4) + 591) / 146097;
            long j9 = 365;
            long j10 = 4;
            long j11 = 100;
            long j12 = j4 - ((((j9 * j8) + (j8 / j10)) - (j8 / j11)) + (j8 / j7));
            if (j12 < 0) {
                j8--;
                j12 = j4 - ((((j9 * j8) + (j8 / j10)) - (j8 / j11)) + (j8 / j7));
            }
            int i2 = (int) j12;
            int i3 = ((i2 * 5) + 2) / 153;
            int i4 = (i2 - (((i3 * 306) + 5) / 10)) + 1;
            int i5 = i / 3600;
            int i6 = i - (i5 * 3600);
            int i7 = i6 / 60;
            return new UnboundLocalDateTime((int) (j8 + j + (i3 / 10)), ((i3 + 2) % 12) + 1, i4, i5, i7, i6 - (i7 * 60), instant.getNanosecondsOfSecond());
        }
    }

    public UnboundLocalDateTime(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
    }

    public final int a() {
        return this.c;
    }

    public final int b() {
        return this.d;
    }

    public final int c() {
        return this.e;
    }

    public final int d() {
        return this.b;
    }

    public final int e() {
        return this.g;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.a;
    }

    public String toString() {
        return "UnboundLocalDateTime(" + this.a + '-' + this.b + '-' + this.c + ' ' + this.d + ':' + this.e + ':' + this.f + '.' + this.g + ')';
    }
}
