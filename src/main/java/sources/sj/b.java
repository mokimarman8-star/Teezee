package sj;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.commercialization.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements f4.a {
    private final LinearLayout a;
    public final CardView b;
    public final ConstraintLayout c;
    public final ConstraintLayout d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final AppCompatTextView g;
    public final AppCompatImageView h;
    public final ConstraintLayout i;
    public final NativeWrapperAdView j;
    public final TextView k;
    public final TextView l;
    public final AppCompatTextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final View q;
    public final View r;

    private b(LinearLayout linearLayout, CardView cardView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView3, ConstraintLayout constraintLayout3, NativeWrapperAdView nativeWrapperAdView, TextView textView, TextView textView2, AppCompatTextView appCompatTextView2, TextView textView3, TextView textView4, TextView textView5, View view, View view2) {
        this.a = linearLayout;
        this.b = cardView;
        this.c = constraintLayout;
        this.d = constraintLayout2;
        this.e = appCompatImageView;
        this.f = appCompatImageView2;
        this.g = appCompatTextView;
        this.h = appCompatImageView3;
        this.i = constraintLayout3;
        this.j = nativeWrapperAdView;
        this.k = textView;
        this.l = textView2;
        this.m = appCompatTextView2;
        this.n = textView3;
        this.o = textView4;
        this.p = textView5;
        this.q = view;
        this.r = view2;
    }

    public static b a(View view) {
        ConstraintLayout a;
        ConstraintLayout a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        AppCompatTextView a5;
        AppCompatImageView a6;
        ConstraintLayout a7;
        AppCompatTextView a8;
        View a9;
        View a10;
        int i = R$id.cardView;
        CardView a11 = f4.b.a(view, i);
        if (a11 != null && (a = f4.b.a(view, (i = R$id.change_group))) != null && (a2 = f4.b.a(view, (i = R$id.cl2MemberInfo))) != null && (a3 = f4.b.a(view, (i = R$id.ivClose))) != null && (a4 = f4.b.a(view, (i = R$id.ivIcon))) != null && (a5 = f4.b.a(view, (i = R$id.ivPremium))) != null && (a6 = f4.b.a(view, (i = R$id.ivRefresh))) != null && (a7 = f4.b.a(view, (i = R$id.llContent))) != null) {
            i = R$id.nativeWrapperAdView;
            NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) f4.b.a(view, i);
            if (nativeWrapperAdView != null) {
                i = R$id.tvGetAd;
                TextView textView = (TextView) f4.b.a(view, i);
                if (textView != null) {
                    i = R$id.tvGetAdSec;
                    TextView textView2 = (TextView) f4.b.a(view, i);
                    if (textView2 != null && (a8 = f4.b.a(view, (i = R$id.tvOr))) != null) {
                        i = R$id.tvTips;
                        TextView textView3 = (TextView) f4.b.a(view, i);
                        if (textView3 != null) {
                            i = R$id.tvTipsSec;
                            TextView textView4 = (TextView) f4.b.a(view, i);
                            if (textView4 != null) {
                                i = R$id.tvTryMore;
                                TextView textView5 = (TextView) f4.b.a(view, i);
                                if (textView5 != null && (a9 = f4.b.a(view, (i = R$id.viewLineL))) != null && (a10 = f4.b.a(view, (i = R$id.viewLineR))) != null) {
                                    return new b((LinearLayout) view, a11, a, a2, a3, a4, a5, a6, a7, nativeWrapperAdView, textView, textView2, a8, textView3, textView4, textView5, a9, a10);
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
    public LinearLayout getRoot() {
        return this.a;
    }
}
