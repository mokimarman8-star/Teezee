package androidx.coroutines.impl.background.greedy;

import androidx.work.j;
import androidx.work.o;
import j4.u;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class DelayedWorkTracker {
    static final String d = j.i("DelayedWorkTracker");
    final a a;
    private final o b;
    private final Map c = new HashMap();

    public DelayedWorkTracker(a aVar, o oVar) {
        this.a = aVar;
        this.b = oVar;
    }

    public void a(u uVar) {
        Runnable runnable = (Runnable) this.c.remove(uVar.a);
        if (runnable != null) {
            this.b.a(runnable);
        }
        1 r0 = new 1(this, uVar);
        this.c.put(uVar.a, r0);
        this.b.b(uVar.c() - System.currentTimeMillis(), r0);
    }

    public void b(String str) {
        Runnable runnable = (Runnable) this.c.remove(str);
        if (runnable != null) {
            this.b.a(runnable);
        }
    }
}
