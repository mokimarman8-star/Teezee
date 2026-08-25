package com.tn.lib.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.n;
import com.tn.lib.pager.PagerLayoutManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001D\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0015\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0014\u001a\b\u0018\u00010\u0013R\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0018\u00010\u0013R\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ/\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0018\u00010\u0013R\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b \u0010\u001eJ\u0017\u0010#\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$J'\u0010%\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0018\u00010\u0013R\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010#\u001a\u0004\b7\u0010)\"\u0004\b8\u00109R\"\u0010=\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010#\u001a\u0004\b;\u0010)\"\u0004\b<\u00109R\u0016\u0010?\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00104R\u0016\u0010A\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00104R\u0016\u0010C\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00104R\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006L"}, d2 = {"Lcom/tn/lib/pager/PagerLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "", "T", "()V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToWindow", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Landroidx/recyclerview/widget/RecyclerView$t;", "recycler", "onDetachedFromWindow", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$t;)V", "Landroid/view/View;", "U", "()Landroid/view/View;", "dy", "Landroidx/recyclerview/widget/RecyclerView$x;", "state", "scrollVerticallyBy", "(ILandroidx/recyclerview/widget/RecyclerView$t;Landroidx/recyclerview/widget/RecyclerView$x;)I", "dx", "scrollHorizontallyBy", "Lng/a;", "listener", "Z", "(Lng/a;)V", "onLayoutChildren", "(Landroidx/recyclerview/widget/RecyclerView$t;Landroidx/recyclerview/widget/RecyclerView$x;)V", "", "canScrollVertically", "()Z", "Landroidx/recyclerview/widget/n;", "a", "Lkotlin/Lazy;", "V", "()Landroidx/recyclerview/widget/n;", "pagerSnapHelper", "b", "Lng/a;", "onViewPagerListener", "c", "I", "direction", "d", "getCanScrollVertically", "X", "(Z)V", "e", "getEnableFadeEffect", "Y", "enableFadeEffect", "f", "oldState", "g", "oldPosition", "h", "oldPositionIdle", "com/tn/lib/pager/PagerLayoutManager$b", "i", "Lcom/tn/lib/pager/PagerLayoutManager$b;", "rvScrollListener", "Landroidx/recyclerview/widget/RecyclerView$o;", "j", "Landroidx/recyclerview/widget/RecyclerView$o;", "childAttachStateChangeListener", "UI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class PagerLayoutManager extends LinearLayoutManager {

    /* renamed from: a, reason: from kotlin metadata */
    private final Lazy pagerSnapHelper;

    /* renamed from: b, reason: from kotlin metadata */
    private ng.a onViewPagerListener;

    /* renamed from: c, reason: from kotlin metadata */
    private int direction;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean canScrollVertically;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean enableFadeEffect;

    /* renamed from: f, reason: from kotlin metadata */
    private int oldState;

    /* renamed from: g, reason: from kotlin metadata */
    private int oldPosition;

    /* renamed from: h, reason: from kotlin metadata */
    private int oldPositionIdle;

    /* renamed from: i, reason: from kotlin metadata */
    private final b rvScrollListener;

    /* renamed from: j, reason: from kotlin metadata */
    private final RecyclerView.o childAttachStateChangeListener;

    public static final class a implements RecyclerView.o {
        a() {
        }

        public void onChildViewAttachedToWindow(View view) {
            ng.a aVar;
            Intrinsics.h(view, "view");
            int position = PagerLayoutManager.this.getPosition(view);
            if (PagerLayoutManager.this.getChildCount() == 1 && position == 0 && (aVar = PagerLayoutManager.this.onViewPagerListener) != null) {
                aVar.b(view);
            }
        }

        public void onChildViewDetachedFromWindow(View view) {
            Intrinsics.h(view, "view");
            if (PagerLayoutManager.this.direction >= 0) {
                ng.a aVar = PagerLayoutManager.this.onViewPagerListener;
                if (aVar != null) {
                    aVar.c(true, PagerLayoutManager.this.getPosition(view), view);
                    return;
                }
                return;
            }
            ng.a aVar2 = PagerLayoutManager.this.onViewPagerListener;
            if (aVar2 != null) {
                aVar2.c(false, PagerLayoutManager.this.getPosition(view), view);
            }
        }
    }

    public static final class b extends RecyclerView.r {
        b() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i);
            View findSnapView = PagerLayoutManager.this.V().findSnapView(PagerLayoutManager.this);
            if (findSnapView == null) {
                return;
            }
            int position = PagerLayoutManager.this.getPosition(findSnapView);
            if (PagerLayoutManager.this.oldState != i && PagerLayoutManager.this.oldPosition != position) {
                PagerLayoutManager.this.oldState = i;
                PagerLayoutManager.this.oldPosition = position;
                ng.a aVar = PagerLayoutManager.this.onViewPagerListener;
                if (aVar != null) {
                    aVar.a(position, position == PagerLayoutManager.this.getItemCount() - 1, findSnapView);
                }
            }
            if (i == 0) {
                PagerLayoutManager.this.oldPositionIdle = position;
                ng.a aVar2 = PagerLayoutManager.this.onViewPagerListener;
                if (aVar2 != null) {
                    aVar2.d(position, position == PagerLayoutManager.this.getItemCount() - 1, findSnapView);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerLayoutManager(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        this.pagerSnapHelper = LazyKt.b(new Function0() { // from class: ng.b
            public final Object invoke() {
                n W;
                W = PagerLayoutManager.W();
                return W;
            }
        });
        this.canScrollVertically = true;
        this.oldState = -1;
        this.oldPosition = -1;
        this.oldPositionIdle = -1;
        this.rvScrollListener = new b();
        this.childAttachStateChangeListener = new a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.h(context, "context");
        this.pagerSnapHelper = LazyKt.b(new Function0() { // from class: ng.b
            public final Object invoke() {
                n W;
                W = PagerLayoutManager.W();
                return W;
            }
        });
        this.canScrollVertically = true;
        this.oldState = -1;
        this.oldPosition = -1;
        this.oldPositionIdle = -1;
        this.rvScrollListener = new b();
        this.childAttachStateChangeListener = new a();
    }

    private final void T() {
        if (getChildCount() == 0) {
            return;
        }
        float height = getHeight() / 2.0f;
        float height2 = getHeight() / 2.0f;
        try {
            Result.Companion companion = Result.Companion;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt != null) {
                    childAt.setAlpha(RangesKt.k(1.0f - (Math.abs(height - ((getDecoratedTop(childAt) + getDecoratedBottom(childAt)) / 2.0f)) / height2), 0.3f, 1.0f));
                }
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n V() {
        return (n) this.pagerSnapHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n W() {
        return new n();
    }

    public final View U() {
        return V().findSnapView(this);
    }

    public final void X(boolean z) {
        this.canScrollVertically = z;
    }

    public final void Y(boolean z) {
        this.enableFadeEffect = z;
    }

    public final void Z(ng.a listener) {
        this.onViewPagerListener = listener;
    }

    public boolean canScrollVertically() {
        return this.canScrollVertically & super.canScrollVertically();
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
        super/*androidx.recyclerview.widget.RecyclerView.m*/.onAttachedToWindow(recyclerView);
        if ((recyclerView != null ? recyclerView.getOnFlingListener() : null) == null) {
            V().attachToRecyclerView(recyclerView);
        }
        if (recyclerView != null) {
            recyclerView.addOnChildAttachStateChangeListener(this.childAttachStateChangeListener);
        }
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(this.rvScrollListener);
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.t recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (recyclerView != null) {
            recyclerView.removeOnChildAttachStateChangeListener(this.childAttachStateChangeListener);
        }
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this.rvScrollListener);
        }
    }

    public void onLayoutChildren(RecyclerView.t recycler, RecyclerView.x state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    public int scrollHorizontallyBy(int dx, RecyclerView.t recycler, RecyclerView.x state) {
        this.direction = dx;
        return super.scrollHorizontallyBy(dx, recycler, state);
    }

    public int scrollVerticallyBy(int dy, RecyclerView.t recycler, RecyclerView.x state) {
        this.direction = dy;
        int scrollVerticallyBy = super.scrollVerticallyBy(dy, recycler, state);
        if (this.enableFadeEffect) {
            T();
        }
        return scrollVerticallyBy;
    }
}
