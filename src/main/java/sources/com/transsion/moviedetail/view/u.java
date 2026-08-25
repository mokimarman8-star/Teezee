package com.transsion.moviedetail.view;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.flow.bean.ResourcesSeason;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.SubjectType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/transsion/moviedetail/view/u;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/ResourcesSeason;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", "<init>", "()V", "holder", "item", BuildConfig.FLAVOR, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/ResourcesSeason;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "payloads", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/ResourcesSeason;Ljava/util/List;)V", BuildConfig.FLAVOR, "F", "Ljava/lang/Integer;", "D1", "()Ljava/lang/Integer;", "E1", "(Ljava/lang/Integer;)V", "subjectType", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class u extends BaseQuickAdapter implements t6.i {

    /* renamed from: F, reason: from kotlin metadata */
    private Integer subjectType;

    public u() {
        super(R$layout.item_item_season_tab, (List) null, 2, (DefaultConstructorMarker) null);
        this.subjectType = Integer.valueOf(SubjectType.MOVIE.getValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, ResourcesSeason item) {
        String a;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        View view = ((RecyclerView.a0) holder).itemView;
        Intrinsics.f(view, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) view;
        Integer num = this.subjectType;
        int value = SubjectType.EDUCATION.getValue();
        if (num != null && num.intValue() == value) {
            a = "Unit " + item.getSe();
        } else {
            a = com.transsion.baseui.util.n.a(item.getSe());
        }
        textView.setText(a);
        textView.setSelected(item.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void G(BaseViewHolder holder, ResourcesSeason item, List<? extends Object> payloads) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.G(holder, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object obj = payloads.get(payloads.size() - 1);
        if (obj instanceof Boolean) {
            View view = ((RecyclerView.a0) holder).itemView;
            Intrinsics.f(view, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) view).setSelected(((Boolean) obj).booleanValue());
        }
    }

    /* renamed from: D1, reason: from getter */
    public final Integer getSubjectType() {
        return this.subjectType;
    }

    public final void E1(Integer num) {
        this.subjectType = num;
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return t6.h.a(this, baseQuickAdapter);
    }
}
