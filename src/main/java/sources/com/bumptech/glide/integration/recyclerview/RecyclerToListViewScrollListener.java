package com.bumptech.glide.integration.recyclerview;

import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class RecyclerToListViewScrollListener extends RecyclerView.r {
    public static final int UNKNOWN_SCROLL_STATE = Integer.MIN_VALUE;
    private final AbsListView.OnScrollListener scrollListener;
    private int lastFirstVisible = -1;
    private int lastVisibleCount = -1;
    private int lastItemCount = -1;

    public RecyclerToListViewScrollListener(@NonNull AbsListView.OnScrollListener onScrollListener) {
        this.scrollListener = onScrollListener;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        int i2;
        if (i != 0) {
            i2 = 1;
            if (i != 1) {
                i2 = 2;
                if (i != 2) {
                    i2 = Integer.MIN_VALUE;
                }
            }
        } else {
            i2 = 0;
        }
        this.scrollListener.onScrollStateChanged(null, i2);
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
        int findFirstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
        int abs = Math.abs(findFirstVisibleItemPosition - layoutManager.findLastVisibleItemPosition());
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (findFirstVisibleItemPosition == this.lastFirstVisible && abs == this.lastVisibleCount && itemCount == this.lastItemCount) {
            return;
        }
        this.scrollListener.onScroll(null, findFirstVisibleItemPosition, abs, itemCount);
        this.lastFirstVisible = findFirstVisibleItemPosition;
        this.lastVisibleCount = abs;
        this.lastItemCount = itemCount;
    }
}
