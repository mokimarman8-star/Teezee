package pw;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.activate.ui.LongVodActivateAdView;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a implements f4.a {
    private final LinearLayout a;
    public final LongVodActivateAdView b;
    public final CardView c;
    public final ConstraintLayout d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final AppCompatTextView g;
    public final ConstraintLayout h;
    public final TextView i;
    public final TextView j;
    public final AppCompatTextView k;
    public final TextView l;
    public final TextView m;
    public final View n;
    public final View o;

    private a(LinearLayout linearLayout, LongVodActivateAdView longVodActivateAdView, CardView cardView, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, AppCompatTextView appCompatTextView2, TextView textView3, TextView textView4, View view, View view2) {
        this.a = linearLayout;
        this.b = longVodActivateAdView;
        this.c = cardView;
        this.d = constraintLayout;
        this.e = appCompatImageView;
        this.f = appCompatImageView2;
        this.g = appCompatTextView;
        this.h = constraintLayout2;
        this.i = textView;
        this.j = textView2;
        this.k = appCompatTextView2;
        this.l = textView3;
        this.m = textView4;
        this.n = view;
        this.o = view2;
    }

    public static a a(View view) {
        CardView a;
        ConstraintLayout a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        AppCompatTextView a5;
        ConstraintLayout a6;
        AppCompatTextView a7;
        View a8;
        View a9;
        int i = R$id.adView;
        LongVodActivateAdView longVodActivateAdView = (LongVodActivateAdView) f4.b.a(view, i);
        if (longVodActivateAdView != null && (a = f4.b.a(view, (i = R$id.cardView))) != null && (a2 = f4.b.a(view, (i = R$id.cl2MemberInfo))) != null && (a3 = f4.b.a(view, (i = R$id.ivClose))) != null && (a4 = f4.b.a(view, (i = R$id.ivIcon))) != null && (a5 = f4.b.a(view, (i = R$id.ivPremium))) != null && (a6 = f4.b.a(view, (i = R$id.llContent))) != null) {
            i = R$id.tvGetAd;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null) {
                i = R$id.tvGetAdSec;
                TextView textView2 = (TextView) f4.b.a(view, i);
                if (textView2 != null && (a7 = f4.b.a(view, (i = R$id.tvOr))) != null) {
                    i = R$id.tvTips;
                    TextView textView3 = (TextView) f4.b.a(view, i);
                    if (textView3 != null) {
                        i = R$id.tvTipsSec;
                        TextView textView4 = (TextView) f4.b.a(view, i);
                        if (textView4 != null && (a8 = f4.b.a(view, (i = R$id.viewLineL))) != null && (a9 = f4.b.a(view, (i = R$id.viewLineR))) != null) {
                            return new a((LinearLayout) view, longVodActivateAdView, a, a2, a3, a4, a5, a6, textView, textView2, a7, textView3, textView4, a8, a9);
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
