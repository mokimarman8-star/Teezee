package tf;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$l;
import androidx.recyclerview.widget.RecyclerView$x;
import com.chad.library.adapter.base.BaseQuickAdapter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a extends RecyclerView$l {

    /* renamed from: a, reason: collision with root package name */
    private int f17885a;

    /* renamed from: b, reason: collision with root package name */
    private int f17886b;

    /* renamed from: c, reason: collision with root package name */
    private int f17887c;

    /* renamed from: d, reason: collision with root package name */
    private int f17888d;

    public a(int i5, int i6, int i7, int i8) {
        this.f17885a = i5;
        this.f17886b = i6;
        this.f17887c = i7;
        this.f17888d = i8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$l
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView$x recyclerView$x) {
        Intrinsics.h(rect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(recyclerView, "parent");
        Intrinsics.h(recyclerView$x, "state");
        super.getItemOffsets(rect, view, recyclerView, recyclerView$x);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        GridLayoutManager layoutManager = recyclerView.getLayoutManager();
        BaseQuickAdapter adapter = recyclerView.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = layoutManager;
            int U = gridLayoutManager.U();
            if (gridLayoutManager.getOrientation() != 1) {
                if (gridLayoutManager.getOrientation() == 0) {
                    int i5 = this.f17886b;
                    rect.top = i5 / 2;
                    rect.bottom = i5 / 2;
                    int i6 = ((itemCount + U) - 1) / U;
                    int i7 = childAdapterPosition / U;
                    if (i7 == 0) {
                        rect.left = this.f17887c;
                        rect.right = this.f17885a / 2;
                        return;
                    } else if (i7 == i6 - 1) {
                        rect.left = this.f17885a / 2;
                        rect.right = this.f17888d;
                        return;
                    } else {
                        int i8 = this.f17885a;
                        rect.left = i8 / 2;
                        rect.right = i8 / 2;
                        return;
                    }
                }
                return;
            }
            int i9 = this.f17885a;
            rect.left = i9 / 2;
            rect.right = i9 / 2;
            if ((adapter instanceof BaseQuickAdapter) && adapter.s0()) {
                if (childAdapterPosition == 0) {
                    rect.left = 0;
                    rect.right = 0;
                    rect.top = 0;
                    rect.bottom = this.f17886b / 2;
                    return;
                }
                childAdapterPosition--;
            }
            int i10 = ((itemCount + U) - 1) / U;
            int i11 = childAdapterPosition / U;
            if (i11 == 0) {
                rect.top = this.f17887c;
                rect.bottom = this.f17886b / 2;
            } else if (i11 == i10 - 1) {
                rect.top = this.f17886b / 2;
                rect.bottom = this.f17888d;
            } else {
                int i12 = this.f17886b;
                rect.top = i12 / 2;
                rect.bottom = i12 / 2;
            }
        }
    }
}
