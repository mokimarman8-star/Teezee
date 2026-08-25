package tf;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$l;
import androidx.recyclerview.widget.RecyclerView$x;
import com.blankj.utilcode.util.a0;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class h extends RecyclerView$l {

    /* renamed from: a, reason: collision with root package name */
    private int f17905a;

    /* renamed from: b, reason: collision with root package name */
    private int f17906b;

    /* renamed from: c, reason: collision with root package name */
    private float f17907c;

    /* renamed from: d, reason: collision with root package name */
    private float f17908d;

    /* renamed from: e, reason: collision with root package name */
    private float f17909e;

    public h(int i5, int i6) {
        this.f17905a = i5;
        if (i6 > 1) {
            int a5 = a0.a(((i6 - 1) * 8) + 24.0f) / i6;
            float a6 = a0.a(12.0f);
            this.f17908d = a6;
            float f5 = a5;
            this.f17907c = f5 - a6;
            this.f17909e = f5 / 2.0f;
        }
    }

    public final void d(int i5) {
        this.f17906b = i5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$l
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView$x recyclerView$x) {
        Intrinsics.h(rect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(recyclerView, "parent");
        Intrinsics.h(recyclerView$x, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null && childAdapterPosition == adapter.getItemCount() - 1) {
            rect.bottom = 0;
        } else if (this.f17906b != 0 && (Intrinsics.c(view.getTag(), "TrendingTitle") || Intrinsics.c(view.getTag(), "UGCFeedsBig"))) {
            rect.bottom = this.f17906b;
        } else if (Intrinsics.c(view.getTag(), "TrendingMargin")) {
            rect.bottom = 0;
        } else {
            rect.bottom = this.f17905a;
        }
        GridLayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = layoutManager;
            int U = gridLayoutManager.U();
            int f5 = gridLayoutManager.Y().f(childAdapterPosition);
            int e5 = gridLayoutManager.Y().e(childAdapterPosition, U);
            if (f5 == U) {
                return;
            }
            float f6 = this.f17908d;
            if (f6 > 0.0f) {
                if (e5 == 0) {
                    rect.left = (int) f6;
                    rect.right = (int) this.f17907c;
                } else if (e5 == U - f5) {
                    rect.left = (int) this.f17907c;
                    rect.right = (int) f6;
                } else {
                    float f7 = this.f17909e;
                    rect.left = (int) f7;
                    rect.right = (int) f7;
                }
                rect.bottom = this.f17906b;
            }
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                int i5 = rect.left;
                rect.left = rect.right;
                rect.right = i5;
            }
        }
    }
}
