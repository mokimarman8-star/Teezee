package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class RecyclerView$n extends ViewGroup.MarginLayoutParams {
    final Rect mDecorInsets;
    boolean mInsetsDirty;
    boolean mPendingInvalidate;
    RecyclerView$a0 mViewHolder;

    public RecyclerView$n(int i5, int i6) {
        super(i5, i6);
        this.mDecorInsets = new Rect();
        this.mInsetsDirty = true;
        this.mPendingInvalidate = false;
    }

    public RecyclerView$n(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDecorInsets = new Rect();
        this.mInsetsDirty = true;
        this.mPendingInvalidate = false;
    }

    public RecyclerView$n(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.mDecorInsets = new Rect();
        this.mInsetsDirty = true;
        this.mPendingInvalidate = false;
    }

    public RecyclerView$n(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.mDecorInsets = new Rect();
        this.mInsetsDirty = true;
        this.mPendingInvalidate = false;
    }

    public RecyclerView$n(RecyclerView$n recyclerView$n) {
        super((ViewGroup.LayoutParams) recyclerView$n);
        this.mDecorInsets = new Rect();
        this.mInsetsDirty = true;
        this.mPendingInvalidate = false;
    }

    public int getAbsoluteAdapterPosition() {
        return this.mViewHolder.getAbsoluteAdapterPosition();
    }

    public int getBindingAdapterPosition() {
        return this.mViewHolder.getBindingAdapterPosition();
    }

    @Deprecated
    public int getViewAdapterPosition() {
        return this.mViewHolder.getBindingAdapterPosition();
    }

    public int getViewLayoutPosition() {
        return this.mViewHolder.getLayoutPosition();
    }

    @Deprecated
    public int getViewPosition() {
        return this.mViewHolder.getPosition();
    }

    public boolean isItemChanged() {
        return this.mViewHolder.isUpdated();
    }

    public boolean isItemRemoved() {
        return this.mViewHolder.isRemoved();
    }

    public boolean isViewInvalid() {
        return this.mViewHolder.isInvalid();
    }

    public boolean viewNeedsUpdate() {
        return this.mViewHolder.needsUpdate();
    }
}
