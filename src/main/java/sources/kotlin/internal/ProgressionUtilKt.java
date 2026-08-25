package kotlin.internal;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\t\u001a'\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0002\u0010\n\u001a'\u0010\b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {HttpUrl.FRAGMENT_ENCODE_SET, "a", "b", "e", "(II)I", HttpUrl.FRAGMENT_ENCODE_SET, "f", "(JJ)J", "c", "(III)I", "(JJJ)J", "start", "end", "step", "d", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ProgressionUtilKt {
    private static final int a(int i, int i2, int i3) {
        return e(e(i, i3) - e(i2, i3), i3);
    }

    private static final long b(long j, long j2, long j3) {
        return f(f(j, j3) - f(j2, j3), j3);
    }

    public static final int c(int i, int i2, int i3) {
        if (i3 > 0) {
            return i >= i2 ? i2 : i2 - a(i2, i, i3);
        }
        if (i3 < 0) {
            return i <= i2 ? i2 : i2 + a(i, i2, -i3);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final long d(long j, long j2, long j3) {
        if (j3 > 0) {
            return j >= j2 ? j2 : j2 - b(j2, j, j3);
        }
        if (j3 < 0) {
            return j <= j2 ? j2 : j2 + b(j, j2, -j3);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    private static final int e(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    private static final long f(long j, long j2) {
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }
}
