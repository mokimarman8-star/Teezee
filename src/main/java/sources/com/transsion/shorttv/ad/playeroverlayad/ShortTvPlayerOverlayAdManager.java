package com.transsion.shorttv.ad.playeroverlayad;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.transsion.shorttv.ad.AdLoadState;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.t1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvPlayerOverlayAdManager {
    private static WeakReference b;
    private static t1 d;
    private static int e;
    private static boolean g;
    public static final ShortTvPlayerOverlayAdManager a = new ShortTvPlayerOverlayAdManager();
    private static ConcurrentHashMap c = new ConcurrentHashMap();
    private static int f = 3;

    private ShortTvPlayerOverlayAdManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        j();
    }

    private final boolean g() {
        if (e < 0 || f < 0) {
            return false;
        }
        int size = c.size() + 1;
        if (g) {
            int i = f;
            return i == 0 || (size - e) % (i + 1) == 0;
        }
        int i2 = e;
        if (i2 == 0) {
            g = true;
            return f == 0;
        }
        if (i2 != size) {
            return false;
        }
        g = true;
        return true;
    }

    private final void h() {
        WeakReference weakReference;
        LifecycleCoroutineScope lifecycleCoroutineScope;
        t1 t1Var = d;
        if ((t1Var != null && t1Var.isActive()) || (weakReference = b) == null || (lifecycleCoroutineScope = (LifecycleCoroutineScope) weakReference.get()) == null) {
            return;
        }
        d = i.d(lifecycleCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ShortTvPlayerOverlayAdManager$startAutoDestroyTimer$1(null), 3, (Object) null);
    }

    private final void i() {
        t1 t1Var = d;
        if (t1Var != null) {
            t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
        }
        d = null;
    }

    private final void j() {
        e b2;
        Collection values = c.values();
        Intrinsics.g(values, "<get-values>(...)");
        for (a aVar : CollectionsKt.R0(values)) {
            if (aVar.c() == AdLoadState.SUCCEED && !aVar.e() && (b2 = aVar.b()) != null) {
                Long valueOf = Long.valueOf(b2.h());
                if (valueOf.longValue() <= 0) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    if (System.currentTimeMillis() - valueOf.longValue() >= 10000) {
                        aVar.a();
                    }
                }
            }
        }
    }

    public final void b() {
        yq.a.g(yq.a.a, "overlay", "overlay ad manager clear", null, 4, null);
        Collection values = c.values();
        Intrinsics.g(values, "<get-values>(...)");
        for (a aVar : CollectionsKt.R0(values)) {
            e b2 = aVar.b();
            if (b2 != null) {
                b2.f();
            }
            aVar.f(null);
        }
        c.clear();
        WeakReference weakReference = b;
        if (weakReference != null) {
            weakReference.clear();
        }
        b = null;
        i();
        g = false;
    }

    public final a c(String str) {
        LifecycleCoroutineScope lifecycleCoroutineScope;
        Intrinsics.h(str, "key");
        WeakReference weakReference = b;
        if (weakReference == null || (lifecycleCoroutineScope = (LifecycleCoroutineScope) weakReference.get()) == null) {
            return null;
        }
        yq.a.g(yq.a.a, "overlay", "getAdData, key=" + str + ", currentVideoCount=" + c.size(), null, 4, null);
        a aVar = (a) c.get(str);
        if (aVar == null) {
            aVar = new a();
            aVar.h(false);
            if (a.g()) {
                aVar.f(new e("ShortTvPlayerOverlayScene", lifecycleCoroutineScope));
                aVar.h(true);
            }
            c.put(str, aVar);
        }
        return aVar;
    }

    public final void d(LifecycleCoroutineScope lifecycleCoroutineScope) {
        Intrinsics.h(lifecycleCoroutineScope, "scope");
        b = new WeakReference(lifecycleCoroutineScope);
        h();
        com.transsion.ad.scene.a aVar = com.transsion.ad.scene.a.a;
        e = aVar.n("ShortTvPlayerOverlayScene", 0);
        f = aVar.p("ShortTvPlayerOverlayScene", 3);
    }

    public final void e(String str) {
        e b2;
        Intrinsics.h(str, "key");
        a aVar = (a) c.get(str);
        if (aVar != null && (b2 = aVar.b()) != null) {
            b2.j();
        }
        a aVar2 = (a) c.get(str);
        if (aVar2 != null) {
            aVar2.i(false);
        }
    }
}
