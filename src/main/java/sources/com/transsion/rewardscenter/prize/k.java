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
import com.transsion.rewardscenter.prize.e;
import com.transsion.rewardscenter.ui.RewardsCenterFragment;
import com.transsion.rewardscenter.utils.p;
import com.transsion.rewardscenter.utils.q;
import com.transsion.rewardscenterapi.DrawResult;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ni.f;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k extends BaseItemProvider {
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
            try {
                iArr[PrizeButtonState.CLAIMING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public k(zo.a aVar) {
        Intrinsics.h(aVar, "config");
        this.e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(PrizeButtonState prizeButtonState, Context context, k kVar, DrawResult drawResult, View view) {
        Intrinsics.h(view, "it");
        if (prizeButtonState == PrizeButtonState.ACTIVE) {
            if (l.a.e()) {
                RewardsCenterFragment rewardsCenterFragment = (RewardsCenterFragment) kVar.e.a().get();
                if (rewardsCenterFragment != null) {
                    rewardsCenterFragment.k1(drawResult);
                }
                kVar.C(drawResult);
            } else {
                String string = context.getString(R.string.no_network_toast);
                Intrinsics.g(string, "getString(...)");
                p.a(false, string);
            }
        }
        return Unit.a;
    }

    private final PrizeButtonState B(DrawResult drawResult) {
        return Intrinsics.c(drawResult.getClaimStatus(), "CLAIM_STATUS_TOP_UP") ? PrizeButtonState.CLAIMING : (Intrinsics.c(drawResult.getClaimStatus(), "CLAIM_STATUS_UNCLAIM") && Intrinsics.c(drawResult.getNeedFill(), "LOTTERY_NEED_FILL_YES") && Intrinsics.c(drawResult.getFillStatus(), "FILL_STATUS_NO")) ? PrizeButtonState.ACTIVE : (Intrinsics.c(drawResult.getClaimStatus(), "CLAIM_STATUS_UNCLAIM") && Intrinsics.c(drawResult.getNeedFill(), "LOTTERY_NEED_FILL_NO")) ? PrizeButtonState.ACTIVE : PrizeButtonState.CLAIMED;
    }

    private final void C(DrawResult drawResult) {
        HashMap hashMap = new HashMap();
        String prizeType = drawResult.getPrizeType();
        if (prizeType == null) {
            prizeType = BuildConfig.FLAVOR;
        }
        hashMap.put("source", prizeType);
        q.a("prize_list", hashMap);
    }

    public int l() {
        return PrizeItemType.ROW.getValue();
    }

    public int m() {
        return R$layout.prize_row_item;
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, e eVar) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(eVar, "item");
        if (eVar instanceof e.c) {
            final DrawResult a2 = ((e.c) eVar).a();
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
            baseViewHolder.setText(R$id.tv_count, "x 1");
            TextView textView = (TextView) baseViewHolder.getView(R$id.btn_action);
            final PrizeButtonState B = B(a2);
            int i2 = a.a[B.ordinal()];
            if (i2 == 1) {
                textView.setBackgroundResource(R$mipmap.btn_claim_normal);
                textView.setText(context.getString(R$string.prize_btn_claim));
                textView.setTextColor(context.getColor(R.color.white));
                textView.setEnabled(true);
                textView.setAlpha(1.0f);
            } else if (i2 == 2) {
                textView.setBackgroundResource(R$mipmap.btn_claim_done);
                textView.setText(context.getString(R$string.prize_btn_claimed));
                textView.setTextColor(context.getColor(R$color.prize_btn_claimed_text));
                textView.setEnabled(false);
                textView.setAlpha(1.0f);
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                textView.setBackgroundResource(R$mipmap.btn_claim_normal);
                textView.setText(context.getString(R$string.prize_btn_Topping));
                textView.setTextColor(context.getColor(R.color.white));
                textView.setEnabled(false);
                textView.setAlpha(0.5f);
            }
            uf.c.c(textView, 0L, new Function1() { // from class: com.transsion.rewardscenter.prize.j
                public final Object invoke(Object obj) {
                    Unit A;
                    A = k.A(PrizeButtonState.this, context, this, a2, (View) obj);
                    return A;
                }
            }, 1, (Object) null);
        }
    }
}
