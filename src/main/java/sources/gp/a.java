package gp;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends RecyclerView.l {
    private int a;
    private int b;
    private int c;

    public a(int i, int i2, int i3) {
        this.c = i;
        this.b = i2;
        this.a = i3;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
        Intrinsics.h(rect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(recyclerView, "parent");
        Intrinsics.h(xVar, "state");
        super.getItemOffsets(rect, view, recyclerView, xVar);
        recyclerView.getChildAdapterPosition(view);
        rect.top = this.c;
        rect.left = this.b;
        rect.right = this.a;
    }
}
