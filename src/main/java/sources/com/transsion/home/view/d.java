package com.transsion.home.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.n;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends n {
    private final int a;

    public d(int i) {
        this.a = i;
    }

    private final int k(RecyclerView.m mVar, View view) {
        return (view.getLeft() - mVar.getPaddingLeft()) - this.a;
    }

    private final int l(RecyclerView.m mVar, View view) {
        return view.getTop() - mVar.getPaddingTop();
    }

    public int[] calculateDistanceToFinalSnap(RecyclerView.m mVar, View view) {
        Intrinsics.h(mVar, "layoutManager");
        Intrinsics.h(view, "targetView");
        return mVar.canScrollHorizontally() ? new int[]{k(mVar, view), 0} : mVar.canScrollVertically() ? new int[]{0, l(mVar, view)} : new int[]{0, 0};
    }
}
