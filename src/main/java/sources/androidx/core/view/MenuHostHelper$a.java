package androidx.core.view;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class MenuHostHelper$a {

    /* renamed from: a, reason: collision with root package name */
    final Lifecycle f7147a;

    /* renamed from: b, reason: collision with root package name */
    private androidx.view.r f7148b;

    MenuHostHelper$a(Lifecycle lifecycle, androidx.view.r rVar) {
        this.f7147a = lifecycle;
        this.f7148b = rVar;
        lifecycle.a(rVar);
    }

    void a() {
        this.f7147a.d(this.f7148b);
        this.f7148b = null;
    }
}
