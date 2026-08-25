package androidx.fragment.app;

import androidx.lifecycle.o0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class Fragment$b extends Fragment$j {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fragment f8074a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Fragment$b(Fragment fragment) {
        super();
        this.f8074a = fragment;
    }

    @Override // androidx.fragment.app.Fragment$j
    void a() {
        this.f8074a.mSavedStateRegistryController.c();
        o0.c(this.f8074a);
    }
}
