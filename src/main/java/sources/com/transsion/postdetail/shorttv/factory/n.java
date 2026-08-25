package com.transsion.postdetail.shorttv.factory;

import android.content.Context;
import android.view.View;
import com.tn.lib.view.NoNetworkBigView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class n implements ur.l {
    @Override // ur.l
    public View a(Context context) {
        Intrinsics.h(context, "context");
        return new NoNetworkBigView(context);
    }
}
