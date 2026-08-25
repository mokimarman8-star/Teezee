package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class SortedListAdapterCallback<T2> extends SortedList$Callback<T2> {
    final RecyclerView.Adapter mAdapter;

    public SortedListAdapterCallback(@SuppressLint({"UnknownNullness", "MissingNullability"}) RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback
    public void onChanged(int i5, int i6) {
        this.mAdapter.notifyItemRangeChanged(i5, i6);
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback, androidx.recyclerview.widget.j
    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i5, int i6, Object obj) {
        this.mAdapter.notifyItemRangeChanged(i5, i6, obj);
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback, androidx.recyclerview.widget.j
    public void onInserted(int i5, int i6) {
        this.mAdapter.notifyItemRangeInserted(i5, i6);
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback, androidx.recyclerview.widget.j
    public void onMoved(int i5, int i6) {
        this.mAdapter.notifyItemMoved(i5, i6);
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback, androidx.recyclerview.widget.j
    public void onRemoved(int i5, int i6) {
        this.mAdapter.notifyItemRangeRemoved(i5, i6);
    }
}
