package tf;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$l;
import androidx.recyclerview.widget.RecyclerView$x;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class j extends RecyclerView$l {

    /* renamed from: a, reason: collision with root package name */
    private final int f17912a;

    public j() {
        this(0, 1, null);
    }

    public j(int i5) {
        this.f17912a = i5;
    }

    public /* synthetic */ j(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? -1 : i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$l
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView$x recyclerView$x) {
        Intrinsics.h(rect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(recyclerView, "parent");
        Intrinsics.h(recyclerView$x, "state");
        super.getItemOffsets(rect, view, recyclerView, recyclerView$x);
        rect.top = this.f17912a;
    }
}
