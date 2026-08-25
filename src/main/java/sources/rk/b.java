package rk;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.home.R;
import com.transsion.home.view.OpRankingView;
import java.util.SortedSet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends RecyclerView.r {
    public static final a i = new a(null);
    public static final int j = 8;
    private static String k = "ExposureHelper";
    private final float a;
    private final rk.a b;
    private final boolean c;
    private int d;
    private int e;
    private int f;
    private final SparseArray g;
    private SortedSet h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(float f, rk.a aVar, boolean z) {
        Intrinsics.h(aVar, "callback");
        this.a = f;
        this.b = aVar;
        this.c = z;
        this.g = new SparseArray();
    }

    public /* synthetic */ b(float f, rk.a aVar, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, aVar, (i2 & 4) != 0 ? false : z);
    }

    private final boolean d(View view) {
        if (view == null) {
            return false;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        if (f(view)) {
            return true;
        }
        int width2 = rect.width();
        int height2 = rect.height();
        int i2 = this.d;
        if (i2 != 1) {
            if (i2 != 2) {
                double d = (width2 * 1.0d) / width;
                float f = this.a;
                if (d < f || (height2 * 1.0d) / height < f) {
                    return false;
                }
            } else if ((height2 * 1.0d) / height < this.a) {
                return false;
            }
        } else if ((width2 * 1.0d) / width < this.a) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [android.view.View, com.transsion.home.view.OpRankingView] */
    private final boolean f(View view) {
        boolean z;
        ?? r3;
        if (view == null || (r3 = (OpRankingView) view.findViewById(R.id.ranking_view)) == 0) {
            z = false;
        } else {
            GridLayoutManager layoutManager = r3.findViewById(R.id.recycler_view).getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            this.h = r3.calcExposureLines(layoutManager);
            z = r3;
        }
        return z;
    }

    private final void g(int i2, int i3, int i4) {
        if (i3 < 0 || i4 >= i2 || i3 > i4 || i3 > i4) {
            return;
        }
        while (true) {
            if (this.g.get(i3) == null) {
                a.a.f(wf.a.a, k, "offer position  " + i3, false, 4, (Object) null);
                this.g.put(i3, Long.valueOf(System.currentTimeMillis()));
            }
            if (i3 == i4) {
                return;
            } else {
                i3++;
            }
        }
    }

    private final void j(int i2) {
        if (this.g.get(i2) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Long l = (Long) this.g.get(i2);
        long longValue = l != null ? l.longValue() : currentTimeMillis;
        this.g.remove(i2);
        long j2 = currentTimeMillis - longValue;
        a.a.f(wf.a.a, k, "out position " + i2 + " duration " + j2, false, 4, (Object) null);
        if (j2 <= 1000) {
            return;
        }
        this.b.a(i2, j2, null);
    }

    private final void k(int i2, int i3, int i4) {
        if (i3 < 0 || i4 >= i2 || i3 > i4 || i3 > i4) {
            return;
        }
        while (true) {
            j(i4);
            if (i4 == i3) {
                return;
            } else {
                i4--;
            }
        }
    }

    public final void e() {
        long currentTimeMillis = System.currentTimeMillis();
        SparseArray sparseArray = this.g;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = sparseArray.keyAt(i2);
            Long l = (Long) sparseArray.valueAt(i2);
            long longValue = currentTimeMillis - (l != null ? l.longValue() : currentTimeMillis);
            a.a.f(wf.a.a, k, "clearCache out position " + keyAt + " duration " + longValue, false, 4, (Object) null);
            if (longValue <= 1000) {
                return;
            }
            this.b.a(keyAt, longValue, null);
        }
        this.g.clear();
    }

    public final void h(LinearLayoutManager linearLayoutManager, int i2, boolean z) {
        Intrinsics.h(linearLayoutManager, "manager");
        if (z) {
            g(linearLayoutManager.getItemCount(), i2, i2);
        }
    }

    public final void i(LinearLayoutManager linearLayoutManager, boolean z) {
        Intrinsics.h(linearLayoutManager, "manager");
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (!d(linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition))) {
            findFirstVisibleItemPosition++;
        }
        if (!d(linearLayoutManager.findViewByPosition(findLastVisibleItemPosition))) {
            findLastVisibleItemPosition--;
        }
        if (this.e == 0 && this.f == 0) {
            g(linearLayoutManager.getItemCount(), findFirstVisibleItemPosition, findLastVisibleItemPosition);
            this.e = findFirstVisibleItemPosition;
            this.f = findLastVisibleItemPosition;
            return;
        }
        if (z) {
            k(linearLayoutManager.getItemCount(), this.e, findFirstVisibleItemPosition - 1);
            g(linearLayoutManager.getItemCount(), this.f + 1, findLastVisibleItemPosition);
        } else {
            k(linearLayoutManager.getItemCount(), findLastVisibleItemPosition + 1, this.f);
            g(linearLayoutManager.getItemCount(), findFirstVisibleItemPosition, this.e - 1);
        }
        this.e = findFirstVisibleItemPosition;
        this.f = findLastVisibleItemPosition;
    }

    public final void l(int i2) {
        this.d = i2;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        Intrinsics.h(recyclerView, "recyclerView");
        a.a.f(wf.a.a, k, "newState " + i2, false, 4, (Object) null);
    }

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i2, i3);
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        i((LinearLayoutManager) layoutManager, i3 >= 0);
    }
}
