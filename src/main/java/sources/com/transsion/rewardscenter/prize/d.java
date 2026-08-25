package com.transsion.rewardscenter.prize;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.R;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.R$string;
import com.transsion.rewardscenter.prize.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends BaseItemProvider {
    private final Function0 e;

    public d(Function0 function0) {
        Intrinsics.h(function0, "onToggle");
        this.e = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(d dVar, View view) {
        Intrinsics.h(view, "it");
        dVar.e.invoke();
        return Unit.a;
    }

    public int l() {
        return PrizeItemType.FOOTER.getValue();
    }

    public int m() {
        return R$layout.prize_footer_item;
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, e eVar) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(eVar, "item");
        if (eVar instanceof e.b) {
            Context context = ((RecyclerView.a0) baseViewHolder).itemView.getContext();
            if (((e.b) eVar).a()) {
                baseViewHolder.setText(R$id.tv_toggle, context.getString(R$string.prize_hide));
                baseViewHolder.setImageResource(R$id.iv_arrow, R.drawable.ic_arrow_up);
            } else {
                baseViewHolder.setText(R$id.tv_toggle, context.getString(R$string.prize_view_more));
                baseViewHolder.setImageResource(R$id.iv_arrow, R.drawable.ic_arrow_down);
            }
            View view = ((RecyclerView.a0) baseViewHolder).itemView;
            Intrinsics.g(view, "itemView");
            uf.c.c(view, 0L, new Function1() { // from class: com.transsion.rewardscenter.prize.c
                public final Object invoke(Object obj) {
                    Unit A;
                    A = d.A(d.this, (View) obj);
                    return A;
                }
            }, 1, (Object) null);
        }
    }
}
