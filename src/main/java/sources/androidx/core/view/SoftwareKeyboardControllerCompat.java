package androidx.core.view;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class SoftwareKeyboardControllerCompat {
    private final c mImpl;

    /* JADX INFO: Access modifiers changed from: private */
    static class a extends c {

        /* renamed from: a, reason: collision with root package name */
        private final View f7151a;

        a(View view) {
            this.f7151a = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(View view) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.c
        void a() {
            View view = this.f7151a;
            if (view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f7151a.getWindowToken(), 0);
            }
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.c
        void b() {
            final View view = this.f7151a;
            if (view == null) {
                return;
            }
            if (view.isInEditMode() || view.onCheckIsTextEditor()) {
                view.requestFocus();
            } else {
                view = view.getRootView().findFocus();
            }
            if (view == null) {
                view = this.f7151a.getRootView().findViewById(R.id.content);
            }
            if (view == null || !view.hasWindowFocus()) {
                return;
            }
            view.post(new Runnable() { // from class: androidx.core.view.y
                @Override // java.lang.Runnable
                public final void run() {
                    SoftwareKeyboardControllerCompat.a.d(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b extends a {

        /* renamed from: b, reason: collision with root package name */
        private View f7152b;

        /* renamed from: c, reason: collision with root package name */
        private WindowInsetsController f7153c;

        b(View view) {
            super(view);
            this.f7152b = view;
        }

        b(WindowInsetsController windowInsetsController) {
            super(null);
            this.f7153c = windowInsetsController;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(AtomicBoolean atomicBoolean, WindowInsetsController windowInsetsController, int i5) {
            atomicBoolean.set((i5 & 8) != 0);
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.a, androidx.core.view.SoftwareKeyboardControllerCompat.c
        void a() {
            int ime;
            View view;
            WindowInsetsController windowInsetsController = this.f7153c;
            if (windowInsetsController == null) {
                View view2 = this.f7152b;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController == null) {
                super.a();
                return;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListener = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.f0
                @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController2, int i5) {
                    SoftwareKeyboardControllerCompat.b.f(atomicBoolean, windowInsetsController2, i5);
                }
            };
            windowInsetsController.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
            if (!atomicBoolean.get() && (view = this.f7152b) != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f7152b.getWindowToken(), 0);
            }
            windowInsetsController.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
            ime = WindowInsets.Type.ime();
            e0.a(windowInsetsController, ime);
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.a, androidx.core.view.SoftwareKeyboardControllerCompat.c
        void b() {
            int ime;
            View view = this.f7152b;
            if (view != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = this.f7153c;
            if (windowInsetsController == null) {
                View view2 = this.f7152b;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController != null) {
                ime = WindowInsets.Type.ime();
                b0.a(windowInsetsController, ime);
            }
            super.b();
        }
    }

    private static class c {
        c() {
        }

        abstract void a();

        abstract void b();
    }

    public SoftwareKeyboardControllerCompat(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new b(view);
        } else {
            this.mImpl = new a(view);
        }
    }

    @Deprecated
    SoftwareKeyboardControllerCompat(WindowInsetsController windowInsetsController) {
        this.mImpl = new b(windowInsetsController);
    }

    public void hide() {
        this.mImpl.a();
    }

    public void show() {
        this.mImpl.b();
    }
}
