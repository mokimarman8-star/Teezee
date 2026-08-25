package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.util.d;
import androidx.core.util.i;
import z0.c;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class WindowInsetsCompat {
    public static final WindowInsetsCompat CONSUMED;
    private static final String TAG = "WindowInsetsCompat";
    private final l mImpl;

    public static final class Builder {
        private final e mImpl;

        public Builder() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 34) {
                this.mImpl = new d();
                return;
            }
            if (i >= 30) {
                this.mImpl = new c();
            } else if (i >= 29) {
                this.mImpl = new b();
            } else {
                this.mImpl = new a();
            }
        }

        public Builder(WindowInsetsCompat windowInsetsCompat) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 34) {
                this.mImpl = new d(windowInsetsCompat);
                return;
            }
            if (i >= 30) {
                this.mImpl = new c(windowInsetsCompat);
            } else if (i >= 29) {
                this.mImpl = new b(windowInsetsCompat);
            } else {
                this.mImpl = new a(windowInsetsCompat);
            }
        }

        public WindowInsetsCompat build() {
            return this.mImpl.b();
        }

        public Builder setDisplayCutout(DisplayCutoutCompat displayCutoutCompat) {
            this.mImpl.c(displayCutoutCompat);
            return this;
        }

        public Builder setInsets(int i, c cVar) {
            this.mImpl.d(i, cVar);
            return this;
        }

        public Builder setInsetsIgnoringVisibility(int i, c cVar) {
            this.mImpl.e(i, cVar);
            return this;
        }

        @Deprecated
        public Builder setMandatorySystemGestureInsets(c cVar) {
            this.mImpl.f(cVar);
            return this;
        }

        @Deprecated
        public Builder setStableInsets(c cVar) {
            this.mImpl.g(cVar);
            return this;
        }

        @Deprecated
        public Builder setSystemGestureInsets(c cVar) {
            this.mImpl.h(cVar);
            return this;
        }

        @Deprecated
        public Builder setSystemWindowInsets(c cVar) {
            this.mImpl.i(cVar);
            return this;
        }

        @Deprecated
        public Builder setTappableElementInsets(c cVar) {
            this.mImpl.j(cVar);
            return this;
        }

        public Builder setVisible(int i, boolean z) {
            this.mImpl.k(i, z);
            return this;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            CONSUMED = k.s;
        } else if (i >= 30) {
            CONSUMED = j.r;
        } else {
            CONSUMED = l.b;
        }
    }

    private WindowInsetsCompat(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            this.mImpl = new k(this, windowInsets);
            return;
        }
        if (i >= 30) {
            this.mImpl = new j(this, windowInsets);
            return;
        }
        if (i >= 29) {
            this.mImpl = new i(this, windowInsets);
        } else if (i >= 28) {
            this.mImpl = new h(this, windowInsets);
        } else {
            this.mImpl = new g(this, windowInsets);
        }
    }

    public WindowInsetsCompat(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat == null) {
            this.mImpl = new l(this);
            return;
        }
        k kVar = windowInsetsCompat.mImpl;
        int i = Build.VERSION.SDK_INT;
        if (i >= 34 && (kVar instanceof k)) {
            this.mImpl = new k(this, kVar);
        } else if (i >= 30 && (kVar instanceof j)) {
            this.mImpl = new j(this, (j) kVar);
        } else if (i >= 29 && (kVar instanceof i)) {
            this.mImpl = new i(this, (i) kVar);
        } else if (i >= 28 && (kVar instanceof h)) {
            this.mImpl = new h(this, (h) kVar);
        } else if (kVar instanceof g) {
            this.mImpl = new g(this, (g) kVar);
        } else if (kVar instanceof f) {
            this.mImpl = new f(this, (f) kVar);
        } else {
            this.mImpl = new l(this);
        }
        kVar.e(this);
    }

    static c insetInsets(c cVar, int i, int i2, int i3, int i4) {
        int max = Math.max(0, cVar.a - i);
        int max2 = Math.max(0, cVar.b - i2);
        int max3 = Math.max(0, cVar.c - i3);
        int max4 = Math.max(0, cVar.d - i4);
        return (max == i && max2 == i2 && max3 == i3 && max4 == i4) ? cVar : c.c(max, max2, max3, max4);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets windowInsets) {
        return toWindowInsetsCompat(windowInsets, null);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets windowInsets, View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) i.g(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            windowInsetsCompat.setRootWindowInsets(ViewCompat.getRootWindowInsets(view));
            windowInsetsCompat.copyRootViewBounds(view.getRootView());
            windowInsetsCompat.setSystemUiVisibility(view.getWindowSystemUiVisibility());
        }
        return windowInsetsCompat;
    }

    @Deprecated
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.a();
    }

    @Deprecated
    public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.b();
    }

    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.c();
    }

    void copyRootViewBounds(View view) {
        this.mImpl.d(view);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WindowInsetsCompat) {
            return d.a(this.mImpl, ((WindowInsetsCompat) obj).mImpl);
        }
        return false;
    }

    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.f();
    }

    public c getInsets(int i) {
        return this.mImpl.g(i);
    }

    public c getInsetsIgnoringVisibility(int i) {
        return this.mImpl.h(i);
    }

    @Deprecated
    public c getMandatorySystemGestureInsets() {
        return this.mImpl.i();
    }

    @Deprecated
    public int getStableInsetBottom() {
        return this.mImpl.j().d;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return this.mImpl.j().a;
    }

    @Deprecated
    public int getStableInsetRight() {
        return this.mImpl.j().c;
    }

    @Deprecated
    public int getStableInsetTop() {
        return this.mImpl.j().b;
    }

    @Deprecated
    public c getStableInsets() {
        return this.mImpl.j();
    }

    @Deprecated
    public c getSystemGestureInsets() {
        return this.mImpl.k();
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.mImpl.l().d;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.mImpl.l().a;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.mImpl.l().c;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.mImpl.l().b;
    }

    @Deprecated
    public c getSystemWindowInsets() {
        return this.mImpl.l();
    }

    @Deprecated
    public c getTappableElementInsets() {
        return this.mImpl.m();
    }

    public boolean hasInsets() {
        c insets = getInsets(Type.all());
        c cVar = c.e;
        return (insets.equals(cVar) && getInsetsIgnoringVisibility(Type.all() ^ Type.ime()).equals(cVar) && getDisplayCutout() == null) ? false : true;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return !this.mImpl.j().equals(c.e);
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return !this.mImpl.l().equals(c.e);
    }

    public int hashCode() {
        l lVar = this.mImpl;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public WindowInsetsCompat inset(int i, int i2, int i3, int i4) {
        return this.mImpl.n(i, i2, i3, i4);
    }

    public WindowInsetsCompat inset(c cVar) {
        return inset(cVar.a, cVar.b, cVar.c, cVar.d);
    }

    public boolean isConsumed() {
        return this.mImpl.o();
    }

    public boolean isRound() {
        return this.mImpl.p();
    }

    public boolean isVisible(int i) {
        return this.mImpl.q(i);
    }

    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int i, int i2, int i3, int i4) {
        return new Builder(this).setSystemWindowInsets(c.c(i, i2, i3, i4)).build();
    }

    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(Rect rect) {
        return new Builder(this).setSystemWindowInsets(c.d(rect)).build();
    }

    void setOverriddenInsets(c[] cVarArr) {
        this.mImpl.r(cVarArr);
    }

    void setRootViewData(c cVar) {
        this.mImpl.s(cVar);
    }

    void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        this.mImpl.t(windowInsetsCompat);
    }

    void setStableInsets(c cVar) {
        this.mImpl.u(cVar);
    }

    void setSystemUiVisibility(int i) {
        this.mImpl.v(i);
    }

    public WindowInsets toWindowInsets() {
        f fVar = this.mImpl;
        if (fVar instanceof f) {
            return fVar.c;
        }
        return null;
    }
}
