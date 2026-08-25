package kotlinx.serialization.json;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class s {
    private final Map a = new LinkedHashMap();

    @PublishedApi
    public s() {
    }

    public final JsonObject a() {
        return new JsonObject(this.a);
    }

    public final h b(String key, h element) {
        Intrinsics.h(key, "key");
        Intrinsics.h(element, "element");
        return (h) this.a.put(key, element);
    }
}
