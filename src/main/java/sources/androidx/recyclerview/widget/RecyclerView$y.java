package androidx.recyclerview.widget;

import android.widget.EdgeEffect;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class RecyclerView$y extends RecyclerView$i {
    RecyclerView$y() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$i
    protected EdgeEffect a(RecyclerView recyclerView, int i5) {
        return new EdgeEffect(recyclerView.getContext());
    }
}
