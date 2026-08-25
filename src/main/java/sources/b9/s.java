package b9;

import d9.a;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class s {
    private final Executor a;
    private final c9.d b;
    private final u c;
    private final d9.a d;

    s(Executor executor, c9.d dVar, u uVar, d9.a aVar) {
        this.a = executor;
        this.b = dVar;
        this.c = uVar;
        this.d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d() {
        Iterator it = this.b.H().iterator();
        while (it.hasNext()) {
            this.c.a((com.google.android.datatransport.runtime.o) it.next(), 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.d.b(new a.InterfaceC0041a() { // from class: b9.r
            @Override // d9.a.InterfaceC0041a
            public final Object execute() {
                Object d;
                d = s.this.d();
                return d;
            }
        });
    }

    public void c() {
        this.a.execute(new Runnable() { // from class: b9.q
            @Override // java.lang.Runnable
            public final void run() {
                s.this.e();
            }
        });
    }
}
