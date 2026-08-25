package androidx.fragment.app;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class FragmentManager$g implements s {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fragment f8117a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ FragmentManager f8118b;

    FragmentManager$g(FragmentManager fragmentManager, Fragment fragment) {
        this.f8118b = fragmentManager;
        this.f8117a = fragment;
    }

    @Override // androidx.fragment.app.s
    public void a(FragmentManager fragmentManager, Fragment fragment) {
        this.f8117a.onAttachFragment(fragment);
    }
}
