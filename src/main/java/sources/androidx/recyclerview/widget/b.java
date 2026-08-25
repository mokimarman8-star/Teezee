package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b implements j {

    /* renamed from: a, reason: collision with root package name */
    private final RecyclerView.Adapter f12924a;

    public b(RecyclerView.Adapter adapter) {
        this.f12924a = adapter;
    }

    @Override // androidx.recyclerview.widget.j
    public void onChanged(int i5, int i6, Object obj) {
        this.f12924a.notifyItemRangeChanged(i5, i6, obj);
    }

    @Override // androidx.recyclerview.widget.j
    public void onInserted(int i5, int i6) {
        this.f12924a.notifyItemRangeInserted(i5, i6);
    }

    @Override // androidx.recyclerview.widget.j
    public void onMoved(int i5, int i6) {
        this.f12924a.notifyItemMoved(i5, i6);
    }

    @Override // androidx.recyclerview.widget.j
    public void onRemoved(int i5, int i6) {
        this.f12924a.notifyItemRangeRemoved(i5, i6);
    }
}
