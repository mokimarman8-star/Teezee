package bx;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import com.noober.background.view.BLView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class j1 implements f4.a {
    private final View a;
    public final View b;
    public final FrameLayout c;
    public final Group d;
    public final Group e;
    public final Group f;
    public final Group g;
    public final AppCompatImageView h;
    public final AppCompatImageView i;
    public final AppCompatImageView j;
    public final AppCompatImageView k;
    public final ProgressBar l;
    public final View m;
    public final AppCompatTextView n;
    public final AppCompatTextView o;
    public final AppCompatTextView p;
    public final AppCompatTextView q;
    public final AppCompatTextView r;
    public final AppCompatTextView s;
    public final AppCompatTextView t;
    public final AppCompatTextView u;
    public final AppCompatTextView v;
    public final View w;
    public final View x;
    public final View y;
    public final BLView z;

    private j1(View view, View view2, FrameLayout frameLayout, Group group, Group group2, Group group3, Group group4, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, ProgressBar progressBar, View view3, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, AppCompatTextView appCompatTextView9, View view4, View view5, View view6, BLView bLView) {
        this.a = view;
        this.b = view2;
        this.c = frameLayout;
        this.d = group;
        this.e = group2;
        this.f = group3;
        this.g = group4;
        this.h = appCompatImageView;
        this.i = appCompatImageView2;
        this.j = appCompatImageView3;
        this.k = appCompatImageView4;
        this.l = progressBar;
        this.m = view3;
        this.n = appCompatTextView;
        this.o = appCompatTextView2;
        this.p = appCompatTextView3;
        this.q = appCompatTextView4;
        this.r = appCompatTextView5;
        this.s = appCompatTextView6;
        this.t = appCompatTextView7;
        this.u = appCompatTextView8;
        this.v = appCompatTextView9;
        this.w = view4;
        this.x = view5;
        this.y = view6;
        this.z = bLView;
    }

    public static j1 a(View view) {
        Group a;
        Group a2;
        Group a3;
        Group a4;
        AppCompatImageView a5;
        AppCompatImageView a6;
        AppCompatImageView a7;
        AppCompatImageView a8;
        View a9;
        AppCompatTextView a10;
        AppCompatTextView a11;
        AppCompatTextView a12;
        AppCompatTextView a13;
        AppCompatTextView a14;
        AppCompatTextView a15;
        AppCompatTextView a16;
        AppCompatTextView a17;
        AppCompatTextView a18;
        View a19;
        View a20;
        View a21;
        BLView a22;
        int i = R.id.bottom_guideline;
        View a23 = f4.b.a(view, i);
        if (a23 != null) {
            i = R.id.fl_send;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null && (a = f4.b.a(view, (i = R.id.group_def))) != null && (a2 = f4.b.a(view, (i = R.id.group_list))) != null && (a3 = f4.b.a(view, (i = R.id.group_send))) != null && (a4 = f4.b.a(view, (i = R.id.group_top_connect))) != null && (a5 = f4.b.a(view, (i = R.id.iv_close))) != null && (a6 = f4.b.a(view, (i = R.id.iv_reset))) != null && (a7 = f4.b.a(view, (i = R.id.iv_send_list))) != null && (a8 = f4.b.a(view, (i = R.id.iv_top_icon))) != null) {
                i = R.id.pb_loading;
                ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                if (progressBar != null && (a9 = f4.b.a(view, (i = R.id.top_guideline))) != null && (a10 = f4.b.a(view, (i = R.id.tv_close))) != null && (a11 = f4.b.a(view, (i = R.id.tv_receive_def))) != null && (a12 = f4.b.a(view, (i = R.id.tv_reset))) != null && (a13 = f4.b.a(view, (i = R.id.tv_send))) != null && (a14 = f4.b.a(view, (i = R.id.tv_send_def))) != null && (a15 = f4.b.a(view, (i = R.id.tv_send_list_count))) != null && (a16 = f4.b.a(view, (i = R.id.tv_send_list_tips))) != null && (a17 = f4.b.a(view, (i = R.id.tv_top_disconnect))) != null && (a18 = f4.b.a(view, (i = R.id.tv_top_phone_model))) != null && (a19 = f4.b.a(view, (i = R.id.v_receive_def))) != null && (a20 = f4.b.a(view, (i = R.id.v_send))) != null && (a21 = f4.b.a(view, (i = R.id.v_send_def))) != null && (a22 = f4.b.a(view, (i = R.id.v_top_bg))) != null) {
                    return new j1(view, a23, frameLayout, a, a2, a3, a4, a5, a6, a7, a8, progressBar, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
