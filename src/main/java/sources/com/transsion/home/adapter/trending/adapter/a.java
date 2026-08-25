package com.transsion.home.adapter.trending.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.b;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.R$drawable;
import com.transsion.moviedetailapi.bean.ExplainBean;
import ij.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/transsion/home/adapter/trending/adapter/a;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/ExplainBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "datas", "<init>", "(Ljava/util/List;)V", "holder", "item", BuildConfig.FLAVOR, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/ExplainBean;)V", BuildConfig.FLAVOR, "getItemCount", "()I", "F", "Ljava/util/List;", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends BaseQuickAdapter {
    public static final int G = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private final List<ExplainBean> datas;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(List<ExplainBean> list) {
        super(R.layout.post_title_tag, CollectionsKt.U0(list));
        Intrinsics.h(list, "datas");
        this.datas = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, ExplainBean item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        AppCompatTextView viewOrNull = holder.getViewOrNull(R.id.tv_tag);
        if (viewOrNull != null) {
            String text = item.getText();
            SpannableString spannableString = new SpannableString(text);
            if (text != null && StringsKt.c0(text, "\"", false, 2, (Object) null)) {
                int o0 = StringsKt.o0(text, "\"", 0, false, 6, (Object) null);
                int v0 = StringsKt.v0(text, "\"", 0, false, 6, (Object) null);
                Context context = viewOrNull.getContext();
                Intrinsics.g(context, "getContext(...)");
                spannableString.setSpan(uf.a.c(context), o0, v0, 33);
                spannableString.setSpan(new StyleSpan(2), o0, v0, 33);
            }
            viewOrNull.setText(spannableString);
            try {
                String color = item.getColor();
                List S0 = color != null ? StringsKt.S0(color, new String[]{","}, false, 0, 6, (Object) null) : null;
                Drawable background = viewOrNull.getBackground();
                Intrinsics.f(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                if (S0 == null || S0.size() != 4) {
                    gradientDrawable.setColor(b.getColor(viewOrNull.getContext(), com.tn.lib.widget.R.color.bg_08));
                    viewOrNull.setTextColor(b.getColor(viewOrNull.getContext(), com.tn.lib.widget.R.color.text_01));
                } else if (y.a.a()) {
                    gradientDrawable.setColor(Color.parseColor((String) S0.get(1)));
                    viewOrNull.setTextColor(Color.parseColor((String) S0.get(3)));
                } else {
                    gradientDrawable.setColor(Color.parseColor((String) S0.get(0)));
                    viewOrNull.setTextColor(Color.parseColor((String) S0.get(2)));
                }
            } catch (Exception unused) {
                viewOrNull.setBackground(b.getDrawable(viewOrNull.getContext(), R$drawable.bg_post_title_tag));
                viewOrNull.setTextColor(b.getColor(viewOrNull.getContext(), com.tn.lib.widget.R.color.text_12));
            }
        }
    }

    public int getItemCount() {
        return this.datas.size();
    }
}
