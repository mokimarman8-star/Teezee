package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* synthetic */ class k implements View.OnLongClickListener {
    public final /* synthetic */ BaseViewHolder a;
    public final /* synthetic */ BaseProviderMultiAdapter b;

    public /* synthetic */ k(BaseViewHolder baseViewHolder, BaseProviderMultiAdapter baseProviderMultiAdapter) {
        this.a = baseViewHolder;
        this.b = baseProviderMultiAdapter;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        return BaseProviderMultiAdapter.D1(this.a, this.b, view);
    }
}
