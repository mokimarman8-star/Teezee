package kotlinx.serialization;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.PublishedApi;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0011\b\u0000\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/serialization/UnknownFieldException;", "Lkotlinx/serialization/SerializationException;", "index", HttpUrl.FRAGMENT_ENCODE_SET, "(I)V", "message", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@PublishedApi
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class UnknownFieldException extends SerializationException {
    public UnknownFieldException(int i) {
        this("An unknown field for index " + i);
    }

    public UnknownFieldException(String str) {
        super(str);
    }
}
