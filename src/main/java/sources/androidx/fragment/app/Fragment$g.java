package androidx.fragment.app;

import androidx.activity.result.ActivityResultRegistry;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class Fragment$g extends Fragment$j {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l.a f8079a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AtomicReference f8080b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ f.a f8081c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ androidx.activity.result.a f8082d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Fragment f8083e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Fragment$g(Fragment fragment, l.a aVar, AtomicReference atomicReference, f.a aVar2, androidx.activity.result.a aVar3) {
        super();
        this.f8083e = fragment;
        this.f8079a = aVar;
        this.f8080b = atomicReference;
        this.f8081c = aVar2;
        this.f8082d = aVar3;
    }

    @Override // androidx.fragment.app.Fragment$j
    void a() {
        String generateActivityResultKey = this.f8083e.generateActivityResultKey();
        this.f8080b.set(((ActivityResultRegistry) this.f8079a.apply(null)).l(generateActivityResultKey, this.f8083e, this.f8081c, this.f8082d));
    }
}
