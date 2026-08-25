package androidx.fragment.app;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class FragmentManager$b extends androidx.activity.u {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FragmentManager f8113a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FragmentManager$b(FragmentManager fragmentManager, boolean z5) {
        super(z5);
        this.f8113a = fragmentManager;
    }

    @Override // androidx.activity.u
    public void handleOnBackPressed() {
        this.f8113a.I0();
    }
}
