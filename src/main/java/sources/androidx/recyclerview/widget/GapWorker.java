package androidx.recyclerview.widget;

import androidx.annotation.Nullable;
import androidx.core.os.s;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
final class GapWorker implements Runnable {
    static final ThreadLocal<GapWorker> sGapWorker = new ThreadLocal<>();
    static Comparator<b> sTaskComparator = new Comparator<b>() { // from class: androidx.recyclerview.widget.GapWorker.1
        @Override // java.util.Comparator
        public int compare(b bVar, b bVar2) {
            RecyclerView recyclerView = bVar.d;
            if ((recyclerView == null) != (bVar2.d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = bVar.a;
            if (z != bVar2.a) {
                return z ? -1 : 1;
            }
            int i = bVar2.b - bVar.b;
            if (i != 0) {
                return i;
            }
            int i2 = bVar.c - bVar2.c;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };
    long mFrameIntervalNs;
    long mPostTimeNs;
    ArrayList<RecyclerView> mRecyclerViews = new ArrayList<>();
    private ArrayList<b> mTasks = new ArrayList<>();

    GapWorker() {
    }

    private void buildTaskList() {
        b bVar;
        int size = this.mRecyclerViews.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.mRecyclerViews.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.c(recyclerView, false);
                i += recyclerView.mPrefetchRegistry.d;
            }
        }
        this.mTasks.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.mRecyclerViews.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                a aVar = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(aVar.a) + Math.abs(aVar.b);
                for (int i6 = 0; i6 < aVar.d * 2; i6 += 2) {
                    if (i3 >= this.mTasks.size()) {
                        bVar = new b();
                        this.mTasks.add(bVar);
                    } else {
                        bVar = this.mTasks.get(i3);
                    }
                    int[] iArr = aVar.c;
                    int i7 = iArr[i6 + 1];
                    bVar.a = i7 <= abs;
                    bVar.b = abs;
                    bVar.c = i7;
                    bVar.d = recyclerView2;
                    bVar.e = iArr[i6];
                    i3++;
                }
            }
        }
        Collections.sort(this.mTasks, sTaskComparator);
    }

    private void flushTaskWithDeadline(b bVar, long j) {
        RecyclerView.a0 prefetchPositionWithDeadline = prefetchPositionWithDeadline(bVar.d, bVar.e, bVar.a ? Long.MAX_VALUE : j);
        if (prefetchPositionWithDeadline == null || prefetchPositionWithDeadline.mNestedRecyclerView == null || !prefetchPositionWithDeadline.isBound() || prefetchPositionWithDeadline.isInvalid()) {
            return;
        }
        prefetchInnerRecyclerViewWithDeadline((RecyclerView) prefetchPositionWithDeadline.mNestedRecyclerView.get(), j);
    }

    private void flushTasksWithDeadline(long j) {
        for (int i = 0; i < this.mTasks.size(); i++) {
            b bVar = this.mTasks.get(i);
            if (bVar.d == null) {
                return;
            }
            flushTaskWithDeadline(bVar, j);
            bVar.a();
        }
    }

    static boolean isPrefetchPositionAttached(RecyclerView recyclerView, int i) {
        int j = recyclerView.mChildHelper.j();
        for (int i2 = 0; i2 < j; i2++) {
            RecyclerView.a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.i(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private void prefetchInnerRecyclerViewWithDeadline(@Nullable RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.j() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        a aVar = recyclerView.mPrefetchRegistry;
        aVar.c(recyclerView, true);
        if (aVar.d != 0) {
            try {
                s.a("RV Nested Prefetch");
                recyclerView.mState.f(recyclerView.mAdapter);
                for (int i = 0; i < aVar.d * 2; i += 2) {
                    prefetchPositionWithDeadline(recyclerView, aVar.c[i], j);
                }
            } finally {
                s.b();
            }
        }
    }

    private RecyclerView.a0 prefetchPositionWithDeadline(RecyclerView recyclerView, int i, long j) {
        if (isPrefetchPositionAttached(recyclerView, i)) {
            return null;
        }
        RecyclerView.t tVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.a0 N = tVar.N(i, false, j);
            if (N != null) {
                if (!N.isBound() || N.isInvalid()) {
                    tVar.a(N, false);
                } else {
                    tVar.G(N.itemView);
                }
            }
            recyclerView.onExitLayoutOrScroll(false);
            return N;
        } catch (Throwable th) {
            recyclerView.onExitLayoutOrScroll(false);
            throw th;
        }
    }

    public void add(RecyclerView recyclerView) {
        if (RecyclerView.sDebugAssertionsEnabled && this.mRecyclerViews.contains(recyclerView)) {
            throw new IllegalStateException("RecyclerView already present in worker list!");
        }
        this.mRecyclerViews.add(recyclerView);
    }

    void postFromTraversal(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow()) {
            if (RecyclerView.sDebugAssertionsEnabled && !this.mRecyclerViews.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            }
            if (this.mPostTimeNs == 0) {
                this.mPostTimeNs = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        recyclerView.mPrefetchRegistry.e(i, i2);
    }

    void prefetch(long j) {
        buildTaskList();
        flushTasksWithDeadline(j);
    }

    public void remove(RecyclerView recyclerView) {
        boolean remove = this.mRecyclerViews.remove(recyclerView);
        if (RecyclerView.sDebugAssertionsEnabled && !remove) {
            throw new IllegalStateException("RecyclerView removal failed!");
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            s.a("RV Prefetch");
            if (!this.mRecyclerViews.isEmpty()) {
                int size = this.mRecyclerViews.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.mRecyclerViews.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    prefetch(TimeUnit.MILLISECONDS.toNanos(j) + this.mFrameIntervalNs);
                    this.mPostTimeNs = 0L;
                    s.b();
                }
            }
        } finally {
            this.mPostTimeNs = 0L;
            s.b();
        }
    }
}
