package tf;

import android.graphics.Rect;
import android.view.View;
import androidx.core.text.u;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$l;
import androidx.recyclerview.widget.RecyclerView$x;
import com.blankj.utilcode.util.a0;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class f extends RecyclerView$l {

    /* renamed from: a, reason: collision with root package name */
    private final float f17900a;

    /* renamed from: b, reason: collision with root package name */
    private final float f17901b;

    /* renamed from: c, reason: collision with root package name */
    private final float f17902c;

    public f() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    public f(float f5, float f6, float f7) {
        this.f17900a = f5;
        this.f17901b = f6;
        this.f17902c = f7;
    }

    public /* synthetic */ f(float f5, float f6, float f7, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0.0f : f5, (i5 & 2) != 0 ? 0.0f : f6, (i5 & 4) != 0 ? 0.0f : f7);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$l
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView$x recyclerView$x) {
        Intrinsics.h(rect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(recyclerView, "parent");
        Intrinsics.h(recyclerView$x, "state");
        super.getItemOffsets(rect, view, recyclerView, recyclerView$x);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != 0) {
            float f5 = this.f17900a;
            if (f5 > 0.0f) {
                rect.left = a0.a(f5);
            }
            float f6 = this.f17901b;
            if (f6 > 0.0f) {
                rect.top = a0.a(f6);
            }
        }
        int b5 = recyclerView$x.b() - 1;
        float f7 = this.f17902c;
        if (f7 > 0.0f && this.f17900a > 0.0f) {
            if (childAdapterPosition == 0) {
                rect.left = a0.a(f7);
            }
            if (childAdapterPosition == b5) {
                rect.right = a0.a(this.f17902c);
            }
        }
        float f8 = this.f17902c;
        if (f8 > 0.0f && this.f17901b > 0.0f) {
            if (childAdapterPosition == 0) {
                rect.top = a0.a(f8);
            }
            if (childAdapterPosition == b5) {
                rect.bottom = a0.a(this.f17902c);
            }
        }
        if (u.a(Locale.getDefault()) == 1) {
            int i5 = rect.left;
            rect.left = rect.right;
            rect.right = i5;
        }
    }
}
