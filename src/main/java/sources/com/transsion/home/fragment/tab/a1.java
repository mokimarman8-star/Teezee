package com.transsion.home.fragment.tab;

import com.transsion.home.bean.MainOperateData;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* synthetic */ class a1 implements Function1 {
    public final /* synthetic */ TrendingFragment a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ a1(TrendingFragment trendingFragment, Function1 function1) {
        this.a = trendingFragment;
        this.b = function1;
    }

    public final Object invoke(Object obj) {
        return TrendingFragment.I0(this.a, this.b, (MainOperateData) obj);
    }
}
