package wn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.ninegridview.video.NineGridVideoView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.view.PostDetailOperationView;
import com.transsion.postdetail.ui.view.PostDetailSubjectView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class m implements f4.a {
    public final AppCompatTextView A;
    public final View B;
    public final View C;
    private final ConstraintLayout a;
    public final TextView b;
    public final ConstraintLayout c;
    public final AppCompatImageView d;
    public final AppCompatSeekBar e;
    public final AppBarLayout f;
    public final ConstraintLayout g;
    public final CoordinatorLayout h;
    public final i0 i;
    public final ConstraintLayout j;
    public final FrameLayout k;
    public final Group l;
    public final AppCompatImageView m;
    public final ShapeableImageView n;
    public final AppCompatImageView o;
    public final AppCompatImageView p;
    public final LinearLayout q;
    public final NineGridVideoView r;
    public final PostDetailOperationView s;
    public final PostDetailSubjectView t;
    public final Toolbar u;
    public final CollapsingToolbarLayout v;
    public final h0 w;
    public final AppCompatTextView x;
    public final j0 y;
    public final AppCompatTextView z;

    private m(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatSeekBar appCompatSeekBar, AppBarLayout appBarLayout, ConstraintLayout constraintLayout3, CoordinatorLayout coordinatorLayout, i0 i0Var, ConstraintLayout constraintLayout4, FrameLayout frameLayout, Group group, AppCompatImageView appCompatImageView2, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, LinearLayout linearLayout, NineGridVideoView nineGridVideoView, PostDetailOperationView postDetailOperationView, PostDetailSubjectView postDetailSubjectView, Toolbar toolbar, CollapsingToolbarLayout collapsingToolbarLayout, h0 h0Var, AppCompatTextView appCompatTextView, j0 j0Var, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, View view, View view2) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = constraintLayout2;
        this.d = appCompatImageView;
        this.e = appCompatSeekBar;
        this.f = appBarLayout;
        this.g = constraintLayout3;
        this.h = coordinatorLayout;
        this.i = i0Var;
        this.j = constraintLayout4;
        this.k = frameLayout;
        this.l = group;
        this.m = appCompatImageView2;
        this.n = shapeableImageView;
        this.o = appCompatImageView3;
        this.p = appCompatImageView4;
        this.q = linearLayout;
        this.r = nineGridVideoView;
        this.s = postDetailOperationView;
        this.t = postDetailSubjectView;
        this.u = toolbar;
        this.v = collapsingToolbarLayout;
        this.w = h0Var;
        this.x = appCompatTextView;
        this.y = j0Var;
        this.z = appCompatTextView2;
        this.A = appCompatTextView3;
        this.B = view;
        this.C = view2;
    }

    public static m a(View view) {
        ConstraintLayout a;
        AppCompatImageView a2;
        AppCompatSeekBar a3;
        AppBarLayout a4;
        View a5;
        Group a6;
        AppCompatImageView a7;
        ShapeableImageView a8;
        AppCompatImageView a9;
        AppCompatImageView a10;
        Toolbar a11;
        CollapsingToolbarLayout a12;
        View a13;
        View a14;
        AppCompatTextView a15;
        View a16;
        View a17;
        int i = R$id.ad_audio_time;
        TextView textView = (TextView) f4.b.a(view, i);
        if (textView != null && (a = f4.b.a(view, (i = R$id.ad_bottom_controller))) != null && (a2 = f4.b.a(view, (i = R$id.ad_pause))) != null && (a3 = f4.b.a(view, (i = R$id.ad_seekbar))) != null && (a4 = f4.b.a(view, (i = R$id.appBar))) != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R$id.clContent;
            CoordinatorLayout a18 = f4.b.a(view, i);
            if (a18 != null && (a5 = f4.b.a(view, (i = R$id.clRating))) != null) {
                i0 a19 = i0.a(a5);
                i = R$id.contentView;
                ConstraintLayout a20 = f4.b.a(view, i);
                if (a20 != null) {
                    i = R$id.flContainer;
                    FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
                    if (frameLayout != null && (a6 = f4.b.a(view, (i = R$id.groupAudio))) != null && (a7 = f4.b.a(view, (i = R$id.iv_audio_wave))) != null && (a8 = f4.b.a(view, (i = R$id.ivAvatar))) != null && (a9 = f4.b.a(view, (i = R$id.ivBack))) != null && (a10 = f4.b.a(view, (i = R$id.iv_cover))) != null) {
                        i = R$id.llTop;
                        LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                        if (linearLayout != null) {
                            i = R$id.nine_grid;
                            NineGridVideoView nineGridVideoView = (NineGridVideoView) f4.b.a(view, i);
                            if (nineGridVideoView != null) {
                                i = R$id.postDetailOperationView;
                                PostDetailOperationView postDetailOperationView = (PostDetailOperationView) f4.b.a(view, i);
                                if (postDetailOperationView != null) {
                                    i = R$id.postDetailSubjectView;
                                    PostDetailSubjectView postDetailSubjectView = (PostDetailSubjectView) f4.b.a(view, i);
                                    if (postDetailSubjectView != null && (a11 = f4.b.a(view, (i = R$id.toolbar))) != null && (a12 = f4.b.a(view, (i = R$id.toolbarLayout))) != null && (a13 = f4.b.a(view, (i = R$id.tvPostDesc))) != null) {
                                        h0 a21 = h0.a(a13);
                                        i = R$id.tvPostTime;
                                        AppCompatTextView a22 = f4.b.a(view, i);
                                        if (a22 != null && (a14 = f4.b.a(view, (i = R$id.tvPostTitle))) != null) {
                                            j0 a23 = j0.a(a14);
                                            i = R$id.tvSubject;
                                            AppCompatTextView a24 = f4.b.a(view, i);
                                            if (a24 != null && (a15 = f4.b.a(view, (i = R$id.tvTitle))) != null && (a16 = f4.b.a(view, (i = R$id.viewBg))) != null && (a17 = f4.b.a(view, (i = R$id.viewTitleLine))) != null) {
                                                return new m(constraintLayout, textView, a, a2, a3, a4, constraintLayout, a18, a19, a20, frameLayout, a6, a7, a8, a9, a10, linearLayout, nineGridVideoView, postDetailOperationView, postDetailSubjectView, a11, a12, a21, a22, a23, a24, a15, a16, a17);
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

    public static m c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static m d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_post_detail_common_layout, viewGroup, false);
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
