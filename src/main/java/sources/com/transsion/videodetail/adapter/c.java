package com.transsion.videodetail.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c extends RecyclerView.l {
    private final int a;

    public c(int i) {
        this.a = i;
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
        Intrinsics.h(outRect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(parent, "parent");
        Intrinsics.h(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        b adapter = parent.getAdapter();
        Intrinsics.f(adapter, "null cannot be cast to non-null type com.transsion.videodetail.adapter.VideoDetailEpisodeAdapter");
        int size = adapter.getData().size();
        GridLayoutManager layoutManager = parent.getLayoutManager();
        Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        int U = size % layoutManager.U();
        if (U == 0) {
            U = 3;
        }
        if (childAdapterPosition >= RangesKt.e(size - U, 0)) {
            outRect.bottom = this.a;
        } else {
            outRect.bottom = 0;
        }
    }
}
