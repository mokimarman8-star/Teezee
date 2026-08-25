package fl;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    private final Map a = new HashMap();
    private final c b = new c(null);

    private static class b {
        final Lock a = new ReentrantLock();
        int b;

        /* synthetic */ b(a aVar) {
        }
    }

    private static class c {
        private final Queue a = new ArrayDeque();

        /* synthetic */ c(a aVar) {
        }

        b a() {
            b bVar;
            synchronized (this.a) {
                bVar = (b) this.a.poll();
            }
            return bVar == null ? new b(null) : bVar;
        }

        void b(b bVar) {
            synchronized (this.a) {
                try {
                    if (this.a.size() < 10) {
                        this.a.offer(bVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void a(el.e eVar) {
        b bVar;
        synchronized (this) {
            try {
                bVar = (b) this.a.get(eVar);
                if (bVar == null) {
                    bVar = this.b.a();
                    this.a.put(eVar, bVar);
                }
                bVar.b++;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        bVar.a.lock();
    }

    public void b(el.e eVar) {
        b bVar;
        synchronized (this) {
            try {
                bVar = (b) this.a.get(eVar);
                int i = bVar.b;
                if (i < 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Cannot release a lock that is not held, key: ");
                    sb.append(eVar);
                    sb.append(", interestedThreads: ");
                    sb.append(bVar.b);
                    throw new IllegalStateException(sb.toString());
                }
                int i2 = i - 1;
                bVar.b = i2;
                if (i2 == 0) {
                    b bVar2 = (b) this.a.remove(eVar);
                    if (!bVar2.equals(bVar)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Removed the wrong lock, expected to remove: ");
                        sb2.append(bVar);
                        sb2.append(", but actually removed: ");
                        sb2.append(bVar2);
                        sb2.append(", key: ");
                        sb2.append(eVar);
                        throw new IllegalStateException(sb2.toString());
                    }
                    this.b.b(bVar2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        bVar.a.unlock();
    }
}
