package androidx.fragment.app;

import androidx.core.os.e;
import androidx.fragment.app.SpecialEffectsController;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class DefaultSpecialEffectsController$f {

    /* renamed from: a, reason: collision with root package name */
    private final SpecialEffectsController.Operation f8061a;

    /* renamed from: b, reason: collision with root package name */
    private final e f8062b;

    DefaultSpecialEffectsController$f(SpecialEffectsController.Operation operation, e eVar) {
        this.f8061a = operation;
        this.f8062b = eVar;
    }

    void a() {
        this.f8061a.d(this.f8062b);
    }

    SpecialEffectsController.Operation b() {
        return this.f8061a;
    }

    e c() {
        return this.f8062b;
    }

    boolean d() {
        SpecialEffectsController.Operation.State state;
        SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(this.f8061a.f().mView);
        SpecialEffectsController.Operation.State e5 = this.f8061a.e();
        return from == e5 || !(from == (state = SpecialEffectsController.Operation.State.VISIBLE) || e5 == state);
    }
}
