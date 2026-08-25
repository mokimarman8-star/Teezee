package kotlin;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {HttpUrl.FRAGMENT_ENCODE_SET, "v1", "v2", "a", "(II)I", HttpUrl.FRAGMENT_ENCODE_SET, "b", "(JJ)I", "value", HttpUrl.FRAGMENT_ENCODE_SET, "c", "(J)D", "base", HttpUrl.FRAGMENT_ENCODE_SET, "d", "(JI)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@JvmName
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class UnsignedKt {
    public static final int a(int i, int i2) {
        return Intrinsics.j(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    public static final int b(long j, long j2) {
        return Intrinsics.k(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    public static final double c(long j) {
        return ((j >>> 11) * 2048) + (j & 2047);
    }

    public static final String d(long j, int i) {
        if (j >= 0) {
            String l = Long.toString(j, CharsKt.a(i));
            Intrinsics.g(l, "toString(...)");
            return l;
        }
        long j2 = i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        String l2 = Long.toString(j3, CharsKt.a(i));
        Intrinsics.g(l2, "toString(...)");
        sb.append(l2);
        String l3 = Long.toString(j4, CharsKt.a(i));
        Intrinsics.g(l3, "toString(...)");
        sb.append(l3);
        return sb.toString();
    }
}
