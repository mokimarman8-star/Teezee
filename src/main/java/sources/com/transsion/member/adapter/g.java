package com.transsion.member.adapter;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cloud.hisavana.sdk.common.util.m0;
import com.transsion.gslb.BuildConfig;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.member.R$string;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MembershipDetailType;
import com.transsion.memberapi.SkuCategory;
import com.transsion.memberapi.SkuItem;
import java.math.BigDecimal;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000f\u0010\u0010JI\u0010\u0018\u001a\u00020\n2:\u0010\u0017\u001a6\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\n0\u0011j\u0002`\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&RN\u0010\u0017\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R$\u0010/\u001a\u00020)2\u0006\u0010*\u001a\u00020)8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcom/transsion/member/adapter/g;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/memberapi/SkuItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "dataList", "<init>", "(Ljava/util/List;)V", "Lcom/transsion/memberapi/MemberDetail;", "detail", BuildConfig.FLAVOR, "G1", "(Lcom/transsion/memberapi/MemberDetail;)V", "holder", "item", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/memberapi/SkuItem;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Landroid/view/View;", "view", "Lcom/transsion/member/adapter/SkuItemCallback;", "clickCallback", "F1", "(Lkotlin/jvm/functions/Function2;)V", BuildConfig.FLAVOR, "getItemCount", "()I", "Landroidx/appcompat/widget/AppCompatTextView;", "F", "Landroidx/appcompat/widget/AppCompatTextView;", "redeemBtn", "Landroidx/constraintlayout/widget/ConstraintLayout;", "G", "Landroidx/constraintlayout/widget/ConstraintLayout;", "redeemContainer", "H", "Lcom/transsion/memberapi/SkuItem;", "I", "Lkotlin/jvm/functions/Function2;", BuildConfig.FLAVOR, "value", "J", "Z", "E1", "(Z)V", "canRedeem", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g extends BaseQuickAdapter {
    public static final int K = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private AppCompatTextView redeemBtn;

    /* renamed from: G, reason: from kotlin metadata */
    private ConstraintLayout redeemContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private SkuItem item;

    /* renamed from: I, reason: from kotlin metadata */
    private Function2<? super SkuItem, ? super View, Unit> clickCallback;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean canRedeem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(List<SkuItem> list) {
        super(R$layout.item_sku, list);
        Intrinsics.h(list, "dataList");
        this.canRedeem = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(g gVar, SkuItem skuItem, View view) {
        a.a.g(wf.a.a, "Should buy now", false, 2, (Object) null);
        Function2<? super SkuItem, ? super View, Unit> function2 = gVar.clickCallback;
        if (function2 != null) {
            Intrinsics.e(view);
            function2.invoke(skuItem, view);
        }
    }

    private final void E1(boolean z) {
        ConstraintLayout constraintLayout = this.redeemContainer;
        if (constraintLayout != null) {
            constraintLayout.setAlpha(z ? 1.0f : 0.4f);
        }
        AppCompatTextView appCompatTextView = this.redeemBtn;
        if (appCompatTextView != null) {
            appCompatTextView.setEnabled(z);
        }
        this.canRedeem = z;
    }

    private final void G1(MemberDetail detail) {
        boolean z = true;
        if (detail != null && MembershipDetailType.INSTANCE.a(detail.getMemberInfo()) == MembershipDetailType.SUBSCRIPTION_MEMBER) {
            SkuItem skuItem = this.item;
            if (Intrinsics.c(skuItem != null ? skuItem.getCategory() : null, SkuCategory.AUTO_RENEW.getValue())) {
                z = false;
            }
        }
        E1(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, final SkuItem item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        if (Intrinsics.c(item.getCategory(), SkuCategory.AUTO_RENEW.getValue())) {
            holder.getView(R$id.detail).setText(getContext().getString(R$string.member_auto_renew));
        } else {
            AppCompatTextView view = holder.getView(R$id.detail);
            view.setText(view.getContext().getString(R$string.member_sku_1_time_payment));
        }
        AppCompatTextView view2 = holder.getView(R$id.title);
        view2.setText(view2.getContext().getString(R$string.member_sku_set_title, item.getDurationCount(), item.getDurationUnitDesc()));
        holder.getView(R$id.price).setText(item.getCurrencySymbol() + m0.a(new BigDecimal(String.valueOf(item.getPrice()))).toPlainString());
        holder.getView(R$id.btn_redeem).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.adapter.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                g.D1(g.this, item, view3);
            }
        });
        this.redeemBtn = holder.getView(R$id.btn_redeem);
        this.redeemContainer = holder.getView(R$id.iv_redeem_container);
        this.item = item;
        G1(item.getMemberDetail());
    }

    public final void F1(Function2<? super SkuItem, ? super View, Unit> clickCallback) {
        Intrinsics.h(clickCallback, "clickCallback");
        this.clickCallback = clickCallback;
    }

    public int getItemCount() {
        return getData().size();
    }
}
