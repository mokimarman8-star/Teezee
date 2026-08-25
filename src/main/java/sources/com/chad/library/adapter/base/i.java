package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* synthetic */ class i implements View.OnLongClickListener {
    public final /* synthetic */ BaseViewHolder a;
    public final /* synthetic */ BaseProviderMultiAdapter b;
    public final /* synthetic */ BaseItemProvider c;

    public /* synthetic */ i(BaseViewHolder baseViewHolder, BaseProviderMultiAdapter baseProviderMultiAdapter, BaseItemProvider baseItemProvider) {
        this.a = baseViewHolder;
        this.b = baseProviderMultiAdapter;
        this.c = baseItemProvider;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        return BaseProviderMultiAdapter.C1(this.a, this.b, this.c, view);
    }
}
