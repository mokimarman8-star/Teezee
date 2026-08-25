package androidx.fragment.app;

import androidx.activity.result.b;
import androidx.core.app.c;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class Fragment$a extends b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f8071a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ f.a f8072b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Fragment f8073c;

    Fragment$a(Fragment fragment, AtomicReference atomicReference, f.a aVar) {
        this.f8073c = fragment;
        this.f8071a = atomicReference;
        this.f8072b = aVar;
    }

    @Override // androidx.activity.result.b
    public void b(Object obj, c cVar) {
        b bVar = (b) this.f8071a.get();
        if (bVar == null) {
            throw new IllegalStateException("Operation cannot be started before fragment is in created state");
        }
        bVar.b(obj, cVar);
    }

    @Override // androidx.activity.result.b
    public void c() {
        b bVar = (b) this.f8071a.getAndSet(null);
        if (bVar != null) {
            bVar.c();
        }
    }
}
