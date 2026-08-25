package sh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.view.AdTagView;
import com.transsion.ad.view.MemberTagView;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class f implements f4.a {
    private final ConstraintLayout a;
    public final AdTagView b;
    public final ConstraintLayout c;
    public final ConstraintLayout d;
    public final ConstraintLayout e;
    public final FrameLayout f;
    public final FrameLayout g;
    public final AppCompatImageView h;
    public final AppCompatImageView i;
    public final LinearLayout j;
    public final ShapeableImageView k;
    public final AppCompatTextView l;
    public final AppCompatTextView m;
    public final AppCompatTextView n;
    public final ShapeableImageView o;
    public final AppCompatTextView p;
    public final AppCompatTextView q;
    public final AppCompatTextView r;
    public final AppCompatTextView s;
    public final LinearLayoutCompat t;
    public final MemberTagView u;
    public final View v;

    private f(ConstraintLayout constraintLayout, AdTagView adTagView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, FrameLayout frameLayout, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, ShapeableImageView shapeableImageView2, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, LinearLayoutCompat linearLayoutCompat, MemberTagView memberTagView, View view) {
        this.a = constraintLayout;
        this.b = adTagView;
        this.c = constraintLayout2;
        this.d = constraintLayout3;
        this.e = constraintLayout4;
        this.f = frameLayout;
        this.g = frameLayout2;
        this.h = appCompatImageView;
        this.i = appCompatImageView2;
        this.j = linearLayout;
        this.k = shapeableImageView;
        this.l = appCompatTextView;
        this.m = appCompatTextView2;
        this.n = appCompatTextView3;
        this.o = shapeableImageView2;
        this.p = appCompatTextView4;
        this.q = appCompatTextView5;
        this.r = appCompatTextView6;
        this.s = appCompatTextView7;
        this.t = linearLayoutCompat;
        this.u = memberTagView;
        this.v = view;
    }

    public static f a(View view) {
        ConstraintLayout a;
        ConstraintLayout a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        ShapeableImageView a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        ShapeableImageView a9;
        AppCompatTextView a10;
        AppCompatTextView a11;
        AppCompatTextView a12;
        AppCompatTextView a13;
        LinearLayoutCompat a14;
        MemberTagView a15;
        View a16;
        int i = R$id.adIcon;
        AdTagView a17 = f4.b.a(view, i);
        if (a17 != null && (a = f4.b.a(view, (i = R$id.clAdEndLayout))) != null && (a2 = f4.b.a(view, (i = R$id.clAdInfo))) != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R$id.container;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R$id.flVolumeContainer;
                FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                if (frameLayout2 != null && (a3 = f4.b.a(view, (i = R$id.ivAdClose))) != null && (a4 = f4.b.a(view, (i = R$id.ivClose))) != null) {
                    i = R$id.llMember;
                    LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                    if (linearLayout != null && (a5 = f4.b.a(view, (i = R$id.tvAdAvatar))) != null && (a6 = f4.b.a(view, (i = R$id.tvAdBtn))) != null && (a7 = f4.b.a(view, (i = R$id.tvAdDesc))) != null && (a8 = f4.b.a(view, (i = R$id.tvAdTitle))) != null && (a9 = f4.b.a(view, (i = R$id.tvAvatar))) != null && (a10 = f4.b.a(view, (i = R$id.tvBtn))) != null && (a11 = f4.b.a(view, (i = R$id.tvCd))) != null && (a12 = f4.b.a(view, (i = R$id.tvDesc))) != null && (a13 = f4.b.a(view, (i = R$id.tvTitle))) != null && (a14 = f4.b.a(view, (i = R$id.viewCd))) != null && (a15 = f4.b.a(view, (i = R$id.viewMember))) != null && (a16 = f4.b.a(view, (i = R$id.viewMemberLiner))) != null) {
                        return new f(constraintLayout, a17, a, a2, constraintLayout, frameLayout, frameLayout2, a3, a4, linearLayout, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static f c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_bidding_buy_out_video_unspecified_layout, viewGroup, false);
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
