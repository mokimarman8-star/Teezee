package av;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a {
    private Reference a;

    public final void a(Object obj) {
        this.a = new WeakReference(obj);
    }

    public void b() {
        Reference reference = this.a;
        if (reference != null) {
            Intrinsics.e(reference);
            reference.clear();
            this.a = null;
        }
    }

    protected final Object c() {
        Reference reference = this.a;
        if (reference == null) {
            return null;
        }
        Intrinsics.e(reference);
        return reference.get();
    }

    protected final boolean d() {
        Reference reference = this.a;
        if (reference != null) {
            Intrinsics.e(reference);
            if (reference.get() != null) {
                return true;
            }
        }
        return false;
    }
}
