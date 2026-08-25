package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class r0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: k, reason: collision with root package name */
    private static r0 f1106k;

    /* renamed from: l, reason: collision with root package name */
    private static r0 f1107l;

    /* renamed from: a, reason: collision with root package name */
    private final View f1108a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f1109b;

    /* renamed from: c, reason: collision with root package name */
    private final int f1110c;

    /* renamed from: d, reason: collision with root package name */
    private final Runnable f1111d = new Runnable() { // from class: androidx.appcompat.widget.p0
        @Override // java.lang.Runnable
        public final void run() {
            r0.this.e();
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f1112e = new Runnable() { // from class: androidx.appcompat.widget.q0
        @Override // java.lang.Runnable
        public final void run() {
            r0.this.d();
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private int f1113f;

    /* renamed from: g, reason: collision with root package name */
    private int f1114g;

    /* renamed from: h, reason: collision with root package name */
    private s0 f1115h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1116i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1117j;

    private r0(View view, CharSequence charSequence) {
        this.f1108a = view;
        this.f1109b = charSequence;
        this.f1110c = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void b() {
        this.f1108a.removeCallbacks(this.f1111d);
    }

    private void c() {
        this.f1117j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        i(false);
    }

    private void f() {
        this.f1108a.postDelayed(this.f1111d, ViewConfiguration.getLongPressTimeout());
    }

    private static void g(r0 r0Var) {
        r0 r0Var2 = f1106k;
        if (r0Var2 != null) {
            r0Var2.b();
        }
        f1106k = r0Var;
        if (r0Var != null) {
            r0Var.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        r0 r0Var = f1106k;
        if (r0Var != null && r0Var.f1108a == view) {
            g(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new r0(view, charSequence);
            return;
        }
        r0 r0Var2 = f1107l;
        if (r0Var2 != null && r0Var2.f1108a == view) {
            r0Var2.d();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private boolean j(MotionEvent motionEvent) {
        int x5 = (int) motionEvent.getX();
        int y5 = (int) motionEvent.getY();
        if (!this.f1117j && Math.abs(x5 - this.f1113f) <= this.f1110c && Math.abs(y5 - this.f1114g) <= this.f1110c) {
            return false;
        }
        this.f1113f = x5;
        this.f1114g = y5;
        this.f1117j = false;
        return true;
    }

    void d() {
        if (f1107l == this) {
            f1107l = null;
            s0 s0Var = this.f1115h;
            if (s0Var != null) {
                s0Var.c();
                this.f1115h = null;
                c();
                this.f1108a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1106k == this) {
            g(null);
        }
        this.f1108a.removeCallbacks(this.f1112e);
    }

    void i(boolean z5) {
        long longPressTimeout;
        long j5;
        long j6;
        if (this.f1108a.isAttachedToWindow()) {
            g(null);
            r0 r0Var = f1107l;
            if (r0Var != null) {
                r0Var.d();
            }
            f1107l = this;
            this.f1116i = z5;
            s0 s0Var = new s0(this.f1108a.getContext());
            this.f1115h = s0Var;
            s0Var.e(this.f1108a, this.f1113f, this.f1114g, this.f1116i, this.f1109b);
            this.f1108a.addOnAttachStateChangeListener(this);
            if (this.f1116i) {
                j6 = 2500;
            } else {
                if ((ViewCompat.getWindowSystemUiVisibility(this.f1108a) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j5 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j5 = 15000;
                }
                j6 = j5 - longPressTimeout;
            }
            this.f1108a.removeCallbacks(this.f1112e);
            this.f1108a.postDelayed(this.f1112e, j6);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1115h != null && this.f1116i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1108a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f1108a.isEnabled() && this.f1115h == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1113f = view.getWidth() / 2;
        this.f1114g = view.getHeight() / 2;
        i(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        d();
    }
}
