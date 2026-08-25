package com.transsion.commercialization.aha.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.TnTextView;
import com.transsion.bean.AhaGameAllGames;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.R$layout;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/transsion/commercialization/aha/adapter/d;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/bean/AhaGameAllGames;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "datas", "<init>", "(Ljava/util/List;)V", "holder", "item", BuildConfig.FLAVOR, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/bean/AhaGameAllGames;)V", BuildConfig.FLAVOR, "F", "I", "itemWidth", "Commercialization_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private final int itemWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(List<AhaGameAllGames> list) {
        super(R$layout.adapter_people_playing, list);
        Intrinsics.h(list, "datas");
        this.itemWidth = (Math.min(y.e(), y.c()) - a0.a(56.0f)) / 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, AhaGameAllGames item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        LinearLayoutCompat viewOrNull = holder.getViewOrNull(R$id.item_root);
        if (viewOrNull != null) {
            ViewGroup.LayoutParams layoutParams = viewOrNull.getLayoutParams();
            layoutParams.width = this.itemWidth;
            layoutParams.height = -2;
            viewOrNull.setLayoutParams(layoutParams);
        }
        TnTextView viewOrNull2 = holder.getViewOrNull(R$id.tv_name);
        if (viewOrNull2 != null) {
            viewOrNull2.setTextWithString(item.getName());
        }
        ShapeableImageView viewOrNull3 = holder.getViewOrNull(R$id.iv_cover);
        if (viewOrNull3 != null) {
            ViewGroup.LayoutParams layoutParams2 = viewOrNull3.getLayoutParams();
            int i = this.itemWidth;
            layoutParams2.width = i;
            layoutParams2.height = i;
            viewOrNull3.setLayoutParams(layoutParams2);
            f.a aVar = ni.f.a;
            Context context = viewOrNull3.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar.m(context);
            String iconPictureLink = item.getIconPictureLink();
            if (iconPictureLink == null) {
                iconPictureLink = BuildConfig.FLAVOR;
            }
            m.g(iconPictureLink).m(this.itemWidth).c(this.itemWidth).d(viewOrNull3);
        }
    }
}
