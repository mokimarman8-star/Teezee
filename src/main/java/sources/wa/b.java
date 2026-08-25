package wa;

import android.os.Bundle;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b {
    private final View a;
    private boolean b = false;
    private int c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public b(a aVar) {
        this.a = (View) aVar;
    }

    private void a() {
        CoordinatorLayout parent = this.a.getParent();
        if (parent instanceof CoordinatorLayout) {
            parent.dispatchDependentViewsChanged(this.a);
        }
    }

    public int b() {
        return this.c;
    }

    public boolean c() {
        return this.b;
    }

    public void d(Bundle bundle) {
        this.b = bundle.getBoolean("expanded", false);
        this.c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.b) {
            a();
        }
    }

    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.b);
        bundle.putInt("expandedComponentIdHint", this.c);
        return bundle;
    }

    public boolean f(boolean z) {
        if (this.b == z) {
            return false;
        }
        this.b = z;
        a();
        return true;
    }

    public void g(int i) {
        this.c = i;
    }
}
