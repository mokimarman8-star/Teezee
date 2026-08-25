package mn;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.player.longvideo.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l implements f4.a {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final ImageView g;
    public final d h;
    public final LinearLayout i;
    public final View j;
    public final View k;
    public final View l;
    public final f m;
    public final SecondariesSeekBar n;
    public final TextView o;
    public final ViewStub p;
    public final ViewStub q;

    private l(ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, ImageView imageView, d dVar, LinearLayout linearLayout, View view, View view2, View view3, f fVar, SecondariesSeekBar secondariesSeekBar, TextView textView, ViewStub viewStub, ViewStub viewStub2) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = appCompatImageView;
        this.d = appCompatImageView2;
        this.e = appCompatImageView3;
        this.f = appCompatImageView4;
        this.g = imageView;
        this.h = dVar;
        this.i = linearLayout;
        this.j = view;
        this.k = view2;
        this.l = view3;
        this.m = fVar;
        this.n = secondariesSeekBar;
        this.o = textView;
        this.p = viewStub;
        this.q = viewStub2;
    }

    public static l a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        View a5;
        View a6;
        View a7;
        View a8;
        View a9;
        int i = R$id.flUGCAutoPlayGroup;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null && (a = f4.b.a(view, (i = R$id.iv_back))) != null && (a2 = f4.b.a(view, (i = R$id.iv_float))) != null && (a3 = f4.b.a(view, (i = R$id.iv_middle_pause))) != null && (a4 = f4.b.a(view, (i = R$id.iv_middle_screen_change))) != null) {
            i = R$id.ivUGCAutoPlayBtn;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null && (a5 = f4.b.a(view, (i = R$id.layout_loading))) != null) {
                d a10 = d.a(a5);
                i = R$id.ll_middle_bottom_controller;
                LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                if (linearLayout != null && (a6 = f4.b.a(view, (i = R$id.middle_gradient_bottom))) != null && (a7 = f4.b.a(view, (i = R$id.middle_gradient_top))) != null && (a8 = f4.b.a(view, (i = R$id.middle_guideline))) != null && (a9 = f4.b.a(view, (i = R$id.operatorLayout))) != null) {
                    f a11 = f.a(a9);
                    i = R$id.seek_bar_middle;
                    SecondariesSeekBar a12 = f4.b.a(view, i);
                    if (a12 != null) {
                        i = R$id.tv_middle_time;
                        TextView textView = (TextView) f4.b.a(view, i);
                        if (textView != null) {
                            i = R$id.vs_forward_guide_middle;
                            ViewStub viewStub = (ViewStub) f4.b.a(view, i);
                            if (viewStub != null) {
                                i = R$id.vs_forward_middle;
                                ViewStub viewStub2 = (ViewStub) f4.b.a(view, i);
                                if (viewStub2 != null) {
                                    return new l((ConstraintLayout) view, frameLayout, a, a2, a3, a4, imageView, a10, linearLayout, a6, a7, a8, a11, a12, textView, viewStub, viewStub2);
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
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
