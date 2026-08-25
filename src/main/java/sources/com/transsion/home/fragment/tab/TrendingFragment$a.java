package com.transsion.home.fragment.tab;

import android.os.Bundle;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TrendingFragment$a {
    private TrendingFragment$a() {
    }

    public /* synthetic */ TrendingFragment$a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final TrendingFragment a(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("tab_id", i);
        bundle.putString("tab_code", str);
        wf.a.a.c("TrendingFragment", "create trending fragment", true);
        TrendingFragment trendingFragment = new TrendingFragment();
        trendingFragment.setArguments(bundle);
        return trendingFragment;
    }
}
