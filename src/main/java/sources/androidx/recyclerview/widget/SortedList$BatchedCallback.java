package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class SortedList$BatchedCallback<T2> extends SortedList$Callback<T2> {
    private final d mBatchingListUpdateCallback;
    final SortedList$Callback<T2> mWrappedCallback;

    @SuppressLint({"UnknownNullness"})
    public SortedList$BatchedCallback(SortedList$Callback<T2> sortedList$Callback) {
        this.mWrappedCallback = sortedList$Callback;
        this.mBatchingListUpdateCallback = new d(sortedList$Callback);
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback
    public boolean areContentsTheSame(T2 t22, T2 t23) {
        return this.mWrappedCallback.areContentsTheSame(t22, t23);
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback
    public boolean areItemsTheSame(T2 t22, T2 t23) {
        return this.mWrappedCallback.areItemsTheSame(t22, t23);
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback, java.util.Comparator
    public int compare(T2 t22, T2 t23) {
        return this.mWrappedCallback.compare(t22, t23);
    }

    public void dispatchLastEvent() {
        this.mBatchingListUpdateCallback.a();
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback
    @Nullable
    public Object getChangePayload(T2 t22, T2 t23) {
        return this.mWrappedCallback.getChangePayload(t22, t23);
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback
    public void onChanged(int i5, int i6) {
        this.mBatchingListUpdateCallback.onChanged(i5, i6, null);
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback, androidx.recyclerview.widget.j
    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i5, int i6, Object obj) {
        this.mBatchingListUpdateCallback.onChanged(i5, i6, obj);
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback, androidx.recyclerview.widget.j
    public void onInserted(int i5, int i6) {
        this.mBatchingListUpdateCallback.onInserted(i5, i6);
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback, androidx.recyclerview.widget.j
    public void onMoved(int i5, int i6) {
        this.mBatchingListUpdateCallback.onMoved(i5, i6);
    }

    @Override // androidx.recyclerview.widget.SortedList$Callback, androidx.recyclerview.widget.j
    public void onRemoved(int i5, int i6) {
        this.mBatchingListUpdateCallback.onRemoved(i5, i6);
    }
}
