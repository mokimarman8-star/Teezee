package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class l {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile;

    public l(boolean z) {
        this._cur$volatile = new m(8, z);
    }

    public final boolean a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            int a2 = mVar.a(obj);
            if (a2 == 0) {
                return true;
            }
            if (a2 == 1) {
                androidx.concurrent.futures.a.a(a, this, mVar, mVar.l());
            } else if (a2 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            if (mVar.d()) {
                return;
            } else {
                androidx.concurrent.futures.a.a(a, this, mVar, mVar.l());
            }
        }
    }

    public final int c() {
        return ((m) a.get(this)).g();
    }

    public final Object e() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            Object m = mVar.m();
            if (m != m.h) {
                return m;
            }
            androidx.concurrent.futures.a.a(a, this, mVar, mVar.l());
        }
    }
}
