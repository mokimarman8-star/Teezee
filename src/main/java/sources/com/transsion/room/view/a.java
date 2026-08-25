package com.transsion.room.view;

import android.content.Context;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/transsion/room/view/a;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Image;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "imageList", "<init>", "(Ljava/util/List;)V", "holder", "item", BuildConfig.FLAVOR, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Image;)V", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends BaseQuickAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(List<Image> list) {
        super(R$layout.adapter_image, list);
        Intrinsics.h(list, "imageList");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, Image item) {
        int e;
        int i;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        ShapeableImageView view = holder.getView(R$id.iv_image);
        Integer width = item.getWidth();
        int intValue = width != null ? width.intValue() : 0;
        Integer height = item.getHeight();
        int intValue2 = height != null ? height.intValue() : 0;
        if (intValue == 0 || intValue2 == 0) {
            return;
        }
        if (getData().size() == 1) {
            if (intValue > intValue2) {
                i = y.e() - a0.a(32.0f);
                e = (intValue2 * i) / intValue;
            } else {
                int a = a0.a(288.0f);
                int i2 = (intValue * a) / intValue2;
                e = a;
                i = i2;
            }
            view.getLayoutParams().width = i;
        } else {
            e = (y.e() - a0.a(48.0f)) / 3;
            i = e;
        }
        view.getLayoutParams().height = e;
        String url = item.getUrl();
        if (url != null) {
            f.a aVar = f.a;
            Context context = view.getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar.m(context).g(url).m(i).c(e).d(view);
        }
    }
}
