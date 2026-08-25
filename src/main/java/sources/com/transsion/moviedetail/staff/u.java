package com.transsion.moviedetail.staff;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class u extends RecyclerView.l {
    private int a;
    private int b;
    private int c;
    private int d;
    private final int e;

    public u(int i, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
        Intrinsics.h(rect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(recyclerView, "parent");
        Intrinsics.h(xVar, "state");
        super.getItemOffsets(rect, view, recyclerView, xVar);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        boolean z = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        if (layoutManager instanceof GridLayoutManager) {
            int i = this.e;
            if (i <= 0) {
                i = 1;
            }
            int i2 = childAdapterPosition % i;
            s adapter = recyclerView.getAdapter();
            Intrinsics.f(adapter, "null cannot be cast to non-null type com.transsion.moviedetail.staff.MovieStaffAdapter");
            int itemViewType = adapter.getItemViewType(childAdapterPosition);
            if (itemViewType != 1) {
                if (itemViewType != 2) {
                    rect.left = 0;
                    rect.right = 0;
                } else {
                    int i3 = this.a;
                    rect.left = i3;
                    rect.right = i3;
                }
            } else if (z) {
                if (i2 == 0) {
                    rect.right = this.a;
                    rect.left = this.b;
                } else if (i2 == this.e - 1) {
                    rect.right = this.b;
                    rect.left = this.a;
                } else {
                    int i4 = this.b;
                    rect.left = i4;
                    rect.right = i4;
                }
            } else if (i2 == 0) {
                rect.left = this.a;
                rect.right = this.b;
            } else if (i2 == this.e - 1) {
                rect.left = this.b;
                rect.right = this.a;
            } else {
                int i5 = this.b;
                rect.left = i5;
                rect.right = i5;
            }
            rect.bottom = this.d;
        }
    }
}
