package com.transsion.baselib.helper;

import android.content.Context;
import android.view.OrientationEventListener;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f extends OrientationEventListener {
    private final Function1 a;
    private final int b;
    private long c;
    private int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, Function1 function1) {
        super(context);
        Intrinsics.h(context, "context");
        Intrinsics.h(function1, "callback");
        this.a = function1;
        this.b = 500;
        this.d = -1;
        this.e = 1;
        this.f = 2;
        this.g = 3;
        this.h = 4;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        if (i == -1 || System.currentTimeMillis() - this.c < this.b) {
            return;
        }
        this.c = System.currentTimeMillis();
        if (i >= 335 || i < 25) {
            int i2 = this.d;
            int i3 = this.e;
            if (i2 != i3) {
                this.d = i3;
                this.a.invoke(Boolean.TRUE);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("竖屏：");
            sb.append(i);
            return;
        }
        if (65 <= i && i < 116) {
            int i4 = this.d;
            int i5 = this.f;
            if (i4 != i5) {
                this.d = i5;
                this.a.invoke(Boolean.FALSE);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("横屏：");
            sb2.append(i);
            return;
        }
        if (155 <= i && i < 206) {
            int i6 = this.d;
            int i7 = this.g;
            if (i6 != i7) {
                this.d = i7;
                this.a.invoke(Boolean.TRUE);
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("反向-竖屏：");
            sb3.append(i);
            return;
        }
        if (245 > i || i >= 296) {
            return;
        }
        int i8 = this.d;
        int i9 = this.h;
        if (i8 != i9) {
            this.d = i9;
            this.a.invoke(Boolean.FALSE);
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("反向-横屏：");
        sb4.append(i);
    }
}
