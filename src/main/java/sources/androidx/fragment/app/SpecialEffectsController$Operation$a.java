package androidx.fragment.app;

import androidx.core.os.e;
import androidx.fragment.app.SpecialEffectsController;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class SpecialEffectsController$Operation$a implements e.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SpecialEffectsController.Operation f8179a;

    SpecialEffectsController$Operation$a(SpecialEffectsController.Operation operation) {
        this.f8179a = operation;
    }

    @Override // androidx.core.os.e.a
    public void onCancel() {
        this.f8179a.b();
    }
}
