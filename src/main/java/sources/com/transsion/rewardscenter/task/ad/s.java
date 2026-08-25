package com.transsion.rewardscenter.task.ad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.rewardscenter.R$layout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class s extends BaseItemProvider {
    private final int e = AdTaskType.TITLE.getValue();
    private final int f = R$layout.member_task_title_item;

    public int l() {
        return this.e;
    }

    public int m() {
        return this.f;
    }

    public BaseViewHolder r(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(m(), viewGroup, false);
        Intrinsics.e(inflate);
        return new BaseViewHolder(inflate);
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, v vVar) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(vVar, "item");
    }
}
