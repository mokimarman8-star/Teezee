package androidx.view;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.view.r;
import androidx.view.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import k.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.savedstate.c, reason: case insensitive filesystem */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class C0204c {

    /* renamed from: g, reason: collision with root package name */
    private static final b f13344g = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private boolean f13346b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f13347c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f13348d;

    /* renamed from: e, reason: collision with root package name */
    private a$b f13349e;

    /* renamed from: a, reason: collision with root package name */
    private final k.b f13345a = new k.b();

    /* renamed from: f, reason: collision with root package name */
    private boolean f13350f = true;

    /* renamed from: androidx.savedstate.c$a */
    public interface a {
        void a(InterfaceC0206e interfaceC0206e);
    }

    /* renamed from: androidx.savedstate.c$b */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: androidx.savedstate.c$c, reason: collision with other inner class name */
    public interface InterfaceC0103c {
        Bundle saveState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C0204c c0204c, u uVar, Lifecycle.Event event) {
        Intrinsics.h(c0204c, "this$0");
        Intrinsics.h(uVar, "<anonymous parameter 0>");
        Intrinsics.h(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_START) {
            c0204c.f13350f = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            c0204c.f13350f = false;
        }
    }

    public final Bundle b(String str) {
        Intrinsics.h(str, "key");
        if (!this.f13348d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f13347c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.f13347c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f13347c;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.f13347c = null;
        }
        return bundle2;
    }

    public final InterfaceC0103c c(String str) {
        Intrinsics.h(str, "key");
        Iterator it = this.f13345a.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Intrinsics.g(entry, "components");
            String str2 = (String) entry.getKey();
            InterfaceC0103c interfaceC0103c = (InterfaceC0103c) entry.getValue();
            if (Intrinsics.c(str2, str)) {
                return interfaceC0103c;
            }
        }
        return null;
    }

    public final void e(Lifecycle lifecycle) {
        Intrinsics.h(lifecycle, "lifecycle");
        if (this.f13346b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        lifecycle.a(new r() { // from class: androidx.savedstate.b
            @Override // androidx.view.r
            public final void onStateChanged(u uVar, Lifecycle.Event event) {
                C0204c.d(C0204c.this, uVar, event);
            }
        });
        this.f13346b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.f13346b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (this.f13348d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        this.f13347c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f13348d = true;
    }

    public final void g(Bundle bundle) {
        Intrinsics.h(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f13347c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        b.d c5 = this.f13345a.c();
        Intrinsics.g(c5, "this.components.iteratorWithAdditions()");
        while (c5.hasNext()) {
            Map.Entry entry = (Map.Entry) c5.next();
            bundle2.putBundle((String) entry.getKey(), ((InterfaceC0103c) entry.getValue()).saveState());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public final void h(String str, InterfaceC0103c interfaceC0103c) {
        Intrinsics.h(str, "key");
        Intrinsics.h(interfaceC0103c, "provider");
        if (((InterfaceC0103c) this.f13345a.g(str, interfaceC0103c)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [androidx.savedstate.a$b] */
    public final void i(Class cls) {
        Intrinsics.h(cls, "clazz");
        if (!this.f13350f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        a$b a_b = this.f13349e;
        a$b a_b2 = a_b;
        if (a_b == null) {
            a_b2 = new InterfaceC0103c(this) { // from class: androidx.savedstate.a$b

                /* renamed from: a, reason: collision with root package name */
                private final Set f13342a;

                {
                    Intrinsics.h(this, "registry");
                    this.f13342a = new LinkedHashSet();
                    this.h("androidx.savedstate.Restarter", this);
                }

                public final void a(String str) {
                    Intrinsics.h(str, "className");
                    this.f13342a.add(str);
                }

                @Override // androidx.view.C0204c.InterfaceC0103c
                public Bundle saveState() {
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f13342a));
                    return bundle;
                }
            };
        }
        this.f13349e = a_b2;
        try {
            cls.getDeclaredConstructor(null);
            a$b a_b3 = this.f13349e;
            if (a_b3 != null) {
                String name = cls.getName();
                Intrinsics.g(name, "clazz.name");
                a_b3.a(name);
            }
        } catch (NoSuchMethodException e5) {
            throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e5);
        }
    }

    public final void j(String str) {
        Intrinsics.h(str, "key");
        this.f13345a.i(str);
    }
}
