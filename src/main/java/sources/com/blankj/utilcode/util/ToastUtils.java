package com.blankj.utilcode.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import com.blankj.utilcode.R$id;
import com.blankj.utilcode.R$layout;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class ToastUtils {
    private static final ToastUtils l = n();
    private static WeakReference m;
    private String a;
    private int b = -1;
    private int c = -1;
    private int d = -1;
    private int e = -16777217;
    private int f = -1;
    private int g = -16777217;
    private int h = -1;
    private boolean i = false;
    private Drawable[] j = new Drawable[4];
    private boolean k = false;

    static final class ActivityToast extends a {
        private static int f;
        private Utils$a d;
        private b e;

        class a extends Utils$a {
            final /* synthetic */ int a;

            a(int i) {
                this.a = i;
            }

            @Override // com.blankj.utilcode.util.Utils$a
            public void a(Activity activity) {
                if (ActivityToast.this.i()) {
                    ActivityToast.this.l(activity, this.a, false);
                }
            }
        }

        ActivityToast(ToastUtils toastUtils) {
            super(toastUtils);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean i() {
            return this.d != null;
        }

        private void j() {
            a aVar = new a(f);
            this.d = aVar;
            e0.a(aVar);
        }

        private b k(int i) {
            c cVar = new c(this.b);
            cVar.a = this.a;
            cVar.a(i);
            return cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(Activity activity, int i, boolean z) {
            Window window = activity.getWindow();
            if (window != null) {
                ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = this.a.getGravity();
                layoutParams.bottomMargin = this.a.getYOffset() + e0.p();
                layoutParams.topMargin = this.a.getYOffset() + e0.s();
                layoutParams.leftMargin = this.a.getXOffset();
                View d = d(i);
                if (z) {
                    d.setAlpha(0.0f);
                    d.animate().alpha(1.0f).setDuration(200L).start();
                }
                viewGroup.addView(d, layoutParams);
            }
        }

        private b m(Activity activity, int i) {
            WindowManagerToast windowManagerToast = new WindowManagerToast(this.b, activity.getWindowManager(), 99);
            windowManagerToast.c = d(-1);
            windowManagerToast.a = this.a;
            windowManagerToast.a(i);
            return windowManagerToast;
        }

        private void n() {
            e0.I(this.d);
            this.d = null;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b
        public void a(int i) {
            if (this.a == null) {
                return;
            }
            if (!e0.x()) {
                this.e = k(i);
                return;
            }
            boolean z = false;
            for (Activity activity : e0.h()) {
                if (e0.w(activity)) {
                    if (z) {
                        l(activity, f, true);
                    } else {
                        this.e = m(activity, i);
                        z = true;
                    }
                }
            }
            if (!z) {
                this.e = k(i);
                return;
            }
            j();
            e0.K(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.ActivityToast.1
                @Override // java.lang.Runnable
                public void run() {
                    ActivityToast.this.cancel();
                }
            }, i == 0 ? 2000L : 3500L);
            f++;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.a, com.blankj.utilcode.util.ToastUtils.b
        public void cancel() {
            Window window;
            if (i()) {
                n();
                for (Activity activity : e0.h()) {
                    if (e0.w(activity) && (window = activity.getWindow()) != null) {
                        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                        StringBuilder sb = new StringBuilder();
                        sb.append("TAG_TOAST");
                        sb.append(f - 1);
                        View findViewWithTag = viewGroup.findViewWithTag(sb.toString());
                        if (findViewWithTag != null) {
                            try {
                                viewGroup.removeView(findViewWithTag);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            b bVar = this.e;
            if (bVar != null) {
                bVar.cancel();
                this.e = null;
            }
            super.cancel();
        }
    }

    public static final class UtilsMaxWidthRelativeLayout extends RelativeLayout {
        private static final int a = e0.d(80.0f);

        public UtilsMaxWidthRelativeLayout(Context context) {
            super(context);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        @Override // android.widget.RelativeLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(e0.i() - a, Integer.MIN_VALUE), i2);
        }
    }

    static final class WindowManagerToast extends a {
        private WindowManager d;
        private WindowManager.LayoutParams e;

        WindowManagerToast(ToastUtils toastUtils, int i) {
            super(toastUtils);
            this.e = new WindowManager.LayoutParams();
            this.d = (WindowManager) Utils.a().getSystemService("window");
            this.e.type = i;
        }

        WindowManagerToast(ToastUtils toastUtils, WindowManager windowManager, int i) {
            super(toastUtils);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.e = layoutParams;
            this.d = windowManager;
            layoutParams.type = i;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b
        public void a(int i) {
            if (this.a == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = this.e;
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = R.style.Animation.Toast;
            layoutParams.setTitle("ToastWithoutNotification");
            WindowManager.LayoutParams layoutParams2 = this.e;
            layoutParams2.flags = 152;
            layoutParams2.packageName = Utils.a().getPackageName();
            this.e.gravity = this.a.getGravity();
            WindowManager.LayoutParams layoutParams3 = this.e;
            int i2 = layoutParams3.gravity;
            if ((i2 & 7) == 7) {
                layoutParams3.horizontalWeight = 1.0f;
            }
            if ((i2 & 112) == 112) {
                layoutParams3.verticalWeight = 1.0f;
            }
            layoutParams3.x = this.a.getXOffset();
            this.e.y = this.a.getYOffset();
            this.e.horizontalMargin = this.a.getHorizontalMargin();
            this.e.verticalMargin = this.a.getVerticalMargin();
            try {
                WindowManager windowManager = this.d;
                if (windowManager != null) {
                    windowManager.addView(this.c, this.e);
                }
            } catch (Exception unused) {
            }
            e0.K(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.WindowManagerToast.1
                @Override // java.lang.Runnable
                public void run() {
                    WindowManagerToast.this.cancel();
                }
            }, i == 0 ? 2000L : 3500L);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.a, com.blankj.utilcode.util.ToastUtils.b
        public void cancel() {
            try {
                WindowManager windowManager = this.d;
                if (windowManager != null) {
                    windowManager.removeViewImmediate(this.c);
                    this.d = null;
                }
            } catch (Exception unused) {
            }
            super.cancel();
        }
    }

    static abstract class a implements b {
        protected Toast a = new Toast(Utils.a());
        protected ToastUtils b;
        protected View c;

        a(ToastUtils toastUtils) {
            this.b = toastUtils;
            if (toastUtils.b == -1 && this.b.c == -1 && this.b.d == -1) {
                return;
            }
            this.a.setGravity(this.b.b, this.b.c, this.b.d);
        }

        private void e() {
            if (e0.B()) {
                b(d(-1));
            }
        }

        private void f(TextView textView) {
            if (this.b.f != -1) {
                this.c.setBackgroundResource(this.b.f);
                textView.setBackgroundColor(0);
                return;
            }
            if (this.b.e != -16777217) {
                Drawable background = this.c.getBackground();
                Drawable background2 = textView.getBackground();
                if (background != null && background2 != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.b.e, PorterDuff.Mode.SRC_IN));
                    textView.setBackgroundColor(0);
                } else if (background != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.b.e, PorterDuff.Mode.SRC_IN));
                } else if (background2 != null) {
                    background2.mutate().setColorFilter(new PorterDuffColorFilter(this.b.e, PorterDuff.Mode.SRC_IN));
                } else {
                    this.c.setBackgroundColor(this.b.e);
                }
            }
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b
        public void b(View view) {
            this.c = view;
            this.a.setView(view);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b
        public void c(CharSequence charSequence) {
            View t = this.b.t(charSequence);
            if (t != null) {
                b(t);
                e();
                return;
            }
            View view = this.a.getView();
            this.c = view;
            if (view == null || view.findViewById(R.id.message) == null) {
                b(e0.F(R$layout.utils_toast_view));
            }
            TextView textView = (TextView) this.c.findViewById(R.id.message);
            textView.setText(charSequence);
            if (this.b.g != -16777217) {
                textView.setTextColor(this.b.g);
            }
            if (this.b.h != -1) {
                textView.setTextSize(this.b.h);
            }
            f(textView);
            e();
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b
        public void cancel() {
            Toast toast = this.a;
            if (toast != null) {
                toast.cancel();
            }
            this.a = null;
            this.c = null;
        }

        View d(int i) {
            Bitmap M = e0.M(this.c);
            ImageView imageView = new ImageView(Utils.a());
            imageView.setTag("TAG_TOAST" + i);
            imageView.setImageBitmap(M);
            return imageView;
        }
    }

    interface b {
        void a(int i);

        void b(View view);

        void c(CharSequence charSequence);

        void cancel();
    }

    static final class c extends a {

        static class a extends Handler {
            private Handler a;

            a(Handler handler) {
                this.a = handler;
            }

            @Override // android.os.Handler
            public void dispatchMessage(Message message) {
                try {
                    this.a.dispatchMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                this.a.handleMessage(message);
            }
        }

        c(ToastUtils toastUtils) {
            super(toastUtils);
            if (Build.VERSION.SDK_INT == 25) {
                try {
                    Field declaredField = Toast.class.getDeclaredField("mTN");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(this.a);
                    Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
                    declaredField2.setAccessible(true);
                    declaredField2.set(obj, new a((Handler) declaredField2.get(obj)));
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b
        public void a(int i) {
            Toast toast = this.a;
            if (toast == null) {
                return;
            }
            toast.setDuration(i);
            this.a.show();
        }
    }

    public static void l() {
        e0.J(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.1
            @Override // java.lang.Runnable
            public void run() {
                if (ToastUtils.m != null) {
                    b bVar = (b) ToastUtils.m.get();
                    if (bVar != null) {
                        bVar.cancel();
                    }
                    WeakReference unused = ToastUtils.m = null;
                }
            }
        });
    }

    private static CharSequence m(CharSequence charSequence) {
        return charSequence == null ? "toast null" : charSequence.length() == 0 ? "toast nothing" : charSequence;
    }

    public static ToastUtils n() {
        return new ToastUtils();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static b o(ToastUtils toastUtils) {
        if (!toastUtils.k && androidx.core.app.t.b(Utils.a()).a() && !e0.z()) {
            return new c(toastUtils);
        }
        int i = Build.VERSION.SDK_INT;
        return i < 25 ? new WindowManagerToast(toastUtils, 2005) : e0.z() ? i >= 26 ? new WindowManagerToast(toastUtils, 2038) : new WindowManagerToast(toastUtils, 2002) : new ActivityToast(toastUtils);
    }

    private static void p(final View view, final CharSequence charSequence, final int i, ToastUtils toastUtils) {
        e0.J(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.2
            @Override // java.lang.Runnable
            public void run() {
                ToastUtils.l();
                b o = ToastUtils.o(ToastUtils.this);
                WeakReference unused = ToastUtils.m = new WeakReference(o);
                View view2 = view;
                if (view2 != null) {
                    o.b(view2);
                } else {
                    o.c(charSequence);
                }
                o.a(i);
            }
        });
    }

    private static void q(CharSequence charSequence, int i, ToastUtils toastUtils) {
        p(null, m(charSequence), i, toastUtils);
    }

    public static void r(int i) {
        q(e0.t(i), 0, l);
    }

    public static void s(String str, Object... objArr) {
        q(e0.g(str, objArr), 0, l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View t(CharSequence charSequence) {
        if (!"dark".equals(this.a) && !"light".equals(this.a)) {
            Drawable[] drawableArr = this.j;
            if (drawableArr[0] == null && drawableArr[1] == null && drawableArr[2] == null && drawableArr[3] == null) {
                return null;
            }
        }
        View F = e0.F(R$layout.utils_toast_view);
        TextView textView = (TextView) F.findViewById(R.id.message);
        if ("dark".equals(this.a)) {
            ((GradientDrawable) F.getBackground().mutate()).setColor(Color.parseColor("#BB000000"));
            textView.setTextColor(-1);
        }
        textView.setText(charSequence);
        if (this.j[0] != null) {
            View findViewById = F.findViewById(R$id.utvLeftIconView);
            ViewCompat.setBackground(findViewById, this.j[0]);
            findViewById.setVisibility(0);
        }
        if (this.j[1] != null) {
            View findViewById2 = F.findViewById(R$id.utvTopIconView);
            ViewCompat.setBackground(findViewById2, this.j[1]);
            findViewById2.setVisibility(0);
        }
        if (this.j[2] != null) {
            View findViewById3 = F.findViewById(R$id.utvRightIconView);
            ViewCompat.setBackground(findViewById3, this.j[2]);
            findViewById3.setVisibility(0);
        }
        if (this.j[3] != null) {
            View findViewById4 = F.findViewById(R$id.utvBottomIconView);
            ViewCompat.setBackground(findViewById4, this.j[3]);
            findViewById4.setVisibility(0);
        }
        return F;
    }
}
