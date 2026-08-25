package com.transsion.home.adapter.suboperate.adapter;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.TnTextView;
import com.transsion.gslb.BuildConfig;
import com.transsion.gslb.Utils;
import com.transsion.home.R;
import com.transsion.home.bean.FilterItem;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.Cover;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B+\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010%¨\u0006("}, d2 = {"Lcom/transsion/home/adapter/suboperate/adapter/SubFilterAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/bean/FilterItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "layoutResId", "tabId", "Lcom/transsion/home/bean/OperateItem;", "operateItem", BuildConfig.FLAVOR, "isTablet", "<init>", "(ILjava/lang/Integer;Lcom/transsion/home/bean/OperateItem;Z)V", BuildConfig.FLAVOR, "color", "Landroid/graphics/drawable/GradientDrawable;", "E1", "(Ljava/lang/String;)Landroid/graphics/drawable/GradientDrawable;", "item", "position", BuildConfig.FLAVOR, "G1", "(Lcom/transsion/home/bean/FilterItem;I)V", "F1", "Landroid/view/ViewGroup;", "parent", "viewType", "z0", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/FilterItem;)V", "F", "Ljava/lang/Integer;", "G", "Lcom/transsion/home/bean/OperateItem;", "H", "I", "itemWidth", "itemHeight", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubFilterAdapter extends BaseQuickAdapter {
    public static final int J = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private final Integer tabId;

    /* renamed from: G, reason: from kotlin metadata */
    private final OperateItem operateItem;

    /* renamed from: H, reason: from kotlin metadata */
    private final int itemWidth;

    /* renamed from: I, reason: from kotlin metadata */
    private final int itemHeight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubFilterAdapter(int i, Integer num, OperateItem operateItem, boolean z) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.h(operateItem, "operateItem");
        this.tabId = num;
        this.operateItem = operateItem;
        int a = a0.a(((((a0.b(Math.min(y.e(), y.c())) - 12) - (r3 * 8)) - 12) * 1.0f) / (z ? 6 : 3));
        this.itemWidth = a;
        this.itemHeight = (int) (a * 0.46d);
    }

    public /* synthetic */ SubFilterAdapter(int i, Integer num, OperateItem operateItem, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R.layout.item_sub_operation_filter_item : i, num, operateItem, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(FilterItem filterItem, SubFilterAdapter subFilterAdapter, View view) {
        Uri g = com.transsion.baselib.helper.b.a.g(Uri.parse(filterItem.getDeepLink()));
        if (g != null) {
            ij.k.o(g);
        }
        subFilterAdapter.G1(filterItem, subFilterAdapter.getData().indexOf(filterItem));
    }

    private final GradientDrawable E1(String color) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColors(new int[]{Color.parseColor(StringsKt.Q(color, Utils.SEPARATOR, "#ff", false, 4, (Object) null)), Color.parseColor(StringsKt.Q(color, Utils.SEPARATOR, "#ff", false, 4, (Object) null)), Color.parseColor(StringsKt.Q(color, Utils.SEPARATOR, "#00", false, 4, (Object) null))});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        return gradientDrawable;
    }

    private final void F1(FilterItem item, int position) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "browse_filter");
        if (item == null || (str = item.getTitle()) == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("title", str);
        hashMap.put("sequence", String.valueOf(position));
        hashMap.put("tabId", String.valueOf(this.tabId));
        sk.b.a(this.operateItem, hashMap);
        com.transsion.baselib.helper.a aVar = com.transsion.baselib.helper.a.a;
        SubTabFragment.Companion companion = SubTabFragment.INSTANCE;
        Integer num = this.tabId;
        aVar.e(companion.a(num != null ? num.intValue() : 1), hashMap);
    }

    private final void G1(FilterItem item, int position) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_filter");
        if (item == null || (str = item.getTitle()) == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("title", str);
        hashMap.put("sequence", String.valueOf(position));
        hashMap.put("tabId", String.valueOf(this.tabId));
        sk.b.a(this.operateItem, hashMap);
        com.transsion.baselib.helper.a aVar = com.transsion.baselib.helper.a.a;
        SubTabFragment.Companion companion = SubTabFragment.INSTANCE;
        Integer num = this.tabId;
        aVar.f(companion.a(num != null ? num.intValue() : 1), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, final FilterItem item) {
        String str;
        String thumbnail;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        TnTextView view = holder.getView(R.id.sub_operation_filter_title);
        if (item.isAll()) {
            view.setTextById(com.tn.lib.widget.R.string.all);
            uf.c.k(holder.getView(R.id.sub_operation_filter_add_icon));
            ((ImageView) holder.getView(R.id.sub_operation_filter_icon)).setImageResource(R.mipmap.bg_op_filter_all);
        } else {
            String title = item.getTitle();
            String str2 = BuildConfig.FLAVOR;
            if (title == null) {
                title = BuildConfig.FLAVOR;
            }
            view.setText(title);
            view.setTextColor(com.blankj.utilcode.util.h.a(com.tn.lib.widget.R.color.white_80));
            uf.c.g(holder.getView(R.id.sub_operation_filter_add_icon));
            ImageView imageView = (ImageView) holder.getView(R.id.sub_operation_filter_icon);
            if (item.getBuiltIn()) {
                kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new SubFilterAdapter$convert$1(item, imageView, null), 3, (Object) null);
            } else {
                f.b m = ni.f.a.m(getContext());
                Cover image = item.getImage();
                if (image == null || (str = image.getUrl()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                f.b g = m.g(str);
                Cover image2 = item.getImage();
                if (image2 != null && (thumbnail = image2.getThumbnail()) != null) {
                    str2 = thumbnail;
                }
                g.l(str2).m(this.itemWidth).d(imageView);
            }
        }
        ((RecyclerView.a0) holder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubFilterAdapter.D1(FilterItem.this, this, view2);
            }
        });
        F1(item, getData().indexOf(item));
    }

    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.h(parent, "parent");
        BaseViewHolder z0 = super.z0(parent, viewType);
        ((RecyclerView.a0) z0).itemView.getLayoutParams().width = this.itemWidth;
        ((RecyclerView.a0) z0).itemView.getLayoutParams().height = this.itemHeight;
        return z0;
    }
}
