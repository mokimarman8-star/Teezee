package q1;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final e f17003a = new e();

    /* renamed from: b, reason: collision with root package name */
    private final Map f17004b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Set f17005c = new LinkedHashSet();

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f17006d;

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (Exception e5) {
                throw new RuntimeException(e5);
            }
        }
    }

    public final void d(AutoCloseable autoCloseable) {
        Intrinsics.h(autoCloseable, "closeable");
        if (this.f17006d) {
            g(autoCloseable);
            return;
        }
        synchronized (this.f17003a) {
            this.f17005c.add(autoCloseable);
            Unit unit = Unit.a;
        }
    }

    public final void e(String str, AutoCloseable autoCloseable) {
        AutoCloseable autoCloseable2;
        Intrinsics.h(str, "key");
        Intrinsics.h(autoCloseable, "closeable");
        if (this.f17006d) {
            g(autoCloseable);
            return;
        }
        synchronized (this.f17003a) {
            autoCloseable2 = (AutoCloseable) this.f17004b.put(str, autoCloseable);
        }
        g(autoCloseable2);
    }

    public final void f() {
        if (this.f17006d) {
            return;
        }
        this.f17006d = true;
        synchronized (this.f17003a) {
            try {
                Iterator it = this.f17004b.values().iterator();
                while (it.hasNext()) {
                    g((AutoCloseable) it.next());
                }
                Iterator it2 = this.f17005c.iterator();
                while (it2.hasNext()) {
                    g((AutoCloseable) it2.next());
                }
                this.f17005c.clear();
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final AutoCloseable h(String str) {
        AutoCloseable autoCloseable;
        Intrinsics.h(str, "key");
        synchronized (this.f17003a) {
            autoCloseable = (AutoCloseable) this.f17004b.get(str);
        }
        return autoCloseable;
    }
}
