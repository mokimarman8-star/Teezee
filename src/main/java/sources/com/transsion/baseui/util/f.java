package com.transsion.baseui.util;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class f implements View.OnClickListener {
    public static final a c = new a(null);
    public static final int d = 8;
    private int a;
    private final Handler b = new Handler(Looper.getMainLooper());

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    protected f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(f fVar, View view) {
        int i = fVar.a;
        if (i == 1) {
            fVar.d(view);
        } else if (i >= 2) {
            fVar.c(view);
        }
        fVar.b.removeCallbacksAndMessages(null);
        fVar.a = 0;
    }

    public abstract void c(View view);

    public abstract void d(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        Intrinsics.h(view, "v");
        int i = this.a + 1;
        this.a = i;
        if (i > 1) {
            return;
        }
        this.b.postDelayed(new Runnable() { // from class: com.transsion.baseui.util.e
            @Override // java.lang.Runnable
            public final void run() {
                f.b(f.this, view);
            }
        }, 300L);
    }
}
