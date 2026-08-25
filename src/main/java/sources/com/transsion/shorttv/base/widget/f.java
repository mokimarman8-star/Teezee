package com.transsion.shorttv.base.widget;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f extends RecyclerView.l {
    private final int a;

    public f(int i) {
        this.a = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
        Intrinsics.h(rect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(recyclerView, "parent");
        Intrinsics.h(xVar, "state");
        super.getItemOffsets(rect, view, recyclerView, xVar);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
            if (childAdapterPosition == 0) {
                rect.left = 0;
                return;
            } else {
                rect.left = this.a;
                return;
            }
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (childAdapterPosition == (adapter != null ? adapter.getItemCount() : 0) - 1) {
            rect.left = 0;
        } else {
            rect.left = this.a;
        }
    }
}
