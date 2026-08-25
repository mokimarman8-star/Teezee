package com.transsion.baseui.activity;

import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* synthetic */ class e implements Function2 {
    public final /* synthetic */ BaseCommonActivity a;
    public final /* synthetic */ int b;

    public /* synthetic */ e(BaseCommonActivity baseCommonActivity, int i) {
        this.a = baseCommonActivity;
        this.b = i;
    }

    public final Object invoke(Object obj, Object obj2) {
        return BaseCommonActivity.O(this.a, this.b, (androidx.compose.runtime.i) obj, ((Integer) obj2).intValue());
    }
}
