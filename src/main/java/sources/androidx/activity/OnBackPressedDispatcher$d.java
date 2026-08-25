package androidx.activity;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class OnBackPressedDispatcher$d implements c {

    /* renamed from: a, reason: collision with root package name */
    private final u f91a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnBackPressedDispatcher f92b;

    public OnBackPressedDispatcher$d(OnBackPressedDispatcher onBackPressedDispatcher, u uVar) {
        Intrinsics.h(uVar, "onBackPressedCallback");
        this.f92b = onBackPressedDispatcher;
        this.f91a = uVar;
    }

    @Override // androidx.activity.c
    public void cancel() {
        OnBackPressedDispatcher.b(this.f92b).remove(this.f91a);
        if (Intrinsics.c(OnBackPressedDispatcher.a(this.f92b), this.f91a)) {
            this.f91a.handleOnBackCancelled();
            OnBackPressedDispatcher.f(this.f92b, (u) null);
        }
        this.f91a.removeCancellable(this);
        Function0<Unit> enabledChangedCallback$activity_release = this.f91a.getEnabledChangedCallback$activity_release();
        if (enabledChangedCallback$activity_release != null) {
            enabledChangedCallback$activity_release.invoke();
        }
        this.f91a.setEnabledChangedCallback$activity_release(null);
    }
}
