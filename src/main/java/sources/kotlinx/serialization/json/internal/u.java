package kotlinx.serialization.json.internal;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class u {
    private final Map a = t.a(1);

    public static final class a {
    }

    public final Object a(kotlinx.serialization.descriptors.f descriptor, a key) {
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(key, "key");
        Map map = (Map) this.a.get(descriptor);
        Object obj = map != null ? map.get(key) : null;
        if (obj == null) {
            return null;
        }
        return obj;
    }

    public final Object b(kotlinx.serialization.descriptors.f descriptor, a key, Function0 defaultValue) {
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(key, "key");
        Intrinsics.h(defaultValue, "defaultValue");
        Object a2 = a(descriptor, key);
        if (a2 != null) {
            return a2;
        }
        Object invoke = defaultValue.invoke();
        c(descriptor, key, invoke);
        return invoke;
    }

    public final void c(kotlinx.serialization.descriptors.f descriptor, a key, Object value) {
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(key, "key");
        Intrinsics.h(value, "value");
        Map map = this.a;
        Object obj = map.get(descriptor);
        if (obj == null) {
            obj = t.a(1);
            map.put(descriptor, obj);
        }
        ((Map) obj).put(key, value);
    }
}
