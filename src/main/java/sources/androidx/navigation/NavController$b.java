package androidx.navigation;

import androidx.activity.u;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class NavController$b extends u {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NavController f12436a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavController$b(NavController navController) {
        super(false);
        this.f12436a = navController;
    }

    @Override // androidx.activity.u
    public void handleOnBackPressed() {
        this.f12436a.N();
    }
}
