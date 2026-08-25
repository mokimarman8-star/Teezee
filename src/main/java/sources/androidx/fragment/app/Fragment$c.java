package androidx.fragment.app;

import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class Fragment$c extends f {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fragment f8075a;

    Fragment$c(Fragment fragment) {
        this.f8075a = fragment;
    }

    @Override // androidx.fragment.app.f
    public View c(int i5) {
        View view = this.f8075a.mView;
        if (view != null) {
            return view.findViewById(i5);
        }
        throw new IllegalStateException("Fragment " + this.f8075a + " does not have a view");
    }

    @Override // androidx.fragment.app.f
    public boolean d() {
        return this.f8075a.mView != null;
    }
}
