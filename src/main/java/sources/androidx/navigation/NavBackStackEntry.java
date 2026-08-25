package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.l;
import androidx.lifecycle.l0;
import androidx.lifecycle.m;
import androidx.lifecycle.q0;
import androidx.lifecycle.u;
import androidx.lifecycle.v0;
import androidx.lifecycle.w;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.navigation.NavBackStackEntry;
import androidx.savedstate.c;
import androidx.savedstate.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p1.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class NavBackStackEntry implements u, y0, m, androidx.savedstate.e {
    public static final a n = new a((DefaultConstructorMarker) null);
    private final Context a;
    private NavDestination b;
    private final Bundle c;
    private Lifecycle.State d;
    private final p e;
    private final String f;
    private final Bundle g;
    private w h;
    private final d i;
    private boolean j;
    private final Lazy k;
    private final Lazy l;
    private Lifecycle.State m;

    private NavBackStackEntry(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, p pVar, String str, Bundle bundle2) {
        this.a = context;
        this.b = navDestination;
        this.c = bundle;
        this.d = state;
        this.e = pVar;
        this.f = str;
        this.g = bundle2;
        this.h = new w(this);
        d a = d.a(this);
        Intrinsics.g(a, "create(this)");
        this.i = a;
        this.k = LazyKt.b(new Function0<q0>() { // from class: androidx.navigation.NavBackStackEntry$defaultFactory$2
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final androidx.lifecycle.q0 m2invoke() {
                Context context2;
                context2 = NavBackStackEntry.this.a;
                Context applicationContext = context2 == null ? null : context2.getApplicationContext();
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                NavBackStackEntry navBackStackEntry = NavBackStackEntry.this;
                return new androidx.lifecycle.q0(application, navBackStackEntry, navBackStackEntry.d());
            }
        });
        this.l = LazyKt.b(new Function0<l0>() { // from class: androidx.navigation.NavBackStackEntry$savedStateHandle$2
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final androidx.lifecycle.l0 m3invoke() {
                boolean z;
                w wVar;
                z = NavBackStackEntry.this.j;
                if (!z) {
                    throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).");
                }
                wVar = NavBackStackEntry.this.h;
                if (wVar.b() == Lifecycle.State.DESTROYED) {
                    throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle after the NavBackStackEntry is destroyed.");
                }
                NavBackStackEntry navBackStackEntry = NavBackStackEntry.this;
                return new v0(navBackStackEntry, new NavBackStackEntry.b(navBackStackEntry, (Bundle) null)).a(NavBackStackEntry.c.class).b();
            }
        });
        this.m = Lifecycle.State.INITIALIZED;
    }

    public /* synthetic */ NavBackStackEntry(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, p pVar, String str, Bundle bundle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, navDestination, bundle, state, pVar, str, bundle2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavBackStackEntry(NavBackStackEntry navBackStackEntry, Bundle bundle) {
        this(navBackStackEntry.a, navBackStackEntry.b, bundle, navBackStackEntry.d, navBackStackEntry.e, navBackStackEntry.f, navBackStackEntry.g);
        Intrinsics.h(navBackStackEntry, "entry");
        this.d = navBackStackEntry.d;
        l(navBackStackEntry.m);
    }

    private final q0 e() {
        return (q0) this.k.getValue();
    }

    public final Bundle d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        Set<String> keySet;
        if (obj == null || !(obj instanceof NavBackStackEntry)) {
            return false;
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (!Intrinsics.c(this.f, navBackStackEntry.f) || !Intrinsics.c(this.b, navBackStackEntry.b) || !Intrinsics.c(this.h, navBackStackEntry.h) || !Intrinsics.c(getSavedStateRegistry(), navBackStackEntry.getSavedStateRegistry())) {
            return false;
        }
        if (!Intrinsics.c(this.c, navBackStackEntry.c)) {
            Bundle bundle = this.c;
            if (bundle == null || (keySet = bundle.keySet()) == null) {
                return false;
            }
            Set<String> set = keySet;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                for (String str : set) {
                    Object obj2 = d().get(str);
                    Bundle d = navBackStackEntry.d();
                    if (!Intrinsics.c(obj2, d == null ? null : d.get(str))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final NavDestination f() {
        return this.b;
    }

    public final String g() {
        return this.f;
    }

    public /* synthetic */ a getDefaultViewModelCreationExtras() {
        return l.a(this);
    }

    public v0.c getDefaultViewModelProviderFactory() {
        return e();
    }

    public Lifecycle getLifecycle() {
        return this.h;
    }

    public c getSavedStateRegistry() {
        c b = this.i.b();
        Intrinsics.g(b, "savedStateRegistryController.savedStateRegistry");
        return b;
    }

    public x0 getViewModelStore() {
        if (!this.j) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).");
        }
        if (this.h.b() == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.");
        }
        p pVar = this.e;
        if (pVar != null) {
            return pVar.a(this.f);
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    public final Lifecycle.State h() {
        return this.m;
    }

    public int hashCode() {
        Set<String> keySet;
        int hashCode = (this.f.hashCode() * 31) + this.b.hashCode();
        Bundle bundle = this.c;
        if (bundle != null && (keySet = bundle.keySet()) != null) {
            Iterator<T> it = keySet.iterator();
            while (it.hasNext()) {
                int i = hashCode * 31;
                Object obj = d().get((String) it.next());
                hashCode = i + (obj == null ? 0 : obj.hashCode());
            }
        }
        return (((hashCode * 31) + this.h.hashCode()) * 31) + getSavedStateRegistry().hashCode();
    }

    public final void i(Lifecycle.Event event) {
        Intrinsics.h(event, "event");
        Lifecycle.State targetState = event.getTargetState();
        Intrinsics.g(targetState, "event.targetState");
        this.d = targetState;
        m();
    }

    public final void j(Bundle bundle) {
        Intrinsics.h(bundle, "outBundle");
        this.i.e(bundle);
    }

    public final void k(NavDestination navDestination) {
        Intrinsics.h(navDestination, "<set-?>");
        this.b = navDestination;
    }

    public final void l(Lifecycle.State state) {
        Intrinsics.h(state, "maxState");
        this.m = state;
        m();
    }

    public final void m() {
        if (!this.j) {
            this.i.d(this.g);
            this.j = true;
        }
        if (this.d.ordinal() < this.m.ordinal()) {
            this.h.n(this.d);
        } else {
            this.h.n(this.m);
        }
    }
}
