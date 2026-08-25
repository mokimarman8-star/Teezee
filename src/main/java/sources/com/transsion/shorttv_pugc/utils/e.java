package com.transsion.shorttv_pugc.utils;

import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import androidx.appcompat.widget.x;
import androidx.core.view.d2;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.a0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e {
    public static final a c = new a(null);
    private static final Lazy d = LazyKt.b(new Function0() { // from class: com.transsion.shorttv_pugc.utils.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            e g;
            g = e.g();
            return g;
        }
    });
    private List a = new ArrayList();
    private int b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a() {
            return (e) e.d.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(FragmentActivity fragmentActivity, e eVar) {
        View decorView;
        WindowInsets rootWindowInsets;
        if (fragmentActivity.isFinishing()) {
            return;
        }
        Window window = fragmentActivity.getWindow();
        Insets a2 = (window == null || (decorView = window.getDecorView()) == null || (rootWindowInsets = decorView.getRootWindowInsets()) == null) ? null : d2.a(rootWindowInsets);
        if (a2 == null || x.a(a2) > a0.a(40.0f)) {
            a.a.f(wf.a.a, "ImmVideoHelper", "is open navigation bar 2", false, 4, (Object) null);
            return;
        }
        int a3 = x.a(a2);
        eVar.b = a3;
        a.a.f(wf.a.a, "ImmVideoHelper", "on get navigation gesture height = " + a3, false, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e g() {
        return new e();
    }

    public final List d() {
        return this.a;
    }

    public final void e(final FragmentActivity activity) {
        Intrinsics.h(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            this.b = 0;
            return;
        }
        if (com.blankj.utilcode.util.d.a() > 50) {
            a.a.f(wf.a.a, "ImmVideoHelper", "is open navigation bar", false, 4, (Object) null);
            this.b = 0;
            return;
        }
        Window window = activity.getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView != null) {
            decorView.post(new Runnable() { // from class: com.transsion.shorttv_pugc.utils.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.f(activity, this);
                }
            });
        }
    }
}
