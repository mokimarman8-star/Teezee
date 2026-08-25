package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.internal.u;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class JsonNamesMapKt {
    private static final u.a a = new u.a();

    public static final Map a(kotlinx.serialization.descriptors.f fVar) {
        String[] names;
        Intrinsics.h(fVar, "<this>");
        int e = fVar.e();
        Map map = null;
        for (int i = 0; i < e; i++) {
            List g = fVar.g(i);
            ArrayList arrayList = new ArrayList();
            for (Object obj : g) {
                if (obj instanceof kotlinx.serialization.json.q) {
                    arrayList.add(obj);
                }
            }
            kotlinx.serialization.json.q qVar = (kotlinx.serialization.json.q) CollectionsKt.G0(arrayList);
            if (qVar != null && (names = qVar.names()) != null) {
                for (String str : names) {
                    if (map == null) {
                        map = t.a(fVar.e());
                    }
                    Intrinsics.e(map);
                    b(map, fVar, str, i);
                }
            }
        }
        return map == null ? MapsKt.h() : map;
    }

    private static final void b(Map map, kotlinx.serialization.descriptors.f fVar, String str, int i) {
        if (!map.containsKey(str)) {
            map.put(str, Integer.valueOf(i));
            return;
        }
        throw new JsonException("The suggested name '" + str + "' for property " + fVar.f(i) + " is already one of the names for property " + fVar.f(((Number) MapsKt.i(map, str)).intValue()) + " in " + fVar);
    }

    public static final u.a c() {
        return a;
    }

    public static final int d(kotlinx.serialization.descriptors.f fVar, kotlinx.serialization.json.a json, String name) {
        Intrinsics.h(fVar, "<this>");
        Intrinsics.h(json, "json");
        Intrinsics.h(name, "name");
        int c = fVar.c(name);
        if (c != -3 || !json.e().j()) {
            return c;
        }
        Integer num = (Integer) ((Map) kotlinx.serialization.json.w.a(json).b(fVar, a, new JsonNamesMapKt$getJsonNameIndex$alternativeNamesMap$1(fVar))).get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final int e(kotlinx.serialization.descriptors.f fVar, kotlinx.serialization.json.a json, String name, String suffix) {
        Intrinsics.h(fVar, "<this>");
        Intrinsics.h(json, "json");
        Intrinsics.h(name, "name");
        Intrinsics.h(suffix, "suffix");
        int d = d(fVar, json, name);
        if (d != -3) {
            return d;
        }
        throw new SerializationException(fVar.i() + " does not contain element with name '" + name + '\'' + suffix);
    }

    public static /* synthetic */ int f(kotlinx.serialization.descriptors.f fVar, kotlinx.serialization.json.a aVar, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return e(fVar, aVar, str, str2);
    }
}
