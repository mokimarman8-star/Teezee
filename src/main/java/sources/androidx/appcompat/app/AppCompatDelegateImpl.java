package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.b;
import androidx.appcompat.view.g;
import androidx.appcompat.view.menu.d;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.j0;
import androidx.appcompat.widget.s;
import androidx.appcompat.widget.t0;
import androidx.appcompat.widget.u0;
import androidx.collection.x0;
import androidx.core.app.n;
import androidx.core.os.i;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.KeyEventDispatcher$Component;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.u;
import java.util.Locale;
import org.mvel2.ast.ASTNode;
import org.xmlpull.v1.XmlPullParser;
import y0.h;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
class AppCompatDelegateImpl extends f implements f.a, LayoutInflater.Factory2 {
    private static final x0 j0 = new x0();
    private static final boolean k0 = false;
    private static final int[] l0 = {R.attr.windowBackground};
    private static final boolean m0 = !"robolectric".equals(Build.FINGERPRINT);
    private boolean A;
    ViewGroup B;
    private TextView C;
    private View D;
    private boolean E;
    private boolean F;
    boolean G;
    boolean H;
    boolean I;
    boolean J;
    boolean K;
    private boolean L;
    private PanelFeatureState[] M;
    private PanelFeatureState N;
    private boolean O;
    private boolean P;
    private boolean Q;
    boolean R;
    private Configuration S;
    private int T;
    private int U;
    private int V;
    private boolean W;
    private n X;
    private n Y;
    boolean Z;
    int a0;
    private final Runnable b0;
    private boolean c0;
    private Rect d0;
    private Rect e0;
    private x f0;
    private y g0;
    private OnBackInvokedDispatcher h0;
    private OnBackInvokedCallback i0;
    final Object j;
    final Context k;
    Window l;
    private l m;
    final d n;
    a o;
    MenuInflater p;
    private CharSequence q;
    private s r;
    private f s;
    private q t;
    b u;
    ActionBarContextView v;
    PopupWindow w;
    Runnable x;
    ViewPropertyAnimatorCompat y;
    private boolean z;

    protected static final class PanelFeatureState {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        f j;
        d k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        PanelFeatureState(int i) {
            this.a = i;
        }

        m a(l.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                d dVar = new d(this.l, R$layout.abc_list_menu_item_layout);
                this.k = dVar;
                dVar.d(aVar);
                this.j.b(this.k);
            }
            return this.k.l(this.g);
        }

        public boolean b() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.a().getCount() > 0;
        }

        void c(f fVar) {
            d dVar;
            f fVar2 = this.j;
            if (fVar == fVar2) {
                return;
            }
            if (fVar2 != null) {
                fVar2.R(this.k);
            }
            this.j = fVar;
            if (fVar == null || (dVar = this.k) == null) {
                return;
            }
            fVar.b(dVar);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                newTheme.applyStyle(i, true);
            }
            newTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            } else {
                newTheme.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(R$styleable.AppCompatTheme);
            this.b = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }
    }

    AppCompatDelegateImpl(Activity activity, d dVar) {
        this(activity, null, dVar, activity);
    }

    AppCompatDelegateImpl(Dialog dialog, d dVar) {
        this(dialog.getContext(), dialog.getWindow(), dVar, dialog);
    }

    private AppCompatDelegateImpl(Context context, Window window, d dVar, Object obj) {
        AppCompatActivity c1;
        this.y = null;
        this.z = true;
        this.T = -100;
        this.b0 = new Runnable() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.2
            @Override // java.lang.Runnable
            public void run() {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                if ((appCompatDelegateImpl.a0 & 1) != 0) {
                    appCompatDelegateImpl.l0(0);
                }
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                if ((appCompatDelegateImpl2.a0 & 4096) != 0) {
                    appCompatDelegateImpl2.l0(108);
                }
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.Z = false;
                appCompatDelegateImpl3.a0 = 0;
            }
        };
        this.k = context;
        this.n = dVar;
        this.j = obj;
        if (this.T == -100 && (obj instanceof Dialog) && (c1 = c1()) != null) {
            this.T = c1.getDelegate().r();
        }
        if (this.T == -100) {
            x0 x0Var = j0;
            Integer num = (Integer) x0Var.get(obj.getClass().getName());
            if (num != null) {
                this.T = num.intValue();
                x0Var.remove(obj.getClass().getName());
            }
        }
        if (window != null) {
            Z(window);
        }
        androidx.appcompat.widget.f.h();
    }

    private boolean A0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.i;
        if (view != null) {
            panelFeatureState.h = view;
            return true;
        }
        if (panelFeatureState.j == null) {
            return false;
        }
        if (this.t == null) {
            this.t = new q(this);
        }
        View a = panelFeatureState.a(this.t);
        panelFeatureState.h = a;
        return a != null;
    }

    private boolean B0(PanelFeatureState panelFeatureState) {
        panelFeatureState.d(r0());
        panelFeatureState.g = new p(this, panelFeatureState.l);
        panelFeatureState.c = 81;
        return true;
    }

    private boolean C0(PanelFeatureState panelFeatureState) {
        Resources.Theme theme;
        Context context = this.k;
        int i = panelFeatureState.a;
        if ((i == 0 || i == 108) && this.r != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme2 = context.getTheme();
            theme2.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme = context.getResources().newTheme();
                theme.setTo(theme2);
                theme.applyStyle(typedValue.resourceId, true);
                theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme2.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
                theme = null;
            }
            if (typedValue.resourceId != 0) {
                if (theme == null) {
                    theme = context.getResources().newTheme();
                    theme.setTo(theme2);
                }
                theme.applyStyle(typedValue.resourceId, true);
            }
            if (theme != null) {
                Context dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(theme);
                context = dVar;
            }
        }
        f fVar = new f(context);
        fVar.W(this);
        panelFeatureState.c(fVar);
        return true;
    }

    private void D0(int i) {
        this.a0 = (1 << i) | this.a0;
        if (this.Z) {
            return;
        }
        ViewCompat.postOnAnimation(this.l.getDecorView(), this.b0);
        this.Z = true;
    }

    private boolean I0(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState w0 = w0(i, true);
        if (w0.o) {
            return false;
        }
        return S0(w0, keyEvent);
    }

    private boolean L0(int i, KeyEvent keyEvent) {
        boolean z;
        s sVar;
        if (this.u != null) {
            return false;
        }
        boolean z2 = true;
        PanelFeatureState w0 = w0(i, true);
        if (i != 0 || (sVar = this.r) == null || !sVar.canShowOverflowMenu() || ViewConfiguration.get(this.k).hasPermanentMenuKey()) {
            boolean z3 = w0.o;
            if (z3 || w0.n) {
                g0(w0, true);
                z2 = z3;
            } else {
                if (w0.m) {
                    if (w0.r) {
                        w0.m = false;
                        z = S0(w0, keyEvent);
                    } else {
                        z = true;
                    }
                    if (z) {
                        P0(w0, keyEvent);
                    }
                }
                z2 = false;
            }
        } else if (this.r.isOverflowMenuShowing()) {
            z2 = this.r.hideOverflowMenu();
        } else {
            if (!this.R && S0(w0, keyEvent)) {
                z2 = this.r.showOverflowMenu();
            }
            z2 = false;
        }
        if (z2) {
            AudioManager audioManager = (AudioManager) this.k.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void P0(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r12, android.view.KeyEvent r13) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.P0(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    private boolean R0(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        f fVar;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.m || S0(panelFeatureState, keyEvent)) && (fVar = panelFeatureState.j) != null) {
            z = fVar.performShortcut(i, keyEvent, i2);
        }
        if (z && (i2 & 1) == 0 && this.r == null) {
            g0(panelFeatureState, true);
        }
        return z;
    }

    private boolean S0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        s sVar;
        s sVar2;
        s sVar3;
        if (this.R) {
            return false;
        }
        if (panelFeatureState.m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.N;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            g0(panelFeatureState2, false);
        }
        Window.Callback y0 = y0();
        if (y0 != null) {
            panelFeatureState.i = y0.onCreatePanelView(panelFeatureState.a);
        }
        int i = panelFeatureState.a;
        boolean z = i == 0 || i == 108;
        if (z && (sVar3 = this.r) != null) {
            sVar3.setMenuPrepared();
        }
        if (panelFeatureState.i == null && (!z || !(Q0() instanceof ToolbarActionBar))) {
            f fVar = panelFeatureState.j;
            if (fVar == null || panelFeatureState.r) {
                if (fVar == null && (!C0(panelFeatureState) || panelFeatureState.j == null)) {
                    return false;
                }
                if (z && this.r != null) {
                    if (this.s == null) {
                        this.s = new f(this);
                    }
                    this.r.setMenu(panelFeatureState.j, this.s);
                }
                panelFeatureState.j.i0();
                if (!y0.onCreatePanelMenu(panelFeatureState.a, panelFeatureState.j)) {
                    panelFeatureState.c(null);
                    if (z && (sVar = this.r) != null) {
                        sVar.setMenu((Menu) null, this.s);
                    }
                    return false;
                }
                panelFeatureState.r = false;
            }
            panelFeatureState.j.i0();
            Bundle bundle = panelFeatureState.s;
            if (bundle != null) {
                panelFeatureState.j.S(bundle);
                panelFeatureState.s = null;
            }
            if (!y0.onPreparePanel(0, panelFeatureState.i, panelFeatureState.j)) {
                if (z && (sVar2 = this.r) != null) {
                    sVar2.setMenu((Menu) null, this.s);
                }
                panelFeatureState.j.h0();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.p = z2;
            panelFeatureState.j.setQwertyMode(z2);
            panelFeatureState.j.h0();
        }
        panelFeatureState.m = true;
        panelFeatureState.n = false;
        this.N = panelFeatureState;
        return true;
    }

    private void T0(boolean z) {
        s sVar = this.r;
        if (sVar == null || !sVar.canShowOverflowMenu() || (ViewConfiguration.get(this.k).hasPermanentMenuKey() && !this.r.isOverflowMenuShowPending())) {
            PanelFeatureState w0 = w0(0, true);
            w0.q = true;
            g0(w0, false);
            P0(w0, null);
            return;
        }
        Window.Callback y0 = y0();
        if (this.r.isOverflowMenuShowing() && z) {
            this.r.hideOverflowMenu();
            if (this.R) {
                return;
            }
            y0.onPanelClosed(108, w0(0, true).j);
            return;
        }
        if (y0 == null || this.R) {
            return;
        }
        if (this.Z && (this.a0 & 1) != 0) {
            this.l.getDecorView().removeCallbacks(this.b0);
            this.b0.run();
        }
        PanelFeatureState w02 = w0(0, true);
        f fVar = w02.j;
        if (fVar == null || w02.r || !y0.onPreparePanel(0, w02.i, fVar)) {
            return;
        }
        y0.onMenuOpened(108, w02.j);
        this.r.showOverflowMenu();
    }

    private int U0(int i) {
        if (i == 8) {
            return 108;
        }
        if (i == 9) {
            return 109;
        }
        return i;
    }

    private boolean W(boolean z) {
        return X(z, true);
    }

    private boolean X(boolean z, boolean z2) {
        if (this.R) {
            return false;
        }
        int b0 = b0();
        int F0 = F0(this.k, b0);
        i a0 = Build.VERSION.SDK_INT < 33 ? a0(this.k) : null;
        if (!z2 && a0 != null) {
            a0 = v0(this.k.getResources().getConfiguration());
        }
        boolean e1 = e1(F0, a0, z);
        if (b0 == 0) {
            u0(this.k).e();
        } else {
            n nVar = this.X;
            if (nVar != null) {
                nVar.a();
            }
        }
        if (b0 == 3) {
            t0(this.k).e();
        } else {
            n nVar2 = this.Y;
            if (nVar2 != null) {
                nVar2.a();
            }
        }
        return e1;
    }

    private void Y() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.B.findViewById(R.id.content);
        View decorView = this.l.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.k.obtainStyledAttributes(R$styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private boolean Y0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.l.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ((View) viewParent).isAttachedToWindow()) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private void Z(Window window) {
        if (this.l != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof l) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        l lVar = new l(this, callback);
        this.m = lVar;
        window.setCallback(lVar);
        j0 u = j0.u(this.k, (AttributeSet) null, l0);
        Drawable h = u.h(0);
        if (h != null) {
            window.setBackgroundDrawable(h);
        }
        u.x();
        this.l = window;
        if (Build.VERSION.SDK_INT < 33 || this.h0 != null) {
            return;
        }
        P(null);
    }

    private int b0() {
        int i = this.T;
        return i != -100 ? i : f.p();
    }

    private void b1() {
        if (this.A) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private AppCompatActivity c1() {
        for (Context context = this.k; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private void d1(Configuration configuration) {
        u uVar = (Activity) this.j;
        if (uVar instanceof u) {
            if (uVar.getLifecycle().b().isAtLeast(Lifecycle.State.CREATED)) {
                uVar.onConfigurationChanged(configuration);
            }
        } else {
            if (!this.Q || this.R) {
                return;
            }
            uVar.onConfigurationChanged(configuration);
        }
    }

    private void e0() {
        n nVar = this.X;
        if (nVar != null) {
            nVar.a();
        }
        n nVar2 = this.Y;
        if (nVar2 != null) {
            nVar2.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean e1(int r10, androidx.core.os.i r11, boolean r12) {
        /*
            r9 = this;
            android.content.Context r1 = r9.k
            r4 = 0
            r5 = 0
            r0 = r9
            r2 = r10
            r3 = r11
            android.content.res.Configuration r0 = r0.h0(r1, r2, r3, r4, r5)
            android.content.Context r1 = r9.k
            int r1 = r9.s0(r1)
            android.content.res.Configuration r2 = r9.S
            if (r2 != 0) goto L1f
            android.content.Context r2 = r9.k
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
        L1f:
            int r3 = r2.uiMode
            r3 = r3 & 48
            int r4 = r0.uiMode
            r4 = r4 & 48
            androidx.core.os.i r2 = r9.v0(r2)
            r5 = 0
            if (r11 != 0) goto L30
            r6 = r5
            goto L34
        L30:
            androidx.core.os.i r6 = r9.v0(r0)
        L34:
            r7 = 0
            if (r3 == r4) goto L3a
            r3 = 512(0x200, float:7.175E-43)
            goto L3b
        L3a:
            r3 = r7
        L3b:
            if (r6 == 0) goto L45
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L45
            r3 = r3 | 8196(0x2004, float:1.1485E-41)
        L45:
            int r2 = ~r1
            r2 = r2 & r3
            r8 = 1
            if (r2 == 0) goto L8c
            if (r12 == 0) goto L8c
            boolean r12 = r9.P
            if (r12 == 0) goto L8c
            boolean r12 = androidx.appcompat.app.AppCompatDelegateImpl.m0
            if (r12 != 0) goto L58
            boolean r12 = r9.Q
            if (r12 == 0) goto L8c
        L58:
            java.lang.Object r12 = r9.j
            boolean r2 = r12 instanceof android.app.Activity
            if (r2 == 0) goto L8c
            android.app.Activity r12 = (android.app.Activity) r12
            boolean r12 = r12.isChild()
            if (r12 != 0) goto L8c
            int r12 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r12 < r2) goto L83
            r12 = r3 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L83
            java.lang.Object r12 = r9.j
            android.app.Activity r12 = (android.app.Activity) r12
            android.view.Window r12 = r12.getWindow()
            android.view.View r12 = r12.getDecorView()
            int r0 = r0.getLayoutDirection()
            r12.setLayoutDirection(r0)
        L83:
            java.lang.Object r12 = r9.j
            android.app.Activity r12 = (android.app.Activity) r12
            androidx.core.app.ActivityCompat.f(r12)
            r12 = r8
            goto L8d
        L8c:
            r12 = r7
        L8d:
            if (r12 != 0) goto L9a
            if (r3 == 0) goto L9a
            r12 = r3 & r1
            if (r12 != r3) goto L96
            r7 = r8
        L96:
            r9.g1(r4, r6, r7, r5)
            goto L9b
        L9a:
            r8 = r12
        L9b:
            if (r8 == 0) goto Lb7
            java.lang.Object r12 = r9.j
            boolean r0 = r12 instanceof androidx.appcompat.app.AppCompatActivity
            if (r0 == 0) goto Lb7
            r0 = r3 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto Lac
            androidx.appcompat.app.AppCompatActivity r12 = (androidx.appcompat.app.AppCompatActivity) r12
            r12.onNightModeChanged(r10)
        Lac:
            r10 = r3 & 4
            if (r10 == 0) goto Lb7
            java.lang.Object r10 = r9.j
            androidx.appcompat.app.AppCompatActivity r10 = (androidx.appcompat.app.AppCompatActivity) r10
            r10.onLocalesChanged(r11)
        Lb7:
            if (r6 == 0) goto Lca
            android.content.Context r10 = r9.k
            android.content.res.Resources r10 = r10.getResources()
            android.content.res.Configuration r10 = r10.getConfiguration()
            androidx.core.os.i r10 = r9.v0(r10)
            r9.W0(r10)
        Lca:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.e1(int, androidx.core.os.i, boolean):boolean");
    }

    private void g1(int i, i iVar, boolean z, Configuration configuration) {
        Resources resources = this.k.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i | (resources.getConfiguration().uiMode & (-49));
        if (iVar != null) {
            V0(configuration2, iVar);
        }
        resources.updateConfiguration(configuration2, null);
        if (Build.VERSION.SDK_INT < 26) {
            a0.a(resources);
        }
        int i2 = this.U;
        if (i2 != 0) {
            this.k.setTheme(i2);
            this.k.getTheme().applyStyle(this.U, true);
        }
        if (z && (this.j instanceof Activity)) {
            d1(configuration2);
        }
    }

    private Configuration h0(Context context, int i, i iVar, Configuration configuration, boolean z) {
        int i2 = i != 1 ? i != 2 ? z ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        if (iVar != null) {
            V0(configuration2, iVar);
        }
        return configuration2;
    }

    private ViewGroup i0() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.k.obtainStyledAttributes(R$styleable.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
            K(1);
        } else if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBar, false)) {
            K(108);
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            K(109);
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            K(10);
        }
        this.J = obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        o0();
        this.l.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.k);
        if (this.K) {
            viewGroup = this.I ? (ViewGroup) from.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(R$layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.J) {
            viewGroup = (ViewGroup) from.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
            this.H = false;
            this.G = false;
        } else if (this.G) {
            TypedValue typedValue = new TypedValue();
            this.k.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new androidx.appcompat.view.d(this.k, typedValue.resourceId) : this.k).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
            s findViewById = viewGroup.findViewById(R$id.decor_content_parent);
            this.r = findViewById;
            findViewById.setWindowCallback(y0());
            if (this.H) {
                this.r.initFeature(109);
            }
            if (this.E) {
                this.r.initFeature(2);
            }
            if (this.F) {
                this.r.initFeature(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.G + ", windowActionBarOverlay: " + this.H + ", android:windowIsFloating: " + this.J + ", windowActionModeOverlay: " + this.I + ", windowNoTitle: " + this.K + " }");
        }
        ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new a(this));
        if (this.r == null) {
            this.C = (TextView) viewGroup.findViewById(R$id.title);
        }
        u0.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.l.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.l.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new b(this));
        return viewGroup;
    }

    private void i1(View view) {
        view.setBackgroundColor((ViewCompat.getWindowSystemUiVisibility(view) & 8192) != 0 ? androidx.core.content.b.getColor(this.k, androidx.appcompat.R.color.abc_decor_view_status_guard_light) : androidx.core.content.b.getColor(this.k, androidx.appcompat.R.color.abc_decor_view_status_guard));
    }

    private void n0() {
        if (this.A) {
            return;
        }
        this.B = i0();
        CharSequence x0 = x0();
        if (!TextUtils.isEmpty(x0)) {
            s sVar = this.r;
            if (sVar != null) {
                sVar.setWindowTitle(x0);
            } else if (Q0() != null) {
                Q0().u(x0);
            } else {
                TextView textView = this.C;
                if (textView != null) {
                    textView.setText(x0);
                }
            }
        }
        Y();
        O0(this.B);
        this.A = true;
        PanelFeatureState w0 = w0(0, false);
        if (this.R) {
            return;
        }
        if (w0 == null || w0.j == null) {
            D0(108);
        }
    }

    private void o0() {
        if (this.l == null) {
            Object obj = this.j;
            if (obj instanceof Activity) {
                Z(((Activity) obj).getWindow());
            }
        }
        if (this.l == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration q0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f = configuration.fontScale;
            float f2 = configuration2.fontScale;
            if (f != f2) {
                configuration3.fontScale = f2;
            }
            int i = configuration.mcc;
            int i2 = configuration2.mcc;
            if (i != i2) {
                configuration3.mcc = i2;
            }
            int i3 = configuration.mnc;
            int i4 = configuration2.mnc;
            if (i3 != i4) {
                configuration3.mnc = i4;
            }
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 24) {
                i.a(configuration, configuration2, configuration3);
            } else if (!androidx.core.util.d.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i7 = configuration.touchscreen;
            int i8 = configuration2.touchscreen;
            if (i7 != i8) {
                configuration3.touchscreen = i8;
            }
            int i9 = configuration.keyboard;
            int i10 = configuration2.keyboard;
            if (i9 != i10) {
                configuration3.keyboard = i10;
            }
            int i11 = configuration.keyboardHidden;
            int i12 = configuration2.keyboardHidden;
            if (i11 != i12) {
                configuration3.keyboardHidden = i12;
            }
            int i13 = configuration.navigation;
            int i14 = configuration2.navigation;
            if (i13 != i14) {
                configuration3.navigation = i14;
            }
            int i15 = configuration.navigationHidden;
            int i16 = configuration2.navigationHidden;
            if (i15 != i16) {
                configuration3.navigationHidden = i16;
            }
            int i17 = configuration.orientation;
            int i18 = configuration2.orientation;
            if (i17 != i18) {
                configuration3.orientation = i18;
            }
            int i19 = configuration.screenLayout & 15;
            int i20 = configuration2.screenLayout;
            if (i19 != (i20 & 15)) {
                configuration3.screenLayout |= i20 & 15;
            }
            int i21 = configuration.screenLayout & 192;
            int i22 = configuration2.screenLayout;
            if (i21 != (i22 & 192)) {
                configuration3.screenLayout |= i22 & 192;
            }
            int i23 = configuration.screenLayout & 48;
            int i24 = configuration2.screenLayout;
            if (i23 != (i24 & 48)) {
                configuration3.screenLayout |= i24 & 48;
            }
            int i25 = configuration.screenLayout & 768;
            int i26 = configuration2.screenLayout;
            if (i25 != (i26 & 768)) {
                configuration3.screenLayout |= i26 & 768;
            }
            if (i6 >= 26) {
                j.a(configuration, configuration2, configuration3);
            }
            int i27 = configuration.uiMode & 15;
            int i28 = configuration2.uiMode;
            if (i27 != (i28 & 15)) {
                configuration3.uiMode |= i28 & 15;
            }
            int i29 = configuration.uiMode & 48;
            int i30 = configuration2.uiMode;
            if (i29 != (i30 & 48)) {
                configuration3.uiMode |= i30 & 48;
            }
            int i31 = configuration.screenWidthDp;
            int i32 = configuration2.screenWidthDp;
            if (i31 != i32) {
                configuration3.screenWidthDp = i32;
            }
            int i33 = configuration.screenHeightDp;
            int i34 = configuration2.screenHeightDp;
            if (i33 != i34) {
                configuration3.screenHeightDp = i34;
            }
            int i35 = configuration.smallestScreenWidthDp;
            int i36 = configuration2.smallestScreenWidthDp;
            if (i35 != i36) {
                configuration3.smallestScreenWidthDp = i36;
            }
            int i37 = configuration.densityDpi;
            int i38 = configuration2.densityDpi;
            if (i37 != i38) {
                configuration3.densityDpi = i38;
            }
        }
        return configuration3;
    }

    private int s0(Context context) {
        if (!this.W && (this.j instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                int i = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.j.getClass()), i >= 29 ? 269221888 : i >= 24 ? 786432 : 0);
                if (activityInfo != null) {
                    this.V = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                this.V = 0;
            }
        }
        this.W = true;
        return this.V;
    }

    private n t0(Context context) {
        if (this.Y == null) {
            this.Y = new m(this, context);
        }
        return this.Y;
    }

    private n u0(Context context) {
        if (this.X == null) {
            this.X = new o(this, c0.a(context));
        }
        return this.X;
    }

    private void z0() {
        n0();
        if (this.G && this.o == null) {
            Object obj = this.j;
            if (obj instanceof Activity) {
                this.o = new d0((Activity) this.j, this.H);
            } else if (obj instanceof Dialog) {
                this.o = new d0((Dialog) this.j);
            }
            a aVar = this.o;
            if (aVar != null) {
                aVar.s(this.c0);
            }
        }
    }

    public void A(Configuration configuration) {
        a v;
        if (this.G && this.A && (v = v()) != null) {
            v.n(configuration);
        }
        androidx.appcompat.widget.f.b().g(this.k);
        this.S = new Configuration(this.k.getResources().getConfiguration());
        X(false, false);
    }

    public void B(Bundle bundle) {
        String str;
        this.P = true;
        W(false);
        o0();
        Object obj = this.j;
        if (obj instanceof Activity) {
            try {
                str = n.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                a Q0 = Q0();
                if (Q0 == null) {
                    this.c0 = true;
                } else {
                    Q0.s(true);
                }
            }
            f.d(this);
        }
        this.S = new Configuration(this.k.getResources().getConfiguration());
        this.Q = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.j
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            androidx.appcompat.app.f.I(r3)
        L9:
            boolean r0 = r3.Z
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.l
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.b0
            r0.removeCallbacks(r1)
        L18:
            r0 = 1
            r3.R = r0
            int r0 = r3.T
            r1 = -100
            if (r0 == r1) goto L45
            java.lang.Object r0 = r3.j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L45
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L45
            androidx.collection.x0 r0 = androidx.appcompat.app.AppCompatDelegateImpl.j0
            java.lang.Object r1 = r3.j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.T
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L54
        L45:
            androidx.collection.x0 r0 = androidx.appcompat.app.AppCompatDelegateImpl.j0
            java.lang.Object r1 = r3.j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L54:
            androidx.appcompat.app.a r0 = r3.o
            if (r0 == 0) goto L5b
            r0.o()
        L5b:
            r3.e0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.C():void");
    }

    public void D(Bundle bundle) {
        n0();
    }

    public void E() {
        a v = v();
        if (v != null) {
            v.t(true);
        }
    }

    public boolean E0() {
        return this.z;
    }

    public void F(Bundle bundle) {
    }

    int F0(Context context, int i) {
        if (i == -100) {
            return -1;
        }
        if (i != -1) {
            if (i == 0) {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return u0(context).c();
            }
            if (i != 1 && i != 2) {
                if (i == 3) {
                    return t0(context).c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i;
    }

    public void G() {
        X(true, false);
    }

    boolean G0() {
        boolean z = this.O;
        this.O = false;
        PanelFeatureState w0 = w0(0, false);
        if (w0 != null && w0.o) {
            if (!z) {
                g0(w0, true);
            }
            return true;
        }
        b bVar = this.u;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        a v = v();
        return v != null && v.h();
    }

    public void H() {
        a v = v();
        if (v != null) {
            v.t(false);
        }
    }

    boolean H0(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.O = (keyEvent.getFlags() & ASTNode.ASSIGN) != 0;
        } else if (i == 82) {
            I0(0, keyEvent);
            return true;
        }
        return false;
    }

    boolean J0(int i, KeyEvent keyEvent) {
        a v = v();
        if (v != null && v.p(i, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.N;
        if (panelFeatureState != null && R0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.N;
            if (panelFeatureState2 != null) {
                panelFeatureState2.n = true;
            }
            return true;
        }
        if (this.N == null) {
            PanelFeatureState w0 = w0(0, true);
            S0(w0, keyEvent);
            boolean R0 = R0(w0, keyEvent.getKeyCode(), keyEvent, 1);
            w0.m = false;
            if (R0) {
                return true;
            }
        }
        return false;
    }

    public boolean K(int i) {
        int U0 = U0(i);
        if (this.K && U0 == 108) {
            return false;
        }
        if (this.G && U0 == 1) {
            this.G = false;
        }
        if (U0 == 1) {
            b1();
            this.K = true;
            return true;
        }
        if (U0 == 2) {
            b1();
            this.E = true;
            return true;
        }
        if (U0 == 5) {
            b1();
            this.F = true;
            return true;
        }
        if (U0 == 10) {
            b1();
            this.I = true;
            return true;
        }
        if (U0 == 108) {
            b1();
            this.G = true;
            return true;
        }
        if (U0 != 109) {
            return this.l.requestFeature(U0);
        }
        b1();
        this.H = true;
        return true;
    }

    boolean K0(int i, KeyEvent keyEvent) {
        if (i != 4) {
            if (i == 82) {
                L0(0, keyEvent);
                return true;
            }
        } else if (G0()) {
            return true;
        }
        return false;
    }

    public void L(int i) {
        n0();
        ViewGroup viewGroup = (ViewGroup) this.B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.k).inflate(i, viewGroup);
        this.m.c(this.l.getCallback());
    }

    public void M(View view) {
        n0();
        ViewGroup viewGroup = (ViewGroup) this.B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.m.c(this.l.getCallback());
    }

    void M0(int i) {
        a v;
        if (i != 108 || (v = v()) == null) {
            return;
        }
        v.i(true);
    }

    public void N(View view, ViewGroup.LayoutParams layoutParams) {
        n0();
        ViewGroup viewGroup = (ViewGroup) this.B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.m.c(this.l.getCallback());
    }

    void N0(int i) {
        if (i == 108) {
            a v = v();
            if (v != null) {
                v.i(false);
                return;
            }
            return;
        }
        if (i == 0) {
            PanelFeatureState w0 = w0(i, true);
            if (w0.o) {
                g0(w0, false);
            }
        }
    }

    void O0(ViewGroup viewGroup) {
    }

    public void P(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.P(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.h0;
        if (onBackInvokedDispatcher2 != null && (onBackInvokedCallback = this.i0) != null) {
            k.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.i0 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.j;
            if ((obj instanceof Activity) && ((Activity) obj).getWindow() != null) {
                this.h0 = k.a((Activity) this.j);
                f1();
            }
        }
        this.h0 = onBackInvokedDispatcher;
        f1();
    }

    public void Q(Toolbar toolbar) {
        if (this.j instanceof Activity) {
            a v = v();
            if (v instanceof d0) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.p = null;
            if (v != null) {
                v.o();
            }
            this.o = null;
            if (toolbar != null) {
                ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, x0(), this.m);
                this.o = toolbarActionBar;
                this.m.e(toolbarActionBar.c);
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.m.e((e) null);
            }
            x();
        }
    }

    final a Q0() {
        return this.o;
    }

    public void R(int i) {
        this.U = i;
    }

    public final void S(CharSequence charSequence) {
        this.q = charSequence;
        s sVar = this.r;
        if (sVar != null) {
            sVar.setWindowTitle(charSequence);
            return;
        }
        if (Q0() != null) {
            Q0().u(charSequence);
            return;
        }
        TextView textView = this.C;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public b T(b.a aVar) {
        d dVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        b bVar = this.u;
        if (bVar != null) {
            bVar.c();
        }
        g gVar = new g(this, aVar);
        a v = v();
        if (v != null) {
            b v2 = v.v(gVar);
            this.u = v2;
            if (v2 != null && (dVar = this.n) != null) {
                dVar.onSupportActionModeStarted(v2);
            }
        }
        if (this.u == null) {
            this.u = a1(gVar);
        }
        f1();
        return this.u;
    }

    void V0(Configuration configuration, i iVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            i.d(configuration, iVar);
        } else {
            configuration.setLocale(iVar.d(0));
            configuration.setLayoutDirection(iVar.d(0));
        }
    }

    void W0(i iVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            i.c(iVar);
        } else {
            Locale.setDefault(iVar.d(0));
        }
    }

    final boolean X0() {
        ViewGroup viewGroup;
        return this.A && (viewGroup = this.B) != null && viewGroup.isLaidOut();
    }

    boolean Z0() {
        if (this.h0 == null) {
            return false;
        }
        PanelFeatureState w0 = w0(0, false);
        return (w0 != null && w0.o) || this.u != null;
    }

    public boolean a(f fVar, MenuItem menuItem) {
        PanelFeatureState p0;
        Window.Callback y0 = y0();
        if (y0 == null || this.R || (p0 = p0(fVar.F())) == null) {
            return false;
        }
        return y0.onMenuItemSelected(p0.a, menuItem);
    }

    i a0(Context context) {
        i u;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 || (u = f.u()) == null) {
            return null;
        }
        i v0 = v0(context.getApplicationContext().getResources().getConfiguration());
        i b = i >= 24 ? z.b(u, v0) : u.f() ? i.e() : i.c(h.b(u.d(0)));
        return b.f() ? v0 : b;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.appcompat.view.b a1(androidx.appcompat.view.b.a r8) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.a1(androidx.appcompat.view.b$a):androidx.appcompat.view.b");
    }

    public void b(f fVar) {
        T0(true);
    }

    void c0(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.M;
                if (i < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.o) && !this.R) {
            this.m.d(this.l.getCallback(), i, menu);
        }
    }

    void d0(f fVar) {
        if (this.L) {
            return;
        }
        this.L = true;
        this.r.dismissPopups();
        Window.Callback y0 = y0();
        if (y0 != null && !this.R) {
            y0.onPanelClosed(108, fVar);
        }
        this.L = false;
    }

    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        n0();
        ((ViewGroup) this.B.findViewById(R.id.content)).addView(view, layoutParams);
        this.m.c(this.l.getCallback());
    }

    public boolean f() {
        return W(true);
    }

    void f0(int i) {
        g0(w0(i, true), true);
    }

    void f1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean Z0 = Z0();
            if (Z0 && this.i0 == null) {
                this.i0 = k.b(this.h0, this);
            } else {
                if (Z0 || (onBackInvokedCallback = this.i0) == null) {
                    return;
                }
                k.c(this.h0, onBackInvokedCallback);
                this.i0 = null;
            }
        }
    }

    void g0(PanelFeatureState panelFeatureState, boolean z) {
        ViewGroup viewGroup;
        s sVar;
        if (z && panelFeatureState.a == 0 && (sVar = this.r) != null && sVar.isOverflowMenuShowing()) {
            d0(panelFeatureState.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.k.getSystemService("window");
        if (windowManager != null && panelFeatureState.o && (viewGroup = panelFeatureState.g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                c0(panelFeatureState.a, panelFeatureState, null);
            }
        }
        panelFeatureState.m = false;
        panelFeatureState.n = false;
        panelFeatureState.o = false;
        panelFeatureState.h = null;
        panelFeatureState.q = true;
        if (this.N == panelFeatureState) {
            this.N = null;
        }
        if (panelFeatureState.a == 0) {
            f1();
        }
    }

    final int h1(WindowInsetsCompat windowInsetsCompat, Rect rect) {
        boolean z;
        boolean z2;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
            if (this.v.isShown()) {
                if (this.d0 == null) {
                    this.d0 = new Rect();
                    this.e0 = new Rect();
                }
                Rect rect2 = this.d0;
                Rect rect3 = this.e0;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                }
                u0.a(this.B, rect2, rect3);
                int i = rect2.top;
                int i2 = rect2.left;
                int i3 = rect2.right;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.B);
                int systemWindowInsetLeft = rootWindowInsets == null ? 0 : rootWindowInsets.getSystemWindowInsetLeft();
                int systemWindowInsetRight = rootWindowInsets == null ? 0 : rootWindowInsets.getSystemWindowInsetRight();
                if (marginLayoutParams.topMargin == i && marginLayoutParams.leftMargin == i2 && marginLayoutParams.rightMargin == i3) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i;
                    marginLayoutParams.leftMargin = i2;
                    marginLayoutParams.rightMargin = i3;
                    z2 = true;
                }
                if (i <= 0 || this.D != null) {
                    View view = this.D;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i4 = marginLayoutParams2.height;
                        int i6 = marginLayoutParams.topMargin;
                        if (i4 != i6 || marginLayoutParams2.leftMargin != systemWindowInsetLeft || marginLayoutParams2.rightMargin != systemWindowInsetRight) {
                            marginLayoutParams2.height = i6;
                            marginLayoutParams2.leftMargin = systemWindowInsetLeft;
                            marginLayoutParams2.rightMargin = systemWindowInsetRight;
                            this.D.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.k);
                    this.D = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = systemWindowInsetLeft;
                    layoutParams.rightMargin = systemWindowInsetRight;
                    this.B.addView(this.D, -1, layoutParams);
                }
                View view3 = this.D;
                r5 = view3 != null;
                if (r5 && view3.getVisibility() != 0) {
                    i1(this.D);
                }
                if (!this.I && r5) {
                    systemWindowInsetTop = 0;
                }
                z = r5;
                r5 = z2;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                r5 = false;
            }
            if (r5) {
                this.v.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.D;
        if (view4 != null) {
            view4.setVisibility(z ? 0 : 8);
        }
        return systemWindowInsetTop;
    }

    public Context i(Context context) {
        this.P = true;
        int F0 = F0(context, b0());
        if (f.y(context)) {
            f.V(context);
        }
        i a0 = a0(context);
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(h0(context, F0, a0, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.d) {
            try {
                ((androidx.appcompat.view.d) context).a(h0(context, F0, a0, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!m0) {
            return super.i(context);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = context.createConfigurationContext(configuration).getResources().getConfiguration();
        Configuration configuration3 = context.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration h0 = h0(context, F0, a0, !configuration2.equals(configuration3) ? q0(configuration2, configuration3) : null, true);
        androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, R$style.Theme_AppCompat_Empty);
        dVar.a(h0);
        try {
            if (context.getTheme() != null) {
                h.f.a(dVar.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.i(dVar);
    }

    void j0() {
        f fVar;
        s sVar = this.r;
        if (sVar != null) {
            sVar.dismissPopups();
        }
        if (this.w != null) {
            this.l.getDecorView().removeCallbacks(this.x);
            if (this.w.isShowing()) {
                try {
                    this.w.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.w = null;
        }
        m0();
        PanelFeatureState w0 = w0(0, false);
        if (w0 == null || (fVar = w0.j) == null) {
            return;
        }
        fVar.close();
    }

    boolean k0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.j;
        if (((obj instanceof KeyEventDispatcher$Component) || (obj instanceof w)) && (decorView = this.l.getDecorView()) != null && KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.m.b(this.l.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? H0(keyCode, keyEvent) : K0(keyCode, keyEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View l(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        if (this.f0 == null) {
            TypedArray obtainStyledAttributes = this.k.obtainStyledAttributes(R$styleable.AppCompatTheme);
            String string = obtainStyledAttributes.getString(R$styleable.AppCompatTheme_viewInflaterClass);
            obtainStyledAttributes.recycle();
            if (string == null) {
                this.f0 = new x();
            } else {
                try {
                    this.f0 = (x) this.k.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to instantiate custom view inflater ");
                    sb.append(string);
                    sb.append(". Falling back to default.");
                    this.f0 = new x();
                }
            }
        }
        boolean z2 = k0;
        boolean z3 = false;
        if (z2) {
            if (this.g0 == null) {
                this.g0 = new y();
            }
            if (this.g0.a(attributeSet)) {
                z = true;
                return this.f0.r(view, str, context, attributeSet, z, z2, true, t0.c());
            }
            if (!(attributeSet instanceof XmlPullParser)) {
                z3 = Y0((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z3 = true;
            }
        }
        z = z3;
        return this.f0.r(view, str, context, attributeSet, z, z2, true, t0.c());
    }

    void l0(int i) {
        PanelFeatureState w0;
        PanelFeatureState w02 = w0(i, true);
        if (w02.j != null) {
            Bundle bundle = new Bundle();
            w02.j.U(bundle);
            if (bundle.size() > 0) {
                w02.s = bundle;
            }
            w02.j.i0();
            w02.j.clear();
        }
        w02.r = true;
        w02.q = true;
        if ((i != 108 && i != 0) || this.r == null || (w0 = w0(0, false)) == null) {
            return;
        }
        w0.m = false;
        S0(w0, null);
    }

    public View m(int i) {
        n0();
        return this.l.findViewById(i);
    }

    void m0() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.y;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    public Context o() {
        return this.k;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return l(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    PanelFeatureState p0(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.M;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    public final b q() {
        return new d(this);
    }

    public int r() {
        return this.T;
    }

    final Context r0() {
        a v = v();
        Context k = v != null ? v.k() : null;
        return k == null ? this.k : k;
    }

    public MenuInflater t() {
        if (this.p == null) {
            z0();
            a aVar = this.o;
            this.p = new g(aVar != null ? aVar.k() : this.k);
        }
        return this.p;
    }

    public a v() {
        z0();
        return this.o;
    }

    i v0(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? i.b(configuration) : i.c(h.b(configuration.locale));
    }

    public void w() {
        LayoutInflater from = LayoutInflater.from(this.k);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory2(from, this);
        } else {
            boolean z = from.getFactory2() instanceof AppCompatDelegateImpl;
        }
    }

    protected PanelFeatureState w0(int i, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.M;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.M = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i);
        panelFeatureStateArr[i] = panelFeatureState2;
        return panelFeatureState2;
    }

    public void x() {
        if (Q0() == null || v().m()) {
            return;
        }
        D0(0);
    }

    final CharSequence x0() {
        Object obj = this.j;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.q;
    }

    final Window.Callback y0() {
        return this.l.getCallback();
    }
}
