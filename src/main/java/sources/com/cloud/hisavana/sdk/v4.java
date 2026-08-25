package com.cloud.hisavana.sdk;

import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class v4 extends com.cloud.hisavana.sdk.common.tranmeasure.h {
    @Override // com.cloud.hisavana.sdk.common.tranmeasure.h
    protected int d(r4 r4Var, View view) {
        if (view == null || r4Var == null || !view.getGlobalVisibleRect(this.a)) {
            return 0;
        }
        long height = this.a.height() * this.a.width();
        long height2 = view.getHeight() * view.getWidth();
        this.b = this.a.width() + "*" + this.a.height();
        if (height2 <= 0) {
            return 0;
        }
        return (int) ((height * 100) / height2);
    }
}
