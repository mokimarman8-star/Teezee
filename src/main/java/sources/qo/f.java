package qo;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f extends RecyclerView.l {
    private int a;

    public f(int i) {
        this.a = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
        Intrinsics.h(rect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(recyclerView, "parent");
        Intrinsics.h(xVar, "state");
        super.getItemOffsets(rect, view, recyclerView, xVar);
        recyclerView.getChildAdapterPosition(view);
        rect.top = this.a;
    }
}
