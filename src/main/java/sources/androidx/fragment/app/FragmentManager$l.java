package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class FragmentManager$l implements t {

    /* renamed from: a, reason: collision with root package name */
    private final Lifecycle f8121a;

    /* renamed from: b, reason: collision with root package name */
    private final t f8122b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.view.r f8123c;

    FragmentManager$l(Lifecycle lifecycle, t tVar, androidx.view.r rVar) {
        this.f8121a = lifecycle;
        this.f8122b = tVar;
        this.f8123c = rVar;
    }

    @Override // androidx.fragment.app.t
    public void a(String str, Bundle bundle) {
        this.f8122b.a(str, bundle);
    }

    public boolean b(Lifecycle.State state) {
        return this.f8121a.b().isAtLeast(state);
    }

    public void c() {
        this.f8121a.d(this.f8123c);
    }
}
