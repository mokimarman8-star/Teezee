package mn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$layout;
import com.transsion.player.longvideo.member.ResolutionAdView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements f4.a {
    private final FrameLayout a;
    public final ResolutionAdView b;
    public final ConstraintLayout c;
    public final ConstraintLayout d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final AppCompatImageView g;
    public final LinearLayout h;
    public final LinearLayout i;
    public final LinearLayout j;
    public final TextView k;
    public final TextView l;
    public final AppCompatTextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final View s;
    public final View t;

    private b(FrameLayout frameLayout, ResolutionAdView resolutionAdView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, AppCompatTextView appCompatTextView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, View view, View view2) {
        this.a = frameLayout;
        this.b = resolutionAdView;
        this.c = constraintLayout;
        this.d = constraintLayout2;
        this.e = appCompatImageView;
        this.f = appCompatImageView2;
        this.g = appCompatImageView3;
        this.h = linearLayout;
        this.i = linearLayout2;
        this.j = linearLayout3;
        this.k = textView;
        this.l = textView2;
        this.m = appCompatTextView;
        this.n = textView3;
        this.o = textView4;
        this.p = textView5;
        this.q = textView6;
        this.r = textView7;
        this.s = view;
        this.t = view2;
    }

    public static b a(View view) {
        ConstraintLayout a;
        ConstraintLayout a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        AppCompatTextView a6;
        View a7;
        View a8;
        int i = R$id.cardAdView;
        ResolutionAdView resolutionAdView = (ResolutionAdView) f4.b.a(view, i);
        if (resolutionAdView != null && (a = f4.b.a(view, (i = R$id.clMemberModule))) != null && (a2 = f4.b.a(view, (i = R$id.clPayModule))) != null && (a3 = f4.b.a(view, (i = R$id.ivClose))) != null && (a4 = f4.b.a(view, (i = R$id.ivPremium))) != null && (a5 = f4.b.a(view, (i = R$id.ivTypeLotteryDisableTop))) != null) {
            i = R$id.llOrModule;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null) {
                i = R$id.llTypeLottery;
                LinearLayout linearLayout2 = (LinearLayout) f4.b.a(view, i);
                if (linearLayout2 != null) {
                    i = R$id.llTypeLotteryDisable;
                    LinearLayout linearLayout3 = (LinearLayout) f4.b.a(view, i);
                    if (linearLayout3 != null) {
                        i = R$id.tvMoneyDes;
                        TextView textView = (TextView) f4.b.a(view, i);
                        if (textView != null) {
                            i = R$id.tvMoneyNum;
                            TextView textView2 = (TextView) f4.b.a(view, i);
                            if (textView2 != null && (a6 = f4.b.a(view, (i = R$id.tvOr))) != null) {
                                i = R$id.tvPremium;
                                TextView textView3 = (TextView) f4.b.a(view, i);
                                if (textView3 != null) {
                                    i = R$id.tvTitle11;
                                    TextView textView4 = (TextView) f4.b.a(view, i);
                                    if (textView4 != null) {
                                        i = R$id.tvTitle12;
                                        TextView textView5 = (TextView) f4.b.a(view, i);
                                        if (textView5 != null) {
                                            i = R$id.tvTitle21;
                                            TextView textView6 = (TextView) f4.b.a(view, i);
                                            if (textView6 != null) {
                                                i = R$id.tvTitle22;
                                                TextView textView7 = (TextView) f4.b.a(view, i);
                                                if (textView7 != null && (a7 = f4.b.a(view, (i = R$id.viewLineL))) != null && (a8 = f4.b.a(view, (i = R$id.viewLineR))) != null) {
                                                    return new b((FrameLayout) view, resolutionAdView, a, a2, a3, a4, a5, linearLayout, linearLayout2, linearLayout3, textView, textView2, a6, textView3, textView4, textView5, textView6, textView7, a7, a8);
                                                }
                                            }
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

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.long_vod_fragment_resolution_unlock, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
