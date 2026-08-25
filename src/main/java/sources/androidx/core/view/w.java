package androidx.core.view;

import androidx.lifecycle.Lifecycle;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final /* synthetic */ class w implements androidx.view.r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MenuHostHelper f7295a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MenuProvider f7296b;

    public /* synthetic */ w(MenuHostHelper menuHostHelper, MenuProvider menuProvider) {
        this.f7295a = menuHostHelper;
        this.f7296b = menuProvider;
    }

    @Override // androidx.view.r
    public final void onStateChanged(androidx.view.u uVar, Lifecycle.Event event) {
        MenuHostHelper.b(this.f7295a, this.f7296b, uVar, event);
    }
}
