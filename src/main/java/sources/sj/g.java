package sj;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.commercialization.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g implements f4.a {
    private final LinearLayout a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final ConstraintLayout g;
    public final LinearLayout h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final View l;
    public final ShapeableImageView m;
    public final FrameLayout n;

    private g(LinearLayout linearLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, ConstraintLayout constraintLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, View view, ShapeableImageView shapeableImageView, FrameLayout frameLayout) {
        this.a = linearLayout;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = appCompatImageView3;
        this.e = appCompatImageView4;
        this.f = appCompatImageView5;
        this.g = constraintLayout;
        this.h = linearLayout2;
        this.i = textView;
        this.j = textView2;
        this.k = textView3;
        this.l = view;
        this.m = shapeableImageView;
        this.n = frameLayout;
    }

    public static g a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        ConstraintLayout a5;
        View a6;
        ShapeableImageView a7;
        int i = R$id.ivBg1;
        AppCompatImageView a8 = f4.b.a(view, i);
        if (a8 != null && (a = f4.b.a(view, (i = R$id.ivClose))) != null && (a2 = f4.b.a(view, (i = R$id.ivLeftWing))) != null && (a3 = f4.b.a(view, (i = R$id.ivRightWing))) != null && (a4 = f4.b.a(view, (i = R$id.ivTreasureAvatar))) != null && (a5 = f4.b.a(view, (i = R$id.llContent))) != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R$id.tvClaimNow;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null) {
                i = R$id.tvStateTitle;
                TextView textView2 = (TextView) f4.b.a(view, i);
                if (textView2 != null) {
                    i = R$id.tvStateTitlePrize;
                    TextView textView3 = (TextView) f4.b.a(view, i);
                    if (textView3 != null && (a6 = f4.b.a(view, (i = R$id.viewBg1))) != null && (a7 = f4.b.a(view, (i = R$id.viewBg2))) != null) {
                        i = R$id.viewClaim;
                        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
                        if (frameLayout != null) {
                            return new g(linearLayout, a8, a, a2, a3, a4, a5, linearLayout, textView, textView2, textView3, a6, a7, frameLayout);
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
