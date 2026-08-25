package ob;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class t implements hc.d, hc.c {
    private final Map a = new HashMap();
    private Queue b = new ArrayDeque();
    private final Executor c;

    t(Executor executor) {
        this.c = executor;
    }

    private synchronized Set e(hc.a aVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(Map.Entry entry, hc.a aVar) {
        ((hc.b) entry.getKey()).a(aVar);
    }

    @Override // hc.d
    public void a(Class cls, hc.b bVar) {
        b(cls, this.c, bVar);
    }

    @Override // hc.d
    public synchronized void b(Class cls, Executor executor, hc.b bVar) {
        try {
            a0.b(cls);
            a0.b(bVar);
            a0.b(executor);
            if (!this.a.containsKey(cls)) {
                this.a.put(cls, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.a.get(cls)).put(bVar, executor);
        } catch (Throwable th) {
            throw th;
        }
    }

    void d() {
        Queue queue;
        synchronized (this) {
            try {
                queue = this.b;
                if (queue != null) {
                    this.b = null;
                } else {
                    queue = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (queue != null) {
            Iterator it = queue.iterator();
            while (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
                g(null);
            }
        }
    }

    public void g(final hc.a aVar) {
        a0.b(aVar);
        synchronized (this) {
            try {
                Queue queue = this.b;
                if (queue != null) {
                    queue.add(aVar);
                    return;
                }
                for (final Map.Entry entry : e(aVar)) {
                    ((Executor) entry.getValue()).execute(new Runnable(entry, aVar) { // from class: ob.s
                        public final /* synthetic */ Map.Entry a;

                        @Override // java.lang.Runnable
                        public final void run() {
                            t.f(this.a, null);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
