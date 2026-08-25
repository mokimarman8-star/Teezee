package gm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.widget.GradientBorderView;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.member.widget.PointView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i implements f4.a {
    private final LinearLayoutCompat a;
    public final ShapeableImageView b;
    public final AppCompatImageView c;
    public final AppCompatTextView d;
    public final GradientBorderView e;
    public final PointView f;
    public final ConstraintLayout g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;
    public final LinearLayoutCompat j;
    public final AppCompatTextView k;
    public final GradientBorderView l;
    public final AppCompatTextView m;
    public final AppCompatImageView n;
    public final PointView o;
    public final AppCompatTextView p;
    public final RecyclerView q;
    public final RecyclerView r;
    public final AppCompatTextView s;
    public final RecyclerView t;
    public final NestedScrollView u;
    public final GradientBorderView v;
    public final ConstraintLayout w;
    public final ConstraintLayout x;
    public final AppCompatTextView y;
    public final AppCompatTextView z;

    private i(LinearLayoutCompat linearLayoutCompat, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, GradientBorderView gradientBorderView, PointView pointView, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, LinearLayoutCompat linearLayoutCompat2, AppCompatTextView appCompatTextView4, GradientBorderView gradientBorderView2, AppCompatTextView appCompatTextView5, AppCompatImageView appCompatImageView2, PointView pointView2, AppCompatTextView appCompatTextView6, RecyclerView recyclerView, RecyclerView recyclerView2, AppCompatTextView appCompatTextView7, RecyclerView recyclerView3, NestedScrollView nestedScrollView, GradientBorderView gradientBorderView3, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, AppCompatTextView appCompatTextView8, AppCompatTextView appCompatTextView9) {
        this.a = linearLayoutCompat;
        this.b = shapeableImageView;
        this.c = appCompatImageView;
        this.d = appCompatTextView;
        this.e = gradientBorderView;
        this.f = pointView;
        this.g = constraintLayout;
        this.h = appCompatTextView2;
        this.i = appCompatTextView3;
        this.j = linearLayoutCompat2;
        this.k = appCompatTextView4;
        this.l = gradientBorderView2;
        this.m = appCompatTextView5;
        this.n = appCompatImageView2;
        this.o = pointView2;
        this.p = appCompatTextView6;
        this.q = recyclerView;
        this.r = recyclerView2;
        this.s = appCompatTextView7;
        this.t = recyclerView3;
        this.u = nestedScrollView;
        this.v = gradientBorderView3;
        this.w = constraintLayout2;
        this.x = constraintLayout3;
        this.y = appCompatTextView8;
        this.z = appCompatTextView9;
    }

    public static i a(View view) {
        AppCompatImageView a;
        AppCompatTextView a2;
        ConstraintLayout a3;
        AppCompatTextView a4;
        AppCompatTextView a5;
        LinearLayoutCompat a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        AppCompatImageView a9;
        AppCompatTextView a10;
        RecyclerView a11;
        RecyclerView a12;
        AppCompatTextView a13;
        RecyclerView a14;
        NestedScrollView a15;
        ConstraintLayout a16;
        ConstraintLayout a17;
        AppCompatTextView a18;
        AppCompatTextView a19;
        int i = R$id.iv_avatar_premium;
        ShapeableImageView a20 = f4.b.a(view, i);
        if (a20 != null && (a = f4.b.a(view, (i = R$id.iv_back))) != null && (a2 = f4.b.a(view, (i = R$id.iv_detail_title))) != null) {
            i = R$id.iv_free_container;
            GradientBorderView gradientBorderView = (GradientBorderView) f4.b.a(view, i);
            if (gradientBorderView != null) {
                i = R$id.iv_free_points;
                PointView pointView = (PointView) f4.b.a(view, i);
                if (pointView != null && (a3 = f4.b.a(view, (i = R$id.iv_info))) != null && (a4 = f4.b.a(view, (i = R$id.iv_name))) != null && (a5 = f4.b.a(view, (i = R$id.iv_next_billing_date))) != null && (a6 = f4.b.a(view, (i = R$id.iv_or))) != null && (a7 = f4.b.a(view, (i = R$id.iv_premium))) != null) {
                    i = R$id.iv_premium_container;
                    GradientBorderView gradientBorderView2 = (GradientBorderView) f4.b.a(view, i);
                    if (gradientBorderView2 != null && (a8 = f4.b.a(view, (i = R$id.iv_premium_info))) != null && (a9 = f4.b.a(view, (i = R$id.iv_premium_mask))) != null) {
                        i = R$id.iv_premium_points;
                        PointView pointView2 = (PointView) f4.b.a(view, i);
                        if (pointView2 != null && (a10 = f4.b.a(view, (i = R$id.iv_premium_title))) != null && (a11 = f4.b.a(view, (i = R$id.iv_redeem_list))) != null && (a12 = f4.b.a(view, (i = R$id.iv_sku_list))) != null && (a13 = f4.b.a(view, (i = R$id.iv_subscription_desc))) != null && (a14 = f4.b.a(view, (i = R$id.iv_task_list))) != null && (a15 = f4.b.a(view, (i = R$id.scroll_view))) != null) {
                            i = R$id.task_container_bar;
                            GradientBorderView gradientBorderView3 = (GradientBorderView) f4.b.a(view, i);
                            if (gradientBorderView3 != null && (a16 = f4.b.a(view, (i = R$id.titleLayout))) != null && (a17 = f4.b.a(view, (i = R$id.top_layout))) != null && (a18 = f4.b.a(view, (i = R$id.tv_promo_code))) != null && (a19 = f4.b.a(view, (i = R$id.tv_redeem))) != null) {
                                return new i((LinearLayoutCompat) view, a20, a, a2, gradientBorderView, pointView, a3, a4, a5, a6, a7, gradientBorderView2, a8, a9, pointView2, a10, a11, a12, a13, a14, a15, gradientBorderView3, a16, a17, a18, a19);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_member_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
