package wn;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLView;
import com.tn.lib.view.NoScrollRecyclerView2;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.postdetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class s implements f4.a {
    public final View A;
    public final View B;
    public final View C;
    public final View D;
    public final View E;
    public final View F;
    public final View G;
    public final BLView H;
    public final BLView I;
    private final View a;
    public final BLConstraintLayout b;
    public final ShapeableImageView c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final ShapeableImageView f;
    public final AppCompatImageView g;
    public final AppCompatImageView h;
    public final AppCompatImageView i;
    public final AppCompatImageView j;
    public final ShapeableImageView k;
    public final ShapeableImageView l;
    public final ShapeableImageView m;
    public final z n;
    public final b0 o;
    public final NoScrollRecyclerView2 p;
    public final AppCompatTextView q;
    public final GradientTextView r;
    public final AppCompatTextView s;
    public final AppCompatTextView t;
    public final AppCompatTextView u;
    public final AppCompatTextView v;
    public final AppCompatTextView w;
    public final AppCompatTextView x;
    public final AppCompatTextView y;
    public final AppCompatTextView z;

    private s(View view, BLConstraintLayout bLConstraintLayout, ShapeableImageView shapeableImageView, FrameLayout frameLayout, FrameLayout frameLayout2, ShapeableImageView shapeableImageView2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, ShapeableImageView shapeableImageView3, ShapeableImageView shapeableImageView4, ShapeableImageView shapeableImageView5, z zVar, b0 b0Var, NoScrollRecyclerView2 noScrollRecyclerView2, AppCompatTextView appCompatTextView, GradientTextView gradientTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, AppCompatTextView appCompatTextView9, View view2, View view3, View view4, View view5, View view6, View view7, View view8, BLView bLView, BLView bLView2) {
        this.a = view;
        this.b = bLConstraintLayout;
        this.c = shapeableImageView;
        this.d = frameLayout;
        this.e = frameLayout2;
        this.f = shapeableImageView2;
        this.g = appCompatImageView;
        this.h = appCompatImageView2;
        this.i = appCompatImageView3;
        this.j = appCompatImageView4;
        this.k = shapeableImageView3;
        this.l = shapeableImageView4;
        this.m = shapeableImageView5;
        this.n = zVar;
        this.o = b0Var;
        this.p = noScrollRecyclerView2;
        this.q = appCompatTextView;
        this.r = gradientTextView;
        this.s = appCompatTextView2;
        this.t = appCompatTextView3;
        this.u = appCompatTextView4;
        this.v = appCompatTextView5;
        this.w = appCompatTextView6;
        this.x = appCompatTextView7;
        this.y = appCompatTextView8;
        this.z = appCompatTextView9;
        this.A = view2;
        this.B = view3;
        this.C = view4;
        this.D = view5;
        this.E = view6;
        this.F = view7;
        this.G = view8;
        this.H = bLView;
        this.I = bLView2;
    }

    public static s a(View view) {
        AppCompatImageView a;
        ShapeableImageView a2;
        ShapeableImageView a3;
        ShapeableImageView a4;
        View a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        AppCompatTextView a9;
        AppCompatTextView a10;
        AppCompatTextView a11;
        View a12;
        View a13;
        View a14;
        View a15;
        View a16;
        BLConstraintLayout a17 = f4.b.a(view, R$id.clHotComment);
        ShapeableImageView a18 = f4.b.a(view, R$id.commentCover);
        int i = R$id.fl_content;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null) {
            i = R$id.fl_cover;
            FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
            if (frameLayout2 != null) {
                ShapeableImageView a19 = f4.b.a(view, R$id.ivHotCommentAvatar);
                AppCompatImageView a20 = f4.b.a(view, R$id.ivHotCommentIcon);
                AppCompatImageView a21 = f4.b.a(view, R$id.ivHotLike);
                i = R$id.iv_location_icon;
                AppCompatImageView a22 = f4.b.a(view, i);
                if (a22 != null && (a = f4.b.a(view, (i = R$id.iv_post_download))) != null && (a2 = f4.b.a(view, (i = R$id.iv_room_cover))) != null && (a3 = f4.b.a(view, (i = R$id.iv_user_avatar))) != null && (a4 = f4.b.a(view, (i = R$id.iv_user_avatar_2))) != null && (a5 = f4.b.a(view, (i = R$id.layout_bottom_module))) != null) {
                    z a23 = z.a(a5);
                    i = R$id.layout_content_video;
                    View a24 = f4.b.a(view, i);
                    if (a24 != null) {
                        b0 a25 = b0.a(a24);
                        i = R$id.recycler_view_post;
                        NoScrollRecyclerView2 a26 = f4.b.a(view, i);
                        if (a26 != null) {
                            AppCompatTextView a27 = f4.b.a(view, R$id.tvHotCommentContent);
                            GradientTextView gradientTextView = (GradientTextView) f4.b.a(view, R$id.tvHotCommentTitle);
                            AppCompatTextView a28 = f4.b.a(view, R$id.tvHotLikeCount);
                            i = R$id.tv_post_comment;
                            AppCompatTextView a29 = f4.b.a(view, i);
                            if (a29 != null && (a6 = f4.b.a(view, (i = R$id.tv_post_content))) != null && (a7 = f4.b.a(view, (i = R$id.tv_post_date))) != null && (a8 = f4.b.a(view, (i = R$id.tv_post_like))) != null && (a9 = f4.b.a(view, (i = R$id.tv_post_share))) != null && (a10 = f4.b.a(view, (i = R$id.tv_room_name))) != null && (a11 = f4.b.a(view, (i = R$id.tv_user_name_or_location))) != null && (a12 = f4.b.a(view, (i = R$id.v_bottom_line))) != null) {
                                View a30 = f4.b.a(view, R$id.vHotLike);
                                i = R$id.v_location_line;
                                View a31 = f4.b.a(view, i);
                                if (a31 != null && (a13 = f4.b.a(view, (i = R$id.v_post_comment))) != null && (a14 = f4.b.a(view, (i = R$id.v_post_download))) != null && (a15 = f4.b.a(view, (i = R$id.v_post_like))) != null && (a16 = f4.b.a(view, (i = R$id.v_post_share))) != null) {
                                    return new s(view, a17, a18, frameLayout, frameLayout2, a19, a20, a21, a22, a, a2, a3, a4, a23, a25, a26, a27, gradientTextView, a28, a29, a6, a7, a8, a9, a10, a11, a12, a30, a31, a13, a14, a15, a16, f4.b.a(view, R$id.v_room_cover_stroke), f4.b.a(view, R$id.v_user_avatar_2_stroke));
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
