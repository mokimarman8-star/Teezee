package bj;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.transsion.baselib.exposure.ExposureType;
import ij.q;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends RecyclerView.r {
    public static final a j = new a(null);
    private static String k = "ExposureHelper";
    private final float a;
    private final bj.a b;
    private final boolean c;
    private int d;
    private ExposureType e;
    private q f;
    private int g;
    private int h;
    private final SparseArray i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return b.k;
        }
    }

    public b(float f, bj.a aVar, boolean z) {
        Intrinsics.h(aVar, "callback");
        this.a = f;
        this.b = aVar;
        this.c = z;
        this.e = ExposureType.VERTICAL_FEED;
        this.i = new SparseArray();
    }

    public /* synthetic */ b(float f, bj.a aVar, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, aVar, (i & 4) != 0 ? false : z);
    }

    private final boolean e(View view) {
        if (view == null) {
            return false;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        int width2 = rect.width();
        int height2 = rect.height();
        int i = this.d;
        if (i != 1) {
            if (i != 2) {
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

    private final void h(int i, int i2, int i3) {
        if (i2 < 0 || i3 >= i || i2 > i3 || i2 > i3) {
            return;
        }
        while (this.i.get(i2) == null) {
            int i4 = i2 + 1;
            a.a.f(wf.a.a, k, "offer position  " + i2, false, 4, (Object) null);
            this.i.put(i2, Long.valueOf(System.currentTimeMillis()));
            q qVar = this.f;
            if (qVar != null) {
                qVar.a(i4);
            }
            if (i2 == i3) {
                return;
            } else {
                i2 = i4;
            }
        }
    }

    public static /* synthetic */ void j(b bVar, RecyclerView.m mVar, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        bVar.i(mVar, i, z, z2);
    }

    private final void l(int i) {
        if (this.i.get(i) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Long l = (Long) this.i.get(i);
        long longValue = l != null ? l.longValue() : currentTimeMillis;
        this.i.remove(i);
        long j2 = currentTimeMillis - longValue;
        a.a.f(wf.a.a, k, "out position " + i + " duration " + j2, false, 4, (Object) null);
        if (j2 <= 1000) {
            return;
        }
        this.b.a(i, j2, null);
    }

    private final void m(int i, int i2, int i3) {
        if (i2 < 0 || i3 >= i || i2 > i3 || i2 > i3) {
            return;
        }
        while (true) {
            l(i3);
            if (i3 == i2) {
                return;
            } else {
                i3--;
            }
        }
    }

    public final void f() {
        long currentTimeMillis = System.currentTimeMillis();
        SparseArray sparseArray = this.i;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int keyAt = sparseArray.keyAt(i);
            Long l = (Long) sparseArray.valueAt(i);
            long longValue = currentTimeMillis - (l != null ? l.longValue() : currentTimeMillis);
            a.a.f(wf.a.a, k, "clearCache out position " + keyAt + " duration " + longValue, false, 4, (Object) null);
            this.b.a(keyAt, longValue, null);
        }
        this.i.clear();
    }

    public final void g() {
        f();
        this.g = 0;
        this.h = 0;
    }

    public final void i(RecyclerView.m mVar, int i, boolean z, boolean z2) {
        Intrinsics.h(mVar, "manager");
        if (z) {
            View findViewByPosition = mVar.findViewByPosition(i);
            if (z2) {
                h(mVar.getItemCount(), i, i);
                return;
            }
            boolean e = e(findViewByPosition);
            a.a.f(wf.a.a, k, "firstView " + findViewByPosition + " export " + e + " count " + mVar.getItemCount(), false, 4, (Object) null);
            if (e) {
                h(mVar.getItemCount(), i, i);
            }
        }
    }

    public final void k(RecyclerView.m mVar, boolean z) {
        int R;
        int R2;
        Intrinsics.h(mVar, "manager");
        boolean z2 = mVar instanceof LinearLayoutManager;
        if (z2) {
            R = ((LinearLayoutManager) mVar).findFirstVisibleItemPosition();
        } else {
            if (!(mVar instanceof StaggeredGridLayoutManager)) {
                return;
            }
            int[] D = ((StaggeredGridLayoutManager) mVar).D((int[]) null);
            Intrinsics.g(D, "findFirstVisibleItemPositions(...)");
            R = ArraysKt.R(D);
        }
        if (z2) {
            R2 = ((LinearLayoutManager) mVar).findLastVisibleItemPosition();
        } else {
            if (!(mVar instanceof StaggeredGridLayoutManager)) {
                return;
            }
            int[] G = ((StaggeredGridLayoutManager) mVar).G((int[]) null);
            Intrinsics.g(G, "findLastVisibleItemPositions(...)");
            R2 = ArraysKt.R(G);
        }
        if (!e(mVar.findViewByPosition(R)) && this.e != ExposureType.NEST_HORIZONTAL) {
            R++;
        }
        if (!e(mVar.findViewByPosition(R2)) && this.e != ExposureType.NEST_HORIZONTAL) {
            R2--;
        }
        if (this.g == 0 && this.h == 0) {
            h(mVar.getItemCount(), R, R2);
            this.g = R;
            this.h = R2;
            return;
        }
        if (z) {
            m(mVar.getItemCount(), this.g, R - 1);
            h(mVar.getItemCount(), this.h + 1, R2);
        } else {
            m(mVar.getItemCount(), R2 + 1, this.h);
            h(mVar.getItemCount(), R, this.g - 1);
        }
        this.g = R;
        this.h = R2;
    }

    public final void n(int i) {
        this.d = i;
    }

    public final void o(ExposureType exposureType) {
        Intrinsics.h(exposureType, "exposureType");
        this.e = exposureType;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.h(recyclerView, "recyclerView");
        a.a.f(wf.a.a, k, "newState " + i, false, 4, (Object) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        if (r6 <= 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        if (((androidx.recyclerview.widget.StaggeredGridLayoutManager) r4).getOrientation() == 1) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
    
        if (r4.getOrientation() == 1) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0030, code lost:
    
        if (r5 <= 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        boolean z = false;
        if (!(layoutManager instanceof LinearLayoutManager)) {
            if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
                return;
            }
        }
        k(layoutManager, z);
    }

    public final void p(q qVar) {
        this.f = qVar;
    }
}
