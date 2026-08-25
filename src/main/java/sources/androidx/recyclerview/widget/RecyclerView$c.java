package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.e;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class RecyclerView$c implements e.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView f12828a;

    RecyclerView$c(RecyclerView recyclerView) {
        this.f12828a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.e.b
    public void a(View view) {
        RecyclerView$a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            childViewHolderInt.onEnteredHiddenState(this.f12828a);
        }
    }

    @Override // androidx.recyclerview.widget.e.b
    public RecyclerView$a0 b(View view) {
        return RecyclerView.getChildViewHolderInt(view);
    }

    @Override // androidx.recyclerview.widget.e.b
    public void c(int i5) {
        View childAt = getChildAt(i5);
        if (childAt != null) {
            RecyclerView$a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
            if (childViewHolderInt != null) {
                if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + this.f12828a.exceptionLabel());
                }
                if (RecyclerView.sVerboseLoggingEnabled) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("tmpDetach ");
                    sb.append(childViewHolderInt);
                }
                childViewHolderInt.addFlags(256);
            }
        } else if (RecyclerView.sDebugAssertionsEnabled) {
            throw new IllegalArgumentException("No view at offset " + i5 + this.f12828a.exceptionLabel());
        }
        RecyclerView.access$100(this.f12828a, i5);
    }

    @Override // androidx.recyclerview.widget.e.b
    public void d(View view, int i5) {
        this.f12828a.addView(view, i5);
        this.f12828a.dispatchChildAttached(view);
    }

    @Override // androidx.recyclerview.widget.e.b
    public void e() {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            this.f12828a.dispatchChildDetached(childAt);
            childAt.clearAnimation();
        }
        this.f12828a.removeAllViews();
    }

    @Override // androidx.recyclerview.widget.e.b
    public int f(View view) {
        return this.f12828a.indexOfChild(view);
    }

    @Override // androidx.recyclerview.widget.e.b
    public void g(View view) {
        RecyclerView$a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            childViewHolderInt.onLeftHiddenState(this.f12828a);
        }
    }

    @Override // androidx.recyclerview.widget.e.b
    public View getChildAt(int i5) {
        return this.f12828a.getChildAt(i5);
    }

    @Override // androidx.recyclerview.widget.e.b
    public int getChildCount() {
        return this.f12828a.getChildCount();
    }

    @Override // androidx.recyclerview.widget.e.b
    public void h(int i5) {
        View childAt = this.f12828a.getChildAt(i5);
        if (childAt != null) {
            this.f12828a.dispatchChildDetached(childAt);
            childAt.clearAnimation();
        }
        this.f12828a.removeViewAt(i5);
    }

    @Override // androidx.recyclerview.widget.e.b
    public void i(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        RecyclerView$a0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + this.f12828a.exceptionLabel());
            }
            if (RecyclerView.sVerboseLoggingEnabled) {
                StringBuilder sb = new StringBuilder();
                sb.append("reAttach ");
                sb.append(childViewHolderInt);
            }
            childViewHolderInt.clearTmpDetachFlag();
        } else if (RecyclerView.sDebugAssertionsEnabled) {
            throw new IllegalArgumentException("No ViewHolder found for child: " + view + ", index: " + i5 + this.f12828a.exceptionLabel());
        }
        RecyclerView.access$000(this.f12828a, view, i5, layoutParams);
    }
}
