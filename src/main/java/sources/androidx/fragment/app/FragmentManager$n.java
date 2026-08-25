package androidx.fragment.app;

import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class FragmentManager$n implements FragmentManager$m {

    /* renamed from: a, reason: collision with root package name */
    final String f8124a;

    /* renamed from: b, reason: collision with root package name */
    final int f8125b;

    /* renamed from: c, reason: collision with root package name */
    final int f8126c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ FragmentManager f8127d;

    FragmentManager$n(FragmentManager fragmentManager, String str, int i5, int i6) {
        this.f8127d = fragmentManager;
        this.f8124a = str;
        this.f8125b = i5;
        this.f8126c = i6;
    }

    @Override // androidx.fragment.app.FragmentManager$m
    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        Fragment fragment = this.f8127d.y;
        if (fragment == null || this.f8125b >= 0 || this.f8124a != null || !fragment.getChildFragmentManager().j1()) {
            return this.f8127d.n1(arrayList, arrayList2, this.f8124a, this.f8125b, this.f8126c);
        }
        return false;
    }
}
