package com.transsion.rewardscenter.prize;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenter.R$color;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.R$mipmap;
import com.transsion.rewardscenter.R$string;
import com.transsion.rewardscenter.model.RewardsCenterModel;
import com.transsion.rewardscenter.prize.e;
import com.transsion.rewardscenter.utils.p;
import com.transsion.rewardscenter.utils.q;
import com.transsion.rewardscenterapi.DrawChance;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ni.f;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends BaseItemProvider {
    private final zo.a e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PrizeButtonState.values().length];
            try {
                iArr[PrizeButtonState.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrizeButtonState.CLAIMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public b(zo.a aVar) {
        Intrinsics.h(aVar, "config");
        this.e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(boolean z, Context context, b bVar, boolean z2, View view) {
        Intrinsics.h(view, "it");
        if (z) {
            if (l.a.e()) {
                RewardsCenterModel.h(bVar.e.c(), null, true, 1, null);
                bVar.D();
            } else {
                String string = context.getString(R.string.no_network_toast);
                Intrinsics.g(string, "getString(...)");
                p.a(false, string);
            }
        } else if (z2) {
            String string2 = context.getString(R$string.prize_limit_tips);
            Intrinsics.g(string2, "getString(...)");
            p.a(false, string2);
        }
        return Unit.a;
    }

    private final void D() {
        HashMap hashMap = new HashMap();
        hashMap.put("source", "draw_chance");
        q.a("prize_list", hashMap);
    }

    public final boolean B(DrawChance drawChance) {
        Intrinsics.h(drawChance, "drawChance");
        return drawChance.getRemain() > 0 && drawChance.getTodayRemain() > 0;
    }

    public final boolean C(DrawChance drawChance) {
        Intrinsics.h(drawChance, "drawChance");
        return drawChance.getTodayRemain() <= 0;
    }

    public int l() {
        return PrizeItemType.DRAW_CHANCE.getValue();
    }

    public int m() {
        return R$layout.prize_row_item;
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, e eVar) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(eVar, "item");
        if (eVar instanceof e.a) {
            DrawChance a2 = ((e.a) eVar).a();
            final Context context = ((RecyclerView.a0) baseViewHolder).itemView.getContext();
            f.a aVar = ni.f.a;
            Intrinsics.e(context);
            aVar.m(context).g(a2.getImgUrl()).d((ImageView) baseViewHolder.getView(R$id.icon));
            int i = R$id.tv_title;
            String title = a2.getTitle();
            if (title == null) {
                title = BuildConfig.FLAVOR;
            }
            baseViewHolder.setText(i, title);
            baseViewHolder.setText(R$id.tv_count, "x " + a2.getRemain());
            TextView textView = (TextView) baseViewHolder.getView(R$id.btn_action);
            final boolean B = B(a2);
            final boolean C = C(a2);
            PrizeButtonState prizeButtonState = B ? PrizeButtonState.ACTIVE : PrizeButtonState.CLAIMED;
            textView.setText(context.getString(B ? R$string.prize_btn_claim : C ? R$string.prize_btn_limit : R$string.prize_btn_claimed));
            int i2 = a.a[prizeButtonState.ordinal()];
            if (i2 == 1) {
                textView.setBackgroundResource(R$mipmap.btn_claim_normal);
                textView.setTextColor(context.getColor(R.color.white));
                textView.setEnabled(true);
            } else if (i2 == 2) {
                textView.setBackgroundResource(R$mipmap.btn_claim_done);
                textView.setTextColor(context.getColor(R$color.prize_btn_claimed_text));
                textView.setEnabled(false);
            }
            uf.c.c(textView, 0L, new Function1() { // from class: com.transsion.rewardscenter.prize.a
                public final Object invoke(Object obj) {
                    Unit A;
                    A = b.A(B, context, this, C, (View) obj);
                    return A;
                }
            }, 1, (Object) null);
        }
    }
}
