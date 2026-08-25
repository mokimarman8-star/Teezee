package com.cloud.tmc.miniapp.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO00o extends RecyclerView.l {
    public final int OooO00o;

    public OooO00o(int i) {
        this.OooO00o = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
        Intrinsics.h(rect, "rect");
        Intrinsics.h(view, "view");
        Intrinsics.h(recyclerView, "recyclerView");
        Intrinsics.h(xVar, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        GridLayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        int U = layoutManager.U();
        if ((childAdapterPosition + 1) % U == 0) {
            rect.right = this.OooO00o;
        }
        if (childAdapterPosition < U) {
            rect.top = this.OooO00o;
        }
        int i = this.OooO00o;
        rect.bottom = i;
        rect.left = i;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar) {
        Intrinsics.h(canvas, "canvas");
        Intrinsics.h(recyclerView, "recyclerView");
        Intrinsics.h(xVar, "state");
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar) {
        Intrinsics.h(canvas, "canvas");
        Intrinsics.h(recyclerView, "recyclerView");
        Intrinsics.h(xVar, "state");
    }
}
