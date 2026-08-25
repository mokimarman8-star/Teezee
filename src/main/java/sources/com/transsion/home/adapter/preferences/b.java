package com.transsion.home.adapter.preferences;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.util.m;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.HomePreferencesContentItem;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B5\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0014\u001a\u00020\f*\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/transsion/home/adapter/preferences/b;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/bean/HomePreferencesContentItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "selectedIds", BuildConfig.FLAVOR, "isSingle", BuildConfig.FLAVOR, "maxSelectNum", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onSelectionChanged", "<init>", "(Ljava/util/Set;ZILkotlin/jvm/functions/Function0;)V", "Lcom/transsion/baseui/widget/GradientTextView;", "Landroid/content/Context;", "context", "selected", "C1", "(Lcom/transsion/baseui/widget/GradientTextView;Landroid/content/Context;Z)V", "holder", "item", "D1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/HomePreferencesContentItem;)V", "F", "Ljava/util/Set;", "G", "Z", "H", "I", "Lkotlin/jvm/functions/Function0;", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends BaseQuickAdapter {
    public static final int J = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private final Set<String> selectedIds;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean isSingle;

    /* renamed from: H, reason: from kotlin metadata */
    private final int maxSelectNum;

    /* renamed from: I, reason: from kotlin metadata */
    private final Function0<Unit> onSelectionChanged;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Set<String> set, boolean z, int i, Function0<Unit> function0) {
        super(R.layout.item_home_preferences_enter_pop_tag, (List) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.h(set, "selectedIds");
        Intrinsics.h(function0, "onSelectionChanged");
        this.selectedIds = set;
        this.isSingle = z;
        this.maxSelectNum = i;
        this.onSelectionChanged = function0;
    }

    public /* synthetic */ b(Set set, boolean z, int i, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, z, (i2 & 4) != 0 ? 0 : i, function0);
    }

    private final void C1(GradientTextView gradientTextView, Context context, boolean z) {
        int color = androidx.core.content.b.getColor(context, com.tn.lib.widget.R.color.white_80);
        int color2 = androidx.core.content.b.getColor(context, com.tn.lib.widget.R.color.brand_new_gradient_start);
        int color3 = androidx.core.content.b.getColor(context, com.tn.lib.widget.R.color.brand_new_gradient_center);
        int color4 = androidx.core.content.b.getColor(context, com.tn.lib.widget.R.color.brand_new_gradient_end);
        if (!z) {
            color2 = color;
        }
        if (!z) {
            color3 = color;
        }
        if (z) {
            color = color4;
        }
        gradientTextView.setGradientColors(color2, color3, color);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(b bVar, HomePreferencesContentItem homePreferencesContentItem, BaseViewHolder baseViewHolder, View view) {
        if (bVar.isSingle) {
            if (bVar.selectedIds.contains(homePreferencesContentItem.getValue())) {
                bVar.selectedIds.remove(homePreferencesContentItem.getValue());
            } else {
                bVar.selectedIds.clear();
                bVar.selectedIds.add(homePreferencesContentItem.getValue());
            }
            bVar.notifyDataSetChanged();
        } else {
            if (bVar.selectedIds.contains(homePreferencesContentItem.getValue())) {
                bVar.selectedIds.remove(homePreferencesContentItem.getValue());
            } else {
                if (bVar.maxSelectNum > 0 && bVar.selectedIds.size() >= bVar.maxSelectNum) {
                    String string = ((RecyclerView.a0) baseViewHolder).itemView.getContext().getString(R.string.home_preferences_max_select_tips, Integer.valueOf(bVar.maxSelectNum));
                    Intrinsics.g(string, "getString(...)");
                    m.e(string);
                    return;
                }
                bVar.selectedIds.add(homePreferencesContentItem.getValue());
            }
            bVar.notifyItemChanged(baseViewHolder.getAdapterPosition());
        }
        bVar.onSelectionChanged.invoke();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.widget.TextView, com.transsion.baseui.widget.GradientTextView] */
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public void F(final BaseViewHolder holder, final HomePreferencesContentItem item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        boolean contains = this.selectedIds.contains(item.getValue());
        ((RecyclerView.a0) holder).itemView.setSelected(contains);
        ?? r1 = (GradientTextView) holder.getView(R.id.tvTagName);
        Context context = ((RecyclerView.a0) holder).itemView.getContext();
        Intrinsics.g(context, "getContext(...)");
        C1(r1, context, contains);
        r1.setText(item.getName());
        ((RecyclerView.a0) holder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.preferences.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.E1(b.this, item, holder, view);
            }
        });
    }
}
