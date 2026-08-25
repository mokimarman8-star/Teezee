package kotlin.io;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ljava/io/Closeable;", HttpUrl.FRAGMENT_ENCODE_SET, "cause", HttpUrl.FRAGMENT_ENCODE_SET, "a", "(Ljava/io/Closeable;Ljava/lang/Throwable;)V", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@JvmName
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class CloseableKt {
    public static final void a(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                kotlin.ExceptionsKt.a(th, th2);
            }
        }
    }
}
