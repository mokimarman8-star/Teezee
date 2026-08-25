package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* synthetic */ class j implements View.OnClickListener {
    public final /* synthetic */ BaseViewHolder a;
    public final /* synthetic */ BaseProviderMultiAdapter b;

    public /* synthetic */ j(BaseViewHolder baseViewHolder, BaseProviderMultiAdapter baseProviderMultiAdapter) {
        this.a = baseViewHolder;
        this.b = baseProviderMultiAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BaseProviderMultiAdapter.B1(this.a, this.b, view);
    }
}
