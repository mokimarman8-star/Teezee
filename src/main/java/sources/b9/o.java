package b9;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import d9.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class o {
    private final Context a;
    private final v8.d b;
    private final c9.d c;
    private final u d;
    private final Executor e;
    private final d9.a f;
    private final e9.a g;
    private final e9.a h;
    private final c9.c i;

    public o(Context context, v8.d dVar, c9.d dVar2, u uVar, Executor executor, d9.a aVar, e9.a aVar2, e9.a aVar3, c9.c cVar) {
        this.a = context;
        this.b = dVar;
        this.c = dVar2;
        this.d = uVar;
        this.e = executor;
        this.f = aVar;
        this.g = aVar2;
        this.h = aVar3;
        this.i = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean l(com.google.android.datatransport.runtime.o oVar) {
        return Boolean.valueOf(this.c.P(oVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Iterable m(com.google.android.datatransport.runtime.o oVar) {
        return this.c.Z(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object n(Iterable iterable, com.google.android.datatransport.runtime.o oVar, long j) {
        this.c.Q(iterable);
        this.c.G(oVar, this.g.getTime() + j);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object o(Iterable iterable) {
        this.c.C(iterable);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p() {
        this.i.d();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object q(Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            this.i.j(((Integer) r0.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) ((Map.Entry) it.next()).getKey());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(com.google.android.datatransport.runtime.o oVar, long j) {
        this.c.G(oVar, this.g.getTime() + j);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object s(com.google.android.datatransport.runtime.o oVar, int i) {
        this.d.a(oVar, i + 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(final com.google.android.datatransport.runtime.o oVar, final int i, Runnable runnable) {
        try {
            try {
                d9.a aVar = this.f;
                final c9.d dVar = this.c;
                Objects.requireNonNull(dVar);
                aVar.b(new a.InterfaceC0041a() { // from class: b9.f
                    @Override // d9.a.InterfaceC0041a
                    public final Object execute() {
                        return Integer.valueOf(c9.d.this.B());
                    }
                });
                if (k()) {
                    u(oVar, i);
                } else {
                    this.f.b(new a.InterfaceC0041a() { // from class: b9.g
                        @Override // d9.a.InterfaceC0041a
                        public final Object execute() {
                            Object s;
                            s = o.this.s(oVar, i);
                            return s;
                        }
                    });
                }
            } catch (SynchronizationException unused) {
                this.d.a(oVar, i + 1);
            }
            runnable.run();
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }

    public com.google.android.datatransport.runtime.i j(v8.k kVar) {
        d9.a aVar = this.f;
        final c9.c cVar = this.i;
        Objects.requireNonNull(cVar);
        return kVar.a(com.google.android.datatransport.runtime.i.a().i(this.g.getTime()).o(this.h.getTime()).n("GDT_CLIENT_METRICS").h(new com.google.android.datatransport.runtime.h(t8.c.b("proto"), ((x8.a) aVar.b(new a.InterfaceC0041a() { // from class: b9.e
            @Override // d9.a.InterfaceC0041a
            public final Object execute() {
                return c9.c.this.h();
            }
        })).f())).d());
    }

    boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public BackendResponse u(final com.google.android.datatransport.runtime.o oVar, int i) {
        BackendResponse b;
        v8.k a = this.b.a(oVar.b());
        long j = 0;
        BackendResponse e = BackendResponse.e(0L);
        while (true) {
            final long j2 = j;
            while (((Boolean) this.f.b(new a.InterfaceC0041a() { // from class: b9.h
                @Override // d9.a.InterfaceC0041a
                public final Object execute() {
                    Boolean l;
                    l = o.this.l(oVar);
                    return l;
                }
            })).booleanValue()) {
                final Iterable iterable = (Iterable) this.f.b(new a.InterfaceC0041a() { // from class: b9.i
                    @Override // d9.a.InterfaceC0041a
                    public final Object execute() {
                        Iterable m;
                        m = o.this.m(oVar);
                        return m;
                    }
                });
                if (!iterable.iterator().hasNext()) {
                    return e;
                }
                if (a == null) {
                    y8.a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", oVar);
                    b = BackendResponse.a();
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((c9.k) it.next()).b());
                    }
                    if (oVar.e()) {
                        arrayList.add(j(a));
                    }
                    b = a.b(v8.e.a().b(arrayList).c(oVar.c()).a());
                }
                e = b;
                if (e.c() == BackendResponse.Status.TRANSIENT_ERROR) {
                    this.f.b(new a.InterfaceC0041a() { // from class: b9.j
                        @Override // d9.a.InterfaceC0041a
                        public final Object execute() {
                            Object n;
                            n = o.this.n(iterable, oVar, j2);
                            return n;
                        }
                    });
                    this.d.b(oVar, i + 1, true);
                    return e;
                }
                this.f.b(new a.InterfaceC0041a() { // from class: b9.k
                    @Override // d9.a.InterfaceC0041a
                    public final Object execute() {
                        Object o;
                        o = o.this.o(iterable);
                        return o;
                    }
                });
                if (e.c() == BackendResponse.Status.OK) {
                    j = Math.max(j2, e.b());
                    if (oVar.e()) {
                        this.f.b(new a.InterfaceC0041a() { // from class: b9.l
                            @Override // d9.a.InterfaceC0041a
                            public final Object execute() {
                                Object p;
                                p = o.this.p();
                                return p;
                            }
                        });
                    }
                } else if (e.c() == BackendResponse.Status.INVALID_PAYLOAD) {
                    final HashMap hashMap = new HashMap();
                    Iterator it2 = iterable.iterator();
                    while (it2.hasNext()) {
                        String n = ((c9.k) it2.next()).b().n();
                        if (hashMap.containsKey(n)) {
                            hashMap.put(n, Integer.valueOf(((Integer) hashMap.get(n)).intValue() + 1));
                        } else {
                            hashMap.put(n, 1);
                        }
                    }
                    this.f.b(new a.InterfaceC0041a() { // from class: b9.m
                        @Override // d9.a.InterfaceC0041a
                        public final Object execute() {
                            Object q;
                            q = o.this.q(hashMap);
                            return q;
                        }
                    });
                }
            }
            this.f.b(new a.InterfaceC0041a() { // from class: b9.n
                @Override // d9.a.InterfaceC0041a
                public final Object execute() {
                    Object r;
                    r = o.this.r(oVar, j2);
                    return r;
                }
            });
            return e;
        }
    }

    public void v(final com.google.android.datatransport.runtime.o oVar, final int i, final Runnable runnable) {
        this.e.execute(new Runnable() { // from class: b9.d
            @Override // java.lang.Runnable
            public final void run() {
                o.this.t(oVar, i, runnable);
            }
        });
    }
}
