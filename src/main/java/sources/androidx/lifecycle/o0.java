package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v0;
import androidx.savedstate.c;
import androidx.savedstate.e;
import kotlin.jvm.internal.Intrinsics;
import p1.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class o0 {
    public static final a.b a = new b();
    public static final a.b b = new c();
    public static final a.b c = new a();

    private static final l0 a(e eVar, y0 y0Var, String str, Bundle bundle) {
        SavedStateHandlesProvider d = d(eVar);
        p0 e = e(y0Var);
        l0 l0Var = (l0) e.b().get(str);
        if (l0Var != null) {
            return l0Var;
        }
        l0 a2 = l0.f.a(d.a(str), bundle);
        e.b().put(str, a2);
        return a2;
    }

    public static final l0 b(a aVar) {
        Intrinsics.h(aVar, "<this>");
        e eVar = (e) aVar.a(a);
        if (eVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        y0 y0Var = (y0) aVar.a(b);
        if (y0Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) aVar.a(c);
        String str = (String) aVar.a(v0.d.c);
        if (str != null) {
            return a(eVar, y0Var, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    public static final void c(e eVar) {
        Intrinsics.h(eVar, "<this>");
        Lifecycle.State b2 = eVar.getLifecycle().b();
        if (b2 != Lifecycle.State.INITIALIZED && b2 != Lifecycle.State.CREATED) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (eVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(eVar.getSavedStateRegistry(), (y0) eVar);
            eVar.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            eVar.getLifecycle().a(new m0(savedStateHandlesProvider));
        }
    }

    public static final SavedStateHandlesProvider d(e eVar) {
        Intrinsics.h(eVar, "<this>");
        c.c c2 = eVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        SavedStateHandlesProvider savedStateHandlesProvider = c2 instanceof SavedStateHandlesProvider ? (SavedStateHandlesProvider) c2 : null;
        if (savedStateHandlesProvider != null) {
            return savedStateHandlesProvider;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final p0 e(y0 y0Var) {
        Intrinsics.h(y0Var, "<this>");
        return new v0(y0Var, new d()).b("androidx.lifecycle.internal.SavedStateHandlesVM", p0.class);
    }
}
