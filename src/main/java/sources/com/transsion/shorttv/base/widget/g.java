package com.transsion.shorttv.base.widget;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g extends RecyclerView.r {
    private t6.f a;
    private int[] b;
    private int c;

    public g(t6.f fVar) {
        this.a = fVar;
    }

    private final void d(RecyclerView recyclerView) {
        StaggeredGridLayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            if (this.b == null) {
                this.b = new int[layoutManager.Q()];
            }
            layoutManager.E(this.b);
            this.c = e(this.b);
            return;
        }
        if (layoutManager instanceof GridLayoutManager) {
            this.c = ((GridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        } else {
            if (!(layoutManager instanceof LinearLayoutManager)) {
                throw new RuntimeException("Unsupported layoutManager.");
            }
            this.c = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        }
    }

    private final int e(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int i = 0;
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        t6.f fVar;
        Intrinsics.h(recyclerView, "recyclerView");
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        int childCount = layoutManager != null ? layoutManager.getChildCount() : 0;
        int itemCount = layoutManager != null ? layoutManager.getItemCount() : 0;
        if (i != 0 || childCount <= 0 || this.c < itemCount - 1) {
            return;
        }
        t6.f fVar2 = this.a;
        if ((fVar2 != null ? fVar2.i() : null) != LoadMoreStatus.Fail || (fVar = this.a) == null) {
            return;
        }
        fVar.w();
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.h(recyclerView, "recyclerView");
        d(recyclerView);
    }
}
