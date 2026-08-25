package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.media.session.c;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.n0;
import androidx.appcompat.widget.t;
import androidx.core.util.i;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
class ToolbarActionBar extends a {
    final t a;
    final Window.Callback b;
    final AppCompatDelegateImpl.e c;
    boolean d;
    private boolean e;
    private boolean f;
    private ArrayList g = new ArrayList();
    private final Runnable h = new 1(this);
    private final Toolbar.g i;

    ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        a aVar = new a(this);
        this.i = aVar;
        i.g(toolbar);
        n0 n0Var = new n0(toolbar, false);
        this.a = n0Var;
        this.b = (Window.Callback) i.g(callback);
        n0Var.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(aVar);
        n0Var.setWindowTitle(charSequence);
        this.c = new d(this);
    }

    private Menu w() {
        if (!this.e) {
            this.a.o(new b(this), new c(this));
            this.e = true;
        }
        return this.a.c();
    }

    public boolean g() {
        return this.a.hideOverflowMenu();
    }

    public boolean h() {
        if (!this.a.a()) {
            return false;
        }
        this.a.collapseActionView();
        return true;
    }

    public void i(boolean z) {
        if (z == this.f) {
            return;
        }
        this.f = z;
        if (this.g.size() <= 0) {
            return;
        }
        c.a(this.g.get(0));
        throw null;
    }

    public int j() {
        return this.a.r();
    }

    public Context k() {
        return this.a.getContext();
    }

    public void l() {
        this.a.setVisibility(8);
    }

    public boolean m() {
        this.a.g().removeCallbacks(this.h);
        ViewCompat.postOnAnimation(this.a.g(), this.h);
        return true;
    }

    public void n(Configuration configuration) {
        super.n(configuration);
    }

    void o() {
        this.a.g().removeCallbacks(this.h);
    }

    public boolean p(int i, KeyEvent keyEvent) {
        Menu w = w();
        if (w == null) {
            return false;
        }
        w.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return w.performShortcut(i, keyEvent, 0);
    }

    public boolean q(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            r();
        }
        return true;
    }

    public boolean r() {
        return this.a.showOverflowMenu();
    }

    public void s(boolean z) {
    }

    public void t(boolean z) {
    }

    public void u(CharSequence charSequence) {
        this.a.setWindowTitle(charSequence);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void x() {
        /*
            r5 = this;
            android.view.Menu r0 = r5.w()
            boolean r1 = r0 instanceof androidx.appcompat.view.menu.f
            r2 = 0
            if (r1 == 0) goto Ld
            r1 = r0
            androidx.appcompat.view.menu.f r1 = (androidx.appcompat.view.menu.f) r1
            goto Le
        Ld:
            r1 = r2
        Le:
            if (r1 == 0) goto L13
            r1.i0()
        L13:
            r0.clear()     // Catch: java.lang.Throwable -> L28
            android.view.Window$Callback r3 = r5.b     // Catch: java.lang.Throwable -> L28
            r4 = 0
            boolean r3 = r3.onCreatePanelMenu(r4, r0)     // Catch: java.lang.Throwable -> L28
            if (r3 == 0) goto L2a
            android.view.Window$Callback r3 = r5.b     // Catch: java.lang.Throwable -> L28
            boolean r2 = r3.onPreparePanel(r4, r2, r0)     // Catch: java.lang.Throwable -> L28
            if (r2 != 0) goto L2d
            goto L2a
        L28:
            r0 = move-exception
            goto L33
        L2a:
            r0.clear()     // Catch: java.lang.Throwable -> L28
        L2d:
            if (r1 == 0) goto L32
            r1.h0()
        L32:
            return
        L33:
            if (r1 == 0) goto L38
            r1.h0()
        L38:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.ToolbarActionBar.x():void");
    }
}
