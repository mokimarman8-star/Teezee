package ij;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    private final RecyclerView a;
    private final float b;
    private final Function1 c;
    private final Set d;

    public static final class a extends RecyclerView.r {
        a() {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i, i2);
            e.this.d();
        }
    }

    public e(RecyclerView recyclerView, RecyclerView recyclerView2, float f, Function1 function1) {
        Intrinsics.h(function1, "onExposure");
        this.a = recyclerView2;
        this.b = f;
        this.c = function1;
        this.d = new LinkedHashSet();
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new a());
        }
        d();
    }

    private final boolean c(View view, int i) {
        Rect rect = new Rect();
        RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            recyclerView.getGlobalVisibleRect(rect);
        }
        Rect rect2 = new Rect();
        if (view != null) {
            view.getGlobalVisibleRect(rect2);
        }
        int i2 = rect2.intersect(rect) ? rect2.bottom - rect2.top : 0;
        int height = view != null ? view.getHeight() : 0;
        float f = this.b;
        if (f < 0.0f) {
            f = 0.1f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        return ((float) i2) >= ((float) height) * f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        RecyclerView recyclerView = this.a;
        RecyclerView.m layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (layoutManager instanceof LinearLayoutManager) {
            f(this.a, layoutManager, this.c);
        } else if (layoutManager instanceof GridLayoutManager) {
            f(this.a, layoutManager, this.c);
        }
    }

    private final void f(RecyclerView recyclerView, RecyclerView.m mVar, Function1 function1) {
        RecyclerView recyclerView2 = this.a;
        int childCount = recyclerView2 != null ? recyclerView2.getChildCount() : 0;
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerView3 = this.a;
            View childAt = recyclerView3 != null ? recyclerView3.getChildAt(i) : null;
            if (!this.d.contains(Integer.valueOf(i)) && c(childAt, i)) {
                this.d.add(Integer.valueOf(i));
                if (childAt != null) {
                    RecyclerView recyclerView4 = this.a;
                    function1.invoke(Integer.valueOf(recyclerView4 != null ? recyclerView4.getChildAdapterPosition(childAt) : -1));
                }
            }
        }
    }

    public final void b() {
        this.d.clear();
    }

    public final void e() {
        b();
        d();
    }
}
