package androidx.fragment.app;

import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class FragmentManager$o implements FragmentManager$m {

    /* renamed from: a, reason: collision with root package name */
    private final String f8128a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ FragmentManager f8129b;

    FragmentManager$o(FragmentManager fragmentManager, String str) {
        this.f8129b = fragmentManager;
        this.f8128a = str;
    }

    @Override // androidx.fragment.app.FragmentManager$m
    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        return this.f8129b.v1(arrayList, arrayList2, this.f8128a);
    }
}
