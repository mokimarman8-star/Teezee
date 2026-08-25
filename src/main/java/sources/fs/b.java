package fs;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.shorttv_pugc.base.exposure.ExposureType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b extends RecyclerView.r {
    public static final a i = new a(null);
    private static String j = "ExposureHelper";
    private final float a;
    private final fs.a b;
    private final boolean c;
    private int d;
    private ExposureType e;
    private int f;
    private int g;
    private final SparseArray h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(float f, fs.a callback, boolean z) {
        Intrinsics.h(callback, "callback");
        this.a = f;
        this.b = callback;
        this.c = z;
        this.e = ExposureType.VERTICAL_FEED;
        this.h = new SparseArray();
    }

    public /* synthetic */ b(float f, fs.a aVar, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
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

    private final void f(int i2, int i3, int i4) {
        if (i3 < 0 || i4 >= i2 || i3 > i4 || i3 > i4) {
            return;
        }
        while (this.h.get(i3) == null) {
            a.a.f(wf.a.a, j, "offer position  " + i3, false, 4, (Object) null);
            this.h.put(i3, Long.valueOf(System.currentTimeMillis()));
            if (i3 == i4) {
                return;
            } else {
                i3++;
            }
        }
    }

    public static /* synthetic */ void h(b bVar, LinearLayoutManager linearLayoutManager, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z2 = false;
        }
        bVar.g(linearLayoutManager, i2, z, z2);
    }

    private final void j(int i2) {
        if (this.h.get(i2) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Long l = (Long) this.h.get(i2);
        long longValue = l != null ? l.longValue() : currentTimeMillis;
        this.h.remove(i2);
        long j2 = currentTimeMillis - longValue;
        a.a.f(wf.a.a, j, "out position " + i2 + " duration " + j2, false, 4, (Object) null);
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
        SparseArray sparseArray = this.h;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = sparseArray.keyAt(i2);
            Long l = (Long) sparseArray.valueAt(i2);
            long longValue = currentTimeMillis - (l != null ? l.longValue() : currentTimeMillis);
            a.a.f(wf.a.a, j, "clearCache out position " + keyAt + " duration " + longValue, false, 4, (Object) null);
            this.b.a(keyAt, longValue, null);
        }
        this.h.clear();
    }

    public final void g(LinearLayoutManager manager, int i2, boolean z, boolean z2) {
        Intrinsics.h(manager, "manager");
        if (z) {
            View findViewByPosition = manager.findViewByPosition(i2);
            if (z2) {
                f(manager.getItemCount(), i2, i2);
                return;
            }
            boolean d = d(findViewByPosition);
            a.a.f(wf.a.a, j, "firstView " + findViewByPosition + " export " + d + " count " + manager.getItemCount(), false, 4, (Object) null);
            if (d) {
                f(manager.getItemCount(), i2, i2);
            }
        }
    }

    public final void i(LinearLayoutManager manager, boolean z) {
        Intrinsics.h(manager, "manager");
        int findFirstVisibleItemPosition = manager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = manager.findLastVisibleItemPosition();
        if (!d(manager.findViewByPosition(findFirstVisibleItemPosition)) && this.e != ExposureType.NEST_HORIZONTAL) {
            findFirstVisibleItemPosition++;
        }
        if (!d(manager.findViewByPosition(findLastVisibleItemPosition)) && this.e != ExposureType.NEST_HORIZONTAL) {
            findLastVisibleItemPosition--;
        }
        if (this.f == 0 && this.g == 0) {
            f(manager.getItemCount(), findFirstVisibleItemPosition, findLastVisibleItemPosition);
            this.f = findFirstVisibleItemPosition;
            this.g = findLastVisibleItemPosition;
            return;
        }
        if (z) {
            k(manager.getItemCount(), this.f, findFirstVisibleItemPosition - 1);
            f(manager.getItemCount(), this.g + 1, findLastVisibleItemPosition);
        } else {
            k(manager.getItemCount(), findLastVisibleItemPosition + 1, this.g);
            f(manager.getItemCount(), findFirstVisibleItemPosition, this.f - 1);
        }
        this.f = findFirstVisibleItemPosition;
        this.g = findLastVisibleItemPosition;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        Intrinsics.h(recyclerView, "recyclerView");
        a.a.f(wf.a.a, j, "newState " + i2, false, 4, (Object) null);
    }

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i2, i3);
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            boolean z = false;
            if (linearLayoutManager.getOrientation() != 1 ? i2 > 0 : i3 > 0) {
                z = true;
            }
            i(linearLayoutManager, z);
        }
    }
}
