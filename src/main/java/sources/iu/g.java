package iu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLConstraintLayout;
import com.tn.lib.view.SwitchButton;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g implements f4.a {
    private final ConstraintLayout a;
    public final BLConstraintLayout b;
    public final BLConstraintLayout c;
    public final BLConstraintLayout d;
    public final BLConstraintLayout e;
    public final BLConstraintLayout f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ImageView k;
    public final ImageView l;
    public final LinearLayout m;
    public final RecyclerView n;
    public final SwitchButton o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final GradientTextView s;
    public final GradientTextView t;
    public final GradientTextView u;
    public final GradientTextView v;
    public final GradientTextView w;
    public final GradientTextView x;
    public final TextView y;
    public final TextView z;

    private g(ConstraintLayout constraintLayout, BLConstraintLayout bLConstraintLayout, BLConstraintLayout bLConstraintLayout2, BLConstraintLayout bLConstraintLayout3, BLConstraintLayout bLConstraintLayout4, BLConstraintLayout bLConstraintLayout5, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout, RecyclerView recyclerView, SwitchButton switchButton, TextView textView, TextView textView2, TextView textView3, GradientTextView gradientTextView, GradientTextView gradientTextView2, GradientTextView gradientTextView3, GradientTextView gradientTextView4, GradientTextView gradientTextView5, GradientTextView gradientTextView6, TextView textView4, TextView textView5) {
        this.a = constraintLayout;
        this.b = bLConstraintLayout;
        this.c = bLConstraintLayout2;
        this.d = bLConstraintLayout3;
        this.e = bLConstraintLayout4;
        this.f = bLConstraintLayout5;
        this.g = imageView;
        this.h = imageView2;
        this.i = imageView3;
        this.j = imageView4;
        this.k = imageView5;
        this.l = imageView6;
        this.m = linearLayout;
        this.n = recyclerView;
        this.o = switchButton;
        this.p = textView;
        this.q = textView2;
        this.r = textView3;
        this.s = gradientTextView;
        this.t = gradientTextView2;
        this.u = gradientTextView3;
        this.v = gradientTextView4;
        this.w = gradientTextView5;
        this.x = gradientTextView6;
        this.y = textView4;
        this.z = textView5;
    }

    public static g a(View view) {
        BLConstraintLayout a;
        BLConstraintLayout a2;
        BLConstraintLayout a3;
        BLConstraintLayout a4;
        RecyclerView a5;
        SwitchButton a6;
        GradientTextView a7;
        GradientTextView a8;
        GradientTextView a9;
        GradientTextView a10;
        GradientTextView a11;
        GradientTextView a12;
        int i = R$id.clAutoplay;
        BLConstraintLayout a13 = f4.b.a(view, i);
        if (a13 != null && (a = f4.b.a(view, (i = R$id.clCleanMode))) != null && (a2 = f4.b.a(view, (i = R$id.clQuality))) != null && (a3 = f4.b.a(view, (i = R$id.clSpeed))) != null && (a4 = f4.b.a(view, (i = R$id.clSubtitle))) != null) {
            i = R$id.ivAutoplayIcon;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null) {
                i = R$id.ivCleanModeIcon;
                ImageView imageView2 = (ImageView) f4.b.a(view, i);
                if (imageView2 != null) {
                    i = R$id.ivQualityIcon;
                    ImageView imageView3 = (ImageView) f4.b.a(view, i);
                    if (imageView3 != null) {
                        i = R$id.ivSpeedIcon;
                        ImageView imageView4 = (ImageView) f4.b.a(view, i);
                        if (imageView4 != null) {
                            i = R$id.ivSubtitleArrow;
                            ImageView imageView5 = (ImageView) f4.b.a(view, i);
                            if (imageView5 != null) {
                                i = R$id.ivSubtitleIcon;
                                ImageView imageView6 = (ImageView) f4.b.a(view, i);
                                if (imageView6 != null) {
                                    i = R$id.llSpeedOptions;
                                    LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                                    if (linearLayout != null && (a5 = f4.b.a(view, (i = R$id.rvQuality))) != null && (a6 = f4.b.a(view, (i = R$id.switchAutoplay))) != null) {
                                        i = R$id.tvAutoplayTitle;
                                        TextView textView = (TextView) f4.b.a(view, i);
                                        if (textView != null) {
                                            i = R$id.tvCleanModeTitle;
                                            TextView textView2 = (TextView) f4.b.a(view, i);
                                            if (textView2 != null) {
                                                i = R$id.tvQualityTitle;
                                                TextView textView3 = (TextView) f4.b.a(view, i);
                                                if (textView3 != null && (a7 = f4.b.a(view, (i = R$id.tvSpeed05))) != null && (a8 = f4.b.a(view, (i = R$id.tvSpeed075))) != null && (a9 = f4.b.a(view, (i = R$id.tvSpeed1))) != null && (a10 = f4.b.a(view, (i = R$id.tvSpeed125))) != null && (a11 = f4.b.a(view, (i = R$id.tvSpeed15))) != null && (a12 = f4.b.a(view, (i = R$id.tvSpeed2))) != null) {
                                                    i = R$id.tvSpeedTitle;
                                                    TextView textView4 = (TextView) f4.b.a(view, i);
                                                    if (textView4 != null) {
                                                        i = R$id.tvSubtitleTitle;
                                                        TextView textView5 = (TextView) f4.b.a(view, i);
                                                        if (textView5 != null) {
                                                            return new g((ConstraintLayout) view, a13, a, a2, a3, a4, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, linearLayout, a5, a6, textView, textView2, textView3, a7, a8, a9, a10, a11, a12, textView4, textView5);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static g c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_ugc_imm_video_setting, viewGroup, false);
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
