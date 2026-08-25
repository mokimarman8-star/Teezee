package androidx.navigation;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class q {

    /* renamed from: b, reason: collision with root package name */
    public static final a f12564b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Map f12565c = new LinkedHashMap();

    /* renamed from: a, reason: collision with root package name */
    private final Map f12566a = new LinkedHashMap();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(Class cls) {
            Intrinsics.h(cls, "navigatorClass");
            String str = (String) q.f12565c.get(cls);
            if (str == null) {
                Navigator$b navigator$b = (Navigator$b) cls.getAnnotation(Navigator$b.class);
                str = navigator$b == null ? null : navigator$b.value();
                if (!b(str)) {
                    throw new IllegalArgumentException(Intrinsics.q("No @Navigator.Name annotation found for ", cls.getSimpleName()).toString());
                }
                q.f12565c.put(cls, str);
            }
            Intrinsics.e(str);
            return str;
        }

        public final boolean b(String str) {
            return str != null && str.length() > 0;
        }
    }

    public final Navigator b(Navigator navigator) {
        Intrinsics.h(navigator, "navigator");
        return c(f12564b.a(navigator.getClass()), navigator);
    }

    public Navigator c(String str, Navigator navigator) {
        Intrinsics.h(str, "name");
        Intrinsics.h(navigator, "navigator");
        if (!f12564b.b(str)) {
            throw new IllegalArgumentException("navigator name cannot be an empty string");
        }
        Navigator navigator2 = (Navigator) this.f12566a.get(str);
        if (Intrinsics.c(navigator2, navigator)) {
            return navigator;
        }
        boolean z5 = false;
        if (navigator2 != null && navigator2.c()) {
            z5 = true;
        }
        if (z5) {
            throw new IllegalStateException(("Navigator " + navigator + " is replacing an already attached " + navigator2).toString());
        }
        if (!navigator.c()) {
            return (Navigator) this.f12566a.put(str, navigator);
        }
        throw new IllegalStateException(("Navigator " + navigator + " is already attached to another NavController").toString());
    }

    public Navigator d(String str) {
        Intrinsics.h(str, "name");
        if (!f12564b.b(str)) {
            throw new IllegalArgumentException("navigator name cannot be an empty string");
        }
        Navigator navigator = (Navigator) this.f12566a.get(str);
        if (navigator != null) {
            return navigator;
        }
        throw new IllegalStateException("Could not find Navigator with name \"" + str + "\". You must call NavController.addNavigator() for each navigation type.");
    }

    public final Map e() {
        return MapsKt.u(this.f12566a);
    }
}
