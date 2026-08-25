package ye;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import ye.b;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class c implements b.a {
    private final BlockingQueue a;
    private final ThreadPoolExecutor b;
    private final ArrayDeque c = new ArrayDeque();
    private b d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.a = linkedBlockingQueue;
        this.b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void b() {
        b bVar = (b) this.c.poll();
        this.d = bVar;
        if (bVar != null) {
            bVar.b(this.b);
        }
    }

    @Override // ye.b.a
    public void a(b bVar) {
        this.d = null;
        b();
    }

    public void c(b bVar) {
        bVar.c(this);
        this.c.add(bVar);
        if (this.d == null) {
            b();
        }
    }
}
