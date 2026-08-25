package tf;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$l;
import androidx.recyclerview.widget.RecyclerView$x;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class i extends RecyclerView$l {

    /* renamed from: a, reason: collision with root package name */
    private final int f17910a;

    /* renamed from: b, reason: collision with root package name */
    private final int f17911b;

    public i(int i5, int i6) {
        this.f17910a = i5;
        this.f17911b = i6;
    }

    public /* synthetic */ i(int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5, (i7 & 2) != 0 ? -1 : i6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$l
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView$x recyclerView$x) {
        int i5;
        Intrinsics.h(rect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(recyclerView, "parent");
        Intrinsics.h(recyclerView$x, "state");
        super.getItemOffsets(rect, view, recyclerView, recyclerView$x);
        if (recyclerView.getChildAdapterPosition(view) == 0 && (i5 = this.f17911b) > 0) {
            rect.top = i5;
        }
        rect.bottom = this.f17910a;
    }
}
