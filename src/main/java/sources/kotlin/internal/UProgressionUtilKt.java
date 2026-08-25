package kotlin.internal;

import androidx.collection.b0;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import ky.b;
import okhttp3.HttpUrl;
import x6.f;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a'\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0004\u001a'\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0002\u0010\u0006\u001a'\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u000b\u0010\u0004\u001a'\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0003\u0010\u0006¨\u0006\r"}, d2 = {"Lkotlin/UInt;", "a", "b", "c", "(III)I", "Lkotlin/ULong;", "(JJJ)J", "start", "end", HttpUrl.FRAGMENT_ENCODE_SET, "step", "d", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class UProgressionUtilKt {
    private static final int a(int i, int i2, int i3) {
        int compare;
        int a = b.a(i, i3);
        int a2 = b.a(i2, i3);
        compare = Integer.compare(a ^ Integer.MIN_VALUE, a2 ^ Integer.MIN_VALUE);
        int b = UInt.b(a - a2);
        return compare >= 0 ? b : UInt.b(b + i3);
    }

    private static final long b(long j, long j2, long j3) {
        long a = f.a(j, j3);
        long a2 = f.a(j2, j3);
        int a3 = b0.a(a, a2);
        long b = ULong.b(a - a2);
        return a3 >= 0 ? b : ULong.b(b + j3);
    }

    public static final long c(long j, long j2, long j3) {
        if (j3 > 0) {
            return b0.a(j, j2) >= 0 ? j2 : ULong.b(j2 - b(j2, j, ULong.b(j3)));
        }
        if (j3 < 0) {
            return b0.a(j, j2) <= 0 ? j2 : ULong.b(j2 + b(j, j2, ULong.b(-j3)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final int d(int i, int i2, int i3) {
        int compare;
        int compare2;
        if (i3 > 0) {
            compare2 = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
            return compare2 >= 0 ? i2 : UInt.b(i2 - a(i2, i, UInt.b(i3)));
        }
        if (i3 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        }
        compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
        return compare <= 0 ? i2 : UInt.b(i2 + a(i, i2, UInt.b(-i3)));
    }
}
