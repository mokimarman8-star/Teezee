package com.transsion.postdetail.comment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.R;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class u extends RecyclerView.l {
    private final int a = lj.a.b(1);
    private final int b = lj.a.b(52);
    private Paint c;

    private final Paint d(Context context) {
        if (this.c == null) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(androidx.core.content.b.getColor(context, R.color.line_01));
            this.c = paint;
        }
        Paint paint2 = this.c;
        Intrinsics.e(paint2);
        return paint2;
    }

    private final boolean e(p6.a aVar, p6.a aVar2) {
        int itemType = aVar.getItemType();
        if (aVar2.getItemType() != 0) {
            return false;
        }
        return itemType == 0 || itemType == 1 || itemType == 2;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
        Intrinsics.h(rect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(recyclerView, "parent");
        Intrinsics.h(xVar, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == -1) {
            return;
        }
        n adapter = recyclerView.getAdapter();
        n nVar = adapter instanceof n ? adapter : null;
        if (nVar == null) {
            return;
        }
        try {
            p6.a aVar = (p6.a) nVar.getItem(childAdapterPosition);
            if (aVar != null && aVar.getItemType() == 0 && childAdapterPosition > 0) {
                p6.a aVar2 = (p6.a) nVar.getItem(childAdapterPosition - 1);
                if (aVar2 != null && e(aVar2, aVar)) {
                    rect.top = this.a;
                }
            }
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar) {
        p6.a aVar;
        Intrinsics.h(canvas, "c");
        Intrinsics.h(recyclerView, "parent");
        Intrinsics.h(xVar, "state");
        n adapter = recyclerView.getAdapter();
        n nVar = adapter instanceof n ? adapter : null;
        if (nVar == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            if (childAdapterPosition != -1 && childAdapterPosition != 0) {
                try {
                    p6.a aVar2 = (p6.a) nVar.getItem(childAdapterPosition);
                    if (aVar2 != null && aVar2.getItemType() == 0 && (aVar = (p6.a) nVar.getItem(childAdapterPosition - 1)) != null && e(aVar, aVar2)) {
                        int i2 = this.b;
                        int width = recyclerView.getWidth();
                        float top = childAt.getTop();
                        Context context = recyclerView.getContext();
                        Intrinsics.g(context, "getContext(...)");
                        canvas.drawRect(i2, top, width, top + this.a, d(context));
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
        }
    }
}
