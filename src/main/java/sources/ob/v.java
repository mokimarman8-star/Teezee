package ob;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class v implements kc.b {
    private volatile Set b = null;
    private volatile Set a = Collections.newSetFromMap(new ConcurrentHashMap());

    v(Collection collection) {
        this.a.addAll(collection);
    }

    static v b(Collection collection) {
        return new v((Set) collection);
    }

    private synchronized void d() {
        try {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                this.b.add(((kc.b) it.next()).get());
            }
            this.a = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized void a(kc.b bVar) {
        try {
            if (this.b == null) {
                this.a.add(bVar);
            } else {
                this.b.add(bVar.get());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // kc.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Set get() {
        if (this.b == null) {
            synchronized (this) {
                try {
                    if (this.b == null) {
                        this.b = Collections.newSetFromMap(new ConcurrentHashMap());
                        d();
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableSet(this.b);
    }
}
