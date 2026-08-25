package com.transsion.subroom.activity;

import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class n implements Function1 {
    public final /* synthetic */ TabLayout.TabView a;
    public final /* synthetic */ MainActivity b;

    public /* synthetic */ n(TabLayout.TabView tabView, MainActivity mainActivity) {
        this.a = tabView;
        this.b = mainActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return MainActivity.t0(this.a, this.b, (Integer) obj);
    }
}
