package androidx.view;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class x0 {

    /* renamed from: a, reason: collision with root package name */
    private final Map f8370a = new LinkedHashMap();

    public final void a() {
        Iterator it = this.f8370a.values().iterator();
        while (it.hasNext()) {
            ((t0) it.next()).clear$lifecycle_viewmodel_release();
        }
        this.f8370a.clear();
    }

    public final t0 b(String str) {
        Intrinsics.h(str, "key");
        return (t0) this.f8370a.get(str);
    }

    public final Set c() {
        return new HashSet(this.f8370a.keySet());
    }

    public final void d(String str, t0 t0Var) {
        Intrinsics.h(str, "key");
        Intrinsics.h(t0Var, "viewModel");
        t0 t0Var2 = (t0) this.f8370a.put(str, t0Var);
        if (t0Var2 != null) {
            t0Var2.clear$lifecycle_viewmodel_release();
        }
    }
}
