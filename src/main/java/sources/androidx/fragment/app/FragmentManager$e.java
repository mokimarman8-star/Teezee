package androidx.fragment.app;

import android.view.ViewGroup;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class FragmentManager$e implements b0 {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FragmentManager f8116a;

    FragmentManager$e(FragmentManager fragmentManager) {
        this.f8116a = fragmentManager;
    }

    @Override // androidx.fragment.app.b0
    public SpecialEffectsController a(ViewGroup viewGroup) {
        return new DefaultSpecialEffectsController(viewGroup);
    }
}
