package kotlin.collections;

import java.util.Collections;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class u extends t {
    public static Map b(Map builder) {
        Intrinsics.h(builder, "builder");
        return ((MapBuilder) builder).build();
    }

    public static Map c() {
        return new MapBuilder();
    }

    public static Map d(int i) {
        return new MapBuilder(i);
    }

    public static int e(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map f(Pair pair) {
        Intrinsics.h(pair, "pair");
        Map singletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        Intrinsics.g(singletonMap, "singletonMap(...)");
        return singletonMap;
    }

    public static final Map g(Map map) {
        Intrinsics.h(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map singletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        Intrinsics.g(singletonMap, "with(...)");
        return singletonMap;
    }
}
