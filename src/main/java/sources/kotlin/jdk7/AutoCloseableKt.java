package kotlin.jdk7;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0005\u001a\u00020\u0004*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006*\u001a\b\u0007\u0010\n\"\u00020\u00002\u00020\u0000B\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¨\u0006\u000b"}, d2 = {"Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", HttpUrl.FRAGMENT_ENCODE_SET, "cause", HttpUrl.FRAGMENT_ENCODE_SET, "a", "(Ljava/lang/AutoCloseable;Ljava/lang/Throwable;)V", "Lkotlin/SinceKotlin;", "version", "2.0", "AutoCloseable", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@JvmName
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class AutoCloseableKt {
    public static final void a(AutoCloseable autoCloseable, Throwable th) {
        if (autoCloseable != null) {
            if (th == null) {
                autoCloseable.close();
                return;
            }
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                ExceptionsKt.a(th, th2);
            }
        }
    }
}
