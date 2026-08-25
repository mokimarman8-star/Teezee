package sq;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends RecyclerView.l {
    private int a;
    private int b;
    private int c;
    private int d;

    public b(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
        Intrinsics.h(rect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(recyclerView, "parent");
        Intrinsics.h(xVar, "state");
        super.getItemOffsets(rect, view, recyclerView, xVar);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        GridLayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof GridLayoutManager)) {
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                ((StaggeredGridLayoutManager) layoutManager).Q();
                StaggeredGridLayoutManager.b layoutParams = view.getLayoutParams();
                Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
                int a = layoutParams.a();
                if (childAdapterPosition == 0) {
                    rect.left = 0;
                    rect.right = 0;
                    return;
                }
                rect.bottom = a0.a(16.0f);
                if (a == 0) {
                    rect.left = this.a;
                    rect.right = this.b;
                    return;
                } else {
                    rect.left = this.b;
                    rect.right = this.a;
                    return;
                }
            }
            return;
        }
        GridLayoutManager gridLayoutManager = layoutManager;
        int U = gridLayoutManager.U();
        int e = gridLayoutManager.Y().e(childAdapterPosition, U);
        boolean z = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        if (e == 0) {
            if (z) {
                rect.left = this.b;
                rect.right = this.a;
            } else {
                rect.left = this.a;
                rect.right = this.b;
            }
        } else if (e != U - 1) {
            int i = this.b;
            rect.left = i;
            rect.right = i;
        } else if (z) {
            rect.left = this.a;
            rect.right = this.b;
        } else {
            rect.left = this.b;
            rect.right = this.a;
        }
        BaseQuickAdapter adapter = recyclerView.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        if ((adapter instanceof BaseQuickAdapter) && adapter.s0()) {
            if (childAdapterPosition == 0) {
                rect.left = 0;
                rect.right = 0;
                rect.top = 0;
                rect.bottom = this.d / 2;
                return;
            }
            childAdapterPosition--;
        }
        int i2 = (itemCount / U) + (itemCount % U != 0 ? 1 : 0);
        int i3 = childAdapterPosition / U;
        if (i3 == 0) {
            rect.top = 0;
            rect.bottom = this.d / 2;
        } else if (i3 == i2 - 1) {
            rect.top = this.c / 2;
            rect.bottom = 0;
        } else {
            rect.top = this.c / 2;
            rect.bottom = this.d / 2;
        }
    }
}
