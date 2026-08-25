package com.tn.tranpay.adapter;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.tranpay.R;
import com.tn.tranpay.bean.MediumInputBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000f\u0010\u0010JI\u0010\u0018\u001a\u00020\u000e2:\u0010\u0017\u001a6\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000e0\u0011j\u0002`\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"RN\u0010\u0017\u001a:\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011j\u0004\u0018\u0001`\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/tn/tranpay/adapter/b;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tn/tranpay/bean/MediumInputBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "", "dataList", "", "canShowFrequentlyTag", "", "usedMethodCode", "<init>", "(Ljava/util/List;ZLjava/lang/String;)V", "holder", "item", "", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/tn/tranpay/bean/MediumInputBean;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Landroid/view/View;", "view", "Lcom/tn/tranpay/adapter/PayMethodCallback;", "clickCallback", "E1", "(Lkotlin/jvm/functions/Function2;)V", "", "getItemCount", "()I", "F", "Z", "G", "Ljava/lang/String;", "H", "Lcom/tn/tranpay/bean/MediumInputBean;", "info", "I", "Lkotlin/jvm/functions/Function2;", "lib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private final boolean canShowFrequentlyTag;

    /* renamed from: G, reason: from kotlin metadata */
    private final String usedMethodCode;

    /* renamed from: H, reason: from kotlin metadata */
    private MediumInputBean info;

    /* renamed from: I, reason: from kotlin metadata */
    private Function2<? super MediumInputBean, ? super View, Unit> clickCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(List<MediumInputBean> list, boolean z, String str) {
        super(R.layout.tran_item_pay_method, list);
        Intrinsics.h(list, "dataList");
        this.canShowFrequentlyTag = z;
        this.usedMethodCode = str;
    }

    public /* synthetic */ b(List list, boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, z, (i & 4) != 0 ? null : str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(b bVar, MediumInputBean mediumInputBean, BaseViewHolder baseViewHolder, View view) {
        Intrinsics.h(bVar, "this$0");
        Intrinsics.h(mediumInputBean, "$item");
        Intrinsics.h(baseViewHolder, "$holder");
        bVar.info = mediumInputBean;
        Function2<? super MediumInputBean, ? super View, Unit> function2 = bVar.clickCallback;
        if (function2 != null) {
            View view2 = ((RecyclerView.a0) baseViewHolder).itemView;
            Intrinsics.g(view2, "holder.itemView");
            function2.invoke(mediumInputBean, view2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void F(final BaseViewHolder holder, final MediumInputBean item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        holder.getView(R.id.iv_title).setText(item.getName());
        AppCompatImageView view = holder.getView(R.id.iv_icon);
        Glide.with(view.getContext()).load(item.getLogo()).placeholder(R.drawable.placeholder).transition(DrawableTransitionOptions.withCrossFade()).into(view);
        ((RecyclerView.a0) holder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.D1(b.this, item, holder, view2);
            }
        });
        View view2 = holder.getView(R.id.iv_line);
        if (holder.getBindingAdapterPosition() == getData().size() - 1) {
            view2.setVisibility(8);
        } else {
            view2.setVisibility(0);
        }
        AppCompatTextView view3 = holder.getView(R.id.iv_tag_recommend);
        AppCompatTextView view4 = holder.getView(R.id.iv_tag_frequently);
        if (this.usedMethodCode == null || !this.canShowFrequentlyTag) {
            if (holder.getBindingAdapterPosition() == 0) {
                view3.setVisibility(0);
            } else {
                view3.setVisibility(8);
            }
            view4.setVisibility(8);
            return;
        }
        if (Intrinsics.c(item.getCode(), this.usedMethodCode)) {
            view4.setVisibility(0);
        } else {
            view4.setVisibility(8);
        }
        view3.setVisibility(8);
    }

    public final void E1(Function2<? super MediumInputBean, ? super View, Unit> clickCallback) {
        Intrinsics.h(clickCallback, "clickCallback");
        this.clickCallback = clickCallback;
    }

    public int getItemCount() {
        return getData().size();
    }
}
