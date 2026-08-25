package t6;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class f {
    private final BaseQuickAdapter a;
    private r6.f b;
    private boolean c;
    private LoadMoreStatus d;
    private boolean e;
    private s6.a f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int j;
    private boolean k;

    public f(BaseQuickAdapter baseQuickAdapter) {
        Intrinsics.h(baseQuickAdapter, "baseQuickAdapter");
        this.a = baseQuickAdapter;
        this.c = true;
        this.d = LoadMoreStatus.Complete;
        this.f = j.a();
        this.h = true;
        this.i = true;
        this.j = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(f fVar, View view) {
        Intrinsics.h(fVar, "this$0");
        LoadMoreStatus loadMoreStatus = fVar.d;
        if (loadMoreStatus == LoadMoreStatus.Fail) {
            fVar.w();
            return;
        }
        if (loadMoreStatus == LoadMoreStatus.Complete) {
            fVar.w();
        } else if (fVar.g && loadMoreStatus == LoadMoreStatus.End) {
            fVar.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(f fVar, RecyclerView.m mVar) {
        Intrinsics.h(fVar, "this$0");
        Intrinsics.h(mVar, "$manager");
        if (fVar.q((LinearLayoutManager) mVar)) {
            fVar.c = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(RecyclerView.m mVar, f fVar) {
        Intrinsics.h(mVar, "$manager");
        Intrinsics.h(fVar, "this$0");
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) mVar;
        int[] iArr = new int[staggeredGridLayoutManager.Q()];
        staggeredGridLayoutManager.E(iArr);
        if (fVar.l(iArr) + 1 != fVar.a.getItemCount()) {
            fVar.c = true;
        }
    }

    private final int l(int[] iArr) {
        int i = -1;
        if (iArr != null && iArr.length != 0) {
            for (int i2 : iArr) {
                if (i2 > i) {
                    i = i2;
                }
            }
        }
        return i;
    }

    private final void n() {
        this.d = LoadMoreStatus.Loading;
        RecyclerView n0 = this.a.n0();
        if (n0 != null) {
            n0.post(new Runnable() { // from class: t6.b
                @Override // java.lang.Runnable
                public final void run() {
                    f.o(f.this);
                }
            });
            return;
        }
        r6.f fVar = this.b;
        if (fVar != null) {
            fVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(f fVar) {
        Intrinsics.h(fVar, "this$0");
        r6.f fVar2 = fVar.b;
        if (fVar2 != null) {
            fVar2.a();
        }
    }

    private final boolean q(LinearLayoutManager linearLayoutManager) {
        return (linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1 == this.a.getItemCount() && linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) ? false : true;
    }

    public static /* synthetic */ void u(f fVar, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadMoreEnd");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        fVar.t(z);
    }

    public final void A(boolean z) {
        this.g = z;
    }

    public final void B(boolean z) {
        this.i = z;
    }

    public final void C(s6.a aVar) {
        Intrinsics.h(aVar, "<set-?>");
        this.f = aVar;
    }

    public void D(r6.f fVar) {
        this.b = fVar;
        z(true);
    }

    public final void E(int i) {
        if (i > 1) {
            this.j = i;
        }
    }

    public final void F(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "viewHolder");
        ((RecyclerView.a0) baseViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: t6.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.G(f.this, view);
            }
        });
    }

    public final void e(int i) {
        LoadMoreStatus loadMoreStatus;
        if (this.h && m() && i >= this.a.getItemCount() - this.j && (loadMoreStatus = this.d) == LoadMoreStatus.Complete && loadMoreStatus != LoadMoreStatus.Loading && this.c) {
            n();
        }
    }

    public final void f() {
        final RecyclerView.m layoutManager;
        if (this.i) {
            return;
        }
        this.c = false;
        RecyclerView n0 = this.a.n0();
        if (n0 == null || (layoutManager = n0.getLayoutManager()) == null) {
            return;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            n0.postDelayed(new Runnable() { // from class: t6.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.g(f.this, layoutManager);
                }
            }, 50L);
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            n0.postDelayed(new Runnable() { // from class: t6.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.h(layoutManager, this);
                }
            }, 50L);
        }
    }

    public final LoadMoreStatus i() {
        return this.d;
    }

    public final s6.a j() {
        return this.f;
    }

    public final int k() {
        if (this.a.q0()) {
            return -1;
        }
        BaseQuickAdapter baseQuickAdapter = this.a;
        return baseQuickAdapter.a0() + baseQuickAdapter.getData().size() + baseQuickAdapter.V();
    }

    public final boolean m() {
        if (this.b == null || !this.k) {
            return false;
        }
        if (this.d == LoadMoreStatus.End && this.e) {
            return false;
        }
        return !this.a.getData().isEmpty();
    }

    public final boolean p() {
        return this.k;
    }

    public final boolean r() {
        return this.d == LoadMoreStatus.Loading;
    }

    public final void s() {
        if (m()) {
            this.d = LoadMoreStatus.Complete;
            this.a.notifyItemChanged(k());
            f();
        }
    }

    public final void t(boolean z) {
        if (m()) {
            this.e = z;
            this.d = LoadMoreStatus.End;
            if (z) {
                this.a.notifyItemRemoved(k());
            } else {
                this.a.notifyItemChanged(k());
            }
        }
    }

    public final void v() {
        if (m()) {
            this.d = LoadMoreStatus.Fail;
            this.a.notifyItemChanged(k());
        }
    }

    public final void w() {
        LoadMoreStatus loadMoreStatus = this.d;
        LoadMoreStatus loadMoreStatus2 = LoadMoreStatus.Loading;
        if (loadMoreStatus == loadMoreStatus2) {
            return;
        }
        this.d = loadMoreStatus2;
        this.a.notifyItemChanged(k());
        n();
    }

    public final void x() {
        if (this.b != null) {
            z(true);
            this.d = LoadMoreStatus.Complete;
        }
    }

    public final void y(boolean z) {
        this.h = z;
    }

    public final void z(boolean z) {
        boolean m = m();
        this.k = z;
        boolean m2 = m();
        if (m) {
            if (m2) {
                return;
            }
            this.a.notifyItemRemoved(k());
        } else if (m2) {
            this.d = LoadMoreStatus.Complete;
            this.a.notifyItemInserted(k());
        }
    }
}
