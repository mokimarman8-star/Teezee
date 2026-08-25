package com.transsion.baseui.util;

import android.view.View;
import com.transsion.push.PushConstants;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class o {
    public static final o a = new o();

    private o() {
    }

    public final void a(View[] viewArr, View.OnClickListener onClickListener) {
        Intrinsics.h(viewArr, "view");
        Intrinsics.h(onClickListener, PushConstants.PUSH_SERVICE_TYPE_CLICK);
        for (View view : viewArr) {
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
        }
    }
}
