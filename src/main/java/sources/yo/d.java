package yo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.prize.PrizeListView;
import com.transsion.rewardscenter.redeem.RedeemView;
import com.transsion.rewardscenter.view.PrizeFlowView;
import com.transsion.rewardscenter.view.RewardsCenterTaskView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final h e;
    public final PrizeFlowView f;
    public final CardView g;
    public final CardView h;
    public final PrizeListView i;
    public final ConstraintLayout j;
    public final CardView k;
    public final RedeemView l;
    public final CardView m;
    public final RewardsCenterTaskView n;
    public final NestedScrollView o;
    public final AppCompatTextView p;
    public final ConstraintLayout q;
    public final AppCompatTextView r;

    private d(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, h hVar, PrizeFlowView prizeFlowView, CardView cardView, CardView cardView2, PrizeListView prizeListView, ConstraintLayout constraintLayout2, CardView cardView3, RedeemView redeemView, CardView cardView4, RewardsCenterTaskView rewardsCenterTaskView, NestedScrollView nestedScrollView, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout3, AppCompatTextView appCompatTextView2) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = appCompatImageView3;
        this.e = hVar;
        this.f = prizeFlowView;
        this.g = cardView;
        this.h = cardView2;
        this.i = prizeListView;
        this.j = constraintLayout2;
        this.k = cardView3;
        this.l = redeemView;
        this.m = cardView4;
        this.n = rewardsCenterTaskView;
        this.o = nestedScrollView;
        this.p = appCompatTextView;
        this.q = constraintLayout3;
        this.r = appCompatTextView2;
    }

    public static d a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        View a3;
        CardView a4;
        CardView a5;
        ConstraintLayout a6;
        CardView a7;
        CardView a8;
        NestedScrollView a9;
        AppCompatTextView a10;
        ConstraintLayout a11;
        AppCompatTextView a12;
        int i = R$id.iv_back;
        AppCompatImageView a13 = f4.b.a(view, i);
        if (a13 != null && (a = f4.b.a(view, (i = R$id.iv_banner))) != null && (a2 = f4.b.a(view, (i = R$id.iv_prize_triangle))) != null && (a3 = f4.b.a(view, (i = R$id.member_info))) != null) {
            h a14 = h.a(a3);
            i = R$id.prize_flow;
            PrizeFlowView prizeFlowView = (PrizeFlowView) f4.b.a(view, i);
            if (prizeFlowView != null && (a4 = f4.b.a(view, (i = R$id.rc_banner_card))) != null && (a5 = f4.b.a(view, (i = R$id.rc_prize_card))) != null) {
                i = R$id.rc_prize_list_view;
                PrizeListView prizeListView = (PrizeListView) f4.b.a(view, i);
                if (prizeListView != null && (a6 = f4.b.a(view, (i = R$id.rc_prize_section))) != null && (a7 = f4.b.a(view, (i = R$id.rc_redeem_card))) != null) {
                    i = R$id.rc_redeem_view;
                    RedeemView redeemView = (RedeemView) f4.b.a(view, i);
                    if (redeemView != null && (a8 = f4.b.a(view, (i = R$id.rc_task_card))) != null) {
                        i = R$id.rc_task_view;
                        RewardsCenterTaskView rewardsCenterTaskView = (RewardsCenterTaskView) f4.b.a(view, i);
                        if (rewardsCenterTaskView != null && (a9 = f4.b.a(view, (i = R$id.scroll_view))) != null && (a10 = f4.b.a(view, (i = R$id.title))) != null && (a11 = f4.b.a(view, (i = R$id.titleLayout))) != null && (a12 = f4.b.a(view, (i = R$id.tv_terms))) != null) {
                            return new d((ConstraintLayout) view, a13, a, a2, a14, prizeFlowView, a4, a5, prizeListView, a6, a7, redeemView, a8, rewardsCenterTaskView, a9, a10, a11, a12);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_rewards_center, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
