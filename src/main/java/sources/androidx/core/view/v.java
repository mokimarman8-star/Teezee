package androidx.core.view;

import androidx.lifecycle.Lifecycle;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final /* synthetic */ class v implements androidx.view.r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MenuHostHelper f7292a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f7293b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MenuProvider f7294c;

    public /* synthetic */ v(MenuHostHelper menuHostHelper, Lifecycle.State state, MenuProvider menuProvider) {
        this.f7292a = menuHostHelper;
        this.f7293b = state;
        this.f7294c = menuProvider;
    }

    @Override // androidx.view.r
    public final void onStateChanged(androidx.view.u uVar, Lifecycle.Event event) {
        MenuHostHelper.a(this.f7292a, this.f7293b, this.f7294c, uVar, event);
    }
}
