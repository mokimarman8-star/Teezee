package com.transsion.search.fragment.hot.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.GroupInfo;
import ij.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import ni.f;
import t6.i;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/transsion/search/fragment/hot/adapter/c;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/search/bean/GroupInfo;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", BuildConfig.FLAVOR, "parentCategory", BuildConfig.FLAVOR, "parentIndex", "<init>", "(Ljava/lang/String;I)V", "groupInfo", BuildConfig.FLAVOR, "E1", "(Lcom/transsion/search/bean/GroupInfo;)V", "holder", "item", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/search/bean/GroupInfo;)V", "F", "Ljava/lang/String;", "G", "I", BuildConfig.FLAVOR, "H", "Z", "mIsLowDevice", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends BaseQuickAdapter implements i {

    /* renamed from: F, reason: from kotlin metadata */
    private final String parentCategory;

    /* renamed from: G, reason: from kotlin metadata */
    private final int parentIndex;

    /* renamed from: H, reason: from kotlin metadata */
    private final boolean mIsLowDevice;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, int i) {
        super(R$layout.provider_result_group, (List) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.h(str, "parentCategory");
        this.parentCategory = str;
        this.parentIndex = i;
        this.mIsLowDevice = ij.h.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(c cVar, GroupInfo groupInfo, View view) {
        cVar.E1(groupInfo);
    }

    private final void E1(GroupInfo groupInfo) {
        com.transsion.search.widget.d.a.m(groupInfo, g0(groupInfo), this.parentCategory, this.parentIndex, this.mIsLowDevice);
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.f(context, "null cannot be cast to non-null type android.app.Activity");
            if (KeyboardUtils.g((Activity) context)) {
                Context context2 = getContext();
                Intrinsics.f(context2, "null cannot be cast to non-null type android.app.Activity");
                KeyboardUtils.d((Activity) context2);
            }
        }
        Navigator.x(TheRouter.c("/room/detail").K("id", groupInfo.getGroupId()), getContext(), (mf.c) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, final GroupInfo item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        ImageView imageView = (ShapeableImageView) holder.getView(R$id.search_result_provider_group_cover);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        zg.h hVar = zg.h.a;
        Context context = imageView.getContext();
        Intrinsics.g(context, "getContext(...)");
        bVar.setMarginStart(hVar.a(context, 12.0f));
        imageView.setLayoutParams(bVar);
        f.b m = ni.f.a.m(getContext());
        String url = item.getCover().getUrl();
        String str = BuildConfig.FLAVOR;
        if (url == null) {
            url = BuildConfig.FLAVOR;
        }
        f.b g = m.g(url);
        String thumbnail = item.getCover().getThumbnail();
        if (thumbnail != null) {
            str = thumbnail;
        }
        g.l(str).m(a0.a(50.0f)).d(imageView);
        int g0 = g0(item);
        int i = g0 != 0 ? g0 != 1 ? g0 != 2 ? R$drawable.bg_hot_subject_no4 : R$drawable.bg_hot_subject_no3 : R$drawable.bg_hot_subject_no2 : R$drawable.bg_hot_subject_no1;
        holder.setVisible(R$id.search_result_provider_group_index_text, true);
        holder.setBackgroundResource(R$id.search_result_provider_group_index_text, i);
        holder.setText(R$id.search_result_provider_group_index_text, String.valueOf(g0 + 1));
        holder.setText(R$id.search_result_provider_group_title, item.getName());
        Long userCount = item.getUserCount();
        String d = userCount != null ? k.d(userCount.longValue()) : null;
        Context context2 = getContext();
        int i2 = R.string.members;
        if (d == null) {
            d = "0";
        }
        String string = context2.getString(i2, d);
        Intrinsics.g(string, "getString(...)");
        holder.setText(R$id.search_result_provider_group_member, string);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        List<String> tags = item.getTags();
        if (tags != null) {
            int i3 = 0;
            for (Object obj : tags) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.u();
                }
                spannableStringBuilder.append((CharSequence) obj);
                List<String> tags2 = item.getTags();
                if (i3 < (tags2 != null ? tags2.size() : 0) - 1) {
                    spannableStringBuilder.append((CharSequence) "￼");
                    spannableStringBuilder.setSpan(com.transsion.search.f.b(getContext()), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                }
                i3 = i4;
            }
        }
        if (spannableStringBuilder.length() > 0) {
            holder.setText(R$id.search_result_provider_group_des, spannableStringBuilder);
            holder.setVisible(R$id.search_result_provider_group_des, true);
        } else {
            holder.setGone(R$id.search_result_provider_group_des, true);
        }
        holder.setVisible(R$id.search_result_provider_group_arrow, false);
        ((RecyclerView.a0) holder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.hot.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.D1(c.this, item, view);
            }
        });
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return t6.h.a(this, baseQuickAdapter);
    }
}
