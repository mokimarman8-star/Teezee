package com.transsion.shorttv.base.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.core.text.u;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class m extends RecyclerView.l {
    private final float a;
    private final float b;
    private final float c;

    public m() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    public m(float f, float f2, float f3) {
        this.a = f;
        this.b = f2;
        this.c = f3;
    }

    public /* synthetic */ m(float f, float f2, float f3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f2, (i & 4) != 0 ? 0.0f : f3);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
        Intrinsics.h(rect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(recyclerView, "parent");
        Intrinsics.h(xVar, "state");
        super.getItemOffsets(rect, view, recyclerView, xVar);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != 0) {
            float f = this.a;
            if (f > 0.0f) {
                rect.left = a0.a(f);
            }
            float f2 = this.b;
            if (f2 > 0.0f) {
                rect.top = a0.a(f2);
            }
        }
        int b = xVar.b() - 1;
        float f3 = this.c;
        if (f3 > 0.0f && this.a > 0.0f) {
            if (childAdapterPosition == 0) {
                rect.left = a0.a(f3);
            }
            if (childAdapterPosition == b) {
                rect.right = a0.a(this.c);
            }
        }
        float f4 = this.c;
        if (f4 > 0.0f && this.b > 0.0f) {
            if (childAdapterPosition == 0) {
                rect.top = a0.a(f4);
            }
            if (childAdapterPosition == b) {
                rect.bottom = a0.a(this.c);
            }
        }
        if (u.a(Locale.getDefault()) == 1) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
    }
}
