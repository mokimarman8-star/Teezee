package com.transsion.shorttv_pugc.base.widget.toast.core;

import android.R;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import com.blankj.utilcode.util.a0;
import com.transsion.shorttv_pugc.base.widget.toast.core.ToastImpl;
import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class ToastImpl {
    private static final Handler g = new Handler(Looper.getMainLooper());
    private final os.a a;
    private final i b;
    private final String c;
    private boolean d;
    private final Runnable e = new AnonymousClass1();
    private final Runnable f = new Runnable() { // from class: com.transsion.shorttv_pugc.base.widget.toast.core.ToastImpl.2
        @Override // java.lang.Runnable
        public void run() {
            Activity a;
            WindowManager windowManager;
            try {
                try {
                    a = ToastImpl.this.b.a();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                if (a != null && (windowManager = (WindowManager) a.getSystemService("window")) != null) {
                    windowManager.removeViewImmediate(ToastImpl.this.a.getView());
                }
            } finally {
                ToastImpl.this.b.c();
                ToastImpl.this.g(false);
            }
        }
    };

    /* renamed from: com.transsion.shorttv_pugc.base.widget.toast.core.ToastImpl$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            ToastImpl.this.e();
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity a = ToastImpl.this.b.a();
            if (a == null || a.isFinishing() || a.isDestroyed()) {
                return;
            }
            int a2 = (ToastImpl.this.a.getView() == null || !(ToastImpl.this.a.getView().getTag() instanceof Integer)) ? -2 : a0.a(((Integer) ToastImpl.this.a.getView().getTag()).intValue());
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = -2;
            layoutParams.width = a2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = R.style.Animation.Toast;
            if (ToastImpl.this.a.a()) {
                layoutParams.flags = Sdk$SDKError.Reason.PRIVACY_URL_ERROR_VALUE;
            } else {
                layoutParams.flags = 152;
            }
            layoutParams.packageName = ToastImpl.this.c;
            layoutParams.gravity = ToastImpl.this.a.getGravity();
            layoutParams.x = ToastImpl.this.a.getXOffset();
            layoutParams.y = ToastImpl.this.a.getYOffset();
            layoutParams.verticalMargin = ToastImpl.this.a.getVerticalMargin();
            layoutParams.horizontalMargin = ToastImpl.this.a.getHorizontalMargin();
            WindowManager windowManager = (WindowManager) a.getSystemService("window");
            if (windowManager == null) {
                return;
            }
            try {
                windowManager.addView(ToastImpl.this.a.getView(), layoutParams);
                ToastImpl.g.postDelayed(new Runnable() { // from class: com.transsion.shorttv_pugc.base.widget.toast.core.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        ToastImpl.AnonymousClass1.this.lambda$run$0();
                    }
                }, ToastImpl.this.a.getDuration() == 1 ? 3500L : 2000L);
                ToastImpl.this.b.b(ToastImpl.this);
                ToastImpl.this.g(true);
            } catch (WindowManager.BadTokenException | IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    ToastImpl(Activity activity, os.a aVar) {
        this.a = aVar;
        this.c = activity.getPackageName();
        this.b = new i(activity);
    }

    void e() {
        if (f()) {
            Handler handler = g;
            handler.removeCallbacks(this.f);
            handler.post(this.f);
        }
    }

    boolean f() {
        return this.d;
    }

    void g(boolean z) {
        this.d = z;
    }

    void h() {
        if (f()) {
            return;
        }
        Handler handler = g;
        handler.removeCallbacks(this.e);
        handler.post(this.e);
    }
}
