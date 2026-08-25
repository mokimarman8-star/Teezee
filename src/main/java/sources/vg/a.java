package vg;

import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a extends RecyclerView.r {
    public static final C0156a f = new C0156a(null);
    private b a;
    private RecyclerView d;
    private int b = 10;
    private int c = 2;
    private final SparseArray e = new SparseArray();

    /* renamed from: vg.a$a, reason: collision with other inner class name */
    public static final class C0156a {
        private C0156a() {
        }

        public /* synthetic */ C0156a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface b {
        int a();

        void onItemViewVisible(boolean z, int i);
    }

    private final int[] e(int[] iArr, int[] iArr2) {
        int i = iArr[0];
        int i2 = iArr2[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i > i4) {
                i = i4;
            }
        }
        int length2 = iArr2.length;
        for (int i8 = 1; i8 < length2; i8++) {
            int i9 = iArr2[i8];
            if (i2 < i9) {
                i2 = i9;
            }
        }
        return new int[]{i, i2};
    }

    private final int[] f(GridLayoutManager gridLayoutManager) {
        return new int[]{gridLayoutManager.findFirstVisibleItemPosition(), gridLayoutManager.findLastVisibleItemPosition()};
    }

    private final int[] g(LinearLayoutManager linearLayoutManager) {
        return new int[]{linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition()};
    }

    private final int[] h(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        int[] iArr = new int[staggeredGridLayoutManager.Q()];
        int[] iArr2 = new int[staggeredGridLayoutManager.Q()];
        staggeredGridLayoutManager.D(iArr);
        staggeredGridLayoutManager.G(iArr2);
        return e(iArr, iArr2);
    }

    private final String i() {
        return a.class.getSimpleName();
    }

    private final void j() {
        Object obj;
        RecyclerView recyclerView = this.d;
        if (recyclerView == null || recyclerView == null || recyclerView.getVisibility() != 0) {
            return;
        }
        RecyclerView recyclerView2 = this.d;
        if (recyclerView2 == null || recyclerView2.isShown()) {
            RecyclerView recyclerView3 = this.d;
            if (recyclerView3 == null || recyclerView3.getGlobalVisibleRect(new Rect())) {
                try {
                    Result.Companion companion = Result.Companion;
                    int[] iArr = new int[2];
                    RecyclerView recyclerView4 = this.d;
                    RecyclerView.m layoutManager = recyclerView4 != null ? recyclerView4.getLayoutManager() : null;
                    if (layoutManager instanceof GridLayoutManager) {
                        iArr = f((GridLayoutManager) layoutManager);
                    } else if (layoutManager instanceof LinearLayoutManager) {
                        iArr = g((LinearLayoutManager) layoutManager);
                    } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                        iArr = h((StaggeredGridLayoutManager) layoutManager);
                    }
                    int i = iArr[0];
                    int i2 = iArr[1];
                    if (i <= i2) {
                        while (true) {
                            b bVar = this.a;
                            if (bVar == null || i != bVar.a()) {
                                m(layoutManager != null ? layoutManager.findViewByPosition(i) : null, i);
                            }
                            if (i == i2) {
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                    obj = Result.constructor-impl(Unit.a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.a(th));
                }
                Throwable th2 = Result.exceptionOrNull-impl(obj);
                if (th2 == null) {
                    return;
                }
                Log.e(i(), "RecyclerViewExposeUtil --> handleCurrentVisibleItems() --> " + Log.getStackTraceString(th2));
            }
        }
    }

    private final void m(View view, int i) {
        if (view != null && view.getVisibility() == 0 && view.isShown() && view.getGlobalVisibleRect(new Rect())) {
            Rect rect = new Rect();
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
            boolean z = ((double) rect.height()) * ((double) rect.width()) > ((((double) view.getMeasuredHeight()) * ((double) view.getMeasuredWidth())) * ((double) this.b)) / ((double) 100);
            StringBuilder sb = new StringBuilder();
            sb.append("isItemViewVisibleInLogic = ");
            sb.append(z);
            if (!globalVisibleRect || !z) {
                b bVar = this.a;
                if (bVar != null) {
                    bVar.onItemViewVisible(false, i);
                }
                if (this.c == 2) {
                    this.e.remove(i);
                    return;
                }
                return;
            }
            if (this.e.get(i) != null) {
                return;
            }
            this.e.put(i, Long.valueOf(System.currentTimeMillis()));
            b bVar2 = this.a;
            if (bVar2 != null) {
                bVar2.onItemViewVisible(true, i);
            }
        }
    }

    public final void d() {
        l();
        RecyclerView recyclerView = this.d;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this);
        }
        this.a = null;
        this.d = null;
    }

    public final void k() {
        j();
    }

    public final void l() {
        this.e.clear();
    }

    public final void n(RecyclerView recyclerView, b bVar) {
        RecyclerView recyclerView2;
        this.a = bVar;
        this.d = recyclerView;
        if (recyclerView == null || recyclerView == null || recyclerView.getVisibility() != 0 || (recyclerView2 = this.d) == null) {
            return;
        }
        recyclerView2.addOnScrollListener(this);
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.h(recyclerView, "recyclerView");
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.h(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        j();
    }
}
