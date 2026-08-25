package com.transsion.home.adapter.suboperate.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.CustomData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.Image;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B=\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010\"\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001dR\u0014\u0010$\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001e¨\u0006%"}, d2 = {"Lcom/transsion/home/adapter/suboperate/adapter/SubCustomAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/bean/BannerData;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "layoutResId", "Lcom/transsion/home/bean/OperateItem;", "operateItem", "Lcom/transsion/home/bean/CustomData;", "customData", "firstItem", "tabId", BuildConfig.FLAVOR, "isTablet", "<init>", "(ILcom/transsion/home/bean/OperateItem;Lcom/transsion/home/bean/CustomData;Lcom/transsion/home/bean/BannerData;IZ)V", "item", "position", BuildConfig.FLAVOR, "C1", "(Lcom/transsion/home/bean/BannerData;I)V", "holder", "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/BannerData;)V", "F", "Lcom/transsion/home/bean/OperateItem;", "G", "Lcom/transsion/home/bean/CustomData;", "H", "I", "Z", "J", "itemWidth", "K", "itemHeight", "L", "hiddenTitle", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubCustomAdapter extends BaseQuickAdapter {
    public static final int M = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private final OperateItem operateItem;

    /* renamed from: G, reason: from kotlin metadata */
    private final CustomData customData;

    /* renamed from: H, reason: from kotlin metadata */
    private final int tabId;

    /* renamed from: I, reason: from kotlin metadata */
    private final boolean isTablet;

    /* renamed from: J, reason: from kotlin metadata */
    private final int itemWidth;

    /* renamed from: K, reason: from kotlin metadata */
    private final int itemHeight;

    /* renamed from: L, reason: from kotlin metadata */
    private final boolean hiddenTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubCustomAdapter(int i, OperateItem operateItem, CustomData customData, BannerData bannerData, int i2, boolean z) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
        Boolean hiddenTitle;
        Image image;
        Integer width;
        Image image2;
        Integer height;
        List<BannerData> items;
        BannerData bannerData2;
        Intrinsics.h(operateItem, "operateItem");
        String str = null;
        this.operateItem = operateItem;
        this.customData = customData;
        this.tabId = i2;
        this.isTablet = z;
        int i3 = 1;
        boolean z2 = false;
        int e = RangesKt.e(customData != null ? customData.getRowCount() : 1, 1) + (z ? 2 : 0);
        int b = a0.b(RangesKt.h(y.e(), y.c()));
        List<BannerData> items2 = customData != null ? customData.getItems() : null;
        if (items2 != null && !items2.isEmpty()) {
            if (customData != null && (items = customData.getItems()) != null && (bannerData2 = items.get(0)) != null) {
                str = bannerData2.getContent();
            }
            if (str == null || str.length() == 0) {
                z2 = true;
                this.hiddenTitle = z2;
                int a = a0.a(((((b - 12) - (e * 8)) - 12) * 1.0f) / e);
                this.itemWidth = a;
                float intValue = ((bannerData != null || (image2 = bannerData.getImage()) == null || (height = image2.getHeight()) == null) ? 1 : height.intValue()) * 1.0f;
                if (bannerData != null && (image = bannerData.getImage()) != null && (width = image.getWidth()) != null) {
                    i3 = width.intValue();
                }
                this.itemHeight = (int) ((intValue / i3) * a);
            }
        }
        if (customData != null && (hiddenTitle = customData.getHiddenTitle()) != null) {
            z2 = hiddenTitle.booleanValue();
        }
        this.hiddenTitle = z2;
        int a2 = a0.a(((((b - 12) - (e * 8)) - 12) * 1.0f) / e);
        this.itemWidth = a2;
        float intValue2 = ((bannerData != null || (image2 = bannerData.getImage()) == null || (height = image2.getHeight()) == null) ? 1 : height.intValue()) * 1.0f;
        if (bannerData != null) {
            i3 = width.intValue();
        }
        this.itemHeight = (int) ((intValue2 / i3) * a2);
    }

    public /* synthetic */ SubCustomAdapter(int i, OperateItem operateItem, CustomData customData, BannerData bannerData, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? R.layout.item_sub_operation_variable_item : i, operateItem, customData, bannerData, i2, z);
    }

    private final void C1(BannerData item, int position) {
        if (ij.g.a.b()) {
            rk.d.c.a(this.tabId, position, this.operateItem, item);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "browse_custom_item");
        hashMap.put("sequence", String.valueOf(position));
        CustomData customData = this.customData;
        hashMap.put("rowCount", String.valueOf(customData != null ? Integer.valueOf(customData.getRowCount()) : null));
        hashMap.put("tabId", String.valueOf(this.tabId));
        if (item != null) {
            sk.b.b(item, hashMap);
        }
        sk.b.a(this.operateItem, hashMap);
        com.transsion.baselib.helper.a.a.e(SubTabFragment.INSTANCE.a(this.tabId), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, BannerData item) {
        String str;
        String thumbnail;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        if (this.itemWidth < 10 || this.itemHeight < 10) {
            return;
        }
        z(holder, getItemViewType(holder.getBindingAdapterPosition()));
        ImageView imageView = (ImageView) holder.getView(R.id.sub_operation_variable_image);
        TextView textView = (TextView) holder.getView(R.id.sub_operation_variable_item_title);
        imageView.getLayoutParams().width = this.itemWidth;
        imageView.getLayoutParams().height = this.itemHeight;
        textView.setMaxWidth(this.itemWidth);
        if (this.hiddenTitle) {
            uf.c.g(textView);
        } else {
            uf.c.k(textView);
        }
        if (item.getBuiltIn()) {
            kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new SubCustomAdapter$convert$1(item, imageView, null), 3, (Object) null);
        } else {
            f.b m = ni.f.a.m(getContext());
            Image image = item.getImage();
            String str2 = BuildConfig.FLAVOR;
            if (image == null || (str = image.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b g = m.g(str);
            Image image2 = item.getImage();
            if (image2 != null && (thumbnail = image2.getThumbnail()) != null) {
                str2 = thumbnail;
            }
            g.l(str2).d(imageView);
        }
        textView.setText(item.getContent());
        C1(item, getData().indexOf(item));
    }
}
