package com.transsion.rewardscenter.redeem;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R;
import com.transsion.push.bean.MsgStyle;
import com.transsion.rewardscenter.R$color;
import com.transsion.rewardscenter.R$drawable;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.R$mipmap;
import com.transsion.rewardscenter.R$string;
import com.transsion.rewardscenter.redeem.e;
import com.transsion.rewardscenter.ui.RewardsCenterFragment;
import com.transsion.rewardscenter.utils.p;
import com.transsion.rewardscenter.utils.q;
import com.transsion.rewardscenterapi.LotteryPrize;
import com.transsion.rewardscenterapi.TopUpType;
import com.transsion.rewardscenterapi.User;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import ni.f;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LotteryItemProvider extends BaseItemProvider {
    private final zo.a e;

    public LotteryItemProvider(zo.a aVar) {
        Intrinsics.h(aVar, "config");
        this.e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(boolean z, LotteryItemProvider lotteryItemProvider, e eVar, LotteryPrize lotteryPrize, View view) {
        Intrinsics.h(view, "it");
        if (!z) {
            return Unit.a;
        }
        if (!l.a.e()) {
            String string = lotteryItemProvider.k().getString(R.string.no_network_toast);
            Intrinsics.g(string, "getString(...)");
            p.a(false, string);
            return Unit.a;
        }
        e.a aVar = (e.a) eVar;
        if (aVar.a()) {
            RewardsCenterFragment rewardsCenterFragment = (RewardsCenterFragment) lotteryItemProvider.e.a().get();
            if (rewardsCenterFragment != null) {
                rewardsCenterFragment.showLoading();
            }
            String activityId = lotteryPrize.getActivityId();
            if (activityId == null || kotlinx.coroutines.i.d(lotteryItemProvider.e.b(), (CoroutineContext) null, (CoroutineStart) null, new LotteryItemProvider$convert$1$1$1(activityId, lotteryItemProvider, null), 3, (Object) null) == null) {
                lotteryItemProvider.e.c().o().n(Boolean.FALSE);
                String string2 = lotteryItemProvider.k().getString(R$string.redeem_failed_tips);
                Intrinsics.g(string2, "getString(...)");
                p.a(false, string2);
                Unit unit = Unit.a;
            }
        } else {
            zo.a aVar2 = lotteryItemProvider.e;
            com.transsion.rewardscenter.utils.f.c(aVar2, TopUpType.REDEEM, aVar2.c().l());
            Unit unit2 = Unit.a;
        }
        lotteryItemProvider.C(aVar.a());
        return Unit.a;
    }

    private final void C(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("has_paid", z ? MsgStyle.CUSTOM_LEFT_PIC : "0");
        hashMap.put("source", "lottery");
        q.a("redeem_rewards", hashMap);
    }

    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final e eVar) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(eVar, "item");
        if (eVar instanceof e.a) {
            e.a aVar = (e.a) eVar;
            final LotteryPrize b = aVar.b();
            baseViewHolder.setText(R$id.title, b.getPrizeName());
            baseViewHolder.setText(R$id.point, "-" + b.getPointCost());
            ImageView imageView = (ImageView) baseViewHolder.getView(R$id.icon);
            f.a aVar2 = ni.f.a;
            Context context = imageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            aVar2.m(context).g(aVar.b().getPrizeUrl()).i(R$mipmap.ic_redeem_lottery).d(imageView);
            User w = this.e.c().w();
            final boolean z = (w != null ? w.getPoint() : 0) >= b.getPointCost();
            TextView textView = (TextView) baseViewHolder.getView(R$id.action);
            if (z) {
                textView.setEnabled(true);
                textView.setBackgroundResource(R$mipmap.ic_redeem_btn_bg_orange);
                textView.setBackgroundTintList(null);
                textView.setTextColor(k().getColor(R.color.white));
            } else {
                textView.setEnabled(false);
                textView.setBackgroundResource(R$drawable.shape_r6_tint);
                textView.setBackgroundTintList(ColorStateList.valueOf(k().getColor(R$color.redeem_disable_bg)));
                textView.setTextColor(k().getColor(R.color.white_80));
            }
            uf.c.c(textView, 0L, new Function1() { // from class: com.transsion.rewardscenter.redeem.a
                public final Object invoke(Object obj) {
                    Unit B;
                    B = LotteryItemProvider.B(z, this, eVar, b, (View) obj);
                    return B;
                }
            }, 1, (Object) null);
        }
    }

    public int l() {
        return RedeemType.LOTTERY.getValue();
    }

    public int m() {
        return R$layout.redeem_lottery_item;
    }
}
