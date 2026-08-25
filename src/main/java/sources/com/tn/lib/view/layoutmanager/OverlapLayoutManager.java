package com.tn.lib.view.layoutmanager;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001J#\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/tn/lib/view/layoutmanager/OverlapLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$t;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/RecyclerView$x;", "state", "", "onLayoutChildren", "(Landroidx/recyclerview/widget/RecyclerView$t;Landroidx/recyclerview/widget/RecyclerView$x;)V", "", "a", "I", "overlapAmount", "UI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OverlapLayoutManager extends LinearLayoutManager {

    /* renamed from: a, reason: from kotlin metadata */
    private final int overlapAmount;

    public void onLayoutChildren(RecyclerView.t recycler, RecyclerView.x state) {
        Intrinsics.h(recycler, "recycler");
        Intrinsics.h(state, "state");
        try {
            Result.Companion companion = Result.Companion;
            detachAndScrapAttachedViews(recycler);
            int itemCount = getItemCount();
            int i = 0;
            for (int i2 = 0; i2 < itemCount; i2++) {
                View o = recycler.o(i2);
                Intrinsics.g(o, "getViewForPosition(...)");
                addView(o);
                measureChildWithMargins(o, 0, 0);
                int decoratedMeasuredWidth = getDecoratedMeasuredWidth(o);
                layoutDecorated(o, i, 0, i + decoratedMeasuredWidth, getDecoratedMeasuredHeight(o));
                i += decoratedMeasuredWidth - this.overlapAmount;
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th));
        }
    }
}
