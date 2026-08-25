package sj;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.task.treasure.TreasureAdView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e implements f4.a {
    private final ScrollView a;
    public final TreasureAdView b;
    public final ConstraintLayout c;
    public final ConstraintLayout d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final AppCompatImageView g;
    public final ShapeableImageView h;
    public final LinearLayout i;
    public final LinearLayout j;
    public final TextView k;
    public final TextView l;
    public final AppCompatTextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final View r;
    public final View s;

    private e(ScrollView scrollView, TreasureAdView treasureAdView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, ShapeableImageView shapeableImageView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, AppCompatTextView appCompatTextView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view, View view2) {
        this.a = scrollView;
        this.b = treasureAdView;
        this.c = constraintLayout;
        this.d = constraintLayout2;
        this.e = appCompatImageView;
        this.f = appCompatImageView2;
        this.g = appCompatImageView3;
        this.h = shapeableImageView;
        this.i = linearLayout;
        this.j = linearLayout2;
        this.k = textView;
        this.l = textView2;
        this.m = appCompatTextView;
        this.n = textView3;
        this.o = textView4;
        this.p = textView5;
        this.q = textView6;
        this.r = view;
        this.s = view2;
    }

    public static e a(View view) {
        ConstraintLayout a;
        ConstraintLayout a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        ShapeableImageView a6;
        AppCompatTextView a7;
        View a8;
        View a9;
        int i = R$id.cardView;
        TreasureAdView treasureAdView = (TreasureAdView) f4.b.a(view, i);
        if (treasureAdView != null && (a = f4.b.a(view, (i = R$id.clMemberModule))) != null && (a2 = f4.b.a(view, (i = R$id.clPayModule))) != null && (a3 = f4.b.a(view, (i = R$id.ivClose))) != null && (a4 = f4.b.a(view, (i = R$id.ivLittleTop))) != null && (a5 = f4.b.a(view, (i = R$id.ivPremium))) != null && (a6 = f4.b.a(view, (i = R$id.ivTop))) != null) {
            i = R$id.llContent;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null) {
                i = R$id.llOrModule;
                LinearLayout linearLayout2 = (LinearLayout) f4.b.a(view, i);
                if (linearLayout2 != null) {
                    i = R$id.tvMoneyDes;
                    TextView textView = (TextView) f4.b.a(view, i);
                    if (textView != null) {
                        i = R$id.tvMoneyNum;
                        TextView textView2 = (TextView) f4.b.a(view, i);
                        if (textView2 != null && (a7 = f4.b.a(view, (i = R$id.tvOr))) != null) {
                            i = R$id.tvPremium;
                            TextView textView3 = (TextView) f4.b.a(view, i);
                            if (textView3 != null) {
                                i = R$id.tvTitle1;
                                TextView textView4 = (TextView) f4.b.a(view, i);
                                if (textView4 != null) {
                                    i = R$id.tvTitle2;
                                    TextView textView5 = (TextView) f4.b.a(view, i);
                                    if (textView5 != null) {
                                        i = R$id.tvTitle3;
                                        TextView textView6 = (TextView) f4.b.a(view, i);
                                        if (textView6 != null && (a8 = f4.b.a(view, (i = R$id.viewLineL))) != null && (a9 = f4.b.a(view, (i = R$id.viewLineR))) != null) {
                                            return new e((ScrollView) view, treasureAdView, a, a2, a3, a4, a5, a6, linearLayout, linearLayout2, textView, textView2, a7, textView3, textView4, textView5, textView6, a8, a9);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.a;
    }
}
