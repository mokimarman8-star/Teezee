package androidx.core.view;

import android.os.Build;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class ViewCompat$f {

    /* renamed from: a, reason: collision with root package name */
    private final int f7155a;

    /* renamed from: b, reason: collision with root package name */
    private final Class f7156b;

    /* renamed from: c, reason: collision with root package name */
    private final int f7157c;

    /* renamed from: d, reason: collision with root package name */
    private final int f7158d;

    ViewCompat$f(int i5, Class cls, int i6) {
        this(i5, cls, 0, i6);
    }

    ViewCompat$f(int i5, Class cls, int i6, int i7) {
        this.f7155a = i5;
        this.f7156b = cls;
        this.f7158d = i6;
        this.f7157c = i7;
    }

    private boolean b() {
        return Build.VERSION.SDK_INT >= this.f7157c;
    }

    boolean a(Boolean bool, Boolean bool2) {
        return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
    }

    abstract Object c(View view);

    abstract void d(View view, Object obj);

    Object e(View view) {
        if (b()) {
            return c(view);
        }
        Object tag = view.getTag(this.f7155a);
        if (this.f7156b.isInstance(tag)) {
            return tag;
        }
        return null;
    }

    void f(View view, Object obj) {
        if (b()) {
            d(view, obj);
        } else if (g(e(view), obj)) {
            ViewCompat.ensureAccessibilityDelegateCompat(view);
            view.setTag(this.f7155a, obj);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, this.f7158d);
        }
    }

    abstract boolean g(Object obj, Object obj2);
}
