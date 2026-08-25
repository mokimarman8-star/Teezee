package tf;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$l;
import androidx.recyclerview.widget.RecyclerView$x;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c extends RecyclerView$l {

    /* renamed from: a, reason: collision with root package name */
    private final int f17893a;

    /* renamed from: b, reason: collision with root package name */
    private final int f17894b;

    public c(int i5, int i6) {
        this.f17893a = i5;
        this.f17894b = i6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$l
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView$x recyclerView$x) {
        Intrinsics.h(rect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(recyclerView, "parent");
        Intrinsics.h(recyclerView$x, "state");
        super.getItemOffsets(rect, view, recyclerView, recyclerView$x);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        if (itemCount == 0) {
            return;
        }
        if (childAdapterPosition == 0) {
            rect.left = this.f17893a;
            rect.right = this.f17894b / 2;
        } else if (childAdapterPosition == itemCount - 1) {
            rect.left = this.f17894b / 2;
            rect.right = this.f17893a;
        } else {
            int i5 = this.f17894b;
            rect.left = i5 / 2;
            rect.right = i5 / 2;
        }
    }
}
