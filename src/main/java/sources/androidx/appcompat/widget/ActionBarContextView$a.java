package androidx.appcompat.widget;

import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ActionBarContextView$a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ androidx.appcompat.view.b f699a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ActionBarContextView f700b;

    ActionBarContextView$a(ActionBarContextView actionBarContextView, androidx.appcompat.view.b bVar) {
        this.f700b = actionBarContextView;
        this.f699a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f699a.c();
    }
}
