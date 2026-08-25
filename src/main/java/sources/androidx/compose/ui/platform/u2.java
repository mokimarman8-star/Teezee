package androidx.compose.ui.platform;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class u2 {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f4861a = new androidx.compose.runtime.collection.b(new Reference[16], 0);

    /* renamed from: b, reason: collision with root package name */
    private final ReferenceQueue f4862b = new ReferenceQueue();

    private final void a() {
        Reference poll;
        do {
            poll = this.f4862b.poll();
            if (poll != null) {
                this.f4861a.t(poll);
            }
        } while (poll != null);
    }

    public final Object b() {
        a();
        while (this.f4861a.q()) {
            Object obj = ((Reference) this.f4861a.v(r0.n() - 1)).get();
            if (obj != null) {
                return obj;
            }
        }
        return null;
    }

    public final void c(Object obj) {
        a();
        this.f4861a.b(new WeakReference(obj, this.f4862b));
    }
}
