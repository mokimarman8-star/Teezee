package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.c;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class SavedStateHandlesProvider implements c.c {
    private final c a;
    private boolean b;
    private Bundle c;
    private final Lazy d;

    public SavedStateHandlesProvider(c cVar, final y0 y0Var) {
        Intrinsics.h(cVar, "savedStateRegistry");
        Intrinsics.h(y0Var, "viewModelStoreOwner");
        this.a = cVar;
        this.d = LazyKt.b(new Function0<p0>() { // from class: androidx.lifecycle.SavedStateHandlesProvider$viewModel$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final androidx.lifecycle.p0 m0invoke() {
                return o0.e(y0Var);
            }
        });
    }

    private final p0 b() {
        return (p0) this.d.getValue();
    }

    public final Bundle a(String str) {
        Intrinsics.h(str, "key");
        c();
        Bundle bundle = this.c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.c = null;
        }
        return bundle2;
    }

    public final void c() {
        if (this.b) {
            return;
        }
        Bundle b = this.a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (b != null) {
            bundle.putAll(b);
        }
        this.c = bundle;
        this.b = true;
        b();
    }

    public Bundle saveState() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : b().b().entrySet()) {
            String str = (String) entry.getKey();
            Bundle saveState = ((l0) entry.getValue()).c().saveState();
            if (!Intrinsics.c(saveState, Bundle.EMPTY)) {
                bundle.putBundle(str, saveState);
            }
        }
        this.b = false;
        return bundle;
    }
}
