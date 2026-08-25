package com.transsion.postdetail.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l {
    private View a;
    private int b;
    private a c;
    private final ViewTreeObserver.OnGlobalLayoutListener d = new b();

    public interface a {
        void a(int i);

        void b(int i);
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (l.this.a == null) {
                View view = l.this.a;
                Intrinsics.e(view);
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                return;
            }
            Rect rect = new Rect();
            View view2 = l.this.a;
            Intrinsics.e(view2);
            view2.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (l.this.c() == 0) {
                l.this.e(height);
                return;
            }
            if (l.this.c() == height) {
                return;
            }
            if (l.this.c() - height > 200) {
                if (l.this.c != null) {
                    a aVar = l.this.c;
                    Intrinsics.e(aVar);
                    aVar.b(l.this.c() - height);
                }
                l.this.e(height);
                return;
            }
            if (height - l.this.c() > 200) {
                if (l.this.c != null) {
                    a aVar2 = l.this.c;
                    Intrinsics.e(aVar2);
                    aVar2.a(height - l.this.c());
                }
                l.this.e(height);
            }
        }
    }

    public final int c() {
        return this.b;
    }

    public final void d(Activity activity, a aVar) {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        Window window;
        this.c = aVar;
        View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
        this.a = decorView;
        if (aVar == null) {
            if (decorView == null || (viewTreeObserver2 = decorView.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver2.removeOnGlobalLayoutListener(this.d);
            return;
        }
        if (decorView == null || (viewTreeObserver = decorView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(this.d);
    }

    public final void e(int i) {
        this.b = i;
    }
}
