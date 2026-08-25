package androidx.activity;

import androidx.lifecycle.Lifecycle;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final /* synthetic */ class i implements androidx.view.r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f101a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f102b;

    public /* synthetic */ i(OnBackPressedDispatcher onBackPressedDispatcher, ComponentActivity componentActivity) {
        this.f101a = onBackPressedDispatcher;
        this.f102b = componentActivity;
    }

    @Override // androidx.view.r
    public final void onStateChanged(androidx.view.u uVar, Lifecycle.Event event) {
        ComponentActivity.m(this.f101a, this.f102b, uVar, event);
    }
}
