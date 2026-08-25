package androidx.compose.runtime;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class x1 {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f3062a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f3063b = new Object();

    public static final Object a(Map map, Object obj) {
        List list = (List) map.get(obj);
        if (list == null) {
            return null;
        }
        Object J = CollectionsKt.J(list);
        if (!list.isEmpty()) {
            return J;
        }
        map.remove(obj);
        return J;
    }
}
