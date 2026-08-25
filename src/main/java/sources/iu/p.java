package iu;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.transsion.ugcvideodetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class p implements f4.a {
    public final View A;
    public final View B;
    private final View a;
    public final Barrier b;
    public final BLTextView c;
    public final Group d;
    public final Group e;
    public final AppCompatImageView f;
    public final AppCompatImageView g;
    public final AppCompatImageView h;
    public final ShapeableImageView i;
    public final LinearLayout j;
    public final ProgressBar k;
    public final RecyclerView l;
    public final AppCompatTextView m;
    public final BLTextView n;
    public final AppCompatTextView o;
    public final AppCompatTextView p;
    public final AppCompatTextView q;
    public final AppCompatTextView r;
    public final BLTextView s;
    public final BLTextView t;
    public final AppCompatTextView u;
    public final AppCompatTextView v;
    public final AppCompatTextView w;
    public final AppCompatTextView x;
    public final AppCompatTextView y;
    public final AppCompatTextView z;

    private p(View view, Barrier barrier, BLTextView bLTextView, Group group, Group group2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, ShapeableImageView shapeableImageView, LinearLayout linearLayout, ProgressBar progressBar, RecyclerView recyclerView, AppCompatTextView appCompatTextView, BLTextView bLTextView2, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, BLTextView bLTextView3, BLTextView bLTextView4, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, AppCompatTextView appCompatTextView9, AppCompatTextView appCompatTextView10, AppCompatTextView appCompatTextView11, View view2, View view3) {
        this.a = view;
        this.b = barrier;
        this.c = bLTextView;
        this.d = group;
        this.e = group2;
        this.f = appCompatImageView;
        this.g = appCompatImageView2;
        this.h = appCompatImageView3;
        this.i = shapeableImageView;
        this.j = linearLayout;
        this.k = progressBar;
        this.l = recyclerView;
        this.m = appCompatTextView;
        this.n = bLTextView2;
        this.o = appCompatTextView2;
        this.p = appCompatTextView3;
        this.q = appCompatTextView4;
        this.r = appCompatTextView5;
        this.s = bLTextView3;
        this.t = bLTextView4;
        this.u = appCompatTextView6;
        this.v = appCompatTextView7;
        this.w = appCompatTextView8;
        this.x = appCompatTextView9;
        this.y = appCompatTextView10;
        this.z = appCompatTextView11;
        this.A = view2;
        this.B = view3;
    }

    public static p a(View view) {
        BLTextView a;
        Group a2;
        Group a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        AppCompatImageView a6;
        ShapeableImageView a7;
        RecyclerView a8;
        AppCompatTextView a9;
        BLTextView a10;
        AppCompatTextView a11;
        AppCompatTextView a12;
        AppCompatTextView a13;
        AppCompatTextView a14;
        BLTextView a15;
        BLTextView a16;
        AppCompatTextView a17;
        AppCompatTextView a18;
        AppCompatTextView a19;
        AppCompatTextView a20;
        AppCompatTextView a21;
        AppCompatTextView a22;
        View a23;
        View a24;
        int i = R$id.barrierButtons;
        Barrier a25 = f4.b.a(view, i);
        if (a25 != null && (a = f4.b.a(view, (i = R$id.bgAutoplay))) != null && (a2 = f4.b.a(view, (i = R$id.groupAutoplay))) != null && (a3 = f4.b.a(view, (i = R$id.groupStandardButtons))) != null && (a4 = f4.b.a(view, (i = R$id.ivAutoplayClose))) != null && (a5 = f4.b.a(view, (i = R$id.ivAutoplayIcon))) != null && (a6 = f4.b.a(view, (i = R$id.ivPostType))) != null && (a7 = f4.b.a(view, (i = R$id.ivUserCover))) != null) {
            i = R$id.llKidsModeButtons;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null) {
                i = R$id.pbSubscribeLoading;
                ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                if (progressBar != null && (a8 = f4.b.a(view, (i = R$id.recyclerTag))) != null && (a9 = f4.b.a(view, (i = R$id.tvAddList))) != null && (a10 = f4.b.a(view, (i = R$id.tvAutoplayGo))) != null && (a11 = f4.b.a(view, (i = R$id.tvAutoplayText))) != null && (a12 = f4.b.a(view, (i = R$id.tvDes))) != null && (a13 = f4.b.a(view, (i = R$id.tvDetailMore))) != null && (a14 = f4.b.a(view, (i = R$id.tvDownload))) != null && (a15 = f4.b.a(view, (i = R$id.tvDownloadKids))) != null && (a16 = f4.b.a(view, (i = R$id.tvFollow))) != null && (a17 = f4.b.a(view, (i = R$id.tvLike))) != null && (a18 = f4.b.a(view, (i = R$id.tvShare))) != null && (a19 = f4.b.a(view, (i = R$id.tvTime))) != null && (a20 = f4.b.a(view, (i = R$id.tvTitle))) != null && (a21 = f4.b.a(view, (i = R$id.tvUsername))) != null && (a22 = f4.b.a(view, (i = R$id.tvViews))) != null && (a23 = f4.b.a(view, (i = R$id.vIconLine1))) != null && (a24 = f4.b.a(view, (i = R$id.vIconLine2))) != null) {
                    return new p(view, a25, a, a2, a3, a4, a5, a6, a7, linearLayout, progressBar, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, a24);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
