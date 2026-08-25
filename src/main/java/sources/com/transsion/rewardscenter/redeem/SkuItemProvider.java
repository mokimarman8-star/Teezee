package com.transsion.rewardscenter.redeem;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cloud.hisavana.sdk.common.util.m0;
import com.tn.lib.widget.R;
import com.transsion.push.bean.MsgStyle;
import com.transsion.rewardscenter.R$color;
import com.transsion.rewardscenter.R$drawable;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.R$mipmap;
import com.transsion.rewardscenter.R$string;
import com.transsion.rewardscenter.redeem.e;
import com.transsion.rewardscenter.utils.p;
import com.transsion.rewardscenter.utils.q;
import com.transsion.rewardscenterapi.Lottery;
import com.transsion.rewardscenterapi.SkuPoint;
import com.transsion.rewardscenterapi.TopUpType;
import com.transsion.rewardscenterapi.User;
import java.math.BigDecimal;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SkuItemProvider extends BaseItemProvider {
    private final zo.a e;

    public SkuItemProvider(zo.a aVar) {
        Intrinsics.h(aVar, "config");
        this.e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(boolean z, SkuItemProvider skuItemProvider, e eVar, SkuPoint skuPoint, View view) {
        Intrinsics.h(view, "it");
        if (!z) {
            return Unit.a;
        }
        if (!l.a.e()) {
            String string = skuItemProvider.k().getString(R.string.no_network_toast);
            Intrinsics.g(string, "getString(...)");
            p.a(false, string);
            return Unit.a;
        }
        Lottery lottery = (Lottery) skuItemProvider.e.c().p().f();
        if (Intrinsics.c(lottery != null ? lottery.getActivityId() : null, "0") || ((e.b) eVar).a()) {
            skuItemProvider.C(skuPoint);
        } else {
            zo.a aVar = skuItemProvider.e;
            com.transsion.rewardscenter.utils.f.c(aVar, TopUpType.REDEEM, aVar.c().l());
        }
        skuItemProvider.D(((e.b) eVar).a());
        return Unit.a;
    }

    private final void C(SkuPoint skuPoint) {
        String skuId = skuPoint.getSkuId();
        if (skuId == null || kotlinx.coroutines.i.d(this.e.b(), (CoroutineContext) null, (CoroutineStart) null, new SkuItemProvider$redeem$1$1(this, skuId, null), 3, (Object) null) == null) {
            String string = k().getString(R$string.redeem_failed_tips);
            Intrinsics.g(string, "getString(...)");
            p.a(false, string);
            Unit unit = Unit.a;
        }
    }

    private final void D(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("has_paid", z ? MsgStyle.CUSTOM_LEFT_PIC : "0");
        hashMap.put("source", "sku");
        q.a("redeem_rewards", hashMap);
    }

    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final e eVar) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(eVar, "item");
        if (eVar instanceof e.b) {
            final SkuPoint b = ((e.b) eVar).b();
            baseViewHolder.setText(R$id.title, b.getDescription());
            baseViewHolder.setText(R$id.point, "-" + m0.a(new BigDecimal(String.valueOf(b.getPrice()))).toPlainString());
            User w = this.e.c().w();
            final boolean z = ((double) (w != null ? w.getPoint() : 0)) >= b.getPrice();
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
            uf.c.c(textView, 0L, new Function1() { // from class: com.transsion.rewardscenter.redeem.f
                public final Object invoke(Object obj) {
                    Unit B;
                    B = SkuItemProvider.B(z, this, eVar, b, (View) obj);
                    return B;
                }
            }, 1, (Object) null);
        }
    }

    public int l() {
        return RedeemType.SKU.getValue();
    }

    public int m() {
        return R$layout.redeem_sku_item;
    }
}
