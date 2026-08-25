package com.transsion.home.adapter.trending.provider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.adapter.BaseItemBindingProvider;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.SingleImagePage;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.PostItemType;
import kotlin.jvm.internal.Intrinsics;
import ni.f;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class y extends BaseItemBindingProvider {
    public static final int h = BaseItemBindingProvider.f;
    private final int g = com.blankj.utilcode.util.y.e() - lj.a.b(24);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(BaseViewHolder baseViewHolder, OperateItem operateItem, View view) {
        String deepLink;
        zk.c.a.f(baseViewHolder.getBindingAdapterPosition(), operateItem);
        SingleImagePage page = operateItem.getPage();
        if (page == null || (deepLink = page.getDeepLink()) == null) {
            deepLink = operateItem.getDeepLink();
        }
        if (deepLink != null) {
            ij.k.h(deepLink, null, 1, null);
        }
    }

    @Override // com.transsion.baseui.adapter.BaseItemBindingProvider
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void y(qk.e0 e0Var, final BaseViewHolder baseViewHolder, final OperateItem operateItem) {
        Image image;
        String url;
        String str;
        Image image2;
        Image image3;
        Image image4;
        Integer width;
        Image image5;
        Integer height;
        Intrinsics.h(e0Var, "binding");
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        e0Var.c.setText(operateItem.getTitle());
        ((RecyclerView.a0) baseViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y.C(baseViewHolder, operateItem, view);
            }
        });
        SingleImagePage page = operateItem.getPage();
        int intValue = (page == null || (image5 = page.getImage()) == null || (height = image5.getHeight()) == null) ? 0 : height.intValue();
        SingleImagePage page2 = operateItem.getPage();
        int intValue2 = (page2 == null || (image4 = page2.getImage()) == null || (width = image4.getWidth()) == null) ? 1 : width.intValue();
        int i = this.g;
        float f = ((i * intValue) * 1.0f) / intValue2;
        a.a aVar = wf.a.a;
        SingleImagePage page3 = operateItem.getPage();
        a.a.f(aVar, "SingleImage", "imgH:" + intValue + ",imgW:" + intValue2 + " imageViewHeight:" + f + ", imageViewWidth:" + i + "， url:" + ((page3 == null || (image3 = page3.getImage()) == null) ? null : image3.getUrl()), false, 4, (Object) null);
        ViewGroup.LayoutParams layoutParams = e0Var.b.getLayoutParams();
        layoutParams.height = (int) f;
        e0Var.b.setLayoutParams(layoutParams);
        SingleImagePage page4 = operateItem.getPage();
        if (page4 == null || (image = page4.getImage()) == null || (url = image.getUrl()) == null) {
            return;
        }
        f.a aVar2 = ni.f.a;
        Context context = e0Var.b.getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b g = aVar2.m(context).g(url);
        SingleImagePage page5 = operateItem.getPage();
        if (page5 == null || (image2 = page5.getImage()) == null || (str = image2.getThumbnail()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b m = g.l(str).m(this.g);
        ShapeableImageView shapeableImageView = e0Var.b;
        Intrinsics.g(shapeableImageView, "ivCover");
        m.d(shapeableImageView);
    }

    @Override // com.transsion.baseui.adapter.BaseItemBindingProvider
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public qk.e0 z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.h(layoutInflater, "inflater");
        Intrinsics.h(viewGroup, "parent");
        qk.e0 c = qk.e0.c(LayoutInflater.from(k()), viewGroup, false);
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public int l() {
        return PostItemType.SINGLE_IMAGE.ordinal();
    }
}
