package okhttp3.internal.connection;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lokhttp3/internal/connection/RouteSelector$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "socketHost", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/net/InetSocketAddress;", "getSocketHost", "(Ljava/net/InetSocketAddress;)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class RouteSelector$Companion {
    private RouteSelector$Companion() {
    }

    public /* synthetic */ RouteSelector$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final String getSocketHost(InetSocketAddress inetSocketAddress) {
        Intrinsics.h(inetSocketAddress, "<this>");
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            String hostName = inetSocketAddress.getHostName();
            Intrinsics.g(hostName, "hostName");
            return hostName;
        }
        String hostAddress = address.getHostAddress();
        Intrinsics.g(hostAddress, "address.hostAddress");
        return hostAddress;
    }
}
