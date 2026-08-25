package okhttp3.internal.connection;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Route;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u000bH\u0086\u0002J\t\u0010\f\u001a\u00020\u0004H\u0086\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lokhttp3/internal/connection/RouteSelector$Selection;", HttpUrl.FRAGMENT_ENCODE_SET, "routes", HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/Route;", "(Ljava/util/List;)V", "nextRouteIndex", HttpUrl.FRAGMENT_ENCODE_SET, "getRoutes", "()Ljava/util/List;", "hasNext", HttpUrl.FRAGMENT_ENCODE_SET, "next", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class RouteSelector$Selection {
    private int nextRouteIndex;
    private final List<Route> routes;

    public RouteSelector$Selection(List<Route> routes) {
        Intrinsics.h(routes, "routes");
        this.routes = routes;
    }

    public final List<Route> getRoutes() {
        return this.routes;
    }

    public final boolean hasNext() {
        return this.nextRouteIndex < this.routes.size();
    }

    public final Route next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        List<Route> list = this.routes;
        int i = this.nextRouteIndex;
        this.nextRouteIndex = i + 1;
        return list.get(i);
    }
}
