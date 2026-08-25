package ew;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.transsion.videofloat.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b implements f4.a {
    private final View a;
    public final FrameLayout b;
    public final Group c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final AppCompatImageView g;
    public final AppCompatImageView h;
    public final SimpleSubtitleView i;
    public final View j;

    private b(View view, FrameLayout frameLayout, Group group, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, SimpleSubtitleView simpleSubtitleView, View view2) {
        this.a = view;
        this.b = frameLayout;
        this.c = group;
        this.d = appCompatImageView;
        this.e = appCompatImageView2;
        this.f = appCompatImageView3;
        this.g = appCompatImageView4;
        this.h = appCompatImageView5;
        this.i = simpleSubtitleView;
        this.j = view2;
    }

    public static b a(View view) {
        Group a;
        AppCompatImageView a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        AppCompatImageView a6;
        SimpleSubtitleView a7;
        View a8;
        int i = R$id.fl_player_container;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout == null || (a = f4.b.a(view, (i = R$id.group_control))) == null || (a2 = f4.b.a(view, (i = R$id.iv_backward))) == null || (a3 = f4.b.a(view, (i = R$id.iv_close))) == null || (a4 = f4.b.a(view, (i = R$id.iv_forward))) == null || (a5 = f4.b.a(view, (i = R$id.iv_full))) == null || (a6 = f4.b.a(view, (i = R$id.iv_play))) == null || (a7 = f4.b.a(view, (i = R$id.v_subtitle))) == null || (a8 = f4.b.a(view, (i = R$id.v_trans_float))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new b(view, frameLayout, a, a2, a3, a4, a5, a6, a7, a8);
    }

    public View getRoot() {
        return this.a;
    }
}
