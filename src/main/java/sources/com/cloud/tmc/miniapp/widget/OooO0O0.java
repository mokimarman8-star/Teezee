package com.cloud.tmc.miniapp.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0O0 extends RecyclerView.l {
    public int OooO00o = Color.parseColor("#cccccc");
    public int OooO0O0;
    public boolean OooO0OO;
    public boolean OooO0Oo;
    public Paint OooO0o;
    public int OooO0o0;
    public Bitmap OooO0oO;

    public static final class OooO00o {
        public int OooO00o;
        public int OooO0O0 = Color.parseColor("#cccccc");
        public int OooO0OO;
        public boolean OooO0Oo;
        public boolean OooO0o0;
    }

    public final boolean OooO00o(int i, int i2) {
        return (i + 1) % i2 == 0;
    }

    public final boolean OooO00o(int i, int i2, int i3) {
        return i / i3 == (i2 - 1) / i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
    
        if (r8 != (r2.getItemCount() - 1)) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002e, code lost:
    
        if (r8 != (r2.getItemCount() - 1)) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
        Intrinsics.h(rect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(recyclerView, "parent");
        Intrinsics.h(xVar, "state");
        int i = this.OooO0o0;
        if (i == 0) {
            if (!this.OooO0Oo) {
                int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                Intrinsics.e(adapter);
            }
            rect.set(0, 0, 0, this.OooO0O0);
            if (this.OooO0OO && recyclerView.getChildLayoutPosition(view) == 0) {
                int i2 = this.OooO0O0;
                rect.set(0, i2, 0, i2);
                return;
            }
            return;
        }
        if (i == 1) {
            if (!this.OooO0Oo) {
                int childLayoutPosition2 = recyclerView.getChildLayoutPosition(view);
                RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
                Intrinsics.e(adapter2);
            }
            rect.set(0, 0, this.OooO0O0, 0);
            if (this.OooO0OO && recyclerView.getChildLayoutPosition(view) == 0) {
                int i3 = this.OooO0O0;
                rect.set(i3, 0, i3, 0);
                return;
            }
            return;
        }
        if (i == 2) {
            GridLayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.e(layoutManager);
            int U = layoutManager.U();
            RecyclerView.Adapter adapter3 = recyclerView.getAdapter();
            Intrinsics.e(adapter3);
            int itemCount = adapter3.getItemCount();
            if (OooO00o(recyclerView.getChildLayoutPosition(view), itemCount, U) && OooO00o(recyclerView.getChildLayoutPosition(view), U)) {
                rect.set(0, 0, 0, 0);
                return;
            }
            if (OooO00o(recyclerView.getChildLayoutPosition(view), itemCount, U)) {
                rect.set(0, 0, this.OooO0O0, 0);
            } else if ((recyclerView.getChildLayoutPosition(view) + 1) % U == 0) {
                rect.set(0, 0, 0, this.OooO0O0);
            } else {
                int i4 = this.OooO0O0;
                rect.set(0, 0, i4, i4);
            }
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar) {
        int i;
        Intrinsics.h(canvas, "c");
        Intrinsics.h(recyclerView, "parent");
        Intrinsics.h(xVar, "state");
        Paint paint = this.OooO0o;
        if (paint != null) {
            paint.setColor(this.OooO00o);
        }
        int i2 = this.OooO0o0;
        int i3 = 2;
        int i4 = 0;
        if (i2 == 0) {
            int childCount = recyclerView.getChildCount();
            if (this.OooO0OO) {
                float top = recyclerView.getChildAt(0).getTop() - (this.OooO0O0 / 2);
                float width = recyclerView.getWidth();
                Paint paint2 = this.OooO0o;
                Intrinsics.e(paint2);
                canvas.drawLine(0, top, width, top, paint2);
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                if (!this.OooO0Oo && i5 == childCount - 1) {
                    return;
                }
                float bottom = (this.OooO0O0 / 2) + recyclerView.getChildAt(i5).getBottom();
                float width2 = recyclerView.getWidth();
                Paint paint3 = this.OooO0o;
                Intrinsics.e(paint3);
                canvas.drawLine(0, bottom, width2, bottom, paint3);
            }
            return;
        }
        if (i2 == 1) {
            int childCount2 = recyclerView.getChildCount();
            if (this.OooO0OO) {
                float left = recyclerView.getChildAt(0).getLeft() - (this.OooO0O0 / 2);
                float height = recyclerView.getHeight();
                Paint paint4 = this.OooO0o;
                Intrinsics.e(paint4);
                canvas.drawLine(left, 0, left, height, paint4);
            }
            for (int i6 = 0; i6 < childCount2; i6++) {
                if (!this.OooO0Oo && i6 == childCount2 - 1) {
                    return;
                }
                float right = (this.OooO0O0 / 2) + recyclerView.getChildAt(i6).getRight();
                float height2 = recyclerView.getHeight();
                Paint paint5 = this.OooO0o;
                Intrinsics.e(paint5);
                canvas.drawLine(right, 0, right, height2, paint5);
            }
            return;
        }
        if (i2 != 2) {
            return;
        }
        int childCount3 = recyclerView.getChildCount();
        GridLayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.e(layoutManager);
        int U = layoutManager.U();
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Intrinsics.e(adapter);
        int itemCount = adapter.getItemCount();
        while (i4 < childCount3) {
            View childAt = recyclerView.getChildAt(i4);
            int right2 = (this.OooO0O0 / i3) + childAt.getRight();
            int bottom2 = (this.OooO0O0 / i3) + childAt.getBottom();
            if (OooO00o(i4, itemCount, U)) {
                i = bottom2;
            } else {
                float left2 = childAt.getLeft();
                float f = bottom2;
                float right3 = childAt.getRight() + this.OooO0O0;
                Paint paint6 = this.OooO0o;
                Intrinsics.e(paint6);
                i = bottom2;
                canvas.drawLine(left2, f, right3, f, paint6);
            }
            if (OooO00o(i4, itemCount, U) && !OooO00o(i4, U)) {
                float f2 = right2;
                float top2 = childAt.getTop();
                float bottom3 = childAt.getBottom();
                Paint paint7 = this.OooO0o;
                Intrinsics.e(paint7);
                canvas.drawLine(f2, top2, f2, bottom3, paint7);
            } else if (!OooO00o(i4, U)) {
                float f3 = right2;
                Paint paint8 = this.OooO0o;
                Intrinsics.e(paint8);
                canvas.drawLine(f3, childAt.getTop(), f3, i, paint8);
            }
            i4++;
            i3 = 2;
        }
    }
}
