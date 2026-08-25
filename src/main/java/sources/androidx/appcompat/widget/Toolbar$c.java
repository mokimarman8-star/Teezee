package androidx.appcompat.widget;

import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class Toolbar$c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Toolbar f952a;

    Toolbar$c(Toolbar toolbar) {
        this.f952a = toolbar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f952a.collapseActionView();
    }
}
