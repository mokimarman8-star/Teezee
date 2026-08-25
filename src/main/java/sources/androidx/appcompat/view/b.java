package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private Object f411a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f412b;

    public interface a {
        void a(b bVar);

        boolean b(b bVar, Menu menu);

        boolean c(b bVar, MenuItem menuItem);

        boolean d(b bVar, Menu menu);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f411a;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f412b;
    }

    public abstract void k();

    public boolean l() {
        return false;
    }

    public abstract void m(View view);

    public abstract void n(int i5);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f411a = obj;
    }

    public abstract void q(int i5);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z5) {
        this.f412b = z5;
    }
}
