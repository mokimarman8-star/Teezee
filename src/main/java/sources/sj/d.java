package sj;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.commercialization.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d implements f4.a {
    private final LinearLayout a;
    public final ConstraintLayout b;
    public final ConstraintLayout c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final AppCompatTextView f;
    public final AppCompatImageView g;
    public final LinearLayoutCompat h;
    public final LinearLayoutCompat i;
    public final h j;
    public final RecyclerView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;

    private d(LinearLayout linearLayout, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView3, LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, h hVar, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.a = linearLayout;
        this.b = constraintLayout;
        this.c = constraintLayout2;
        this.d = appCompatImageView;
        this.e = appCompatImageView2;
        this.f = appCompatTextView;
        this.g = appCompatImageView3;
        this.h = linearLayoutCompat;
        this.i = linearLayoutCompat2;
        this.j = hVar;
        this.k = recyclerView;
        this.l = textView;
        this.m = textView2;
        this.n = textView3;
        this.o = textView4;
        this.p = textView5;
    }

    public static d a(View view) {
        ConstraintLayout a;
        AppCompatImageView a2;
        AppCompatImageView a3;
        AppCompatTextView a4;
        AppCompatImageView a5;
        LinearLayoutCompat a6;
        LinearLayoutCompat a7;
        View a8;
        int i = R$id.adGroup;
        ConstraintLayout a9 = f4.b.a(view, i);
        if (a9 != null && (a = f4.b.a(view, (i = R$id.cl2MemberInfo))) != null && (a2 = f4.b.a(view, (i = R$id.ivClose))) != null && (a3 = f4.b.a(view, (i = R$id.ivIcon))) != null && (a4 = f4.b.a(view, (i = R$id.ivPremium))) != null && (a5 = f4.b.a(view, (i = R$id.ivRefresh))) != null && (a6 = f4.b.a(view, (i = R$id.llContent))) != null && (a7 = f4.b.a(view, (i = R$id.llLine))) != null && (a8 = f4.b.a(view, (i = R$id.rewarded_layout))) != null) {
            h a10 = h.a(a8);
            i = R$id.rv;
            RecyclerView a11 = f4.b.a(view, i);
            if (a11 != null) {
                i = R$id.tvGetAd;
                TextView textView = (TextView) f4.b.a(view, i);
                if (textView != null) {
                    i = R$id.tvGetAdSec;
                    TextView textView2 = (TextView) f4.b.a(view, i);
                    if (textView2 != null) {
                        i = R$id.tvTips;
                        TextView textView3 = (TextView) f4.b.a(view, i);
                        if (textView3 != null) {
                            i = R$id.tvTipsSec;
                            TextView textView4 = (TextView) f4.b.a(view, i);
                            if (textView4 != null) {
                                i = R$id.tvTryMore;
                                TextView textView5 = (TextView) f4.b.a(view, i);
                                if (textView5 != null) {
                                    return new d((LinearLayout) view, a9, a, a2, a3, a4, a5, a6, a7, a10, a11, textView, textView2, textView3, textView4, textView5);
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
