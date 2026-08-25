package okhttp3.internal.http2;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/http2/ErrorCode$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "fromHttp2", "Lokhttp3/internal/http2/ErrorCode;", "code", HttpUrl.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ErrorCode$Companion {
    private ErrorCode$Companion() {
    }

    public /* synthetic */ ErrorCode$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final ErrorCode fromHttp2(int code) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.getHttpCode() == code) {
                return errorCode;
            }
        }
        return null;
    }
}
