package lm;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class u implements f4.a {
    private final ConstraintLayout a;
    public final Group b;
    public final Group c;
    public final ShapeableImageView d;
    public final ShapeableImageView e;
    public final AppCompatImageView f;
    public final ProgressBar g;
    public final TextureView h;
    public final TextView i;
    public final View j;
    public final AppCompatImageView k;
    public final SecondariesSeekBar l;
    public final TextView m;
    public final ViewStub n;

    private u(ConstraintLayout constraintLayout, Group group, Group group2, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, AppCompatImageView appCompatImageView, ProgressBar progressBar, TextureView textureView, TextView textView, View view, AppCompatImageView appCompatImageView2, SecondariesSeekBar secondariesSeekBar, TextView textView2, ViewStub viewStub) {
        this.a = constraintLayout;
        this.b = group;
        this.c = group2;
        this.d = shapeableImageView;
        this.e = shapeableImageView2;
        this.f = appCompatImageView;
        this.g = progressBar;
        this.h = textureView;
        this.i = textView;
        this.j = view;
        this.k = appCompatImageView2;
        this.l = secondariesSeekBar;
        this.m = textView2;
        this.n = viewStub;
    }

    public static u a(View view) {
        Group a;
        ShapeableImageView a2;
        ShapeableImageView a3;
        AppCompatImageView a4;
        View a5;
        AppCompatImageView a6;
        SecondariesSeekBar a7;
        int i = R$id.group_loading;
        Group a8 = f4.b.a(view, i);
        if (a8 != null && (a = f4.b.a(view, (i = R$id.group_progress))) != null && (a2 = f4.b.a(view, (i = R$id.ivMovieBlurCover))) != null && (a3 = f4.b.a(view, (i = R$id.ivMovieCover))) != null && (a4 = f4.b.a(view, (i = R$id.iv_play))) != null) {
            i = R$id.progress;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null) {
                i = R$id.textureView;
                TextureView textureView = (TextureView) f4.b.a(view, i);
                if (textureView != null) {
                    i = R$id.tv_loading;
                    TextView textView = (TextView) f4.b.a(view, i);
                    if (textView != null && (a5 = f4.b.a(view, (i = R$id.v_tap))) != null && (a6 = f4.b.a(view, (i = R$id.vd_pause))) != null && (a7 = f4.b.a(view, (i = R$id.vd_seekbar))) != null) {
                        i = R$id.vd_video_time;
                        TextView textView2 = (TextView) f4.b.a(view, i);
                        if (textView2 != null) {
                            i = R$id.vs_load_failed;
                            ViewStub viewStub = (ViewStub) f4.b.a(view, i);
                            if (viewStub != null) {
                                return new u((ConstraintLayout) view, a8, a, a2, a3, a4, progressBar, textureView, textView, a5, a6, a7, textView2, viewStub);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static u c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static u d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_trailer, viewGroup, false);
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
