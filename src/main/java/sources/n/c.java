package n;

import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap f16552a;

    public c() {
        this(0, 0.0f, 3, null);
    }

    public c(int i5, float f5) {
        this.f16552a = new LinkedHashMap(i5, f5, true);
    }

    public /* synthetic */ c(int i5, float f5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 16 : i5, (i6 & 2) != 0 ? 0.75f : f5);
    }

    public final Object a(Object obj) {
        Intrinsics.h(obj, "key");
        return this.f16552a.get(obj);
    }

    public final Set b() {
        Set entrySet = this.f16552a.entrySet();
        Intrinsics.g(entrySet, "map.entries");
        return entrySet;
    }

    public final boolean c() {
        return this.f16552a.isEmpty();
    }

    public final Object d(Object obj, Object obj2) {
        Intrinsics.h(obj, "key");
        Intrinsics.h(obj2, "value");
        return this.f16552a.put(obj, obj2);
    }

    public final Object e(Object obj) {
        Intrinsics.h(obj, "key");
        return this.f16552a.remove(obj);
    }
}
