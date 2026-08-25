package com.transsion.transfer.wifi.permission;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.transfer.R$id;
import com.transsion.transfer.R$layout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b extends BaseItemProvider {
    public int l() {
        return 0;
    }

    public int m() {
        return R$layout.item_permission_layout;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, PermissionsBean item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        ((ImageView) ((RecyclerView.a0) helper).itemView.findViewById(R$id.ivIcon)).setImageResource(item.getIcon());
        ((TextView) ((RecyclerView.a0) helper).itemView.findViewById(R$id.tvTitle)).setText(item.getTitle());
        ((TextView) ((RecyclerView.a0) helper).itemView.findViewById(R$id.tvContent)).setText(item.getContent());
        boolean f = d.a.f(item.getPermission());
        TextView textView = (TextView) ((RecyclerView.a0) helper).itemView.findViewById(R$id.tvAction);
        textView.setText(item.getBtnName());
        if (f) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }
}
