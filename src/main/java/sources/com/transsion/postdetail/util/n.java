package com.transsion.postdetail.util;

import android.app.Activity;
import android.view.OrientationEventListener;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class n extends OrientationEventListener {
    private final Activity a;
    private final Function1 b;
    private int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Activity activity, Function1 function1) {
        super(activity);
        Intrinsics.h(activity, "activity");
        Intrinsics.h(function1, "callback");
        this.a = activity;
        this.b = function1;
    }

    public final int a() {
        return this.c;
    }

    public final int b(Activity activity) {
        Intrinsics.h(activity, "activity");
        return activity.getWindowManager().getDefaultDisplay().getRotation();
    }

    public final void c(int i) {
        if (this.c == i) {
            return;
        }
        this.c = i;
        this.b.invoke(Integer.valueOf(i));
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        if (71 <= i && i < 110) {
            if (this.c != 3 && b(this.a) == 3) {
                c(3);
                return;
            }
            return;
        }
        if (251 > i || i >= 290 || this.c == 1 || b(this.a) != 1) {
            return;
        }
        c(1);
    }
}
