package kotlin.time;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {HttpUrl.FRAGMENT_ENCODE_SET, "value", "Lkotlin/time/Duration;", "a", "(J)J", "origin1", "origin2", "Lkotlin/time/DurationUnit;", "unit", "c", "(JJLkotlin/time/DurationUnit;)J", "value1", "value2", "b", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class LongSaturatedMathKt {
    private static final long a(long j) {
        return j < 0 ? Duration.INSTANCE.b() : Duration.INSTANCE.a();
    }

    private static final long b(long j, long j2, DurationUnit durationUnit) {
        long j3 = j - j2;
        if (((j3 ^ j) & (~(j3 ^ j2))) >= 0) {
            return DurationKt.t(j3, durationUnit);
        }
        DurationUnit durationUnit2 = DurationUnit.MILLISECONDS;
        if (durationUnit.compareTo(durationUnit2) >= 0) {
            return Duration.K(a(j3));
        }
        long b = DurationUnitKt__DurationUnitJvmKt.b(1L, durationUnit2, durationUnit);
        long j4 = (j / b) - (j2 / b);
        long j5 = (j % b) - (j2 % b);
        Duration.Companion companion = Duration.INSTANCE;
        return Duration.G(DurationKt.t(j4, durationUnit2), DurationKt.t(j5, durationUnit));
    }

    public static final long c(long j, long j2, DurationUnit unit) {
        Intrinsics.h(unit, "unit");
        return ((j2 - 1) | 1) == Long.MAX_VALUE ? j == j2 ? Duration.INSTANCE.c() : Duration.K(a(j2)) : (1 | (j - 1)) == Long.MAX_VALUE ? a(j) : b(j, j2, unit);
    }
}
