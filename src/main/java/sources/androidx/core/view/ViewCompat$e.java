package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ViewCompat$e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final WeakHashMap f7154a = new WeakHashMap();

    ViewCompat$e() {
    }

    private void b(Map.Entry entry) {
        View view = (View) entry.getKey();
        boolean booleanValue = ((Boolean) entry.getValue()).booleanValue();
        boolean z5 = view.isShown() && view.getWindowVisibility() == 0;
        if (booleanValue != z5) {
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, z5 ? 16 : 32);
            entry.setValue(Boolean.valueOf(z5));
        }
    }

    private void c(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    private void e(View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    void a(View view) {
        this.f7154a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
        view.addOnAttachStateChangeListener(this);
        if (view.isAttachedToWindow()) {
            c(view);
        }
    }

    void d(View view) {
        this.f7154a.remove(view);
        view.removeOnAttachStateChangeListener(this);
        e(view);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (Build.VERSION.SDK_INT < 28) {
            Iterator it = this.f7154a.entrySet().iterator();
            while (it.hasNext()) {
                b((Map.Entry) it.next());
            }
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        c(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}
