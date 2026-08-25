package kotlin.coroutines.jvm.internal;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000>\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\tH\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0001\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {HttpUrl.FRAGMENT_ENCODE_SET, "primitive", "Ljava/lang/Boolean;", "a", "(Z)Ljava/lang/Boolean;", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/Integer;", "d", "(I)Ljava/lang/Integer;", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/Long;", "e", "(J)Ljava/lang/Long;", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/Float;", "c", "(F)Ljava/lang/Float;", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/Double;", "b", "(D)Ljava/lang/Double;", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@JvmName
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class Boxing {
    public static final Boolean a(boolean z) {
        return Boolean.valueOf(z);
    }

    public static final Double b(double d) {
        return new Double(d);
    }

    public static final Float c(float f) {
        return new Float(f);
    }

    public static final Integer d(int i) {
        return new Integer(i);
    }

    public static final Long e(long j) {
        return new Long(j);
    }
}
