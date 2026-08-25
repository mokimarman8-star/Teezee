package a9;

import b9.u;
import com.google.android.datatransport.runtime.o;
import com.google.android.datatransport.runtime.t;
import d9.a;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import t8.j;
import v8.k;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class c implements e {
    private static final Logger f = Logger.getLogger(t.class.getName());
    private final u a;
    private final Executor b;
    private final v8.d c;
    private final c9.d d;
    private final d9.a e;

    public c(Executor executor, v8.d dVar, u uVar, c9.d dVar2, d9.a aVar) {
        this.b = executor;
        this.c = dVar;
        this.a = uVar;
        this.d = dVar2;
        this.e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d(o oVar, com.google.android.datatransport.runtime.i iVar) {
        this.d.w0(oVar, iVar);
        this.a.a(oVar, 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(final o oVar, j jVar, com.google.android.datatransport.runtime.i iVar) {
        try {
            k a = this.c.a(oVar.b());
            if (a == null) {
                String format = String.format("Transport backend '%s' is not registered", oVar.b());
                f.warning(format);
                jVar.a(new IllegalArgumentException(format));
            } else {
                final com.google.android.datatransport.runtime.i a2 = a.a(iVar);
                this.e.b(new a.InterfaceC0041a() { // from class: a9.b
                    @Override // d9.a.InterfaceC0041a
                    public final Object execute() {
                        Object d;
                        d = c.this.d(oVar, a2);
                        return d;
                    }
                });
                jVar.a(null);
            }
        } catch (Exception e) {
            f.warning("Error scheduling event " + e.getMessage());
            jVar.a(e);
        }
    }

    @Override // a9.e
    public void a(final o oVar, final com.google.android.datatransport.runtime.i iVar, final j jVar) {
        this.b.execute(new Runnable() { // from class: a9.a
            @Override // java.lang.Runnable
            public final void run() {
                c.this.e(oVar, jVar, iVar);
            }
        });
    }
}
