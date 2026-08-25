package androidx.fragment.app.strictmode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class FragmentStrictMode$b {

    /* renamed from: c, reason: collision with root package name */
    public static final a f8211c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final FragmentStrictMode$b f8212d = new FragmentStrictMode$b(SetsKt.f(), null, MapsKt.h());

    /* renamed from: a, reason: collision with root package name */
    private final Set f8213a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f8214b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FragmentStrictMode$b(Set set, FragmentStrictMode$a fragmentStrictMode$a, Map map) {
        Intrinsics.h(set, "flags");
        Intrinsics.h(map, "allowedViolations");
        this.f8213a = set;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put((String) entry.getKey(), (Set) entry.getValue());
        }
        this.f8214b = linkedHashMap;
    }

    public final Set a() {
        return this.f8213a;
    }

    public final FragmentStrictMode$a b() {
        return null;
    }

    public final Map c() {
        return this.f8214b;
    }
}
