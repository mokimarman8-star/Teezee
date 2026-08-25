package com.transsion.postdetail.util;

import android.view.View;
import com.transsion.push.PushConstants;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    public static final e a = new e();

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function0 function0, View view) {
        function0.invoke();
    }

    public final void b(View[] viewArr, final Function0 function0) {
        Intrinsics.h(viewArr, "view");
        Intrinsics.h(function0, PushConstants.PUSH_SERVICE_TYPE_CLICK);
        for (View view : viewArr) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.util.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    e.c(function0, view2);
                }
            });
        }
    }
}
