package com.transsion.usercenter.profile;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ProfileFragment$b implements TabLayout.OnTabSelectedListener {
    ProfileFragment$b() {
    }

    public void onTabReselected(TabLayout.Tab tab) {
    }

    public void onTabSelected(TabLayout.Tab tab) {
        View customView = tab != null ? tab.getCustomView() : null;
        Intrinsics.f(customView, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) customView;
        Context context = textView.getContext();
        Intrinsics.g(context, "getContext(...)");
        textView.setTypeface(uf.a.a(context));
    }

    public void onTabUnselected(TabLayout.Tab tab) {
        TextView textView = (TextView) (tab != null ? tab.getCustomView() : null);
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        Intrinsics.g(context, "getContext(...)");
        textView.setTypeface(uf.a.d(context));
    }
}
