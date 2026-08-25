package androidx.fragment.app;

import android.animation.Animator;
import android.util.Log;
import androidx.core.os.e;
import androidx.fragment.app.SpecialEffectsController;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class DefaultSpecialEffectsController$c implements e.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Animator f8050a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SpecialEffectsController.Operation f8051b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ DefaultSpecialEffectsController f8052c;

    DefaultSpecialEffectsController$c(DefaultSpecialEffectsController defaultSpecialEffectsController, Animator animator, SpecialEffectsController.Operation operation) {
        this.f8052c = defaultSpecialEffectsController;
        this.f8050a = animator;
        this.f8051b = operation;
    }

    @Override // androidx.core.os.e.a
    public void onCancel() {
        this.f8050a.end();
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Animator from operation " + this.f8051b + " has been canceled.");
        }
    }
}
