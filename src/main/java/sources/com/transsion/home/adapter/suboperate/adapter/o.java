package com.transsion.home.adapter.suboperate.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.BffCommonOpData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.Cover;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ni.f;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001-B+\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010$R\u0014\u0010)\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010$R\u0014\u0010+\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010$¨\u0006."}, d2 = {"Lcom/transsion/home/adapter/suboperate/adapter/o;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/bean/BffCommonOpData;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "layoutResId", "Lcom/transsion/home/bean/OperateItem;", "operateItem", "tabId", BuildConfig.FLAVOR, "isTablet", "<init>", "(ILcom/transsion/home/bean/OperateItem;IZ)V", "item", "position", BuildConfig.FLAVOR, "D1", "(Lcom/transsion/home/bean/BffCommonOpData;I)V", "C1", "(Lcom/transsion/home/bean/BffCommonOpData;)Z", "newOperateItem", "E1", "(Lcom/transsion/home/bean/OperateItem;)V", "P", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "y0", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/BffCommonOpData;)V", "F", "Lcom/transsion/home/bean/OperateItem;", "G", "I", "H", "Z", "itemWidth", "J", "itemHeight", "K", "titleAreaHeight", "L", "a", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class o extends BaseQuickAdapter {
    public static final int M = 8;
    public static final int N = 100;

    /* renamed from: F, reason: from kotlin metadata */
    private OperateItem operateItem;

    /* renamed from: G, reason: from kotlin metadata */
    private final int tabId;

    /* renamed from: H, reason: from kotlin metadata */
    private final boolean isTablet;

    /* renamed from: I, reason: from kotlin metadata */
    private final int itemWidth;

    /* renamed from: J, reason: from kotlin metadata */
    private final int itemHeight;

    /* renamed from: K, reason: from kotlin metadata */
    private final int titleAreaHeight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(int i, OperateItem operateItem, int i2, boolean z) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.h(operateItem, "operateItem");
        this.operateItem = operateItem;
        this.tabId = i2;
        this.isTablet = z;
        this.titleAreaHeight = a0.a(28.0f);
        int a = a0.a(((((a0.b(RangesKt.h(y.e(), y.c())) - 12) - (r3 * 8)) - 12) * 1.0f) / (z ? 4 : 3));
        this.itemWidth = a;
        this.itemHeight = (int) (a * 1.39f);
    }

    public /* synthetic */ o(int i, OperateItem operateItem, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? R.layout.item_sub_post_list_card : i, operateItem, i2, (i3 & 8) != 0 ? false : z);
    }

    private final boolean C1(BffCommonOpData item) {
        Integer postType = item.getPostType();
        return postType != null && postType.intValue() == 4;
    }

    private final void D1(BffCommonOpData item, int position) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "browse_post_list_item");
        hashMap.put("sequence", String.valueOf(position));
        hashMap.put("tabId", String.valueOf(this.tabId));
        if (item != null) {
            sk.b.c(item, hashMap);
        }
        sk.b.a(this.operateItem, hashMap);
        com.transsion.baselib.helper.a.a.e(SubTabFragment.INSTANCE.a(this.tabId), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, BffCommonOpData item) {
        String str;
        String thumbnail;
        String str2;
        String thumbnail2;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        if (this.itemWidth < 10 || this.itemHeight < 10) {
            return;
        }
        int P = P(holder.getBindingAdapterPosition());
        String str3 = BuildConfig.FLAVOR;
        if (P == 100) {
            int i = this.itemHeight + this.titleAreaHeight;
            ImageView imageView = (ImageView) holder.getViewOrNull(R.id.main_op_movie_rank_image);
            if (imageView != null) {
                Cover image = item.getImage();
                f.b m = ni.f.a.m(getContext());
                if (image == null || (str2 = image.getUrl()) == null) {
                    str2 = BuildConfig.FLAVOR;
                }
                f.b g = m.g(str2);
                if (image != null && (thumbnail2 = image.getThumbnail()) != null) {
                    str3 = thumbnail2;
                }
                g.l(str3).m(this.itemWidth).c(i).d(imageView);
                return;
            }
            return;
        }
        TextView textView = (TextView) holder.getView(R.id.postTitle);
        holder.getView(R.id.videoPlay).setVisibility(C1(item) ? 0 : 8);
        ImageView imageView2 = (ImageView) holder.getView(R.id.postCover);
        imageView2.getLayoutParams().width = this.itemWidth;
        imageView2.getLayoutParams().height = this.itemHeight;
        textView.setMaxWidth(this.itemWidth);
        Cover image2 = item.getImage();
        f.b m2 = ni.f.a.m(getContext());
        if (image2 == null || (str = image2.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        f.b g2 = m2.g(str);
        if (image2 != null && (thumbnail = image2.getThumbnail()) != null) {
            str3 = thumbnail;
        }
        g2.l(str3).m(this.itemWidth).c(this.itemHeight).d(imageView2);
        textView.setText(item.getContent());
        D1(item, getData().indexOf(item));
    }

    public final void E1(OperateItem newOperateItem) {
        Intrinsics.h(newOperateItem, "newOperateItem");
        this.operateItem = newOperateItem;
    }

    protected int P(int position) {
        BffCommonOpData bffCommonOpData = (BffCommonOpData) f0(position);
        if (position == getItemCount() - 1) {
            if (Intrinsics.c(bffCommonOpData != null ? bffCommonOpData.getId() : null, "0")) {
                return 100;
            }
        }
        return super.P(position);
    }

    protected BaseViewHolder y0(ViewGroup parent, int viewType) {
        Intrinsics.h(parent, "parent");
        if (viewType != 100) {
            BaseViewHolder y0 = super.y0(parent, viewType);
            ImageView imageView = (ImageView) y0.getViewOrNull(R.id.postCover);
            if (imageView != null) {
                imageView.getLayoutParams().width = this.itemWidth;
                imageView.getLayoutParams().height = this.itemHeight;
            }
            return y0;
        }
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_operation_movie_rank_more, parent, false);
        int i = this.itemHeight + this.titleAreaHeight;
        View findViewById = inflate.findViewById(R.id.main_op_movie_rank_image);
        if (findViewById != null) {
            findViewById.getLayoutParams().width = this.itemWidth;
            findViewById.getLayoutParams().height = i;
        }
        View findViewById2 = inflate.findViewById(R.id.main_op_movie_rank_more_mask);
        if (findViewById2 != null) {
            findViewById2.getLayoutParams().width = this.itemWidth;
            findViewById2.getLayoutParams().height = i;
        }
        Intrinsics.e(inflate);
        return new BaseViewHolder(inflate);
    }
}
