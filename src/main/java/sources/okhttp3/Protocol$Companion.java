package okhttp3;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lokhttp3/Protocol$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "get", "Lokhttp3/Protocol;", "protocol", HttpUrl.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class Protocol$Companion {
    private Protocol$Companion() {
    }

    public /* synthetic */ Protocol$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public final Protocol get(String protocol) throws IOException {
        Intrinsics.h(protocol, "protocol");
        Protocol protocol2 = Protocol.HTTP_1_0;
        if (!Intrinsics.c(protocol, Protocol.access$getProtocol$p(protocol2))) {
            protocol2 = Protocol.HTTP_1_1;
            if (!Intrinsics.c(protocol, Protocol.access$getProtocol$p(protocol2))) {
                protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
                if (!Intrinsics.c(protocol, Protocol.access$getProtocol$p(protocol2))) {
                    protocol2 = Protocol.HTTP_2;
                    if (!Intrinsics.c(protocol, Protocol.access$getProtocol$p(protocol2))) {
                        protocol2 = Protocol.SPDY_3;
                        if (!Intrinsics.c(protocol, Protocol.access$getProtocol$p(protocol2))) {
                            protocol2 = Protocol.QUIC;
                            if (!Intrinsics.c(protocol, Protocol.access$getProtocol$p(protocol2))) {
                                throw new IOException("Unexpected protocol: " + protocol);
                            }
                        }
                    }
                }
            }
        }
        return protocol2;
    }
}
