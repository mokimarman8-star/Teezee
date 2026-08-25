package com.transsion.home.view.filter.linear;

import android.graphics.Typeface;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.R$drawable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/transsion/home/view/filter/linear/a;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lbl/a;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "layoutResId", BuildConfig.FLAVOR, "datas", "<init>", "(ILjava/util/List;)V", "holder", "position", BuildConfig.FLAVOR, "w0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;I)V", "item", "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lbl/a;)V", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends BaseQuickAdapter {
    public static final int F = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int i, List<bl.a> list) {
        super(i, list);
        Intrinsics.h(list, "datas");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, bl.a item) {
        Typeface defaultFromStyle;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        TextView textView = (TextView) holder.getView(R.id.filter_item_name);
        textView.setText(item.a());
        if (item.d()) {
            textView.setBackgroundResource(R$drawable.bg_selected_filter_item);
            textView.setTextColor(androidx.core.content.b.getColor(textView.getContext(), com.tn.lib.widget.R.color.text_01));
            defaultFromStyle = Typeface.defaultFromStyle(1);
        } else {
            textView.setBackgroundResource(com.tn.lib.widget.R.color.transparent);
            textView.setTextColor(androidx.core.content.b.getColor(textView.getContext(), com.tn.lib.widget.R.color.text_02));
            defaultFromStyle = Typeface.defaultFromStyle(0);
        }
        textView.setTypeface(defaultFromStyle);
    }

    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.h(holder, "holder");
        super.w0(holder, position);
        ConstraintLayout view = holder.getView(R.id.root);
        int a = a0.a(6.0f);
        if (position == 0) {
            view.setPaddingRelative(a0.a(12.0f), a, 0, a);
        } else if (position == getItemCount() - 1) {
            view.setPaddingRelative(a0.a(10.0f), a, a0.a(12.0f), a);
        } else {
            view.setPaddingRelative(a0.a(10.0f), a, 0, a);
        }
    }
}
